function notesController($scope, $http) {

	$http.get("http://localhost:9090/notepad/notes").success(
			function(response) {
				$scope.notes = response;
			});

	// sorting table data
	$scope.sort = {
		column : '',
		descending : false
	};

	$scope.changeSorting = function(column) {

		var sort = $scope.sort;

		if (sort.column == column) {
			sort.descending = !sort.descending;
		} else {
			sort.column = column;
			sort.descending = false;
		}
	};

};

function formController($scope) {
	$scope.masterText = {
		aa : 'this is sample text'
	};
	$scope.reset = function() {
		$scope.formText = angular.copy($scope.masterText);
	};
	$scope.reset();

	$scope.saveNote() = function() {
		$scope.formText = "testssss";
	}
}
