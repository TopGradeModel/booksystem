<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
		%>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath%>">
    <title>财金图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
       <jsp:include page="/pages/header.jsp"></jsp:include>

          <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                    <h1 class="h1">增加图书操作</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写数据增加表单--%>
                <form action="/booksystem/book_addBooks" method="post" class="form-horizontal" id="insertForm">
                    <%--图书名称--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">图书名称</label>
                        <div class="col-md-6">
                            <input type="text" name="name" id="name" class="form-control input-sm">
                        </div>
                    </div>
                    <%--管理员ID--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">管理员ID</label>
                        <div class="col-md-6">
                            <input type="hidden" name="aid"  class="form-control input-sm" value="${findAdmin.aid}">
                            <input type="text" name="aid" id="aid" class="form-control input-sm" value="${findAdmin.aid}" disabled="disabled">
                        </div>
                    </div>
                    <%--分类名称--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">分类名称</label>
                        <div class="col-md-6">
                        <select name="iid" id="iid" class="form-control input-sm">
                        <c:forEach items="${listItem}" var="iids">
                        <option value="${iids.iid}">${iids.iname}</option>
                        </c:forEach>
                        </select>
                        </div>
                    </div>
                    <%--图书说明--%>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">图书说明</label>
                        <div class="col-md-6">
                        <textarea name="note" id="note" class="form-control input-sm" rows="3"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn btn-success c">提交</button>
                            <button type="reset" class="btn btn-success">重置</button>
                        </div>
                    </div>
                </form>
        </div>
    </div>
   </div>

    <jsp:include page="/pages/footer.jsp"></jsp:include>
    <script src="assets/js/jquery-1.10.2.js"></script>
     <script src="js/jquery.validate.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom.js"></script>
    
    <script type="text/javascript">
	$(function(){
		$("#insertForm").validate({
			rules:{
				name:"required",
				note:"required"
			},
			messages:{
				name:"分类不能为空",
				note:"简介不能为空"
			}
		});
	});
	</script>
</body>
</html>