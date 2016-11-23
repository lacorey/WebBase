
App.factory('UserService',['$http','$q',function($http,$q){
    return{

        fetchUserList: function () {
            return $http.get('/listuser')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetch user list');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}]);