App.controller('UserController', ['$http','$scope','$stateParams','$log', function ($http,$scope,$stateParams,$log) {
    $scope.currentPage = 1;
    $scope.test = "test";
    $scope.setPage = function (pageNo) {
        $log.log('Page setPage to: ' + pageNo);
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function() {
        $log.log('Page changed to: ' + $scope.currentPage);
        $scope.fetchUserList($scope.currentPage);
    };

    $scope.fetchUserList = function(page){
        $http.get('/listuser?page='+page).success(function (response) {
            $scope.users = response.data;
            $scope.totalItems = response.count;
            return response;
        });
    }

    $scope.page = $stateParams.page;
    $scope.fetchUserList($scope.page);


    $scope.deleteUser = function(id){
        $http.get('/deleteuser?id='+id).success(function (response) {
            var delStatus = response.status;
            if(delStatus == 1){
                $scope.fetchUserList($scope.page);
            }
        });
    }


}]);

