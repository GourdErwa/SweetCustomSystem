<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<title>糖果管理-${applicationScope.projectName}</title>

<div class="row row-offcanvas row-offcanvas-right">

    <div class="col-xs-12 col-sm-9">
        <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
        </p>
        <div class="row" style="margin-bottom: 30px;">
            <div class="row placeholders">
                <c:forEach var="candy" items="${candies}">
                    <div class="col-xs-6 col-sm-3 placeholder">
                        <a href="<%=basePath%>candy/showOne?candyId=${candy.candyId}" class="thumbnail">
                            <img src="<%=basePath%>candy/downImage?downImageUrl=${candy.image}" class="img-rounded"
                                 alt="未知">
                        </a>
                        <div style="margin: 5px 0px 15px;">
                            <p>${candy.candyName}</p>
                            <span class="text-muted">类别:${candy.candyCategory.candyCategoryName}&nbsp;|&nbsp;销量:${candy.salesVolume}</span>
                        </div>
                    </div>
                </c:forEach>
            </div><!--/row-->
        </div>
        <!--/.col-xs-12.col-sm-9-->
    </div>
    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">

        <button type="button" class="btn btn-info">搜索</button>

        <hr>
        <p>糖果类别:</p>
        <div class="list-group">
            <c:forEach var="candyCategory" items="${applicationScope.candyCategories}">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="candyCategoriesCheckBox" value="${candyCategory.candyCategoryId}">
                            ${candyCategory.candyCategoryName}
                    </label>
                </div>
            </c:forEach>
        </div>

        <hr>
        <p>糖果商品状态:</p>
        <div class="list-group" id="candyStates">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="candyStates" value="Audi">审核中
                    </label>
                </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="candyStates" value="SaleIn">售货中
                </label>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="candyStates" value="UnShelve">下架
                </label>
            </div>
        </div>
    </div>
    <!--/.sidebar-offcanvas-->

</div>
