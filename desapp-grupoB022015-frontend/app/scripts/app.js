'use strict';

/**
 * @ngdoc overview
 * @name desappGrupoB022015FrontendApp
 * @description
 * # desappGrupoB022015FrontendApp
 *
 * Main module of the application.
 */
angular
  .module('desappGrupoB022015FrontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'auth0',
    'angular-storage',
    'angular-jwt'
  ])
  .config(function ($routeProvider,authProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/home', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl',
        requiresLogin: true

      })
      .when('/createTeam', {
        templateUrl: 'views/createTeam.html',
        controller: 'CreateTeamCtrl',
        requiresLogin: true
      })
      .when('/updateRound', {
        templateUrl: 'views/updateRound.html',
        controller: 'UpdateRoundCtrl',
        requiresLogin: true
      })
      .when('/createLeague', {
        templateUrl: 'views/createLeague.html',
        controller: 'CreateLeagueCtrl',
        requiresLogin: true
      })
      .when('/activeLeagues', {
        templateUrl: 'views/activeLeagues.html',
        controller: 'LeagueCtrl',
        requiresLogin: true
      })
      .when('/createUser', {
        templateUrl: 'views/createUser.html',
        controller: 'CreateUserCtrl',
      })
      .when('/uploadRTeams', {
        templateUrl: 'views/uploadRTeams.html',
        controller: 'UploadRTeamsCtrl',
        requiresLogin: true
      })
      .when('/editLeague/:idLeague', {
        templateUrl: 'views/editLeague.html',
        controller: 'EditLeagueCtrl',
        requiresLogin: true
      })
      .otherwise({
        redirectTo: '/'
      });
      authProvider.init({
      domain: 'supergolgrupob.auth0.com',
      clientID: 'lZL8EWPowrIK05acdRHN3HiKPi8stO7u',
      loginUrl: '/createUser',
      });
  }).run(function(auth) {
  // This hooks al auth events to check everything as soon as the app starts
    auth.hookEvents();
}).controller('AppCtrl', function($scope, $http, auth) {
  // Using a promise

  var app = this;

  app.setProfile = function(profile){
    $scope.profile = auth.profile;
        $scope.profile.roles = auth.profile.roles;
        $scope.profile.id = auth.profile.user_id.split("google-oauth2|")[1];

        $http.put('http://localhost:8080/desapp-grupoB022015-backend/rest/user/create/' + auth.profile.nickname + '/' + $scope.id)
        .success(function(data) {
                alert('Bienvenido! ' + auth.profile.given_name);

        location = '#/home';
        }).error(function(data,status) {
            alert('No se pudo registrar correctamente, error (' + status + ')');
        });

        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/user/getUser/' + $scope.id).success(function(data) {
          $scope.user = data;
        });
  }

  $scope.checkProfile = function(profile){
    if(auth.profile != undefined){
      if($scope.profile == undefined){
        app.setProfile(profile);
      }
      return true;
    }else{
      return false;
    }
  }

  $scope.checkAdmin = function(profile){
    if($scope.profile != undefined){
      if($scope.profile == undefined){
        app.setProfile(profile);
      }
      if(auth.profile.roles != undefined){
        if(!(auth.profile.roles.indexOf('admin') === -1)){
          return true;
        }
      }
    }
    return false;
  }

  
});