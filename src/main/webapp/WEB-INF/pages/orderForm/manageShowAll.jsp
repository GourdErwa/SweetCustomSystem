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
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">订单管理</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" id="orderFormId" value="">
                    <div class="form-group">
                        <label class="control-label">请选择:</label>
                        <div class="controls">
                            <select class="form-control" id="state">
                                <option value="WaitingForDelivery">等待发货</option>
                                <option value="SellerRejected">卖家驳回</option>
                                <option value="AlreadyShipped">发货</option>
                                <option value="AlreadySign">已签收</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="reasonRejection" class="control-label">商家留言:</label>
                        <textarea class="form-control" id="reasonRejection"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="update">确认修改</button>
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
            {"data": "candy.candyName"},
            {"data": "candy.candyCategory.candyCategoryName"},
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
            {//showOneForMy?orderFormId=320
                "render": function (data, type, row) {
                    return "<button type=\"button\" " +
                            "onclick = window.open(\"<%=basePath%>orderForm/showOneForMy?orderFormId=" + data + "\") " +
                            "class=\"btn btn-primary btn-xs\" " +
                            ">查看 " +
                            "</button>&nbsp; " +
                            "<button type=\"button\" " +
                            "orderFormId =\"" + data + "\"  " +
                            "onclick = updateOrderForm('" + data + "') " +
                            "class=\"btn btn-danger  btn-xs\" " +
                            "data-toggle=\"modal\"  " +
                            "data-target=\"#manageOrderForm\" " +
                            "data-whatever=\"@getbootstrap\"> " +
                            "修改订单" +
                            " </button>";
                },
                "targets": 6
            }
        ]
    };


    dataTableSetting.data = orderForms;
    table = $showTable.DataTable(dataTableSetting);

    var $orderFormId = $("#orderFormId");
    function updateOrderForm(orderFormId) {
        $("#reasonRejection").empty();
        $orderFormId.val(orderFormId);
    }

    $("#update").on("click", function () {
        $("#manageOrderForm").hide();
        var orderFormId = $orderFormId.val();
        var state = $("#state").val();
        var reasonRejection = $("#reasonRejection").val();

        $.ajax({
            type: "POST",
            url: "<%=basePath%>" + "orderForm/updateOrderForm",
            data: {
                "orderFormId": orderFormId,
                "state": state,
                "reasonRejection": reasonRejection
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                if (data.success) {
                    MSG.showSucceedMsg("修改成功");
                } else {
                    MSG.showErrorMsg("修改失败，error：" + data.msg);
                }
            }

        });
    });
</script>
