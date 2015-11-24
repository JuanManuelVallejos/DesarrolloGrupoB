'use strict';


angular.module('desappGrupoB022015FrontendApp')
  .controller('EditLeagueCtrl', function ($http,$scope,$routeParams) {

  	$http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/league/' + $routeParams.idLeague)
        .success(function(data) {
        	$scope.league = data;
    });

    $scope.editLeague = function() {

        $http.put('http://localhost:8080/desapp-grupoB022015-backend/rest/league/edit/' + $routeParams.idLeague+ '/' + $scope.league.leaguename + '/' + $scope.league.minTeams + '/' + $scope.league.maxTeams)
        .success(function(data) {
                alert('"Liga "' + $scope.league.leaguename +'", editada correctamente');
                location = '#/activeLeagues';
        }).error(function(data,status) {
            alert('No se pudo editar la liga, error (' + status + ')');
        });

      
    };

    $scope.cancel = function() {
        location = '#/activeLeagues';
    };

  });