'use strict';

angular.module('desappGrupoB022015FrontendApp')
.controller('LeagueCtrl', LeagueCtrl);


function LeagueCtrl($http) {

	var ls = this;

	$http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/league/list').success(function (data) {
    	ls.leagues = data;
    });

    ls.editLeague = function(league) {
      location = '#/editLeague/' + league.id;
    };

}