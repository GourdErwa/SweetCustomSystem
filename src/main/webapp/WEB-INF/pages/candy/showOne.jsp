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
<title>${candy.candyName}-<%=application.getAttribute("projectName")%>
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
        邮费: ${candy.postage}
        <br><br>
        状态: ${candy.state.describe}
        <br><br>
        销量: ${candy.salesVolume}
        <br><br>
        库存: ${candy.stock}


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

                    <button type="submit" class="btn btn-warning"
                            onclick="window.location.href='<%=basePath%>orderForm/insertOrderFormsGoIndexPage?candyId=${candy.candyId}'"
                    >去下单
                    </button>

                </c:if>
            </c:if>
        </c:if>
    </div>
</div>
</body>

<script>

</script>
