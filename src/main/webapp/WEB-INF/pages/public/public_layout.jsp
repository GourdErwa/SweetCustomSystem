<%--
  Created by IntelliJ IDEA.
  User: lw
  Date: 14-6-14
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>校园帮帮平台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/plug/chosen/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/plug/chosen/chosen.css"></script>

    <script type="text/javascript" src="<%=basePath%>resources/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>resources/bootstrap-3.2.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>resources/css/style.css">

    <script type="text/javascript" src="<%=basePath%>resources/plug/icheck/icheck.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>resources/plug/icheck/skins/flat/_all.css">


    <script type="text/javascript" src="<%=basePath%>resources/plug/buttons/js/buttons.js"></script>
    <link rel="stylesheet" href="<%=basePath%>resources/plug/buttons/css/buttons.css">

    <link rel="stylesheet" href="<%=basePath%>resources/plug/font-awesome-4.1.0/css/font-awesome.min.css">

    <script type="text/javascript" src="<%=basePath%>resources/js/application.js"></script>
    <script>


        $(function () {
            var window_height = $(document).height();
            var body_height = $("body").height();
            var title_height = $("#title").height();
            var content_height = $("#content").height();
            if (window_height - body_height < 100) {
                $("#content").css("min-height", "320px");
            }
        });
    </script>
</head>
<body>
<div id="title">
    <tiles:insertAttribute name="header"/>
</div>

<div id="content" style="min-height: 450px;">
    <tiles:insertAttribute name="main-container"/>
</div>

<div id="bottom">
    <tiles:insertAttribute name="bottom"/>
</div>

</body>
</html>

