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
    'ngTouch'
  ])
  .config(function ($routeProvider) {
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
      .when('/signin', {
        templateUrl: 'views/signin.html',
        controller: 'SinginCtrl',
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
      .otherwise({
        redirectTo: '/'
      });
  });
