var routerApp = angular.module('routerApp', ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');
    $stateProvider

    // HOME STATES AND NESTED VIEWS ========================================
        .state('user', {
            url: '/user',
            templateUrl: 'tpluser.html',
            controller: 'userController',
            resolve:{
                promiseObj2:  function($http){
                    return $http({method: 'GET', url: '/listuser'})
                        .then (function (data) {
                            console.log(data);
                            return data;
                        });
                },
            }
        })

        // nested list with custom controller
        .state('data', {
            url: '/data',
            templateUrl: 'tpldata.html'
        })

        // nested list with just some random string data
        .state('export', {
            url: '/export',
            templateUrl: 'tplexport.html'
        })

        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('about', {
            url: '/about',
            views: {
                '': { templateUrl: 'partial-about.html' },
                'columnOne@about': { template: 'Look I am a column!' },
                'columnTwo@about': {
                    templateUrl: 'table-data.html',
                    controller: 'scotchController'
                }
            }

        });
});

//routerApp.controller('scotchController', function($scope) {
//
//    $scope.message = 'test';
//
//    $scope.scotches = [
//        {
//            name: 'Macallan 12',
//            price: 50
//        },
//        {
//            name: 'Chivas Regal Royal Salute',
//            price: 10000
//        },
//        {
//            name: 'Glenfiddich 1937',
//            price: 20000
//        }
//    ];
//
//});
