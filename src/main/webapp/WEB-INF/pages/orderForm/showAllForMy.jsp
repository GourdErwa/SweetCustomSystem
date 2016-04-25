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
    <title>我的订单-${applicationScope.projectName}</title>
    <jsp:include page="../public/datatables-bootstrap-js-css.jsp"/>
</head>
<body>

<div>
    <table id="showTable" class="table table-striped" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>订单号</th>
            <th>商品名称</th>
            <th>商品类别</th>
            <th>订单状态</th>
            <th>下单时间</th>
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
            {"data": "candy.candyName"},
            {"data": "candy.candyCategory.candyCategoryName"},
            {"data": "state"},
            {"data": "orderTime"}
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
            },
            {
                "render": function (data, type, row) {
                    return orderFormStateMap[data];
                },
                "targets": 3
            },
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 4
            }
        ]
    };


    dataTableSetting.data = orderForms;
    table = $showTable.DataTable(dataTableSetting);

</script>
