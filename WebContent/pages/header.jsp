<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-cls-top " role="navigation"
		style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".sidebar-collapse">
			<span class="sr-only">财金图书管理系统</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.html">财金图书管理系统</a>
	</div>
	<!--顶部-->
	<div class="header-right">
		<a href="/booksystem/user_endSystem" class="btn btn-danger" title="Logout"> 退出系统</a>
	</div>
	</nav>
	<!-- 导航 -->
	<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li>
				<div class="user-img-div">
					<img src="/booksystem/${findAdmin.urls}" class="img-thumbnail" />
					<div class="inner-text">
						管理员:${findAdmin.aid} <br /> <small>上次登录日期:${findAdmin.lastdate}</small>
					</div>
				</div>
			</li>

			<li><a class="active-menu" href="pages/index.jsp"><i
					class="fa fa-dashboard "></i>导航</a></li>

			<!--超级管理员-->

			<li><a href="#"><i class="fa fa-desktop "></i>超级管理员<span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a
						<c:if test="${findAdmin.flag==1}">href="/booksystem/pages/admin/addAdmin.jsp"</c:if>
						<c:if test="${findAdmin.flag==2}">href="/booksystem/admin_noSuperAdmin"
						</c:if>><i
							class="fa fa-toggle-on"></i>添加管理</a></li>
						<li><a
						<c:if test="${findAdmin.flag==1}">href="/booksystem/admin_findAdmin"</c:if>
						<c:if test="${findAdmin.flag==2}">href="/booksystem/admin_noSuperAdmin"
						</c:if>><i class="glyphicon glyphicon-eye-open"></i>查看管理</a></li>
				</ul></li>

			<!--用户管理-->
			<li><a href="#"><i class="glyphicon glyphicon-user"></i>用户管理 <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="/booksystem/pages/member/addMember.jsp"><i
							class="glyphicon glyphicon-plus-sign"></i>用户录入</a></li>
					<li><a href="/booksystem/member_findUser"><i
							class="glyphicon glyphicon-heart"></i>查看用户</a></li>
				</ul></li>
			<!--分类管理-->
			<li><a href="#"><i class="glyphicon glyphicon-th-list"></i>分类管理
					<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="/booksystem/pages/item/addItem.jsp"><i
							class="fa fa-coffee"></i>增加分类</a></li>
					<li><a href="/booksystem/item_findItem?tag=A"><i
							class="fa fa-flash "></i>查看分类</a></li>
				</ul></li>
			<!--图书信息-->
			<li><a href="#"><i class="fa fa-yelp "></i>图书管理 <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="/booksystem/item_findItem?tag=B"><i
							class="glyphicon glyphicon-leaf"></i>增加图书</a></li>
					<li><a href="/booksystem/book_listBooks"><i
							class="glyphicon glyphicon-tasks"></i>图书列表</a></li>
				</ul></li>
			<!--借书登记-->
			<li><a href="#"><i class="fa fa-bicycle "></i>借书登记 <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="/booksystem/lenBook_listBooks"><i
							class="glyphicon glyphicon-indent-left"></i>借书信息录入 </a></li>
					<li><a href="/booksystem/lenBook_findLenBook"><i
							class="glyphicon glyphicon-folder-close"></i>借书信息查询 </a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
</body>
</html>