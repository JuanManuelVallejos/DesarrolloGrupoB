'use strict';

var leagueApp = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
leagueApp.controller('CreateLeagueCtrl', function ($scope, $http) {

		$scope.createLeague = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/league/create/',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var l in obj)
                        str.push(encodeURIComponent(l) + "=" + encodeURIComponent(obj[l]));
            return str.join("&");
            },

            data: {name: $scope.nombre, minTeams: $scope.minTeams, maxTeams: $scope.maxTeams}

        }).success(function (data) {

		});
    }
    changeClass();
}
