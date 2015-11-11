'use strict';

/**
 * @ngdoc function
 * @name desappGrupoB022015FrontendApp.controller:UserCtrl
 * @description
 * # UserCtrl
 * Controller of the desappGrupoB022015FrontendApp
 */

  angular.controller('CreateUserCtrl', function ($scope, $http) {

		$scope.createUser = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/user/create/',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var l in obj)
                        str.push(encodeURIComponent(l) + "=" + encodeURIComponent(obj[l]));
            return str.join("&");
            },

            data: {userName: $scope.userName}

        }).success(function (data) {
        	alert("El usuario fue creado correctamente.");
            location = "#/signin";
		});
    }
    changeClass();
}
  });

