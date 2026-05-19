angular.module("MEMBERVIEWHIS-CTRL",[]).controller("memberviewhisctrl",function($scope,$rootScope,$http,$window) {  
	
	
	$scope.user = JSON.parse($window.sessionStorage.getItem("user"));
	 
	if($scope.user == null ){
		$location.path("/");
	}else{ 
		$rootScope.$broadcast('updatemenu', $scope.user.role);
	}
	
	$scope.promise= $http.get('./rest/viewhistory/todayhistory') .then(function(result) {
	       if ( result != null && result.data != null && result.data!="NO_CONTENT"){
			 $scope.noemp=false;
			 $scope.memberviewedhistory = result.data; 
	       } else {
	    	   $scope.noemp=true;  
	       }
	       }, function(error) {  
	    	   console.log('Got notification: ' + error); 
	       }, function(update) {
	    	  console.log('Got notification: ' + error);    
	  }); 
	
	
	$scope.getViewedMember = function() { 
		$scope.promise= $http.get('./rest/viewhistory/memberIdHistory/'+$scope.memberid) .then(function(result) {
		       if ( result != null && result.data != null && result.data!="NO_CONTENT"){
				 $scope.noemp=false;
				 $scope.memberviewedhistory = result.data; 
		       } else {
		    	   $scope.noemp=true;  
		       }
		       }, function(error) { 
		    	   console.log('Got notification: ' + error); 
		       }, function(update) {
		    	  console.log('Got notification: ' + error);    
		  }); 
	}
	  
	
});
