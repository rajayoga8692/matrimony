 angular.module("REPORT-CTRL",[]).controller("reportctrl",function($scope,$http,DataProvider,$rootScope,$location,$window) {

	 $scope.user = JSON.parse($window.sessionStorage.getItem("user")); 
		if($scope.user == null ){
			$location.path("/");
		}else {  
			$rootScope.$broadcast('updatemenu', $scope.user.role);
		}

		
		$http.post("./rest/salesreport/currentMonthReport").then(
				function(response) {
					$scope.salesreportlist = response.data;
		});  
	 
        $scope.total = function() {
             var total = 0;
            angular.forEach($scope.salesreportlist, function(product, index) {
                total += product.amount;
            })
            console.log(total);
            return total;
        }

         
        $scope.getReport = function() {
        	var start = $('#start').val().split("-");
        	var end = $('#finish').val().split("-");
        	var startdate = start[2]+"-"+start[1]+"_"+start[0];
        	var enddate = end[2]+"-"+end[1]+"_"+end[0]
        	$http.post("./rest/salesreport/getReport/"+startdate+"/"+enddate).then(
    				function(response) {
    					$scope.salesreportlist = response.data;
    		});
        }
		
	 
 });  