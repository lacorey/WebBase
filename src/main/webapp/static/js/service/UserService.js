App.factory('UserService',['$http','$q',function($http,$q){
    return{
        fetchUserList: function (page) {
            if(page == null)page == 1;
            $http.get('/listuser?page='+page).success(function (response) {
                console.log(response);
                return response;
            });
                //.then(
                //    function(response){
                //        console.log(response.data);
                //        return response.data;
                //    },
                //    function(errResponse){
                //        console.error('Error while fetch user list');
                //        return $q.reject(errResponse);
                //    }
                //);
        }
    };

}]);