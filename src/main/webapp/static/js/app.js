var App = angular.module('myApp', ['ui.router','ui.bootstrap']);
App.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/home");
    $stateProvider
        .state(
            'user', {
                url: "/user/:page",
                templateUrl: 'tpl_user.html',
                controller: 'UserController',
                //resolve: {
                //    halo: ['UserService','$stateParams', function (UserService,$stateParams) {
                //        console.log($stateParams.page);
                //        return UserService.fetchUserList($stateParams.page);
                //    }]
                //}

            })
        .state(
            'data', {
                url: '/data',
                templateUrl: 'tpl_data.html'
            }
        )
        .state(
            'export', {
                url: "/export",
                templateUrl: 'tpl_export.html'
            }
        )

}]);