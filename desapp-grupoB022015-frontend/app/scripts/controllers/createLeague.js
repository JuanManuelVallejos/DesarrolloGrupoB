'use strict';

var leagueApp = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
leagueApp.controller('CreateLeagueCtrl', function ($scope, $http, auth) {

        $scope.profile = auth.profile;

		$scope.createLeague = function() {
        $http.post('http://localhost:8080/desapp-grupoB022015-backend/rest/league/create/' + $scope.leaguename + '/' + $scope.minTeams + '/' + $scope.maxTeams +'/' + $scope.profile.user_id).success(function (data) {
                location = "#/myLeagues";
		}).error(function(data,status) {
                alert("Error (" + status +"): " + "no se pudo crear la liga.");
                location = '#/';
        });
    }
});