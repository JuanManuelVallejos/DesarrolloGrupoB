'use strict';

/**
 * @ngdoc function
 * @name desappGrupoB022015FrontendApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the desappGrupoB022015FrontendApp
 */
angular.module('desappGrupoB022015FrontendApp').controller('MainCtrl', ['$scope', '$http', 'auth', 'store', '$location',
function ($scope, $translate, $cookies, auth, store, $log, $location, $http) {
	
	$scope.upload = function(file) {
     console.log(file);
     var data =  {
          name : file.name,
          file : file
    };
    
    $http.post('http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/createPlayers',file).success(function(response){     
           alert('Se actualizo la fecha');
      });
  
	};

  
}]);