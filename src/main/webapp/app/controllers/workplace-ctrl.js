 angular.module("WORKPLACE-CTRL",[]).controller("workplacectrl",function($scope,$http,$window,$location,$rootScope) {
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/"); 
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	 
	 $http({
			method : 'GET', 
			url :  './rest/workplace/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.workplacelist = response.data;
	         }else{
	         }
		});
	 
	 $scope.saveWorkplace = function() {  

 			$http({
				method : 'POST',
				url :  './rest/workplace', 
				data : {
					workplacename : $scope.workplacenamenew
 				}
			}).then(function(response) {
				if (response.data == "OK") {
					bootbox.alert("The Working Place added sucessfully");
					 $scope.getWorkplace();  
 				} else {
					bootbox.alert("Failed!..");
  				}
			});
		}
  
	 $scope.getWorkplace=function(){
	    $http({
			method : 'GET', 
			url :  './rest/workplace/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.workplacelist = response.data;
	         }else{
 	         }
		});
	 }
	 
	 
	 $scope.editworkplace=function(data){
		 $scope.workplacename = data.workplacename;
		 $scope.workplaceid = data.workplaceid;
		 $("#myModal").modal();
	 }
	 
	 
	 $scope.updateWorkplace = function() {  
		 bootbox.confirm({
			    message: "Do you want update this Working Place?",
			    buttons: {
			        confirm: {
			            label: 'Yes',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: 'No',
			            className: 'btn-danger'
			        }
			    },
			    callback: function (result) {
			    	if(result!=false){
					   $http.put("./rest/workplace/updateWorkplace/"+$scope.workplacename+"/"+$scope.workplaceid).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
				            	bootbox.alert("The Working Place updated sucessfully");
				        		window.location.reload();
				         	} 
				        });
					 }
			    }
		 });
		 
	}
	 
	 
$scope.deleteworkplace=function(data){
	
	 bootbox.confirm({
		    message: "Do you want delete this Working Place?",
		    buttons: {
		        confirm: {
		            label: 'Yes',
		            className: 'btn-success'
		        },
		        cancel: {
		            label: 'No',
		            className: 'btn-danger'
		        } 
		    },
		    callback: function (result) {
		    	if(result!=false){
				$scope.status="D";
				$scope.workplaceid = data.workplaceid;
				$http.put("./rest/workplace/removeWorkplace/"+$scope.status+"/"+$scope.workplaceid).then(function(response) {
			        $scope.message = response.data;
			        if($scope.message=="OK"){
			        	bootbox.alert("The Working Place deleted sucessfully");
			    		window.location.reload();
			     	}
			    });
				 }
			 }
	 });
}
	 
 });
/**
 * 
 */