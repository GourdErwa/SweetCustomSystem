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
<jsp:include page="../public/file-input-bootstrap-js-css.jsp"/>
<style>
    .image.right {
        float: right;
        padding: 0 5.5em 1em 0;
        top: 0.25em;
    }

    .file-drop-zone {
        height: 50%;
    }
</style>
<body>
<div class="container">
    <div>

        <form class="form-horizontal" method="post" action="<%=basePath%>candy/updateCandy"
              enctype="multipart/form-data" target="upLoadCustomizationCandyFrame"
        >
            <div class="form-group">
                <label for="candyName" class="col-sm-2 control-label">糖果编号</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" name="candyId" id="candyId" readonly placeholder="糖果编号"
                           value="${candy.candyId}">
                </div>
            </div>
            <div class="form-group">
                <label for="candyName" class="col-sm-2 control-label">糖果名称</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" name="candyName" id="candyName" placeholder="糖果名称"
                           value="${candy.candyName}">
                </div>
            </div>
            <div class="form-group">
                <label for="candyName" class="col-sm-2 control-label">糖果状态</label>

                <div class="col-sm-10">
                    <select id="stateSel" name="state" class="form-control">
                        <option value="Audi">审核中</option>
                        <option value="SaleIn">售货中</option>
                        <option value="UnShelve">下架</option>
                    </select>

                </div>
            </div>
            <div class="form-group">
                <label for="candyName" class="col-sm-2 control-label">邮费</label>

                <div class="col-sm-10">
                    <input type="number" class="form-control" name="postage" id="postage" placeholder="邮费"
                           value="${candy.postage}">
                </div>
            </div>
            <div class="form-group">
                <label for="stock" class="col-sm-2 control-label">库存</label>

                <div class="col-sm-10">
                    <input type="number" class="form-control" name="stock" id="stock" placeholder="库存"
                           value="${candy.stock}">
                </div>
            </div>

            <div class="form-group">
                <label for="file-Portrait" class="col-sm-2 control-label">图片</label>

                <div class="col-sm-10">
                    <input type="file" name="file-Portrait" id="file-Portrait" class="file-loading">
                </div>
            </div>
            <hr>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-warning">修改</button>
                </div>
            </div>
        </form>

    </div>
</div>
<iframe id="upLoadCustomizationCandyFrame" name="upLoadCustomizationCandyFrame" style="display:none;">
</iframe>
</body>

<script>

    var state = '${candy.state}';
    if (state) {
        $("#stateSel").val(state);
    }
    var url = '<%=basePath%>candy/updateCandy';

    $(function () {
        var oFileInput = new FileInput("file-Portrait");
        oFileInput.init(url);
    });
    var FileInput = function (id) {
        var fileInputId = id;
        var oFile = {};
        oFile.init = function (uploadUrl) {
            var $fileInput = $('#' + fileInputId);
            $fileInput.fileinput({
                language: 'zh', //设置语言
                uploadUrl: uploadUrl, //上传的地址
                allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
                showUpload: false, //是否显示上传按钮
                showCaption: false,//是否显示标题
                browseClass: "btn btn-primary btn-xs", //按钮样式
                dropZoneEnabled: true,//是否显示拖拽区域
                minImageWidth: 50, //图片的最小宽度
                minImageHeight: 50,//图片的最小高度
                maxImageWidth: 250,//图片的最大宽度
                maxImageHeight: 250,//图片的最大高度
                maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
                //minFileCount: 0,
                maxFileCount: 1, //表示允许同时上传的最大文件个数
                enctype: 'multipart/form-data',
                validateInitialCount: true,
                //previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
            });
            //导入文件上传完成之后的事件
            $fileInput.on("fileuploaded", function (event, data, previewId, index) {
                console.log(data.response);
            });
        };
        return oFile;
    };


    var $upLoadCustomizationCandyFrame = $("#upLoadCustomizationCandyFrame");
    //表单提交后成功与否判断
    $upLoadCustomizationCandyFrame.load(function () {
        var result = "允许上传的最大文件大小为 10M";
        try {
            result = $upLoadCustomizationCandyFrame.contents().find("body").text();
        } catch (e) {
            console.log(e);
        }
        if (result.indexOf('true-') != -1) {
            MSG.showSucceedMsg("操作成功");
            //window.location.href = '<%=basePath%>candy/showOne?candyId=' + result.split("-")[1];
        } else {
            MSG.showErrorMsg("操作失败: " + result);
        }

    });

</script>

