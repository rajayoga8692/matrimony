"use strict";
angular.module('data-services',[]).service("DataServices",function(){
	
	function testService($http, $q) {
		 // fetch all posts in deferred technique
		
		var postRS = undefined;
	    this.postData = function(_data) {
	        // create deferred object using $q
	        var deferred = $q.defer();

	        // get posts form backend
	        $http.post('./rest/registration',_data)
	          .then(function(result) {
	            // save fetched posts to the local variable
	        	  postRS = result.data;
	            // resolve the deferred
	            deferred.resolve(posts);
	          }, function(error) {
	        	  postRS = error;
	            deferred.reject(error);
	          });

	        // set the posts object to be a promise until result comeback
	        postRS = deferred.promise;
	      

	      // in any way wrap the posts object with $q.when which means:
	      // local posts object could be:
	      // a promise
	      // a real posts data
	      // both cases will be handled as promise because $q.when on real data will resolve it immediately
	      return $q.when(postRS);
	    };

	  }
});