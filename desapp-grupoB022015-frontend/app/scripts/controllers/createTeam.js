'use strict';

var leagueApp = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
leagueApp.controller('CreateTeamCtrl', function ($scope, $http, auth) {

    $scope.profile = auth.profile;

	$scope.createTeam = function() {
    $http.post('http://localhost:8080/desapp-grupoB022015-backend/rest/user/createMyTeam/' + $scope.teamname + '/' + $scope.profile.user_id).success(function (data) {
            alert('El equipo fue creado satisfactoriamente');
            $scope.fantasyTeam = true;
            $scope.fantasyTeamName = $scope.teamname;
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
       $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/getPlayers/'+ $scope.playerteam +'/' + $scope.playerposition).success(function (data) {
            pl.players = data;
        });
    }
    
    pl.refreshGoalkeeper = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/searchGoalkeeper/'+$scope.profile.user_id).success(function(data){
            $scope.goalkeeper = data;
        });
    }

    pl.refreshDefenders = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/getPlayersByPosition/'+$scope.profile.user_id+"/Defender").success(function(data){
            $scope.defenders = data;
        });
    }

    pl.refreshMidfielders = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/getPlayersByPosition/'+$scope.profile.user_id+"/Midfielder").success(function(data){
            $scope.midfielders = data;
        });
    }

    pl.refreshForwards = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/getPlayersByPosition/'+$scope.profile.user_id+"/Forward").success(function(data){
            $scope.forwards = data;
        });
    }

     pl.updatePlayers = function() {
        pl.refreshGoalkeeper();
        pl.refreshDefenders();
        pl.refreshMidfielders();
        pl.refreshForwards();
    };

    $scope.addMyPlayer = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/canAddAPlayer/' + $scope.playerid +'/' + $scope.profile.user_id).success(function(data){
            $scope.iCanAdd =  data;
            pl.addMyPlayerB();
        })
    }

    pl.addMyPlayerB = function() {
        if($scope.iCanAdd){
            $http.post('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/addOnePlayer/'+ $scope.playerid +'/' + $scope.profile.user_id).success(function (data) {
                    alert('El jugador fue agregado satisfactoriamente');
            }).error(function(data,status) {
                    alert("Error no se pudo agregar al jugador al equipo.");
            });
            pl.updatePlayers();
            pl.isTeamComplete();
        }else{
            alert('No puede agregar este jugador');
        }
    }

    pl.refreshTeams = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/list').success(function (data) {
            pl.teams = data;
        });
    }

    pl.haveFantasyTeam = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/haveFantasyTeam/' + $scope.profile.user_id).success(function(data){
            $scope.fantasyTeam = data;
            pl.getFantasyName();
        });
    }

    pl.getFantasyName = function(){
        if($scope.fantasyTeam){
            $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/myFantasyTeam/' + $scope.profile.user_id).success(function(data){
                $scope.fantasyTeamName = data.name;
            });
        }
    }

    pl.isTeamComplete = function(){
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/fantasyTeam/isTeamComplete/' + $scope.profile.user_id).success(function(data){
            $scope.teamComplete = data;
        })
    }

    pl.haveFantasyTeam();
    pl.refreshTeams();
    pl.updatePlayers();
    pl.isTeamComplete();
    
});