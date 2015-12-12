'use strict';

angular.module('desappGrupoB022015FrontendApp')
.controller('LeagueCtrl', LeagueCtrl);


function LeagueCtrl($http) {

	var lc = this;

	$http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/league/list').success(function (data) {
    	lc.leagues = data;
    });

    lc.editLeague = function(league) {
      location = '#/editLeague/' + league.id;
    };

    lc.showFixture = function(league) {
      location = '#/showFixture/' + league.id;
    };

}