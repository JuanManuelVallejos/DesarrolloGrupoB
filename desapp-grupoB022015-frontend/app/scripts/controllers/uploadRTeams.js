'use strict';

var uploadRTeams = angular.module('desappGrupoB022015FrontendApp');

/* Controllers */
var global = 0;
uploadRTeams.directive('file', function(){
    return {
        scope: {
            file: '='
        },
        link: function(scope, el, attrs){
            el.bind('change', function(event){
                var files = event.target.files;
                var file = files[0];
                scope.file = file ? file.name : undefined;
                scope.$apply();
                global = file;
                console.log(file);
            });
        }
    };
}).controller('UploadRTeamsCtrl', function ($scope, $http) {

    $scope.uploadRT = function(){
/*
    $http.post('http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/createPlayers/' + global.name)
        .success(function(data) {
                alert('Equipos subidos correctamente');
                location = '#/';
        }).error(function(data,status) {
            alert('No se pudieron subir los equipos, error (' + status + ')');
        });
*/


    $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/createPlayers',
            headers: {'Content-Type': 'multipart/form-data'},
            data: {is: global.name}
        }).success(function(data) {
                alert('Equipos subidos correctamente');
                location = '#/';
        }).error(function(data,status) {
            alert('No se pudieron subir los equipos, error (' + status + ')');
        });

}});
function UploadRTeamsCtrl($scope){
    $scope.param = {};
}