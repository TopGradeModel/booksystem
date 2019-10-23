<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <link href="assets/css/login.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<style type="text/css">
.error{
color:red;
}
</style>
</head>
<body>
    <div id="wrapper">
       <jsp:include page="/pages/header.jsp"></jsp:include>

        <!-- 此处编写内容  -->
          <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                    <h1 class="h1">增加管理员</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写增加管理员--%>
                <form action="/booksystem/admin_addAdmin" method="post" enctype="multipart/form-data"  class="form-horizontal" id="insertForm">
                    <%--编号--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">账号</label>
                        <div class="col-md-6">
                            <input type="text" name="aid" id="aid" class="form-control input-sm">
                        </div>
                    </div>
                    <%--上传图片--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">上传头像</label>
                        <div class="col-md-6">
                            <input type="file" name="upload" id="upload"  class="input-sm">
                        </div>
                    </div>
                    <%--密码--%>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">密码</label>
                        <div class="col-md-6">
                            <input type="text" name="password" id="password" class="form-control input-sm">
                        </div>
                    </div>
                  


                    <!--标记超级管理员-->
                    <div class="form-group">
                        <label for="sex" class="col-md-3 control-label">标记</label>
                        <div class="radio">
                            <div class="col-md-2 col-md-offset-1">
                                <input type="radio" name="flag" id="flag1" value="1"  >超级管理
                            </div>
                            <div class="col-md-1">
                                <input type="radio" name="flag" id="flag2"  value="2">普通管理
                            </div>
                        </div>
                    </div>

                    <!--状态1==正常,0==锁定-->
                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">状态</label>
                        <div class="col-md-6">
                            <input type="text" name="status" id="status" class="form-control">
                        </div>
                    </div>
					<!--提交-->
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn btn-success">提交</button>
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
				aid:{
					required:true,
					rangelength:[1,6]
				},
				password:{
					required:true,
					rangelength:[6,12]
				},
				status:{
					required:true,
					rangelength:[1,1]
				}
			},
			messages:{
				aid:{
					required:"账号不能为空",
					rangelength:"请输入1-5个字符"
				},
				password:{
					required:"密码不能为空",
					rangelength:"请输入6-12个字符"
				},
				status:{
					required:"状态不能为空",
					rangelength:"请输入正确的状态"
				}
			}
		});
	});
	</script>	
    
</body>
</html>