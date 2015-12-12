'use strict';

var leagueApp = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
leagueApp.controller('CreateLeagueCtrl', function ($scope, $http, auth) {

        $scope.profile = auth.profile;

		$scope.createLeague = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/league/create/' + $scope.leaguename + '/' + $scope.minTeams + '/' + $scope.maxTeams +'/' + $scope.profile.user_id,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var l in obj)
                        str.push(encodeURIComponent(l) + "=" + encodeURIComponent(obj[l]));
            return str.join("&");
            },
           // data: {name: $scope.leaguename, minTeams: $scope.minTeams, maxTeams: $scope.maxTeams}
        }).success(function (data) {
                alert('La liga fue creada satisfactoriamente')
		}).error(function(data,status) {
                alert("Error (" + status +"): " + "no se pudo crear la liga.");
                location = '#/';
        });
    }
});