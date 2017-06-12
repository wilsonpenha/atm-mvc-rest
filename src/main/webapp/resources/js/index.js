var app = angular.module('atms', [],function(){

});

app.controller('mainController', ['$scope', '$window', 'mainFactory', function($scope, $window, mainFactory) {

    var $body = $("body");

    $scope.currentFilter = "city";
    $scope.filterValue = "";

    $scope.updateFilter = function(filter) {
        $scope.currentFilter = filter;
    };


    $body.addClass("loading");
    mainFactory.getAtms().then(function(atms){
        $body.removeClass("loading");
        $scope.atms = atms.data;
    });

    $scope.searchAtms = function() {
        $body.addClass("loading");
        mainFactory.getAtmsByFilter($scope.currentFilter.toLowerCase(),$scope.filterValue.toLowerCase()).then(function(atms){
            $body.removeClass("loading");
            $scope.atms = atms.data;
        });
    }
    
    $scope.clearFilter = function () {
        $scope.filterValue = "";
        $body.addClass("loading");
        mainFactory.getAtms().then(function(atms){
            $body.removeClass("loading");
            $scope.atms = atms.data;
        });
    }

    $scope.getLocationMap = function (type,num,street,postcode,city,lat,lgt) {
    	$window.open('https://www.google.com.br/maps/dir/'+street+' '+num+', '+postcode+' '+city+',+Netherlands/'+street+' '+num+', '+postcode+' '+city+'/@'+lat+','+lgt+',16.9z', '_blank');
    }
}]);

app.factory('mainFactory', ["$http", function($http){

    return {
        getAtms: function() {
            return $http.get('/atm-mvc-rest/list');
        },
        getAtmsByFilter: function(filter,value) {
            return $http.get('/atm-mvc-rest/search/' + filter + '/' + value);
        }
    }

}]);