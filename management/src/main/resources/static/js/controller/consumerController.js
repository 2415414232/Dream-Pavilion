app.controller('consumerController',function ($scope,$http) {
    $scope.condition={};
    $scope.loadDataFirst = 1;
    //分页控件配置
    $scope.saveconsumer={};
    $scope.goods={};
    $scope.num={}
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
    /!*时间转换*!/
    $scope.transform = function (transTime) {
        var date = new Date(transTime);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var d = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        return year + '-' + month + '-' + d;
    };
    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        //$scope.findPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    $scope.search=function (page,size) {
        $http.post('../consumer/findAll/'+page+'/'+size,$scope.condition).success(
            function (response) {
                $scope.entitys=response.list;
                $scope.paginationConf.totalItems=response.nums;

            }
        )
    }
        //查找
    $scope.findOne=function (id) {
        $http.get('../consumer/findOne/'+id).success(
            function (response) {
                $scope.findone=response;
                $scope.findone.contime=$scope.transform(response.contime);
            }
        )
    }

    $scope.findService=function () {
        $http.get('../consumer/findService').success(
            function (response) {
                $scope.allservice=response;
            }
        )
    }
    $scope.editConsumer=function () {
        $http.post('../consumer/editConsumer',$scope.findone).success(
            function (response) {
                $scope.reloadList();
                alert(response.map.msg);
            }
        )
    }

    $scope.saveConsumer=function () {
        $http.post('../consumer/saveConsumer',$scope.saveconsumer).success(
            function (response) {
                $scope.reloadList();
                alert(response.map.msg);
            }
        )
    }
    //保存服务
    $scope.saveGoods=function () {
            $http.post('../goods/saveGoods',$scope.goods).success(
                function (response) {
                    alert(response.map.msg);
                    window.location.reload();
                }
            )
    }
    //删除服务
    $scope.deleteGoods=function (id) {
        if(confirm("确定要删除吗？")) {


            $http.get('../goods/deleteGoods/' + id).success(
                function (response) {
                    window.location.reload();
                }
            )
        }
    }
    $scope.findGoodsById=function (id) {
        $http.get('../goods/findGoodsById/'+id).success(
            function (response) {
                $scope.goods=response.map.msg;

            }
        )
    }
    $scope.updateGoods=function (id) {
        $http.post('../goods/updateGoods/',$scope.goods).success(
            function (response) {
                alert(response.map.msg);
                window.location.reload();

            }
        )
    }
    $scope.findordernum=function () {
        $http.get('../goods/findordernum').success(
            function (response) {
                //console.log(response)
                $scope.num=response.map.msg;
            }
        )
    }
})