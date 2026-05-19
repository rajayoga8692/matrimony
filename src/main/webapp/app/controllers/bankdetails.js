 app.controller("bankdetailsctrl",function($scope,$http,$window,$location,$rootScope) {
	 
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/");
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	    
	 $http({
			method : 'GET', 
			url :  './rest/bankdetails/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.bankdetailslist = response.data;
	         }else{
	         }
		});
	 
		var formdata = new FormData();
	 $scope.setFile = function(element) { 
 		 $scope.loading = true; 
			$scope.$apply(function($scope) {
				$scope.files = element.files;
				for (var i = 0; i < element.files.length; i++) {
					formdata.append('files', element.files[i]);
				} 
			});
 		}
	 $scope.saveBankdetails = function() {  
		 var photo=document.getElementById('imageFile');    
			if(photo!= null && photo.files[0] != undefined){
				var request = {
					method : 'POST',
					url :  './rest/file/upload/bank/',
					data : formdata,   
					headers : {
						'Content-Type' : undefined
					}
				};
				$http(request).success(function(response) {
		 			$http({
						method : 'POST',
						url :  './rest/bankdetails', 
						data : {
							accountnumber : $scope.accountnumber,
							holdername:$scope.holdername,
							branchname:$scope.branchname,
							bankname:$scope.bankname,
							branchcode:$scope.branchcode,
							ifsccode:$scope.ifsccode,
							imagepath:response[0].path
		  				}
					}).then(function(response) {
						if (response.data == "OK") {
							 bootbox.alert("The Bank info added sucessfully");
		 					 $scope.planname="";
							 $scope.contacts="";
							 $scope.amount="";
							 $scope.getBankInfo();  
		 				} else {
		 					bootbox.alert("The Bank info save process is failed. Please try again later");
						}
					});
				}).error(function(response) {
		 			formdata = new FormData();
					$('input[type=file]').val('');
				});
			} else {
				bootbox.alert("Please select bank logo");
				return;
			}
		}
  
	 $scope.getBankInfo=function(){
	    $http({
			method : 'GET', 
			url :  './rest/bankdetails/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.bankdetailslist = response.data;
	         }else{
 	         }
		});
	 };
	 $scope.sub=true;
	 $scope.editBankinfo = function(data){
		 $scope.bankdetailsid=data.bankdetailsid;
		 $scope.accountnumber = data.accountnumber;
		 $scope.holdername=data.holdername;
		 $scope.branchname=data.branchname;
		 $scope.bankname=data.bankname;
		 $scope.branchcode=data.branchcode;
		 $scope.ifsccode=data.ifsccode;
		  $scope.imagepath=data.imagepath;
		  $scope.sub=false;
		  $scope.update=true;
		 $("#myModal").modal();
	 };
	 
	 $scope.mdlview = true;
	
	 $scope.updateBankInfo = function(){
		 
		 
		   var photo=document.getElementById('imageFile');    
			if(photo!= null && photo.files[0] != undefined){
				var request = {
					method : 'POST',
					url :  './rest/file/upload/bank/',
					data : formdata,   
					headers : {
						'Content-Type' : undefined
					}
				};
				$http(request).success(function(response) {
					 var data={
							 	bankdetailsid:$scope.bankdetailsid,
							 	accountnumber : $scope.accountnumber,
								holdername:$scope.holdername,
								branchname:$scope.branchname,
								bankname:$scope.bankname,
								branchcode:$scope.branchcode,
								ifsccode:$scope.ifsccode,
								imagepath:response[0].path
					 };
					 
					 bootbox.confirm({
						    message: "Do you want update this bank info?",
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
								   $http.post("./rest/bankdetails/updateBankDetails",data).then(function(response) {
							            $scope.message = response.data;
							            if($scope.message=="OK"){
											bootbox.alert("The Bank info updated sucessfully");
											
							        		$scope.getBankInfo();
							        		$scope.mdlview = false;
							         	}
							        });
								 } 
						    }
					 });
				});
			} else { 
				 var data={
						 	bankdetailsid:$scope.bankdetailsid,
						 	accountnumber : $scope.accountnumber,
							holdername:$scope.holdername,
							branchname:$scope.branchname,
							bankname:$scope.bankname,
							branchcode:$scope.branchcode,
							ifsccode:$scope.ifsccode,
							imagepath:$scope.imagepath
				 };
				 
				 bootbox.confirm({
					    message: "Do you want update this bank info?",
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
							   $http.post("./rest/bankdetails/updateBankDetails",data).then(function(response) {
						            $scope.message = response.data;
						            if($scope.message=="OK"){
										bootbox.alert("The Bank info updated sucessfully");
										
						        		$scope.getBankInfo();
						        		$scope.mdlview = false;
						         	}
						        });
							 } 
					    }
				 });
				
			}
		 
	 
	 }; 
	 $scope.deleteBankInfo = function(data){
		 $scope.bankdetailsid = data.bankdetailsid;
		 $scope.status = "D"; 
		 bootbox.confirm({
			    message: "Do you want delete this bank info?",
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
				 		$http.post("./rest/bankdetails/removeBankDetails/"+$scope.status+"/"+$scope.bankdetailsid).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
								bootbox.alert("The Bank info deleted sucessfully");
				        		$scope.getBankInfo();
				         	}
				 		});
			    	}
			    }
		 });
	 };  
 });
