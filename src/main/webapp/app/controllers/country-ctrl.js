 angular.module("COUNTRY-CTRL",[]).controller("countryctrl",function($scope,$http,$window,$location,$rootScope,$route) {
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/"); 
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	 
	 $http({
			method : 'GET', 
			url :  './rest/country/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.countrylist = response.data;
	         }else{
	         }
		});
	 
	 $scope.saveCountry = function() {  

 			$http({
				method : 'POST',
				url :  './rest/country', 
				data : {
					countryname : $scope.countrynamenew
 				}
			}).then(function(response) {
				if (response.data == "OK") {
 					bootbox.alert("The Country added sucessfully");
 					 $scope.getCountry();  
 				} else {
  					bootbox.alert("The Country added Failed!");
 				}
			});
		}
  
	 $scope.getCountry=function(){
	    $http({
			method : 'GET', 
			url :  './rest/country/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.countrylist = response.data;
	         }else{
 	         }
		});
	 }
	   
	 
	 $scope.editcountry=function(data){
		 $scope.countryname = data.countryname;
		 $scope.countryid = data.countryid;
		 $("#myModal").modal();
	 } 
	 
	 $scope.mdlview = true;
	 $scope.updateCountry = function() {  
		 bootbox.confirm({
			    message: "Do you want update this country?",
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
				 		   $http.put("./rest/country/updateCountry/"+$scope.countryname+"/"+$scope.countryid).then(function(response) {
					            $scope.message = response.data;
					            if($scope.message=="OK"){
					            	bootbox.alert("The Country info updated sucessfully");
  					        		$scope.mdlview = false;
 					        		$('.modal-backdrop').remove();  
 					        		$route.reload();  
 					         	}
				 		   });
			    	}
			    }
	        });
		 }
		 
 	 
	 
	$scope.deletecountry=function(data){
			
		 bootbox.confirm({
			    message: "Do you want delete this Country?",
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
						$scope.countryid = data.countryid;
						$http.put("./rest/country/removeCountry/"+$scope.status+"/"+$scope.countryid).then(function(response) {
					        $scope.message = response.data;
					        if($scope.message=="OK"){
					        	bootbox.alert("The Country  deleted sucessfully");
					     		$scope.getCountry();
					     		$route.reload();  
					     	}
					    });
			    	}
			    }
		 }); 
	}
	 
 });
