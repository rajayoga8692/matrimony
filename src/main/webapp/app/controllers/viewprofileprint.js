"use strict";
 angular.module("VIEWPROFILE-PRINTCTRL",[]).controller("viewprofilectrlprint",function($scope,$http,DataProvider,$routeParams,$window,$route,$rootScope,$timeout,$modal) {
	 console.log("$routeParams.data"+$routeParams.data);  
 		 $scope.user = JSON.parse($window.localStorage.getItem("user")); 
 		$window.sessionStorage.setItem("user", $window.localStorage.getItem("user"));  

//  	 	  if($scope.user == null ){ 
// 				$location.path("/");
// 			}else{
// 				$rootScope.$broadcast('updatemenu', $scope.user.role);   
// 			}
  	     $scope.serarchData={memberid:$routeParams.data} 

  	     
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
  	     
  	     
 	    //  $scope.contactlist = JSON.parse($window.sessionStorage.getItem("contact")); 
 
 		  $scope.promise= $http.post('./rest/profile/viewprofile',$scope.serarchData) 
          .then(function(result) {
         	$scope.moreInfo = result.data;
           }, function(error) {
        	alert("Error"); 
           }, function(update) {
        	  console.log('Got notification: ' + update);    
         });   
 		  
       
 		    $scope.printOverallReport = function () {
  		        $timeout($window.print, 0);
  		      };  
 		      
  		$scope.btnId=true;
  		
  		$scope.addressid=false; 
  		 
 	    $scope.openPrint=function(divName,id){
 	    	$scope.btnId=false;
 	    	$scope.addressid=true;  
 	    	$http({
				method : 'POST',
				url :  './rest/viewhistory',     
				data : {
					viewedmemberid : id[0].p_id,      
					viewedby:$scope.user.id,
					updatecount:$scope.user.updatecount
 				}
			}).then(function(response) { 
				
				if(response.data.message == "found") {
					$scope.viewedcount = response.data.updatecount;
  				} else if(response.data.message == "success") { 
  					
  					$scope.promise= $http.post('./rest/authenticate/getUser/'+$scope.user.id)
			          .then(function(result) {
			        		$window.sessionStorage.setItem("user", JSON.stringify(result.data[0]));
			        		$window.location.reload();
			        		$scope.viewedcount = response.data.updatecount;
		 	           }, function(error) {    
			        	alert("Error"); 
			           }, function(update) {
			        	  console.log('Got notification: ' + update);    
			         });
  					
				} else {
					$scope.viewedcount = response.data.updatecount;    
				}  
 				 
			});   
 	    	
 	    	
 	    	  var printContents = document.getElementById(divName).innerHTML;  
 	    	  var popupWin = window.open('', '_blank', 'width=1000,height=800');
 	    	  popupWin.document.open();
 	    	  popupWin.document.write('<!DOCTYPE html><html><head><link rel="stylesheet" href="./assets/plugins/bootstrap/css/bootstrap.min.css">	<link rel="stylesheet" href="./assets/css/style.css"><link rel="stylesheet" href="./assets/plugins/font-awesome/css/font-awesome.min.css"><link rel="stylesheet" href="./assets/css/pages/profile.css"  ></head><body onload="window.print()">' + printContents + '</body></html>');
 	    	  popupWin.document.close();
 	    	   
  	    }
 	    
 	    
 	   $scope.modalPrint=function(id){  
 	    	
	    	window.print();
	    	 
  	    }
 	    
 	   var memberRequestModalInstance; 
 		$scope.getAddress= function (moreInfo){
 		 
 			$scope.moreInfo = moreInfo 
 			if($scope.user.role == 'user' ){
	 			$http({    
					method : 'POST',
					url :  './rest/viewhistory',     
					data : {
						viewedmemberid : moreInfo[0].p_id,      
						viewedby:$scope.user.id,
						updatecount:$scope.user.updatecount
					}
				}).then(function(response) {   
					if(response.data.message == "found") {
						$scope.viewedcount = response.data.updatecount;
	  				} else if(response.data.message == "success") { 
	  					$scope.promise= $http.post('./rest/authenticate/getUser/'+$scope.user.id)
				          .then(function(result) {
				        		$window.sessionStorage.setItem("user", JSON.stringify(result.data[0]));
				        		//$window.location.reload();
				        		$scope.viewedcount = response.data.updatecount;  
			 	           }, function(error) {    
				        	alert("Error"); 
				           }, function(update) {
				        	  console.log('Got notification: ' + update);    
				         });
 					} else { 
						$scope.viewedcount = response.data.updatecount;    
					}     
				});   
 			}
 			memberRequestModalInstance = $modal.open({  
 				templateUrl : './app/views/modal/address.html',  
 				controller : ModalInstanceCtrl,
 				scope : $scope
 				});    
 		};  
 		 
 		function ModalInstanceCtrl($scope, $modalInstance) {

 			$scope.ok = function() {
 				$modalInstance.close();
 				$route.reload(); 
 			};

 			$scope.cancel = function() {
 				$modalInstance.dismiss('cancel');
 				$route.reload();  
 			};
 		};
 		  
 }); 
 
 