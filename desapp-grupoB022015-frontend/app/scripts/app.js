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
      .otherwise({
        redirectTo: '/'
      });
  });
