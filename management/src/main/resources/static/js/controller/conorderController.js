app.controller('conorderController',function ($http,$scope) {
    $scope.condition = {};
    $scope.loadDataFirst = 1;
    $scope.addOrder={};
    //分页控件配置
    $scope.saveconsumer = {};
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 20, 30, 40],
        onChange: function () {
            if ($scope.loadDataFirst == 1) {
                $scope.reloadList(); //重新加载
                $scope.loadDataFirst = 2;
            } else if ($scope.loadDataFirst == 2) {
                $scope.loadDataFirst = 0;
            } else if ($scope.loadDataFirst == 0) {
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
    $scope.search=function (page,size) {
        $http.post('../conorder/find/'+page+'/'+size,$scope.condition).success(
            function (response) {
                $scope.entry=response;
                $scope.paginationConf.totalItems=response.nums;
            }
        )
    }
    $scope.findConsumer=function () {
        $http.get('../consumer/findConsumer').success(
            function (response) {
                $scope.consumer=response;
            }
        )
    }
    $scope.findSeller=function () {
        $http.get('../staff/findSeller').success(
            function (response) {
                $scope.seller=response;
            }
        )
    }
    $scope.saveOrder=function () {
        $http.post('../conorder/saveOrder',$scope.addOrder).success(
            function (response) {
                $scope.reloadList();
                alert(response.map.msg)
            }
        )
    }

})

