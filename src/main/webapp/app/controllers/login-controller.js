"use strict";
 angular.module("LOGIN-CTRL",[]).controller("loginctrl",function($scope,$http,$window,$location) {
	
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
			  //var deferred = $q.defer();
		        
		        // get posts form backend
		 $scope.promise= $http.post('./rest/authenticate',$scope.authen)
		          .then(function(result) {
		        	 
		        	
		        	if (result.data == "NOT_ACCEPTABLE"){
		        		$scope.invalid = 'உங்கள் பயனர் பெயர (அல்லது) உறுப்பினர் அடையாள எண்  (அல்லது) கடவுச்சொல்லை தவறானது / Invalid Username or member Id or password';
		        	}else{
		        		$window.sessionStorage.setItem("user", JSON.stringify(result.data[0]));
		        		$scope.invalid ="";
		        		var _path = "/admin";
		        			
		        			if(result.data[0].role  == "user" )
		        				_path ="/profile";
		        		
		        			console.log("printa data values00000000 "+_path  +"--- 0"+result.data);
		        			$location.path(_path);
		        	}
		        	 
		          }, function(error) {
		         });
		 }
	 };
	 
 });