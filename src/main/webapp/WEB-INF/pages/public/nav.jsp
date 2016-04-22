<%@ page import="com.gourderwa.entity.Users" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wei.Li
  Date: 16/3/11
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<nav>
    <ul class="nav nav-pills pull-right" id="menu">
        <li id="homeMenu" role="presentation" class="active"><a>首页 </a></li>
        <li id="usersMenu" role="presentation"><a href="http://v3.bootcss.com/examples/jumbotron-narrow/#">用户管理</a>
        </li>
        <li id="candyMenu" role="presentation"><a href="http://v3.bootcss.com/examples/jumbotron-narrow/#">糖果定制</a>
        </li>
        <li id="orderMenu" role="presentation"><a href="http://v3.bootcss.com/examples/jumbotron-narrow/#">我的订单</a>
        </li>
        <c:if test="${sessionScope.get('users') == null}">
            <li id="loginMenu" role="presentation"><a href="http://v3.bootcss.com/examples/jumbotron-narrow/#">登录</a>
            </li>
            <li id="regiMenu" role="presentation"><a href="http://v3.bootcss.com/examples/jumbotron-narrow/#">注册</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.get('users') != null}">
            <li id="currUserMenu" role="presentation"><a
                    href="http://v3.bootcss.com/examples/jumbotron-narrow/#"><%=((Users) session.getAttribute("users")).getUserName()%>
            </a>
            </li>
        </c:if>

    </ul>
</nav>
<h3 class="text-muted">${applicationScope.projectName}</h3>

<script>

    //菜单激活控制
    var activeMenu = '${sessionScope.activeMenu}';
    if (activeMenu) {
        $("#menu").find("li .active").removeClass("active");
        $("#" + activeMenu).addClass("active");
    }

</script>
