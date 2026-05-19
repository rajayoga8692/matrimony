 angular.module("DISTRICT-CTRL",[]).controller("districtctrl",function($scope,$http,$window,$location,$rootScope) {
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/"); 
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	 
	 $http({
			method : 'GET', 
			url :  './rest/district/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.districtlist = response.data;
	         }else{
	         }
		});
	 
	 $scope.saveDistrict = function() {  

 			$http({
				method : 'POST',
				url :  './rest/district', 
				data : {
					districtname : $scope.districtnamenew
 				}
			}).then(function(response) {
				if (response.data == "OK") {
					alert("Successfully inserted");
					 $scope.getDistrict();  
 				} else {
					alert("Failed!");
				}
			});
		}
  
	 $scope.getDistrict=function(){
	    $http({
			method : 'GET', 
			url :  './rest/district/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.districtlist = response.data;
	         }else{
 	         }
		});
	 }
	 
	 
	 $scope.editcity=function(data){
		 $scope.districtname = data.districtname;
		 $scope.districtid = data.districtid;
		 $("#myModal").modal();
	 }
	 
	 
	 $scope.updateDistrict = function() {  
		 var result = confirm("Want to Edit?");
		 if (result) {
		   $http.put("./rest/district/updateDistrict/"+$scope.districtname+"/"+$scope.districtid).then(function(response) {
	            $scope.message = response.data;
	            if($scope.message=="OK"){
	        		alert("Register is successfully updated");
	        		window.location.reload();
	         	}
	        });
		 }
		 
		}
	 
	 
$scope.deletecity=function(data){
	
	var result = confirm("Want to delete?");
	if (result) {
	$scope.status="D";
	$scope.districtid = data.districtid;
	$http.put("./rest/district/removeDistrict/"+$scope.status+"/"+$scope.districtid).then(function(response) {
        $scope.message = response.data;
        if($scope.message=="OK"){
    		alert("Register is successfully removed");
    		window.location.reload();
     	}
    });
	 }
 }
	 
 });
