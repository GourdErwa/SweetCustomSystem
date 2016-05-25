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
                        <a href="<%=basePath%>candy/showOneForUpdate?candyId=${candy.candyId}" class="thumbnail">
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

        <button type="button" id="search" class="btn btn-info">搜索</button>

        <hr>
        <p>糖果类别:</p>
        <div class="list-group">
            <c:forEach var="candyCategory" items="${applicationScope.candyCategories}">
                <div class="checkbox">
                    <label>
                        <input type="radio" name="candyCategoriesCheckBox" value="${candyCategory.candyCategoryId}">
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
                    <input type="radio" name="candyStates" value="Audi">审核中
                </label>
            </div>
            <div class="checkbox">
                <label>
                    <input type="radio" name="candyStates" value="SaleIn">售货中
                </label>
            </div>
            <div class="checkbox">
                <label>
                    <input type="radio" name="candyStates" value="UnShelve">下架
                </label>
            </div>
        </div>
    </div>
    <!--/.sidebar-offcanvas-->

</div>

<script>

    var categoryId = '${categoryId}';
    if (categoryId) {
        $("input:radio[name=candyCategoriesCheckBox][value=" + categoryId + "]").attr("checked", 'checked');
    }
    var state = '${state}';
    if (state) {
        $("input:radio[name=candyStates][value=" + state + "]").attr("checked", 'checked');
    }

    $("#search").on("click", function () {
        var url = "<%=basePath%>candy/manageCandy?";
        var candyCategoriesCheckBox = $('input:radio[name=candyCategoriesCheckBox]:checked').val();
        var state = $('input:radio[name=candyStates]:checked').val();
        if (candyCategoriesCheckBox) {
            url += "candyCategoryId=" + candyCategoriesCheckBox;
        } else {
            url += "candyCategoryId=";
        }
        if (state) {
            url += "&state=" + state;
        }
        window.location.href = url;

    });

</script>