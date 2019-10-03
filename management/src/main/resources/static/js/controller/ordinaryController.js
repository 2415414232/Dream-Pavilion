app.controller('ordinaryController',function ($scope,$http) {
    $scope.condition={};
    $scope.loadDataFirst = 1;
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 20, 30, 40],
        onChange: function(){
            if($scope.loadDataFirst == 1) {
                $scope.reloadList(); //重新加载
                $scope.loadDataFirst = 2;
            }else if($scope.loadDataFirst == 2) {
                $scope.loadDataFirst = 0;
            }else if ($scope.loadDataFirst == 0) {
                $scope.reloadList(); //重新加载
            }
        }

    };
    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        //$scope.findPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    //查询所有普通人员
    $scope.search=function (page,size) {
        $http.post('../../ordinary/findAll/'+page+'/'+size,$scope.condition).success(
            function (response) {
                $scope.list=response.list;
                $scope.paginationConf.totalItems=response.nums;

            }
        )
    }
    //禁用y
    $scope.banConsumer=function (id) {
        $http.get('../../ordinary/prohibit/'+id).success(
            function (response) {
                $scope.reloadList();
                alert(response.map.msg);
                //$scope.message=response;
            }
        )
    }
    $scope.actiivation=function (id) {
        $http.get('../../ordinary/actiivation/' + id).success(
            function (response) {
                $scope.reloadList();
                alert(response.map.msg);
                //$scope.message=response;
            }
        )
    }

})