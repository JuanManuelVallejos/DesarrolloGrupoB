'use strict';

/**
 * @ngdoc function
 * @name desappGrupoB022015FrontendApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the desappGrupoB022015FrontendApp
 */

angular.module('desappGrupoB022015FrontendApp').controller('HomeCtrl', function($scope, $http, auth) {

  var home = this;


  $scope.checkProfile = function(profile){
    return (auth.profile != undefined);
  }

  $scope.logout = function() {
  	auth.signout();
    $scope.profile= undefined;
  	location = '#/';
  }

  $scope.profile = auth.profile;

});