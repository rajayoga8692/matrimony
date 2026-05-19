 app.controller("succestoryctrl",function($scope,$http,$window,$location,$rootScope) {
	 
	 
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/");
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}
	    
	 $http({
			method : 'GET', 
			url :  './rest/succestory/A'
		}).then(function(response) {
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.succesStorylist = response.data;
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
	 $scope.saveStory = function() {  
		 	var photo=document.getElementById('imageFile');    
		 
			if(photo!= null && photo.files[0] != undefined){
				
				 formdata.append('files', photo.files[0]);
				 $http.post("./rest/file/upload/successstory", formdata, {
			            transformRequest: angular.identity,
			            headers: {'Content-Type': undefined}
			        })
			        .success(function(response){
			        	$http({
							method : 'POST',
							url :  './rest/succestory', 
							data : {
								description : $scope.story,
								name : $scope.name,
	 							imagepath:response[0].path
			  				}
						}).then(function(response) {
							if (response.data == "OK") {
								 bootbox.alert("The Success Story added sucessfully");
			 					 $scope.description="";
			 					 formdata = new FormData();
								 $('input[type=file]').val('');
	 							 $scope.getSuccesStory();  
			 				} else {
			 					bootbox.alert("The Success Story save process is failed. Please try again later");
							}
						});
 			        })  
				 
			} else {
				bootbox.alert("Please select story logo");
				return;
			}
		}
  
	 $scope.getSuccesStory=function(){
	    $http({
			method : 'GET', 
			url :  './rest/succestory/A'
 		}).then(function(response) {
 			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
  		            $scope.succesStorylist = response.data;
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
	 
 	
	 
	 $scope.deleteSuccess = function(id,imagepath){
 		 
 		 data = {
 				successtoryid : id,
 				imagepath :imagepath,
 				status :"D"
  		 }
		 bootbox.confirm({
			    message: "Do you want delete this Story?",
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
				 		$http.post("./rest/succestory/removeSuccesstory/",data).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
								bootbox.alert("The Story info deleted sucessfully");
				        		$scope.getSuccesStory();
				         	}
				 		});
			    	}
			    }
		 });
	 };  
 });
