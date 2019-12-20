app.controller('userController',function ($scope,$http) {   //后台用户
    $scope.user={};
    $scope.boolean=false;


$scope.addUser=function () {

        $http.post('../user/addUser',$scope.user).success(
            function (response) {

            }
        )
    }


$scope.blur=function () {
    if($scope.user.upassword==$scope.user.uupassword){
        $scope.boolean=false;
    }else{
        $scope.boolean=true;
    }
}


})