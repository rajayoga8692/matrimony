 app.controller("caddressctrl",function($scope,$http,$window,$location,$route) {
	 
	 $http({
			method : 'GET', 
			url :  './rest/caddress/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){ 
		            $scope.contactlist = response.data;
	         }else{
	         }
		});
	 
	 
	 $scope.saveContact = function() {  
  
 		 			$http({
						method : 'POST',
						url :  './rest/caddress', 
						data : {
							address : $scope.address,
							city:$scope.city,
							phoneno:$scope.phoneno,
							pincode:$scope.pincode,
							emailid:$scope.emailid,
							name:$scope.name
 		  				} 
					}).then(function(response) {
						if (response.data == "OK") {
							 bootbox.alert("The Contact info added sucessfully");
		 					 $scope.planname="";
							 $scope.contacts="";
							 $scope.amount="";
							 $scope.getContactInfo();  
		 				} else {
		 					bootbox.alert("The Contact info save process is failed. Please try again later");
						}
					});
				 
 		}
  
	 $scope.getContactInfo=function(){
		 $http({
				method : 'GET', 
				url :  './rest/caddress/A'
			}).then(function(response) {
				 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
			            $scope.contactlist = response.data;
		         }else{
		         }
			});
	 };
	 
	 
	 $scope.editContactinfo = function(data){
  		 $scope.editaddress =data.address;
		 $scope.editcity=data.city;
		 $scope.editphoneno=data.phoneno;
		 $scope.editpincode=data.pincode;
		 $scope.editemailid=data.emailid;
		 $scope.editname=data.name;
		 $scope.contactaddressid=data.contactaddressid;
		 $("#myModal").modal();
	 }; 
	 
	 $scope.mdlview = true;
	 
	 $scope.updateContactInfo = function(){
		 var data={
				 	address : $scope.editaddress,
					city:$scope.editcity,
					phoneno:$scope.editphoneno,
					pincode:$scope.editpincode,
					emailid:$scope.editemailid,
					name:$scope.editname, 
					contactaddressid:$scope.contactaddressid

		 };
		 
		 bootbox.confirm({
			    message: "Do you want update this Contact info?",
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
					   $http.post("./rest/caddress/updateContact",data).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
								bootbox.alert("The Contact info updated sucessfully");
				        		$scope.mdlview = false;
				        		$('.modal-backdrop').remove();
 				        		$route.reload();  
				         	}    
				        }); 
					 } 
			    }
		 });
	 } 
	 
	 $scope.deleteContactInfo = function(data){
		 $scope.contactaddressid = data.contactaddressid;
		 $scope.status = "D"; 
		 bootbox.confirm({
			    message: "Do you want delete this Contact info?",
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
				 		$http.post("./rest/caddress/removeContact/"+$scope.status+"/"+$scope.contactaddressid).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
								bootbox.alert("The Contact info deleted sucessfully");
								$route.reload();  
				         	}
				 		});
			    	}
			    }
		 });
	 }  
 });
