angular.module('desappGrupoB022015FrontendApp').controller('FixtureCtrl', function($scope, $http, auth,$routeParams) {

	var fixture = this;

  	$scope.profile = auth.profile;

  	$scope.currDate = 0;

	$scope.editLeague = function() {
		fixture.refreshCurrentDate();
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/league/showFixture/' + $scope.profile.user_id + $routeParams.idLeague + currDate)
        .success(function(data) {

        }).error(function(data,status) {
            alert('error (' + status + ')');
        });

    };

    fixture.refreshCurrentDate = function(){
    	$http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/league/getCurrentDate')
        .success(function(data) {
    		$scope.currDate = data;
    	});
    }

    fixture.refreshCurrentDate();

    $scope.runLeagues = function() {
    
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/league/initializeFixtures/')
        .success(function(data) {
            alert('Todas las ligas activas')
        }).error(function(data,status) {
            alert('Las ligas no pudieron arrancar');
        });

    };
});