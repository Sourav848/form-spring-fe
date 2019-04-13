/*var myApp = angular.module('myApp', []);

 myApp.controller('myController', function ($scope, $http)
 {
	 alert("hoo")
    //alert("successfully deployed this");
	 $scope.submitForm = function () {
		 var data = {
					name : $scope.name,
					email : $scope.email,
					password : $scope.password,
					rePassword : $scope.rePassword
				}
				var responsePromise = $http.post("/personal/detail/save", data);
		 
	
			responsePromise
					.success(function(data, status, headers, config) {
						if (data.status == 'SUCCESS') {

							
							
							$scope.loading = false;
							$scope.responseMsg = data.successMsg;
						

						} else {
							
							$scope.errorMsg = data.errorDetails;
							$scope.loading = false;

							
						}
					})
	 }
 });*/