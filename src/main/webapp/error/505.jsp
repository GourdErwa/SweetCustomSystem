<!--

Created by IntelliJ IDEA.
User: lw
Date: 14-6-28
Time: 23:42
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<body>
<h1>505</h1>
服务器不支持，或者拒绝支持在请求中使用的 HTTP 版本。
</body>