<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    @author wei.Li
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<p>糖果类别:</p>
<div class="list-group" id="candyCategories">
    <c:forEach var="candyCategory" items="${applicationScope.candyCategories}">
        <a id='candyCategories_${candyCategory.candyCategoryId}'
           href="<%=basePath%>candy/goIndexPage?candyCategoryId=${candyCategory.candyCategoryId}"
           class="list-group-item">${candyCategory.candyCategoryName}</a>
    </c:forEach>
</div>
<script>

    var categoryId = '${categoryId}';

    if (categoryId && categoryId != -1) {
        $("#candyCategories_" + categoryId).addClass("active");
    }

</script>
