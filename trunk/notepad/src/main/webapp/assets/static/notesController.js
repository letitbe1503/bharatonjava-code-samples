function notesController($scope, $http) {
	
	$http.get("http://localhost:9090/notepad/notes").success(
			function(response) {
				$scope.notes = response;
			});

};