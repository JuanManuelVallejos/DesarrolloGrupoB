'use strict';

var leagueApp = angular.module('LeagueApp', []);

/* Controllers */
leagueApp.controller('LeagueController', function ($scope, $http) {

		
		$scope.createLeague = function(){
		    var league = {
		    	name : $scope.nombre,
		    	minTeams : $scope.minTeams,
		    	maxTeams: $scope.maxTeams
		    }
			$http.post('http://localhost:8080/desapp-grupoB022015-backend/rest/league/create', league).success(function(data){
				alert("Se creo una liga");
			});
		}
		
	});