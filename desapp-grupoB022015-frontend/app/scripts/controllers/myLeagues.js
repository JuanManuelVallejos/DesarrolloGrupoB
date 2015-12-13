'use strict';

angular.module('desappGrupoB022015FrontendApp')
.controller('MyLeaguesCtrl', LeagueCtrl);


function LeagueCtrl($http,$scope, auth) {

  var mlc = this;

  $scope.profile = auth.profile;

  $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/league/list').success(function (data) {
      mlc.myLeagues = data;
    });

    mlc.editLeague = function(league) {
      location = '#/editLeague/' + league.id;
    };

    mlc.showFixture = function(league) {
      location = '#/showFixture/' + league.id;
    };

}