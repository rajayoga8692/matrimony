/**
 * 
 */ angular.module("JOB-CTRL",[]).controller("jobctrl",function($scope,$http,$window,$location,$rootScope) {
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/"); 
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	 
	 $http({
			method : 'GET', 
			url :  './rest/job/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.joblist = response.data;
	         }else{
	         }
		});
	 
	 $scope.saveJob = function() {  

 			$http({
				method : 'POST',
				url :  './rest/job', 
				data : {
					jobname : $scope.jobnamenew
 				}
			}).then(function(response) {
				if (response.data == "OK") {
 					bootbox.alert("The Job added sucessfully");
  					 $scope.getJob();  
 				} else {
 					bootbox.alert("Failed !..");
				}
			});
		}
  
	 $scope.getJob=function(){
	    $http({
			method : 'GET', 
			url :  './rest/job/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.joblist = response.data;
	         }else{
 	         }
		});
	 }
	 
	 
	 $scope.editjob=function(data){
		 $scope.jobname = data.jobname;
		 $scope.jobid = data.jobid;
		 $("#myModal").modal();
	 }
	 
	 
	 $scope.updateJob = function() {  
		 
		 bootbox.confirm({
			    message: "Do you want update this Job?",
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
		 
				 if (result) {
				   $http.put("./rest/job/updateJob/"+$scope.jobname+"/"+$scope.jobid).then(function(response) {
			            $scope.message = response.data;
			            if($scope.message=="OK"){
			            	bootbox.alert("The Job edited sucessfully");
			        		window.location.reload();
			         	}
			        });   
				 }
			    }
		 });
		 
	}
	 
	 
	$scope.deletejob=function(data){
	 	 bootbox.confirm({
			    message: "Do you want delete this Job?",
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
						$scope.jobid = data.jobid;
						$http.put("./rest/job/removeJob/"+$scope.status+"/"+$scope.jobid).then(function(response) {
					        $scope.message = response.data;
					        if($scope.message=="OK"){ 
					        	bootbox.alert("The Job deleted sucessfully");
					    		window.location.reload();
					     	}
					    });
						 }
					 }
		 });
	}
	   
 });
