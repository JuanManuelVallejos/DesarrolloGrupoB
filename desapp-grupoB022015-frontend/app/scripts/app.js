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
      .when('/home/:id', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl',
      })
      .when('/createTeam', {
        templateUrl: 'views/createTeam.html',
        controller: 'CreateTeamCtrl',
      })
      .when('/updateRound', {
        templateUrl: 'views/updateRound.html',
        controller: 'UpdateRoundCtrl',
      })
      .when('/createLeague', {
        templateUrl: 'views/createLeague.html',
        controller: 'CreateLeagueCtrl',
      })
      .when('/activeLeagues', {
        templateUrl: 'views/activeLeagues.html',
        controller: 'LeagueCtrl',
      })
      .when('/createUser', {
        templateUrl: 'views/createUser.html',
        controller: 'CreateUserCtrl',
      })
      .when('/uploadRTeams', {
        templateUrl: 'views/uploadRTeams.html',
        controller: 'UploadRTeamsCtrl',
      })
      .when('/editLeague/:idLeague', {
        templateUrl: 'views/editLeague.html',
        controller: 'EditLeagueCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
      authProvider.init({
      domain: 'supergolgrupob.auth0.com',
      clientID: 'lZL8EWPowrIK05acdRHN3HiKPi8stO7u'
      });
  }).run(function(auth) {
  // This hooks al auth events to check everything as soon as the app starts
    auth.hookEvents();
});