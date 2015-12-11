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

  $scope.profile = auth.profile;

  $scope.logout = function() {
  	auth.signout();
    $scope.profile= undefined;
  	location = '#/';
  }

  home.getRankingPoints = function(){
    $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/user/getUser/' + auth.profile.user_id).success(function(data) {
      $scope.rankingPoints = data.rankingPoints;
    });
  }
  home.getRankingPoints();

});