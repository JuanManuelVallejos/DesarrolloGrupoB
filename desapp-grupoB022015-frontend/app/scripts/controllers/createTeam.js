'use strict';

var leagueApp = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
leagueApp.controller('CreateTeamCtrl', function ($scope, $http) {

		$scope.createTeam = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/user/createMyTeam/' + $scope.teamname + '/' + 1,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var l in obj)
                        str.push(encodeURIComponent(l) + "=" + encodeURIComponent(obj[l]));
            return str.join("&");
            },
           // data: {name: $scope.leaguename, minTeams: $scope.minTeams, maxTeams: $scope.maxTeams}
        }).success(function (data) {
                alert('El equipo fue creado satisfactoriamente')
		}).error(function(data,status) {
                alert("Error no se pudo crear el equipo.");
                location = '#/';
        });
    }

     var pl = this;

        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/player/list').success(function (data) {
        pl.players = data;
        });

    $scope.searchPlayers = function() {
       
    }

    $scope.addPlayer = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/user/addPlayer/' + $scope.player.getId() + '/' + 1,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var l in obj)
                        str.push(encodeURIComponent(l) + "=" + encodeURIComponent(obj[l]));
            return str.join("&");
            },
           // data: {name: $scope.leaguename, minTeams: $scope.minTeams, maxTeams: $scope.maxTeams}
        }).success(function (data) {
                alert('El jugador fue agregado satisfactoriamente')
        }).error(function(data,status) {
                alert("Error no se pudo agregar al jugador al equipo.");
                location = '#/';
        });
    }



});