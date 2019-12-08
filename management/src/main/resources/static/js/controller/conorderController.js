app.controller('conorderController',function ($http,$scope) {
    $scope.condition = {};
    $scope.loadDataFirst = 1;
    $scope.addOrder={};
    $scope.consumer={};
    $scope.seller={};
    $scope.check=[];
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
                $scope.addOrder={};
            }
        )
    }
    //编辑预约信息的查询数据
    $scope.editOne=function (id) {
        $http.get('../conorder/editOne/'+id).success(
            function (response) {
                $scope.addOrder=response;
            }
        )
    }
    //编辑后保存
    $scope.editOrder=function () {
        $http.post('../conorder/editOrder',$scope.addOrder).success(
            function (response) {
                alert(response.map.msg);
                $scope.reloadList();
                $scope.addOrder={};
            }
        )
    }
    //复选框
    $scope.selected=function ($event,id) {
        if($event.target.checked){
            $scope.check.push(id);
        }else{
            var idx=$scope.check.indexOf(id);
            $scope.check.splice(idx,1);
        }
    }

    $scope.deleteOrder=function () {
        if($scope.check.length>0){
            $http.post('../conorder/deleteOrder',$scope.check).success(
                function (response) {
                    $scope.reloadList();
                    alert(response.map.msg);
                    $scope.check=[];
                }
            )
        }else{
            alert("你至少选择一项！")
        }


    }
})

