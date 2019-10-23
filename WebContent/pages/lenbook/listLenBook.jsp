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
				<table class="table" style="text-align: center;font-size: 20px;">
					<tr style="font-weight: 800;">
						<td>借书编号</td>
						<td>借书时间</td>
						<td>归还日期</td>
						<td>图书名称</td>
						<td>用户名称</td>
						<td>操作</td>
					</tr >
					<c:forEach items="${listLenBook}" var="len">
						<tr <c:if test="${len.flag==0}">class="alert alert-info"</c:if> <c:if test="${len.flag==2}">class="alert alert-danger"</c:if>>
						<td>${len.leid}</td>
						<td>${len.credate }</td>
						<td>${len.retdate }</td>
						<td>${len.books.name }</td>
						<!-- 给个图书标记 -->
						<td>${len.member.mname}</td>
						<td><a href="/booksystem/lenBook_oneBook?leid=${len.leid}" class="btn btn-success c">操作</a></td>
						</tr>
					</c:forEach>
				</table>
				<!-- 分页插件 -->
				 <div class="col-md-5 col-md-offset-3">
                    <jsp:include page="/pages/split_bar.jsp"></jsp:include>
                </div>
				
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