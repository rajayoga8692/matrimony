 angular.module("RESIDENCE-CTRL",[]).controller("residencectrl",function($scope,$http,$window,$location,$rootScope) {
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/"); 
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	 
	 $http({
			method : 'GET', 
			url :  './rest/residence/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.residencelist = response.data;
	         }else{
	         }
		});
	 
	 $scope.saveResidence = function() {  

 			$http({
				method : 'POST',
				url :  './rest/residence', 
				data : {
					residencename : $scope.residencenamenew
 				}
			}).then(function(response) {
				if (response.data == "OK") {
					bootbox.alert("The Residence added sucessfully");
					 $scope.getResidence();  
 				} else {
					bootbox.alert("Failed!..");
				}
			});
		}
  
	 $scope.getResidence=function(){
	    $http({
			method : 'GET', 
			url :  './rest/residence/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.residencelist = response.data;
	         }else{
 	         }
		});
	 }
	 
	 
	 $scope.editresidence=function(data){
		 $scope.residencename = data.residencename;
		 $scope.residenceid = data.residenceid;
		 $("#myModal").modal();
	 }
	 
	 
	 $scope.updateResidence = function() {  
		 bootbox.confirm({
			    message: "Do you want update this Residence?",
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
					   $http.put("./rest/residence/updateResidence/"+$scope.residencename+"/"+$scope.residenceid).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
				            	bootbox.alert("The Residence updated sucessfully");
				        		window.location.reload();
				         	}
				        });
			    	}
 			    }
		 });
	 }
	 
	 
$scope.deleteresidence=function(data){
	
	bootbox.confirm({
	    message: "Do you want delete this Residence?",
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
				$scope.residenceid = data.residenceid;
				$http.put("./rest/residence/removeResidence/"+$scope.status+"/"+$scope.residenceid).then(function(response) {
			        $scope.message = response.data;
			        if($scope.message=="OK"){
			        	bootbox.alert("The Residence deleted sucessfully");
			    		window.location.reload();
			     	}  
			    });
				 }
			 }
	});
}
	 
 });
