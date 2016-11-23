var App = angular.module('myApp', ['ui.router','ui.bootstrap']);
App.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/home")

    $stateProvider
        .state(
            'user', {
                url: "/user",
                templateUrl: 'tpl_user.html',
                controller: 'UserController as userController',
                resolve: {
                    async: ['UserService', function (UserService) {
                        return UserService.fetchUserList();
                    }]
                }
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