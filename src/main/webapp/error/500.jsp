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
<h1>500</h1>
服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理。
</body>