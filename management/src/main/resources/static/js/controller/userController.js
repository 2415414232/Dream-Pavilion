app.controller('userController',function ($scope,$http) {   //后台用户
    $scope.user={};
    $scope.boolean=false;
    $scope.message="";
    $scope.tocken="";
    $scope.userss={};


$scope.addUser=function () {
    console.log($scope.user.length)
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
    $http.get("../user/findUser").success(
        function (response) {
            $scope.userss=response.map.list;
        }
    )
}
$scope.login=function () {
    $http.post('../user/login',$scope.user).success(
        function(response){
              if(response.res){
                  $scope.boolean=false;
                  $scope.tocken=response.map.tocken;
                  $http.post('../user/index',{'name':response.map.name},{ headers : {'Authorization': $scope.tocken}}).success(
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
//删除用户
    $scope.deleteUser=function (uid,username) {

        if(confirm("你确定要删除"+username+"用户吗？")){
            $http.get('../user/deleteUser/'+uid).success(
                function (response) {
                    window.location.reload();
                }
            )
        }
    }
})