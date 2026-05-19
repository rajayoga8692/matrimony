"use strict";
 angular.module("SEARCH-CTRL",[]).controller("searchctrl",function($scope,$http,$routeParams,DataProvider,$location,$window,$rootScope,$route) { 
	  $scope.gender =''; 
	  $scope.user = JSON.parse($window.sessionStorage.getItem("user"));   
 	  if($scope.user != null ){
			    
			$rootScope.$broadcast('updatemenu', $scope.user.role); 
			if($scope.user.gender=='ஆண்'){
				$scope.gender='பெண்';
			} else {
				$scope.gender='ஆண்';
			}  
			
			$scope.checkdate =0;	
		 	 var expirydate  = new Date($scope.user.expireddate);
		 	 var todaydate = new Date();
		 	if(todaydate.getTime() > expirydate.getTime())
		 	{
		 		$scope.checkdate =1; 
		 	}
		 	else
		 	{
		 		$scope.checkdate=0;
		 	}
		}  
         
 	     
 	  if($routeParams.data!=undefined) { 
  	     $scope.contactlist = JSON.parse($window.sessionStorage.getItem("contact")); 
 	 	 $scope.serarchData={memberid:$routeParams.data}
	 	   $scope.promise= $http.post('./rest/profile/viewprofile',$scope.serarchData) 
	      .then(function(result) {
	     	$scope.moreInfo = result.data;
	       }, function(error) {
	    	alert("Error"); 
	       });   
 	  }
 	 $scope.slides=[];
 	
 	 $http.get("./rest/profile/recentprofile").then(
				function(response) {
					$scope.recentlist = response.data;
					 angular.forEach($scope.recentlist, function (value, key) {
						 $scope.slides.push({'image':value.photo} );
 			            });   
		});  
 	         
 	 $scope._data=DataProvider.getdata();
	 $scope.delay = 0;
	 $scope.minDuration = 0;
	 $scope.message = 'Please Wait...';
	 $scope.backdrop = true;
	 $scope.promise = null;
	$scope.searchResult=[];
	$scope.moreInfo={};
	 $scope._data.star1=[{value:"0",label:"-தேர்வு செய்யவும்-"}];    

	 $('#myCarousel').carousel({
			interval: 10000
	});
		      
	 $scope.serarchData={gender:$scope.gender,memberid:'',agefrom:18,ageto:50,subcaste:'',star:'',rasi:'',education:'',merital:'',wplace:'',jobtype:'',country:'',jobsector:''}
	
	 $scope.getStar =function (id){  
		 $scope._data.star1 =_.where($scope._data.star, {id:id}); 
 	}   

	 $scope.likedBy =function(list){
		 
		 $http({
				method : 'POST',
				url :  './rest/like', 
				data : {
					likedto : list.p_id,
					likedby:$scope.user.id
 				}
			}).then(function(response) {
				if (response.data == "OK") {
					bootbox.alert("Liked sucessfully");
					 $scope.planname="";
					 $scope.contacts="";
					 $scope.amount="";
					 $scope.searchByUserRecords();     
				}else if (response.data == "FOUND") {
					bootbox.alert("Already liked");
				}else {
 					bootbox.alert("Liked process is failed. Please try again later");
				}
			});
		 
	 }  
	 
	 $scope.nonfulldetails=true;
	 $scope.fulldetails=false;
	  $scope.promise= $http.get('./rest/subcaste/A').then(function(result) {
		  	$scope.filter_caste = result.data;
			 
		    	}, function(error) {
		});
	  
	  $scope.promise= $http.get('./rest/workplace/A').then(function(result) {
		  	$scope.filter_workplace = result.data;
			 
		    	}, function(error) {
		});
	    
	  $scope.promise= $http.get('./rest/country/A').then(function(result) {
		  	$scope.filter_country = result.data;
			 
		    	}, function(error) {
		});
	  
	  $scope.promise= $http.get('./rest/residence/A').then(function(result) {
			 $scope.filter_residence = result.data;
			
		    	}, function(error) {
		    });
	  
	  $scope.myInterval = 3000;
	 
	  
	  $scope.searchByUserRecords = function(){
		   
			 $scope.fulldetails=true; 
			 $scope.nonfulldetails=false;
			 
			 $scope.serarchData.pid=$scope.user.id;
			 if($scope.serarchData.star==undefined){
				 $scope.serarchData.star='';
			 }
			 if($scope.serarchData.education==undefined){
				 $scope.serarchData.education='';
			 }
			 
			 if($scope.serarchData.jobsector==undefined){
				 $scope.serarchData.jobsector='';
			 }
			 if($scope.serarchData.jobtype==undefined){
				 $scope.serarchData.jobtype='';
			 }
			 if($scope.serarchData.merital==undefined){
				 $scope.serarchData.merital='';
			 }
			 if($scope.serarchData.rasi==undefined){
				 $scope.serarchData.rasi='';
			 }
			 
        	  $scope.serarchData.star=$scope.serarchData.star.value;
		  $scope.serarchData.rasi= $scope.serarchData.rasi.value;
		  $scope.serarchData.education= $scope.serarchData.education.value;
		  $scope.serarchData.merital= $scope.serarchData.merital.value;
		  $scope.serarchData.jobtype= $scope.serarchData.jobtype.value;
		  $scope.serarchData.jobsector=$scope.serarchData.jobsector.value;
	  	if($scope.tab==1) {
		      if($scope.serarchData.memberid!='' && $scope.serarchData.memberid!=undefined){ 
		    	  $scope.serarchData.agefrom='';
				  $scope.serarchData.ageto= '';
				  $scope.serarchData.gender= '';
				 // $scope.serarchData.height= '';
				  $scope.serarchData.income1= '';
				  $scope.serarchData.income2= '';
				  $scope.serarchData.wplace= '';
				  $scope.serarchData.height1= '';
				  $scope.serarchData.height2= '';
				  $scope.serarchData.country= '';
				 $scope.serarchData.jobsector= '';
				 $scope.serarchData.residence= '';
		      }     
		  	else {
				 bootbox.alert("Please enter member id"); 
				 $scope.nonfulldetails=true;
				  $scope.fulldetails=false; 
				  $route.reload(); 
					 $scope.serarchData.education=[{value:"0",label:"-தேர்வு செய்யவும்-"}];      
		  		return;
		  	}   
		} 
	      if($scope.serarchData.education=='0'){
	    	  $scope.serarchData.education='';
	      }
	      if($scope.serarchData.merital=='0'){  
	    	  $scope.serarchData.merital='';
	      }   
	      if($scope.serarchData.star=='0'){  
	    	  $scope.serarchData.star='';
	      }
	      if($scope.serarchData.rasi=='0'){   
	    	  $scope.serarchData.rasi='';
	      }
	      
	     if($scope.serarchData.jobtype =='0'){
	    	  $scope.serarchData.jobtype ='';
	      }
	     if($scope.serarchData.height1 =='0'){   
	    	  $scope.serarchData.height1 ='';
	      }  
	     if($scope.serarchData.height2 =='0'){   
	    	  $scope.serarchData.height2 ='';
	      }  
	    if($scope.serarchData.country =='0'){
	    	  $scope.serarchData.country ='';
	      }
	     if($scope.serarchData.jobsector =='0'){
	    	  $scope.serarchData.jobsector ='';
	      }
	     if($scope.serarchData.residence =='0'){
	    	  $scope.serarchData.residence ='';
	      }
	     if($scope.user.gender=='ஆண்'){
	    	 	$scope.serarchData.gender='பெண்';
			} else {
				$scope.serarchData.gender='ஆண்';
			}  
	     
	  $scope.promise= $http.post('./rest/profile/searchByUserRecords',$scope.serarchData) 
   .then(function(result) {
     // save fetched posts to the local variable
 	  $scope.nonfulldetails=false; 
 	  if(result.data!="NOT_ACCEPTABLE") {  
 		  $scope.nonfulldetails=false; 
 		  $scope.fulldetails=true;
 		 $scope.nodata =false;
            
 		  	$scope.searchResult = result.data;
 		  	  
 		  //............For pagination
 			  $scope.totalItems = $scope.searchResult.length;
 			  $scope.currentPage = 1;
 			  $scope.numPerPage = 5; 
 			  $scope.paginate = function(value) {
 			    var begin, end, index;
 			    begin = ($scope.currentPage - 1) * $scope.numPerPage;
 			    end = begin + $scope.numPerPage;
 			    index = $scope.searchResult.indexOf(value);
 			    return (begin <= index && index < end);
 			   
 			  };
 			   
 			 //....................pagination end...
 	  }
 	 
 	  else {
 		  $scope.searchResult =[];
	       	 $scope.nodata =true;    
	 		  $scope.fulldetails=false;

 	  }

   },function(error) {
 	alert(" Alert Error"); 
  });

	  $scope.back=function()
	  {
		  $scope.nonfulldetails=true;
		  $scope.fulldetails=false;
		  $route.reload();
	  }
	  
}
	  
	  
	  $scope.searchRecords = function(){
 		   
				 $scope.fulldetails=true; 
				 $scope.nonfulldetails=false;
				 
	 $scope.serarchData.star=$scope.serarchData.star.value;
	  $scope.serarchData.rasi= $scope.serarchData.rasi.value;
	  $scope.serarchData.education= $scope.serarchData.education.value;
	  $scope.serarchData.merital= $scope.serarchData.merital.value;
	  $scope.serarchData.jobtype= $scope.serarchData.jobtype.value;
	  $scope.serarchData.jobsector=$scope.serarchData.jobsector.value;
		  	if($scope.tab==1) {
	 		      if($scope.serarchData.memberid!='' && $scope.serarchData.memberid!=undefined){ 
			    	  $scope.serarchData.agefrom='';
					  $scope.serarchData.ageto= '';
					  $scope.serarchData.gender= '';
					 // $scope.serarchData.height= '';
					  $scope.serarchData.income1= '';
					  $scope.serarchData.income2= '';
					  $scope.serarchData.wplace= '';
					  $scope.serarchData.height1= '';
					  $scope.serarchData.height2= '';
					  $scope.serarchData.country= '';
					 $scope.serarchData.jobsector= '';
					 $scope.serarchData.residence= '';
			      }     
			  	else {
					 bootbox.alert("Please enter member id"); 
					 $scope.nonfulldetails=true;
					  $scope.fulldetails=false; 
					  $route.reload(); 
						 $scope.serarchData.education=[{value:"0",label:"-தேர்வு செய்யவும்-"}];      
	 		  		return;
			  	}   
	  		} 
		      if($scope.serarchData.education=='0'){
		    	  $scope.serarchData.education='';
		      }
		      if($scope.serarchData.merital=='0'){  
		    	  $scope.serarchData.merital='';
		      }   
		      if($scope.serarchData.star=='0'){  
		    	  $scope.serarchData.star='';
		      }
		      if($scope.serarchData.rasi=='0'){   
		    	  $scope.serarchData.rasi='';
		      }
		      
		     if($scope.serarchData.jobtype =='0'){
		    	  $scope.serarchData.jobtype ='';
		      }
		     if($scope.serarchData.height1 =='0'){   
		    	  $scope.serarchData.height1 ='';
		      }  
		     if($scope.serarchData.height2 =='0'){   
		    	  $scope.serarchData.height2 ='';
		      }  
		    if($scope.serarchData.country =='0'){
		    	  $scope.serarchData.country ='';
		      }
	     if($scope.serarchData.jobsector =='0'){
	    	  $scope.serarchData.jobsector ='';
	      }
	     if($scope.serarchData.residence =='0'){
	    	  $scope.serarchData.residence ='';
	      }
	  $scope.promise= $http.post('./rest/profile/search',$scope.serarchData)
          .then(function(result) {
            // save fetched posts to the local variable
        	  $scope.nonfulldetails=false; 
        	  if(result.data!="NOT_ACCEPTABLE") {  
        		  $scope.nonfulldetails=false; 
        		  $scope.fulldetails=true; 
     	 		 $scope.nodata =false;     

        		  	$scope.searchResult = result.data;
        		  	  
        		  //............For pagination
        			  $scope.totalItems = $scope.searchResult.length;
        			  $scope.currentPage = 1;
        			  $scope.numPerPage = 5; 
        			  $scope.paginate = function(value) {
        			    var begin, end, index;
        			    begin = ($scope.currentPage - 1) * $scope.numPerPage;
        			    end = begin + $scope.numPerPage;
        			    index = $scope.searchResult.indexOf(value);
        			    return (begin <= index && index < end);
        			   
        			  };
        			   
        			 //....................pagination end...
        	  }
        	  else {
        		  $scope.searchResult =[];
        	 		 $scope.nodata =true;    
        			  $scope.fulldetails=false;
        	  }


          },function(error) {
        	alert(" Alert Error"); 
         });

		  $scope.back=function()
		  {
			  $scope.nonfulldetails=true;
			  $scope.fulldetails=false;
			  $route.reload();
		  }
		  
	  }
	  
	  
	  
	  
	  $scope.getDate = function (db) {
			var sp = db.split("/");
			 return DataProvider.getAge(new Date(sp[2],sp[0],sp[1]));
	 };
	 
	 		
 	 
	$scope.openProfile = function(param){
		$scope.moreInfo = param;
	}	
	$scope.viewProfile = function(param){
		$state.go('viewprofile', {data: param});
	}	
	     
	$scope.loginClick=function(){
		bootbox.confirm({
		    message: "Already have an account?",
		    buttons: {
		        confirm: {
		            label: 'Login',
		            className: 'btn-success'
		        },
		        cancel: {
		            label: 'Register',
		            className: 'btn-danger'
		        }
		    }, 
		    callback: function (result) {
		    	if(result!=false){
		    		$window.location.href = "#/login";
		    	} else { 
		    		$window.location.href ="#/registration"; 
		    	}
		    }
		});
	}
	 
	
});
 
