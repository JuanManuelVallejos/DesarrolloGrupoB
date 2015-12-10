'use strict';

/**
 * @ngdoc function
 * @name desappGrupoB022015FrontendApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the desappGrupoB022015FrontendApp
 */

angular.module('desappGrupoB022015FrontendApp').controller('HomeCtrl', function($scope, $http, auth) {


  $scope.checkProfile = function(profile){
    if(auth.profile != undefined){
      if($scope.profile == undefined){
        $scope.profile = auth.profile;
        $scope.id = auth.profile.user_id.split("google-oauth2|")[1];

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
      return true;
    }else{
      return false;
    }
  }

  $scope.logout = function() {
  	auth.signout();
    $scope.profile= undefined;
  	location = '#/';
  }

});