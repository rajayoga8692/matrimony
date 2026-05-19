"use strict";
 var app = angular.module("MENU-CTRL",[]) 
 
 app.controller("menuctrl",function($scope,$rootScope,$location,$route,$http,$window) {
	 $scope.role="dashboard"; 
		
		$scope.getClass = function (path) {  
			  return ($location.path() === path) ? 'active' : ''; 
		} 
		$scope.search = function (path) {    
			  $scope.nonfulldetails=true;
			  $scope.fulldetails=false;
  			  $location.path("/search");   
 			  $route.reload();
		}  
	 $rootScope.$on('updatemenu', function (event, data) {
		 $scope.role = data;
		 $scope.user = JSON.parse($window.sessionStorage.getItem("user"));
		 console.log("get data values "+data);
	});
	 
	 $scope.logout = function (){
		 $scope.role="dashboard"; 
		    window.location = "#/";  
 
		$scope.user = JSON.parse($window.sessionStorage.getItem("user"));

		 $http.post("./rest/registration/updateLastlogin/"+$scope.user.id).then(function(response) {
	            $scope.message = response.data;
	            if($scope.message=="OK"){
	            	sessionStorage.removeItem("user"); 
 	         	}
	 		});
  
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
		/*$http.post("./rest/dashboard/totalcount").then( 
				function(response) {
					$scope.totalcount= response.data;    
				});  */
 	 
	 $http({
			method : 'GET', 
			url :  './rest/caddress/A'
		}).then(function(response) {   
			 if ( response != null && response.data != null && response.data!="BAD_REQUEST"){
		            $scope.contactlist = response.data[0];
	        		$window.sessionStorage.setItem("contact", JSON.stringify(response.data[0]));

	         }else{
	         }
		});
 });
 
 app.controller("loginctrl",function($scope,$http,$window,$location,$rootScope) {
	 $scope.invalid = "";
	 	
	 	$scope.delay = 0;
		$scope.minDuration = 0;
		$scope.message = 'Please Wait...';
		$scope.backdrop = true;
		$scope.promise = null;
		
		
		$scope.myInterval = 5000;      
		   
		   $scope.sliderlist = JSON.parse($window.sessionStorage.getItem("sliderlist")); 
 
		  if($scope.sliderlist ==null) {
			$http.get("./rest/galleryupload/getGallery").then(
					function(response) {
						$scope.sliderlist= response.data;  
	 		});  
		  }  
		
	 $scope.authenticate = function (){
		 
		 $("#loginform").validate({                   
	         // Rules for form validation
	         rules:
	         {
	        	 username:{required: true},
	        	 pwd:{required: true}
	         },
	         // Messages for form validation
	         messages:
	         {
	        	 username:{required: 'உங்கள் பயனர் பெயரை உள்ளிடவும் (அல்லது) உறுப்பினர் அடையாள எண் உள்ளிடவும் / Please enter your username / member Id'},
	        	 pwd:{required: 'உங்கள் கடவுச்சொல்லை உள்ளிடவும் / Please enter your password'},
	         },                  
	         
	         // Do not change code below
	         errorPlacement: function(error, element){
	             error.insertAfter(element.parent());
	         }
	     });
		 
		 if($scope.loginform.$valid){
			  
		 $scope.promise= $http.post('./rest/authenticate',$scope.authen)
		          .then(function(result) {
		        	console.log("Success result "+result.data);
		        	
		        	if (result.data == "NOT_ACCEPTABLE"){
		        		$scope.invalid = 'உங்கள் பயனர் பெயர (அல்லது) உறுப்பினர் அடையாள எண்  (அல்லது) கடவுச்சொல்லை தவறானது / Invalid Username or member Id or password';
		        	}else{
		        		$window.sessionStorage.setItem("user", JSON.stringify(result.data[0]));
		        		$window.localStorage.setItem("user", JSON.stringify(result.data[0]));

		        		$scope.invalid ="";
		        		var _path = "/admin";
	        			
	        			if(result.data[0].role  == "user" )
	        				_path ="/usersearch";
	        		 
	        			 
	        			$location.path(_path);
		        	}
		        	 
		          }, function(error) {
		         });
		 }
	 };
	 
 });