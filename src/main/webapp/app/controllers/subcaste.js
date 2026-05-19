 angular.module("SUBCASTE-CTRL",[]).controller("subcastectrl",function($scope,$http,$window,$location,$rootScope) {
	 
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user"));  
		if($scope.user == null ){
			$location.path("/"); 
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	 
	 $http({
			method : 'GET', 
			url :  './rest/subcaste/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.subcastelist = response.data;
	         }else{
	         }
		});
	 
	  
	 $scope.saveSubCaste = function() {  

 			$http({
				method : 'POST',
				url :  './rest/subcaste', 
				data : {
					subcastename : $scope.subcaste
 				}
			}).then(function(response) {
				if (response.data == "OK") {
					alert("Successfully inserted");
					$scope.getSubcaste(); 
 				} else {
					alert("Failed!");
				}
			});
		};

	 $scope.getSubcaste = function(){
	    $http({
			method : 'GET', 
			url :  './rest/subcaste/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.subcastelist = response.data;
	         }else{
 	         }
		});
	 };
	 
	 $scope.editsubcaste = function(data) {
		 $scope.subcastename = data.subcastename;
		 $scope.subcasteid= data.subcasteid;
		 $("#myModal").modal();
	};
	 
	 $scope.updateSubcaste = function() {
         
		 var result = confirm("Do you want update?");
		 if (result) {
		 $http.post("./rest/subcaste/updateSubcaste/"+$scope.subcastename+"/"+$scope.subcasteid).then(function(response) {
	            $scope.message = response.data;
	            if($scope.message=="OK"){
	        		alert("Sub Caste is successfully updated");
	        		window.location.reload();
	         	}
	        });
		 }
	 };
	 
	 $scope.deletesubcaste = function(data) {   
		 var result = confirm("Do you Want to delete?");
		 if (result) {
		 $scope.status = "D";
		 $scope.subcasteid = data.subcasteid;
		 $http.post("./rest/subcaste/removeSubcaste/"+$scope.status+"/"+$scope.subcasteid).then(function(response) {
	            $scope.message = response.data;
	            if($scope.message=="OK"){
	        		alert("Removed successfully");
	        		window.location.reload();
	         	}
	        });
		 }
	};
 });
