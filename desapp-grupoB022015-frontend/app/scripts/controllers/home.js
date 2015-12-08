'use strict';

/**
 * @ngdoc function
 * @name desappGrupoB022015FrontendApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the desappGrupoB022015FrontendApp
 */

angular.module('desappGrupoB022015FrontendApp').controller('HomeCtrl', function($scope, $http, auth) {
  // Using a promise
  auth.profilePromise.then(function(profile) {
    $scope.profile = profile;
  });
  // Or using the object
  $scope.profile = auth.profile;
  $scope.id = auth.profile.user_id.split("google-oauth2|")[1];
  
  $scope.logout = function() {
  	auth.signout();
  	store.remove('profile');
  	store.remove('token');
  	location = '#/';
  }

});