'use strict';


angular.module('desappGrupoB022015FrontendApp').controller('CreateUserCtrl', ['$scope', '$http', 'auth', 'store', '$location',
function ($scope, $http, auth, store, $location) {
  
  var login = this;

  login.setProfile = function(profile){
    $scope.profile = auth.profile;
        $scope.profile.roles = auth.profile.roles;
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

  login.setRules = function (user) {
    user.roles = [];
    // only johnfoo is admin
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
      login.setProfile(profile);
      location = '#/home'
    });
  }

}]);