<!--

Created by IntelliJ IDEA.
User: lw
Date: 14-6-28
Time: 23:38
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<body>

<h1>404</h1>
请求失败，请求所希望得到的资源未被在服务器上发现。
</body>