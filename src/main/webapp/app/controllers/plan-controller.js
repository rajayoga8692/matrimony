"use strict";
 angular.module("PLAN-CTRL",[]).controller("assignplanctrl",function($scope,$http,DataProvider,$rootScope,$location,$window) {
	 
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/");
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
		
	 $scope.delay = 0;
	 $scope.minDuration = 0;
	 $scope.message = 'Please Wait...';
	 $scope.vtype="d";    
 	 $scope.backdrop = true;
	 $scope.freePlan=false;
	 $scope.promise = null;
	 $scope.serarchData={gender:'',memberid:'',agefrom:'',ageto:'',subcaste:'',star:'',rasi:'',education:'',merital:''}
	 $scope.searchResult=false;
	 $scope.searchNoResult=false;
	 $scope.memberid="";
	 $scope.process = "insert";
	 $scope.idassigned_plan;
	 $scope.searchAssignedMeber = function(){
		 $scope.promise= $http.post('./rest/profile/searchbyid',$scope.serarchData).then(function(result) {
			 if(result.data !="NOT_ACCEPTABLE") { 
	 	    	 $scope.searchResult = result.data;
		    	 $scope.moreInfo=$scope.searchResult[0];
		    	 $scope.getPlaneName($scope.moreInfo.p_id);
		    	 $scope.memberid = $scope.moreInfo.p_id;
		    	 $scope.searchResult=true;
			 } else { 
 				 $scope.searchNoResult=true
			 }
  	     }, function(error) {
	    	 alert("Error"); 
 	     }, function(update) {
 	    	 console.log('Got notification: ' + update);
	     });
	 } 
	 
	 $scope.myplan="NOT_ACCEPTABLE"; 
	 $scope.getPlaneName = function (memberid){
		 $scope.promise= $http.get('./rest/plan/planname/'+memberid).then(function(result) {
		       // save fetched posts to the local variable
		    	$scope.myplan = result.data;
		    	$scope.idassigned_plan=$scope.myplan[0].idassigned_plan
		    	if($scope.idassigned_plan!='' && $scope.idassigned_plan!=undefined){
		    		 $scope.process = "update";
		    	}  
		   	// resolve the deferred
		     //  deferred.resolve();
		     }, function(error) {
		    	 alert("Error"); 
		      // deferred.reject(error);
		     }, function(update) {
		   	  	console.log('Got notification: ' + update);
		     });
	 }
	 
	 $scope.promise= $http.get('./rest/plan/all/getPlans').then(function(result) {
	       // save fetched posts to the local variable
	    	$scope.planDetails = result.data;
	   	// resolve the deferred
	     //  deferred.resolve();
	     }, function(error) {
	    	 alert("Error"); 
	      // deferred.reject(error);
	     }, function(update) {
	   	  	console.log('Got notification: ' + update);
	     });
	  
	var count;
	 $scope.showPlandettail=function(planDetails){
		 $scope.planDetails.planname = planDetails.planname;
		 $scope.planDetails.amount= planDetails.amount;
		 $scope.planDetails.contacts= planDetails.contacts;
		 $scope.planDetails.validitydays= planDetails.validitydays;

		 
		 if(planDetails.status=='F'){
			 $scope.freePlan=true;
		 } else { 
			 $scope.freePlan=false; 
			 $('#myModal').modal('show');
		 }
	 }   
	 
	 $scope.signup = function (planids, status,counts){
		 
		 console.log($scope.planid);  
		 $scope.promise= $http.get('./rest/plan/subscript/'+$scope.planid.planid+"/"+$scope.memberid+"/"+$scope.process+"/"+$scope.idassigned_plan+"/"+$scope.planid.contacts+"/"+$scope.planid.validitydays+"/"+$scope.planid.status+"/"+$scope.vdays+"/"+$scope.econtacts+"/"+$scope.vtype).then(function(result) {
		       // save fetched posts to the local variable
		    	$scope.status = result.data; 
		    	if($scope.status ==  'ACCEPTED'){
		    		//$('#myModal').modal('hide');
					bootbox.alert("Payment plan is successfully subscribed");

		    		$scope.getPlaneName($scope.memberid);
		    	}
		   	// resolve the deferred
		     //  deferred.resolve();
		     }, function(error) {
		    	 alert("Error"); 
		      // deferred.reject(error);
		     }, function(update) {
		   	  	console.log('Got notification: ' + update);
		     });
	 }
	 
	 $scope.dataFormat=function(value) {   
			if(value==null) {
				return '-' ;
			} else {  
				var date = new Date(value);
				var dates = date.toDateString();
				var datess = dates.split(' ');
				return datess[2] + '-' + datess[1] + '-' + datess[3]; 
			}
		};
 });