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

    }

    $scope.addPlayer = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/addPlayer/' + $scope.playerteam + '/' + $scope.playername + '/' + $scope.playerposition,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var l in obj)
                        str.push(encodeURIComponent(l) + "=" + encodeURIComponent(obj[l]));
            return str.join("&");
            },
        }).success(function (data) {
                alert('El jugador fue agregado satisfactoriamente')
        }).error(function(data,status) {
                alert("Error (" + status +"): " + "no se pudo agregar el jugador.");
                location = '#/';
        });
    }

    var rt = this;

    rt.refreshTeams = function(){
        console.log("ejec");
        $http.get('http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/list').success(function (data) {
            rt.teams = data;
        });
    }

    $scope.addTeam = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/desapp-grupoB022015-backend/rest/realTeam/create/' + $scope.team,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var l in obj)
                        str.push(encodeURIComponent(l) + "=" + encodeURIComponent(obj[l]));
            return str.join("&");
            },
        }).success(function (data) {
                alert('El equipo fue agregado satisfactoriamente')
        }).error(function(data,status) {
                alert("Error (" + status +"): " + "no se pudo agregar el equipo.");
                location = '#/';
        });
        rt.refreshTeams();
    }

    rt.refreshTeams();

});
function UploadRTeamsCtrl($scope){
    $scope.param = {};
}