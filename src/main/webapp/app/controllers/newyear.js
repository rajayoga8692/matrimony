
 app.controller("newyearcontroller",function($scope,$http,$window,$location,$rootScope,$routeParams) {


   	
 
 		
		$window.document.title = $routeParams.name+" Wishes To Wish you Happy New Year 2020";
		document.getElementById("icon").href = "./images/"+$routeParams.image+".jpg"
		
		$scope.name = $routeParams.name;  
		$scope.image = $routeParams.image;    
 	
});
   