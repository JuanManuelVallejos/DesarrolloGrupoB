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

  $scope.checkProfile = function(profile){
    if(auth.profile != undefined){
      $scope.profile = auth.profile;
      $scope.id = auth.profile.user_id.split("google-oauth2|")[1];
      return true;
    }else{
      return false;
    }
  }
  
  $scope.logout = function() {
  	auth.signout();
  	location = '#/';
  }


});