<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
   	 %>
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
            <!-- 此处编写内容  -->
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                    <h1 class="h1">借书信息查询</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
				<%--编写修改单个借书信息--%>
                <form action="/booksystem/lenBook_update" method="post" class="form-horizontal" id="insertForm">
                    <%--借书编号--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">借书编号</label>
                        <div class="col-md-6">
                            <input type="hidden" value="${oneLen.leid}" name="leid" id="leid" class="form-control input-sm">
                            <input type="text" value="${oneLen.leid}" id="leid1" class="form-control input-sm" disabled="disabled">
                        </div>
                    </div>
                    <%--借书日期--%>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">借书日期</label>
                        <div class="col-md-6">
                            <input type="text" name="credate"  value="${oneLen.credate}" id="credate" class="form-control input-sm">
                        </div>
                    </div>
                    <%--归还日期--%>
                    <div class="form-group">
                    <label for="age" class="col-md-3 control-label">归还日期</label>
                    <div class="col-md-6">
                        <input type="text" value="${oneLen.retdate}" id="retdate" name="retdate" class="form-control input-sm">
                    </div>
                </div>

                    <!--用户姓名-->
                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">用户姓名</label>
                        <div class="col-md-6">
                         <input type="text" value="${oneLen.member.mname}" id="mid" name="mid" class="form-control" disabled="disabled">
                        </div>
                    </div>
                    
                    <!--图书名称-->
                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">图书名称</label>
                        <div class="col-md-6">
                            <input type="hidden" value="${oneLen.books.bid}"  name="bid" class="form-control">
                            <input type="text" value="${oneLen.books.name}"  class="form-control" disabled="disabled">
                        </div>
                    </div>
                    
                    <!--是否还书-->
                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">是否还书</label>
                        <div class="col-md-6" style="margin-top: 8px;">
                         <input type="radio" name="returnbook" id="returnbook" value="1" >是
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="returnbook" id="returnbook" value="0" checked="checked">否
                        </div>
                    </div>
					<!--提交-->
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                           <button type="submit" class="btn btn-success c">修改</button>
                        </div>
                    </div>
                </form>
				
            </div>
        </div>
    </div>
    
    
    <jsp:include page="/pages/footer.jsp"></jsp:include>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom.js"></script>
</body>
</html>