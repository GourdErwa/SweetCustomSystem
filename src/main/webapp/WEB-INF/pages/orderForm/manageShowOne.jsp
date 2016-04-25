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
<title>订单中心-<%=application.getAttribute("projectName")%>
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
        <img src="<%=basePath%>candy/downImage?downImageUrl=${orderForm.candy.image}"
             class="img-thumbnail"
             alt="未知"
        >
    </span>
    <div style="font-size: 17px">
        订单编号: &nbsp;<label>${orderForm.orderFormId}</label>
        <br><br>
        下单时间: &nbsp;<label>${orderForm.orderTime}</label>
        <br><br>
        商品名称: &nbsp;<label>${orderForm.candy.candyName}</label>
        <br><br>
        商品类别: &nbsp;<label>${orderForm.candy.candyCategory.candyCategoryName}</label>
        <br><br>
        订单邮费: &nbsp;<label>${orderForm.candy.postage}</label>
        <br><br>
        订单状态: &nbsp;<label>${orderForm.state.describe}</label>
        <br><br>
        邮寄地址: &nbsp;<label>${orderForm.address}</label>
        <br><br>
        用户留言: &nbsp;<label>${orderForm.guestBook}</label>
        <br><br>
        商家留言: &nbsp;<label>${orderForm.reasonRejection}</label>

    </div>
    </p>

    <hr>
    <div class="form-group" style="float: right">
        <c:if test="${sessionScope.get('users') != null}">
            <!--是否可以确定收货-->
            <c:if test="${orderForm.state=='AlreadyShipped'}">
                <button type="button" class="btn btn-warning"
                        onclick="window.location.href='<%=basePath%>orderForm/updateOrderFormsSateAlreadySign?orderFormId=${orderForm.orderFormId}'"
                >确认收货
                </button>
            </c:if>
        </c:if>
    </div>
</div>
</body>
