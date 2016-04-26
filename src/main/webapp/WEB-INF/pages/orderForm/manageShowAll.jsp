<%--
  Created by IntelliJ IDEA.
  User: wei.Li
  Date: 16/3/10
  Time: 下午3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>订单中心-${applicationScope.projectName}</title>
    <jsp:include page="../public/datatables-bootstrap-js-css.jsp"/>
</head>
<body>

<div class="modal fade" id="manageOrderForm" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">订单管理</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">订单状态:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">商家留言:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>

<div>
    <table id="showTable" class="table table-striped" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>订单号</th>
            <th>用户</th>
            <th>商品名称</th>
            <th>商品类别</th>
            <th>订单状态</th>
            <th>下单时间</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>

<script>
    var orderFormStateMap = eval('(' + '${orderFormStateMap}' + ')');
    var orderForms = eval('(' + '${orderForms}' + ')');

    var $showTable = $("#showTable");
    var table;

    var dataTableSetting = {

        "language": {
            "sProcessing": "处理中...",
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "查无数据",
            "info": "_PAGE_ / _PAGES_",
            "infoEmpty": "暂无数据",
            "infoFiltered": "(过滤总数 _MAX_ 条)",
            "search": "检索",
            "sLoadingRecords": "载入中...",
            "oPaginate": {
                "sFirst": "首页",
                "sLast": "末页",
                "sNext": ">",
                "sPrevious": "<"
            }
        },
        "columns": [
            {"data": "orderFormId"},
            {"data": "users.userName"},
            {"data": "candyName"},
            {"data": "candyCategory.candyCategoryName"},
            {"data": "state"},
            {"data": "orderTime"},
            {"data": "orderFormId"}
        ],
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 0
            },
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 1
            },
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 2
            }, {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 3
            },
            {
                "render": function (data, type, row) {
                    return orderFormStateMap[data];
                },
                "targets": 4
            },
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 5
            }
            ,
            {
                "render": function (data, type, row) {
                    return "<button type=\"button\" data =\""+data+"\"  class=\"btn btn-primary js-updateOrderForm\" data-toggle=\"modal\"  data-target=\"#manageOrderForm\" data-whatever=\"@getbootstrap\">" +
                            "修改订单</button>";
                },
                "targets": 6
            }
        ]
    };


    dataTableSetting.data = orderForms;
    table = $showTable.DataTable(dataTableSetting);


    $(".js-updateOrderForm").on('click',function () {
        console.log("===");
    });

</script>
