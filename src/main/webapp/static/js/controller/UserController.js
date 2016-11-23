//todo 使用$scope 还是 this 有待考证
App.controller('UserController', ['async','$log', function (async,$log) {
    var self = this;
    self.users = async;
    self.totalItems = 64;
    self.currentPage = 1;

    self.setPage = function (pageNo) {
        currentPage = pageNo;
        $log.log('Page click to: ' + self.currentPage);
    };

    self.pageChanged = function() {
        $log.log('Page changed to: ' + self.currentPage);
    };

    self.maxSize = 5;
    self.bigTotalItems = 175;
    self.bigCurrentPage = 1;
}]);

//App.controller('UserController', function ($scope, $log) {
//    $scope.totalItems = 64;
//    $scope.currentPage = 1;
//
//    $scope.setPage = function (pageNo) {
//        $scope.currentPage = pageNo;
//        $log.log('Page click to: ' + $scope.currentPage);
//    };
//
//    $scope.pageChanged = function() {
//        $log.log('Page changed to: ' + $scope.currentPage);
//    };
//
//    $scope.maxSize = 5;
//    $scope.bigTotalItems = 175;
//    $scope.bigCurrentPage = 1;
//});
