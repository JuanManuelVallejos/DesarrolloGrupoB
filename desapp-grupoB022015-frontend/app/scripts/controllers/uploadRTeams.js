'use strict';

var uploadRTeams = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
uploadRTeams.controller('UploadRTeamsCtrl', function ($scope, $http) {

    $scope.uploadRT = function(){
        var file = $scope.files;
        //console.log(file);
    
  	$http.put('http://localhost:8080/desapp-grupoB022015-backend/rest/supergol/setRealTeams/' + $scope.files)
        .success(function(data) {
                alert('Equipos subidos correctamente');
                location = '#/';
        }).error(function(data,status) {
            alert('No se pudieron subir los equipos, error (' + status + ')');
        });

      
    };
	}	
});