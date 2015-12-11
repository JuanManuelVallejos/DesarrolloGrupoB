'use strict';


angular.module('desappGrupoB022015FrontendApp').controller('CreateUserCtrl', ['$scope', '$http', 'auth', 'store', '$location',
function ($scope, $http, auth, store, $location) {
  
  var login = this;

  login.setRules = function (user) {
    user.roles = [];

    if (user.email === 'juanmanuelvallejos2@gmail.com') user.roles.push('admin');

    // all users are guest
    user.roles.push('guest');

  }

  $scope.login = function () {
    auth.signin({}, function (profile, token) {
      // Success callback
      store.set('profile', profile);
      store.set('token', token);
      login.setRules(profile);
      location = '#/home'
    });
  }

}]);