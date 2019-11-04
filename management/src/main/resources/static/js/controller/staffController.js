app.controller('staffController',function ($scope,$http) {
    $scope.condition={};
    $scope.entity={};
    $scope.affair={};
    $scope.check=[];
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
        $http.post('../staff/findstaff/'+page+'/'+size,$scope.condition).success(
            function (response) {
                $scope.entitys=response.list;
                $scope.paginationConf.totalItems=response.nums;

            }
        )
    }
    /*详情页*/
    $scope.findDetails=function (id) {
        $http.get('../staff/findDetails/'+id).success(
            function (response) {
                $scope.staff=response;
            }
        )
    }
    /*修改*/
    $scope.editStaff=function (id) {
        $http.get('../staff/editStaff/'+id).success(
            function (response) {
            $scope.staff=response;
            $scope.staff.entrytime=$scope.transform($scope.staff.entrytime);
        })
    };
    /*修改保存*/
    $scope.addStaff=function () {

            $http.post('../staff/addStaff',$scope.staff).success(
                function (response) {
                    $scope.reloadList();
                    alert(response.map.msg);

                }
            )
        }
        $scope.saveStaff=function () {
            $http.post('/staff/saveStaff',$scope.entity).success(
                function (response) {
                    $scope.reloadList();
                    alert(response.map.msg);
                }
            )

        }
        $scope.findId=function (id) {
            $scope.affair={};
            $scope.affair.sellerid=id;
        }
        $scope.addAffair=function () {
            $http.post('../staff/addAffair',$scope.affair).success(
                function (response) {
                    $scope.reloadList();
                    alert(response.map.msg);
                }
            )
        }

        //复选框
        $scope.selected=function ($event,id) {
            if($event.target.checked){
                $scope.check.push(id);
                alert("请注意如果你选择删除的话，该员工对应的预约信息也将会被删除！")
            }else{
                var idx=$scope.check.indexOf(id);
                $scope.check.splice(idx,1);
            }
        }

        $scope.deleteStaff=function () {
        if($scope.check.length>0){
            $http.post('../staff/deleteStaff',$scope.check).success(
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


    $scope.findService=function () {
        $http.get('../consumer/findService').success(
            function (response) {
                $scope.allservice=response;
            }
        )
    }

})