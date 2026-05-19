angular.module("CONTACT-CTRL",[]).controller("contactmail",function($scope,$rootScope,$http,$window) {  
	
	 $scope.contactlist = JSON.parse($window.sessionStorage.getItem("contact"));

	
	 map = new GMaps({
			div: '#map',
			scrollwheel: false,				
			lat: 9.8959468,
			lng: 78.1137537
		  });
	 
 		  
		  var marker = map.addMarker({
			lat: 9.8959468,
			lng: 78.1137537,
		    title: 'Sandhiya matrimony / சந்தியா திருமண தகவல் மையம்'  
		   });
	$scope.con={};
	$scope.submitform = function(){ 
		        $('#processing').modal("show");
				$('.processtext').text("Mail Sending... Please wait...");
				$http.post("./rest/contact/userget",$scope.con).then(function(response) {  
					$scope.mail = response.data;
					if($scope.mail=="OK"){
						$('#processing').modal("show");
						$('.processtext').text("Thank You!..Your Registration for the sms has been completed.");
						setTimeout(function(){ 
							$('#processing').modal("hide");
							}, 3000);
						    window.location.reload();
						}else{
						$('#processing').modal("hide");
						$('#faildprocessing').modal("show");
						$('.processtext').text("Mail Sending... Faild...");
						}
			    }); 
		 
	};
});
