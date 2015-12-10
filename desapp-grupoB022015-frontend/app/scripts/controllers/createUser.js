'use strict';


angular.module('desappGrupoB022015FrontendApp').controller('CreateUserCtrl', ['$scope', '$http', 'auth', 'store', '$location',
function ($scope, $http, auth, store, $location) {
  $scope.login = function () {
    auth.signin({}, function (profile, token) {
      // Success callback
      store.set('profile', profile);
      store.set('token', token);
      var idUs = profile.user_id.split("google-oauth2|")[1];
      var path = "#/home/".concat(idUs);
      location = '#/home'
    });
  }

}]);