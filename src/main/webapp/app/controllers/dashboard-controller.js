"use strict";
angular.module("DASHBOARD-CTRL", []).controller(
		"dashboardctrl",
		function($scope,$http,$timeout,$window,$modal) {  
			
			 $('#myModal').modal('show');
			
			/*var memberRequestModalInstance;
			$scope.noteicePage = function(){
				 memberRequestModalInstance = $modal.open({  
	 				templateUrl : './app/views/modal/noticepage.html',  
	 				controller : ModalInstanceCtrl,
	 				scope : $scope
	 			 });    
			}
			$scope.noteicePage();*/
			
			LayerSlider.initLayerSlider();
			//OwlCarousel.initOwlCarousel();
			//OwlRecentWorks.initOwlRecentWorksV2(); 
			
			  $scope.myInterval = 5000;      
    
			
			$http.get("./rest/profile/recentprofile").then(
					function(response) {
						$scope.recentlist = response.data;
 			});  
			
			
			 $scope.sliderlist = JSON.parse($window.sessionStorage.getItem("sliderlist")); 

			if($scope.sliderlist ==null) {
				$http.get("./rest/galleryupload/getGallery").then( 
					function(response) {
						$scope.sliderlist= response.data;    
						$window.sessionStorage.setItem("sliderlist",JSON.stringify($scope.sliderlist))
  				});     
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
			 
			/*$http.post("./rest/dashboard/totalcount").then( 
					function(response) {
						$scope.totalcount= response.data;    
   				});  */   
			   
			
			
			
});      