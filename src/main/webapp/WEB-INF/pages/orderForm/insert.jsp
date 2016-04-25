<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>下单-${candy.candyName}-<%=application.getAttribute("projectName")%>
</title>
<style>
    .image.right {
        float: right;
        padding: 0 5.5em 1em 0;
        top: 0.25em;
    }
</style>
<body>
<div class="container">

    <p><span class="image right">
        <img src="<%=basePath%>candy/downImage?downImageUrl=${candy.image}"
             class="img-thumbnail"
             alt="未知"
        >
    </span>

    <div style="font-size: 17px">
        名称: ${candy.candyName}
        <br><br>
        类别: ${candy.candyCategory.candyCategoryName}
        <br><br>
        邮费:
        <span id="postage">${candy.postage}</span>
        <br><br>
        <div class="input-group" style="width: 120px;">
            <div class="input-group-addon">数量</div>
            <input type="number" class="form-control" id="num" value="1" placeholder="数量">
        </div>
        <div class="input-group" style="width: 400px;margin-top: 20px;">
            <div class="input-group-addon">留言</div>
            <input type="text" class="form-control" id="guestBook" value="1" placeholder="留言">
        </div>
        <div class="input-group" style="width: 400px;margin-top: 20px;">
            <div class="input-group-addon">邮寄地址</div>
            <input type="text" class="form-control" id="address" value="1" placeholder="邮寄地址">
        </div>

        <br>
    </div>
    </p>

    <hr>
    <div class="form-group" style="float: right">
        <c:if test="${candy.state=='SaleIn'}">
            <c:if test="${candy.stock > 0}">
                <c:if test="${sessionScope.get('users') == null}">
                    登录后进行操作
                </c:if>
                <c:if test="${sessionScope.get('users') != null}">

                    <button class="btn btn-warning" id="insertOrderForms">确认下单
                    </button>

                </c:if>
            </c:if>
        </c:if>
    </div>
</div>
</body>

<script>
    $(function () {

        $("#insertOrderForms").click(function () {

            var candyId = '${candy.candyId}';
            var num = $("#num").val();
            var guestBook = $("#guestBook").val().trim();
            var address = $("#address").val().trim();

            if (num < 1) {
                MSG.showErrorMsg("请输入数量");
                return;
            }

            $.ajax({
                type: "POST",
                url: "<%=basePath%>" + "orderForm/insertOrderForms",
                data: {
                    "candyId": candyId,
                    "num": num,
                    "address": address,
                    "guestBook": guestBook
                },
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    if (data.success) {
                        window.location.href = '<%=basePath%>orderForm/showOneForMy?orderFormId=' + data.data;
                    } else {
                        if (data.data) {
                            MSG.showErrorMsg(data.data);
                        }
                    }
                }

            });
        });

    });
</script>
