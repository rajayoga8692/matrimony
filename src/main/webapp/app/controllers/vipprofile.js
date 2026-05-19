app.controller("searchvip", function($scope, $http, $window, $location,$rootScope) {
	
	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
	 	  if($scope.user == null ){       
			$location.path("/");
		}else{
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		} 

	$scope.searchVip = function() {
		$scope.insert = true;
		$scope.view = false;
		$scope.id = $scope.vipid;
		$http.get("./rest/plan/vipsearch/" + $scope.id).then(
				function(response) {
					$scope.personaldata = response.data;
					if ($scope.personaldata == "OK") {
						/* alert("Register is successfully updated"); */
						/* window.location.reload(); */
					}
				});
	};
	$http.get("./rest/galleryupload/getGallery").then(
			function(response) {
				$scope.gallerylist = response.data;
				$scope.view = true;
				}); 	
	$scope.viewVip = function() {
		$scope.insert = false;
		$scope.view = true; 
 		$http.get("./rest/galleryupload/getGallery").then(
				function(response) {
					$scope.gallerylist = response.data;
					$window.sessionStorage.setItem("sliderlist",JSON.stringify($scope.gallerylist));  

 				});
	};
	

	$scope.uploads = function(personalid) {
		var data = {
			galleryid : 0,
			personalid : personalid,
		};
		uploadFiles(data);
	};  

	$scope.uploadimg = function(data) {
		$http.post("./rest/galleryupload/usergallery", data).then(
				function(response) {
					$scope.message = response.data;
					if ($scope.message = "ACCEPTED") {
						alert("Gallery is successfully saved");
 					}
				});
	};

	var uploadFiles = function(data) {

		// var files = angular.element(".imgupload");
		var files = angular.element(document.querySelector('.imgupload'));

		if (files.length != 0) {
			var formdata = new FormData();
			for (var i = 0; i < files.length; i++) {
				var fileObj = files[i].files;
				formdata.append("files", fileObj[0]);
			}
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "./rest/file/upload/gallery");
			xhr.send(formdata);
			xhr.onload = function(e) {
				if (this.status == 200) {

					var obj = JSON.parse(this.responseText);
 					data.imagepath = obj[0].path;
					data.imagename = obj[0].name;

					if (data.galleryid == 0) {
						$scope.uploadimg(data);
					} else {

					}
				}
			};
		}
	};
	
	
	$scope.deleteVIP = function(data){
		 $scope.galleryid = data.galleryid;
 		 bootbox.confirm({
			    message: "Do you want delete this VIP?",
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
				 		$http.post("./rest/galleryupload/deleteGallery/D/"+$scope.galleryid).then(function(response) {
				            $scope.message = response.data;
				            if($scope.message=="OK"){
								bootbox.alert("The VIP deleted sucessfully");
				        		$scope.viewVip();
				         	}
				 		});
			    	}
			    }
		 });
	 };

	

});