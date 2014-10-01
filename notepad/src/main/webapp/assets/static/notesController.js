function notesController($scope, $http) {
	
	$http.get("http://localhost:9090/notepad/notes").success(
			function(response) {
				$scope.notes = response;
			});

};


function formController ($scope) {
    $scope.masterText = {aa:'this is sample text'};
    $scope.reset = function() {
        $scope.formText = angular.copy($scope.masterText);
    };
    $scope.reset();
}