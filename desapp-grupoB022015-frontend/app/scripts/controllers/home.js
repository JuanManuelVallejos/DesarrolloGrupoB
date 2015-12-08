'use strict';

/**
 * @ngdoc function
 * @name desappGrupoB022015FrontendApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the desappGrupoB022015FrontendApp
 */
angular.module('desappGrupoB022015FrontendApp')
  .controller('HomeCtrl', function ($scope, $http) {

	var hm = this;

    $http.get('https://www.googleapis.com/auth/userinfo.email').success(function (data) {
        hm.infor = data;
    });
	});