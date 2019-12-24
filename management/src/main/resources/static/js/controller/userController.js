app.controller('userController',function ($scope,$http) {   //后台用户
    $scope.user={};
    $scope.boolean=false;
    $scope.message="";
    $scope.tocken="";


$scope.addUser=function () {

        $http.post('../user/addUser',$scope.user).success(
            function (response) {
                alert(response.map.msg);
                window.location.reload();
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
$scope.findUser=function () {
    $http.get("")
}
$scope.login=function () {
    $http.post('../user/login',$scope.user).success(
        function(response){
              if(response.res){
                  $scope.boolean=false;
                  $scope.tocken=response.map.tocken;
                  $http.post('../user/index',response.map.name,{ headers : {'Authorization': $scope.tocken}}).success(
                      function (res) {
                          if(res.res){


                              window.location.replace("http://localhost:8889/admin/index.html");

                          }
                      }
                  );

              }else{
                  $scope.boolean=true;
                  $scope.message=response.map.msg;

              }



        }
    )
}

$scope.findName=function () {
     $http.get('../user/findName').success(
         function (response) {
             $scope.message=response.map.name;
         }
     )
}
//注销
    $scope.logout=function () {
        $http.get('../user/logout').success(
            function (response) {
                window.location.replace("http://localhost:8889/admin/login.html");
            }
        )
    }

})