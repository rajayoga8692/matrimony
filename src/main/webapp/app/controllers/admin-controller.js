"use strict";
 var app=angular.module("ADMIN-CTRL",[]);
 app.controller("adminctrl",function($scope,$http,$window,$rootScope,$location,$modal) {
	
	  
	$scope.user = JSON.parse($window.sessionStorage.getItem("user"));

	if($scope.user == null ){
		$location.path("/");
	}else
		$rootScope.$broadcast('updatemenu', $scope.user.role);
	
	
	$scope.promise= $http.get('./rest/profile/pending/count').then(function(result) {
		$scope.count = result.data[0];
  	 
    	}, function(error) {
    });
	
	$scope.promise= $http.get('./rest/profile/count').then(function(result) {
		$scope.counts = result.data[0];
  	 
    	}, function(error) {
    });
	
 });
 

 app.controller("nprofilectrl",function($scope,$http,$window,$rootScope,$location,DataProvider,$modal) {
	 
	$scope.delay = 0;
	$scope.minDuration = 0; 
	$scope.message = 'Please Wait...';
	$scope.backdrop = true;
	$scope.promise = null;
		
	$scope.user = JSON.parse($window.sessionStorage.getItem("user"));
	if($scope.user == null ){
		$location.path("/");
	}else{
		$rootScope.$broadcast('updatemenu', $scope.user.role);
	}
	   
	$scope.reload = function(){
		$scope.promise= $http.get('./rest/profile/pending/P').then(function(result) {
			$scope.pending = result.data ;
	  	 
	    	}, function(error) {
	    });
	};
	$scope.reload();
	
	 $scope.$on("refresh",function(event){
		 $scope.reload();
	 });
	
	
	$scope.getDate = function (db) {
		var sp = db.split("/");
		 return DataProvider.getAge(new Date(sp[2],sp[0],sp[1]));
	};
	
	$scope.activate= function (id,status){
		$scope.promise= $http.put('./rest/profile/update/'+id+"/"+status).then(function(result) {
			
			if (result.data == "NOT_ACCEPTABLE")
				alert("Activation process is failed. Please try again later");
	    	}, function(error) {
	    });
	};
	/*$scope.moreInfo= function (id){
		$scope.promise= $http.get('./rest/profile/moreinfo/'+id).then(function(result) {
			var _update = result.data[0];
			$rootScope.$broadcast('updateProfile', _update);
	    	}, function(error) {
	    });        
	};*/
	        
	var memberRequestModalInstance; 
	$scope.getModal= function (id){
		$scope.promise= $http.get('./rest/profile/moreinfo/'+id).then(function(result) {
			var _update = result.data[0];
			$rootScope.$broadcast('updateProfile', _update);
	    	}, function(error) {
	    });
		
		memberRequestModalInstance = $modal.open({  
			templateUrl : './app/views/modal/registration.html',  
			controller : ModalInstanceCtrl,
			scope : $scope
			});    
	};    
	  
	
	
		
 });
 
 app.controller("aprofilectrl",function($scope,$http,$window,$rootScope,$location,DataProvider,$modal) {
	 
 		$scope.delay = 0;   
		$scope.minDuration = 0;
		$scope.message = 'Please Wait...';
		$scope.backdrop = true;
		$scope.promise = null;
			
		$scope.user = JSON.parse($window.sessionStorage.getItem("user"));
		if($scope.user == null ){
			$location.path("/");
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
 		}
		
 		
		$scope.reload = function(){
			$scope.promise= $http.get('./rest/profile/pending/A').then(function(result) {
				$scope.pending = result.data ;
		  	 
		    	}, function(error) {
		    });
		};
		$scope.reload();
		
		$scope.data = this;
		$scope.data.users = []; //declare an empty array
		$scope.data.pageno = 1; // initialize page no to 1
		$scope.data.currentPage=1;
		$scope.data.total_count = 0;
		$scope.data.itemsPerPage = 30; //this could be a dynamic value from a drop down
		$scope.getData = function(pageno){
			$scope.data.currentPage=pageno; 
			$scope.promise= $http.get('./rest/profile/newpending/A/'+pageno+'/'+$scope.data.itemsPerPage).then(function(result) {
				$scope.data.users = result.data ;
				$scope.data.total_count = result.data[0].total_count;
		    	}, function(error) {
		    });
		};
		$scope.getData($scope.data.pageno);
		
		
		
		$scope.searchProfile = function(){
		
			$scope.promise= $http.get('./rest/profile/userSearch/'+$scope.keyItem).then(function(result) {
				$scope.data.userSearchData = result.data ;
 		    	}, function(error) {
		    });
		}
		
		$scope.getDate = function (db) {
			var sp = db.split("/");
			 return DataProvider.getAge(new Date(sp[2],sp[0],sp[1]));
		};
		
		$scope.deactivate= function (id,status){
			
			bootbox.confirm({
			    message: "Do you want deactive this user?",
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
			    		$scope.promise= $http.put('./rest/profile/update/'+id+"/"+status).then(function(result) {
			    			
  						if (result.data == "NOT_ACCEPTABLE") {
  							bootbox.alert("Deactivation process is failed. Please try again later");
   						 } else {
  							bootbox.alert("Sucessfully deactivated"); 
  							$scope.reload();  
   						 }
				    	}, function(error) {
				    	});	
			    	}
			    } 
			});
			
		};    
		
		$scope.activate= function (id,status){
			$scope.promise= $http.put('./rest/profile/update/'+id+"/"+status).then(function(result) {
				
				if (result.data == "NOT_ACCEPTABLE")
					alert("Activation process is failed. Please try again later");
		    	}, function(error) {
		    });
		};
		$scope.moreInfo= function (id){
			$scope.promise= $http.get('./rest/profile/moreinfo/'+id).then(function(result) {
				var _update = result.data[0];
				$rootScope.$broadcast('updateProfile', _update);
		    	}, function(error) {
		    });
		};
		
		var memberRequestModalInstance; 
		$scope.getModal= function (id){
			$scope.promise= $http.get('./rest/profile/moreinfo/'+id).then(function(result) {
				var _update = result.data[0];
				$rootScope.$broadcast('updateProfile', _update);
		    	}, function(error) {
		    });
			
			memberRequestModalInstance = $modal.open({  
				templateUrl : './app/views/modal/registration.html',  
				controller : ModalInstanceCtrl,
				scope : $scope  
				});    
		};    
			
	 });
 
 
 app.controller("dprofilectrl",function($scope,$http,$window,$rootScope,$location,DataProvider) {
	 
		$scope.delay = 0;
		$scope.minDuration = 0;
		$scope.message = 'Please Wait...';
		$scope.backdrop = true;
		$scope.promise = null;
			
		$scope.user = JSON.parse($window.sessionStorage.getItem("user"));
 		if($scope.user == null ){
			$location.path("/");
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
 		}
		
		
		
		$scope.reload = function(){
			$scope.promise= $http.get('./rest/profile/pending/D').then(function(result) {
				if (result != null && result.data != null && result.data !='NOT_ACCEPTABLE' ) {   
					$scope.nodata = true;
					$scope.pending = result.data ; 
				} else {
					$scope.nodata = false;
				 
				}
		  	 
		    	}, function(error) { 
		    });
		};
		
		$scope.reload();
		
		
		$scope.getDate = function (db) {
			var sp = db.split("/");
			 return DataProvider.getAge(new Date(sp[2],sp[0],sp[1]));
		};
		
		
		$scope.activate= function (id,status,photo){
    	    var message="",successmessage="";
    	    if(status=="T"){
    	    	message = "Warning! The user once deleted not recoverable . Do you want delete this user?";
    	    	successmessage = "Sucessfully deleted";
    	    } else {
    	    	message = "Do you want active this user?"
        	     successmessage = "Sucessfully activated";
    	    }
    	 
    	 
			bootbox.confirm({
			    message: message,
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
			    		$scope.promise= $http.put('./rest/profile/update/'+id+"/"+status).then(function(result) {
			    			
  						if (result.data == "NOT_ACCEPTABLE") {
  							bootbox.alert("The process is failed. Please try again later");
   						 } else {
  							bootbox.alert(successmessage); 
  							$scope.reload();  
   						 }
				    	}, function(error) {
				    	});	
			    	}
			    } 
			});
			
		};    
		
	
		$scope.moreInfo= function (id){
			$scope.promise= $http.get('./rest/profile/moreinfo/'+id).then(function(result) {
				var _update = result.data[0];
				$rootScope.$broadcast('updateProfile', _update);
		    	}, function(error) {
		    });
		};
		
		
			
	 }); 
 
 
 
 app.controller("paidmemberctrl",function($scope,$http,$window,$rootScope,$location,DataProvider) {
	 
		$scope.delay = 0;
		$scope.minDuration = 0;
		$scope.message = 'Please Wait...';
		$scope.backdrop = true;
		$scope.promise = null;
		$scope.user = JSON.parse($window.sessionStorage.getItem("user"));
		if($scope.user == null ){
			$location.path("/");
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
 		}
		
		 
 		 $scope.promise= $http.get('./rest/profile/paymenthistorylist/') .then(function(result) {
		     	$scope.paidmemberlist = result.data;
		       }, function(error) { 
		    	   console.log('Got notification: ' + update); 
		       }, function(update) {
		    	  console.log('Got notification: ' + update);    
		  }); 
		 
		
			
	 }); 
 
 
 app.controller("likedhistoryctrl",function($scope,$http,$window,$rootScope,$location,DataProvider,$routeParams) {

	 $scope.user = JSON.parse($window.sessionStorage.getItem("user"));
	 	 
	 $scope._data=DataProvider.getdata();

		if($scope.user == null ){
			$location.path("/");
		}else {
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}			

		 $scope.promise= $http.get('./rest/like/history/'+$scope.user.id) .then(function(result) {
		       if ( result != null && result.data != null && result.data!="NO_CONTENT"){
				 $scope.noemp=false;
				 $scope.likededhistory = result.data; 
		       } else {
		    	   $scope.noemp=true;  
		       }
		       }, function(error) { 
		    	   console.log('Got notification: ' + error); 
		       }, function(update) {
		    	  console.log('Got notification: ' + error);    
		  });
		 
		 $scope.promise= $http.get('./rest/like/likedto/'+$scope.user.id) .then(function(result) {
		       if ( result != null && result.data != null && result.data!="NO_CONTENT"){
				 $scope.noliked=false;
				 $scope.likededbyhistory = result.data; 
		       } else {
		    	   $scope.noliked=true;   
		       }
		       }, function(error) { 
		    	   console.log('Got notification: ' + error); 
		       }, function(update) {
		    	  console.log('Got notification: ' + error);    
		  });
		 
		 $scope.getDate = function (db) {
				var sp = db.split("/");
				 return DataProvider.getAge(new Date(sp[2],sp[0],sp[1]));
			};
			
			 $scope.myInterval = 5000;      
 
		 	 $scope.sliderlist = JSON.parse($window.sessionStorage.getItem("sliderlist")); 

				if($scope.sliderlist ==null) {
					$http.get("./rest/galleryupload/getGallery").then( 
						function(response) {
							$scope.sliderlist= response.data;    
							$window.sessionStorage.setItem("sliderlist",JSON.stringify($scope.sliderlist))
					});      
				} 
 });
 
 app.controller("profilectrl",function($scope,$http,$window,$rootScope,$location,DataProvider,$routeParams,$modal,$timeout) {
 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user"));
	 
	    
	 
	 $scope.myInterval = 5000;      

 	 $scope.sliderlist = JSON.parse($window.sessionStorage.getItem("sliderlist")); 

		if($scope.sliderlist ==null) {
			$http.get("./rest/galleryupload/getGallery").then( 
				function(response) {
					$scope.sliderlist= response.data;    
					$window.sessionStorage.setItem("sliderlist",JSON.stringify($scope.sliderlist))
			});      
		} 
	 
	 $scope._data=DataProvider.getdata();

		if($scope.user == null ){
			$location.path("/");
		}else
			$rootScope.$broadcast('updatemenu', $scope.user.role);
	    
  	 
		  
		
		
			 $scope.promise= $http.get('./rest/profile/paymenthistory/'+$scope.user.id) .then(function(result) {
		     	$scope.paymenthistory = result.data;
		       }, function(error) { 
		    	   console.log('Got notification: ' + error); 
		       }, function(update) {
		    	  console.log('Got notification: ' + error);    
		     }); 
		
			  
			 $scope.promise= $http.get('./rest/viewhistory/history/'+$scope.user.id) .then(function(result) {
			       if ( result != null && result.data != null && result.data!="NO_CONTENT"){
 					 $scope.noemp=false;
 					 $scope.viewedhistory = result.data; 
			       } else {
			    	   $scope.noemp=true;  
			       }
			       }, function(error) { 
			    	   console.log('Got notification: ' + error); 
			       }, function(update) {
			    	  console.log('Got notification: ' + error);    
			  }); 
			 
			 
			 if($routeParams.page=="rprofile") {
			 $scope.promise= $http.get('./rest/viewhistory/yourprofileHistory/'+$scope.user.id) .then(function(result) {
			       if ( result != null && result.data != null && result.data!="NO_CONTENT"){
					 $scope.noemp=false;
					 $scope.yourprofilehistory = result.data; 
			       } else {
			    	   $scope.noemp=true;  
			       }
			       }, function(error) { 
			    	   console.log('Got notification: ' + error); 
			       }, function(update) {
			    	  console.log('Got notification: ' + error);    
			  }); 
			 }
			 
			 $scope.getDate = function (db) {
		 			var sp = db.split("/");  
		 			 return DataProvider.getAge(new Date(sp[2],sp[0],sp[1]));
		 		};   
			 
			
		 
			
			$scope.passwordcheck = function() {
				if ($scope._update.password != $scope._update.password1) {
					$scope.newpassword = false;
					bootbox.alert("password does not match");
					return false;
				} else {
					$scope.newpassword = true;
					$scope.old = false;
				}
				$scope.newpass = function(data) {
					var data = {
						pwd : $scope.password,
						personal_id : $scope._update.p_id
					};
					bootbox.confirm({
								message : "Do you want update this Password?",
								buttons : {
									confirm : {
										label : 'Yes',
										className : 'btn-success'
									},
									cancel : {
										label : 'No',
										className : 'btn-danger'
									}
								},
								callback : function(result) {
									$http.post("./rest/authenticate/login",data)
				 	 						.then(function(response) {
														$scope.word = response.data;
														if ($scope.word == "OK") {
															bootbox.alert("password is successfully updated");
														}
													});
								}
								
							});
				}

			}
			
			var update_data=[];
			$scope.updateItem = function (properties,ids,form,value){
				var txt = prompt("Please enter your name", value);
				
				if (txt != null) {
					var obj ={};
					obj[properties]=txt;
					obj[form]=ids;					
					update_data.push(obj);
			    }
				
			};  
			  
			
 				 $scope.promise= $http.get('./rest/plan/planname/'+$scope.user.id).then(function(result) {
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
 			 
			 
			 $scope.promise= $http.get('./rest/profile/moreinfo/'+$scope.user.id).then(function(result) {
					$scope._update=result.data[0];
					if($scope._update.dateofbirth!=null) {
						var date = $scope._update.dateofbirth.split("/");
						$scope._update.dateofbirth= date[0]+"/"+date[1]+"/"+date[2];   
					}
					//$scope._update.caste=$scope._data.caste[$scope._update.subcaste_id].label;
					$scope._update.subcaste =$scope._update.subcastename;
					
					if($scope._update.education_id!=null) {
						$scope._update.elevel=$scope._data.education[$scope._update.education_id].label;
					}
					
			    	}, function(error) {
			   	});
			 
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
				
				
				$scope.dataFormattime=function(value) {   
					if(value==null) {
						return '-' ;
					} else {  
						var date = new Date(value); 
						var dates = date.toString();
						var datess = dates.split(' ');
						return datess[2] + '-' + datess[1] + '-' + datess[3] +" "+datess[4]; 
					}
				};
				
				var memberRequestModalInstance; 
				$scope.updateRequest = function(){
 					 memberRequestModalInstance = $modal.open({  
		 				templateUrl : './app/views/modal/updaterequest.html',  
		 				controller : ModalInstanceCtrl,
		 				scope : $scope
		 			 });    
				}
				$scope.saveRequest = function(){
					if ($scope.comments == "" || $scope.comments.length==0 || $scope.comments==undefined) {
 						return false;
					}
					var data={comments:$scope.comments,requestby: $scope.user.id,status:"P"};
					
					$http.post("./rest/profile/saveRequest",data)
						.then(function(response) {
								$scope.word = response.data;
								if ($scope.word == "OK") {
									$scope.success=true;
									$timeout(function() {
										$scope.success = false;
										$scope.ok();
									}, 1500);
								} else {
									$scope.error=true;
									$timeout(function() {
										$scope.error = false;
										$scope.ok();
									}, 1500);
								}
								
							});
				}
				
				$http.post("./rest/profile/getRequest").then( 
						function(response) {
							$scope.getRequestList= response.data;    
 					});   
 });
 
 function ModalInstanceCtrl($scope, $modalInstance) {

		$scope.ok = function() {
			$modalInstance.close();
		};

		$scope.cancel = function() {
			$modalInstance.dismiss('cancel');
		};
	};