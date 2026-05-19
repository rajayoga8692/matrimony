 app.controller("planctrl",function($scope,$http,$window,$location,$route,$rootScope) {
		
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
 	 if($scope.user == null ){ 
			$location.path("/plan");
	 }else{
			$rootScope.$broadcast('updatemenu', $scope.user.role);
	 }
 	    
	 $scope.contactlist = JSON.parse($window.sessionStorage.getItem("contact")); 

	   
	 $http({
			method : 'GET', 
			url :  './rest/plan/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.planlist = response.data;
	         }else{
	         }
		});
	 
	 $http({
			method : 'GET', 
			url :  './rest/bankdetails/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.banklist = response.data;
	         }else{
	         }
		});
	 
	 $scope.savePlan = function() {  

			 if($scope.planname==null || $scope.planname==undefined || $scope.planname==""){
			 	bootbox.dialog({
				    message: "Please enter a valid plan name",
				    closeButton: false,
				    buttons: {
				        "success": {
				           label: "Ok",
				           className: "btn-success",
				           callback: function () {}
				        }
				    }       
				});
	 			return;
			 }
			 
			 if($scope.amount==null || $scope.amount==undefined || $scope.amount==""){
				 	bootbox.dialog({
					    message: "Please enter a valid amount",
					    closeButton: false,
					    buttons: {
					        "success": {
					           label: "Ok",
					           className: "btn-success",
					           callback: function () {}
					        }
					    }       
					});
		 			return;
			}
			 
			 if($scope.validitydays==null || $scope.validitydays==undefined || $scope.validitydays==""){
				 	bootbox.dialog({
					    message: "Please enter a valid validity days",
					    closeButton: false,
					    buttons: {
					        "success": {
					           label: "Ok",
					           className: "btn-success",
					           callback: function () {}
					        }
					    }       
					});
		 			return;
				 }
			 
			 if($scope.contacts==null || $scope.contacts==undefined || $scope.contacts==""){
			 	bootbox.dialog({
				    message: "Please enter a valid contacts",
				    closeButton: false,
				    buttons: {
				        "success": {
				           label: "Ok",
				           className: "btn-success",
				           callback: function () {}
				        }
				    }       
				});
	 			return;
			 }
 			 
 			$http({
				method : 'POST',
				url :  './rest/plan', 
				data : {
					planname : $scope.planname,
					contacts:$scope.contacts,
					amount:$scope.amount,
					validitydays:$scope.validitydays

 				}
			}).then(function(response) {
				if (response.data == "OK") {
					bootbox.alert("The Member plan added sucessfully");
 					 $scope.planname="";
					 $scope.contacts="";
					 $scope.amount="";
					 $scope.getPlan();  
 				} else {
 					bootbox.alert("Member plan save process is failed. Please try again later");
				}
			});
		}
  
	 $scope.getPlan=function(){
	    $http({
			method : 'GET', 
			url :  './rest/plan/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.planlist = response.data;
	         }else{
 	         }
		});
	 };
	 
	 
	 $scope.editcity = function(data){
		 $scope.planid = data.planid;
		 $scope.pname = data.planname;
		 $scope.contact = data.contacts;
		 $scope.price = data.amount;					
		 $scope.validityday=data.validitydays;

		   
		 $("#myModal").modal();
	 };
	 
	 $scope.mdlview = true;
	 
	 $scope.updatemember = function(){
		 
		 if($scope.pname==null || $scope.pname==undefined || $scope.pname==""){
			 	bootbox.dialog({
				    message: "Please enter a valid plan name",
				    closeButton: false,
				    buttons: {
				        "success": {
				           label: "Ok",
				           className: "btn-success",
				           callback: function () {}
				        }
				    }       
				});
	 			return;
			 }
			 
			 if($scope.price==null || $scope.price==undefined || $scope.price==""){
				 	bootbox.dialog({
					    message: "Please enter a valid amount",
					    closeButton: false,
					    buttons: {
					        "success": {
					           label: "Ok",
					           className: "btn-success",
					           callback: function () {}
					        }
					    }       
					});
		 			return;
			}
			 
			 if($scope.validityday==null || $scope.validityday==undefined || $scope.validityday==""){
				 	bootbox.dialog({
					    message: "Please enter a valid validity days",
					    closeButton: false,
					    buttons: {
					        "success": {
					           label: "Ok",
					           className: "btn-success",
					           callback: function () {}
					        }
					    }       
					});
		 			return;
				 }
			 
			 if($scope.contact==null || $scope.contact==undefined || $scope.contact==""){
			 	bootbox.dialog({
				    message: "Please enter a valid contacts",
				    closeButton: false,
				    buttons: {
				        "success": {
				           label: "Ok",
				           className: "btn-success",
				           callback: function () {}
				        }
				    }       
				});
	 			return;
			 }
		 
		 var data={
				 planid : $scope.planid,
				 planname : $scope.pname,
				 contacts : $scope.contact,
				 amount : $scope.price,
				 validitydays:$scope.validityday

		 }; 
		  
		 bootbox.confirm({
			    message: "Do you want update this Member plan?",
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
						   $http.post("./rest/plan/updatePlan",data).then(function(response) {
					            $scope.message = response.data;
					            if($scope.message=="OK"){
					            	bootbox.alert("Member plan is successfully updated");
				 	        		$scope.getPlan();
					        		$scope.mdlview = false;
					        		$('.modal-backdrop').remove();
	 				        		$route.reload();  
					         	}else {
				 					bootbox.alert("Member plan update process is failed. Please try again later");
								}
						   }); 
				    }
 	        }
		 });
	 };
	 
	 $scope.deletememberplan = function(data){
		 $scope.planid = data.planid;
		 $scope.status = "D";
		 	
		 bootbox.confirm({
			    message: "Do you want delete this Member plan?",
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
			    		$http.post("./rest/plan/removeMemberplan/"+$scope.status+"/"+$scope.planid).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
				            	bootbox.alert("Member plan is deleted successully");
				        		$scope.getPlan();
				         	}else {
			 					bootbox.alert("Member plan delete process is failed. Please try again later");
							}
				        });
				    }
	        }
		 });
 	 };
 });
