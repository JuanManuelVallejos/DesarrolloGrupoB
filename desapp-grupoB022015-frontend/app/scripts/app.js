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
        controllerAs: 'signin'
      })
      .when('/update_round', {
        templateUrl: 'views/update_round.html',
        controller: 'Update_round.Ctrl',
        controllerAs: 'update_round'
      })
      .when('/create_tournament', {
        templateUrl: 'views/create_tournament.html',
        controller: 'Create_tournament.Ctrl',
        controllerAs: 'create_tournament'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
