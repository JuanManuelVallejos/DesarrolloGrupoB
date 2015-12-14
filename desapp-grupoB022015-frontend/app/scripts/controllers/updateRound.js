'use strict';

/**
 * @ngdoc function
 * @name desappGrupoB022015FrontendApp.controller:UpdateRoundCtrl
 * @description
 * # UpdateRoundCtrl
 * Controller of the desappGrupoB022015FrontendApp
 */
angular.module('desappGrupoB022015FrontendApp')
  .controller('UpdateRoundCtrl', function ($scope,$http) {

  	$scope.increaseDate = function(){
      $http.put('http://localhost:8080/desapp-grupoB022015-backend/rest/league/increaseCurrentDate')
      .success(function(data) {
        alert('Se cambio de fecha exitosamente');
        }).error(function(data,status) {
            alert('No se pudo cambiar de fecha, error (' + status + ')');
        });
    }

    $scope.runLeagues = function(){
      $scope.tournamentBegan = true;
      $http.put('http://localhost:8080/desapp-grupoB022015-backend/rest/league/initializeFixtures')
      .success(function(data) {
        alert('Empezo el torneo');
        }).error(function(data,status) {
            alert('No pudo arrancar el torneo, error (' + status + ')');
        });
    }

});
