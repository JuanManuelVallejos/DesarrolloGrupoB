'use strict';

//var createUserApp = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
/*createUserApp.controller('CreateUserCtrl', function ($scope, $http) {

		$scope.createUser = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/user/create/' + $scope.userName + '/' + $scope.password,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        }).success(function (data) {
                alert('Usuario creado satisfactoriamente')
                location = '#/signin';
		    }).error(function(data,status) {
                alert("Error (" + status +"): " + "no se pudo crear el usuario.");
                location = '#/';
        });
    }
});
*/

angular.module('desappGrupoB022015FrontendApp').controller('CreateUserCtrl', ['$scope', '$http', 'auth', 'store', '$location',
function ($scope, $http, auth, store, $location) {
  $scope.login = function () {
    auth.signin({}, function (profile, token) {
      // Success callback
      store.set('profile', profile);
      store.set('token', token);
      $location.path('/');
    }, function () {
      // Error callback
    });
  }
}]);