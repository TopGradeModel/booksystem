<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                    <h1 class="h1">增加用户操作</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写数据增加表单--%>
                <form action="/booksystem/member_addMember" method="post" class="form-horizontal" id="insertForm">
                    <%--编号--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">编号</label>
                        <div class="col-md-6">
                            <input type="text" name="mid" id="mid" class="form-control input-sm" onblur="blur1()">
                        	<span id="sp1" style="color: red;"></span>
                        </div>
                    </div>
                    <%--姓名--%>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">姓名</label>
                        <div class="col-md-6">
                            <input type="text" name="mname" id="mname" class="form-control input-sm">
                        </div>
                    </div>
                    <%--年龄--%>
                    <div class="form-group">
                    <label for="age" class="col-md-3 control-label">年龄</label>
                    <div class="col-md-6">
                        <input type="text" name="age" id="age" class="form-control input-sm">
                    </div>
                </div>


                    <!--性别-->
                    <div class="form-group">
                        <label for="sex" class="col-md-3 control-label">性别</label>
                        <div class="radio">
                            <div class="col-md-2 col-md-offset-1">
                                <input type="radio" name="sex" id="sex" value="1" checked >男
                            </div>
                            <div class="col-md-1">
                                <input type="radio" name="sex" id="sex"  value="2">女
                            </div>
                        </div>
                    </div>

                    <!--联系电话-->
                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">联系电话</label>
                        <div class="col-md-6">
                            <input type="text" name="phone" id="phone" class="form-control">
                        </div>
                    </div>
                    <!--验证码-->
                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">验证码</label>
                        <div class="col-md-6">
                         <input type="text" name="code" id="code" class="form-control" placeholder="验证码">
                            <input name="getVCode" id="getVCode" type="button" class="btn btn-success" value="点击发送验证码" onclick="sendCode(this);fun1()" style="border-radius: 5px;">
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
</body>
<script type="text/javascript">
		var clock = '';
		var nums = 30;
		var btn;
		function sendCode(thisBtn) {
			btn = thisBtn;
			btn.disabled = true; //将按钮置为不可点击
			btn.value = '重新获取（'+nums+'）';
			clock = setInterval(doLoop, 1000); //一秒执行一次
		}

		function doLoop() {
			nums--;
			if (nums > 0) {
				btn.value = '重新获取（'+nums+'）';
			} else {
				clearInterval(clock); //清除js定时器
				btn.disabled = false;
				btn.value = '点击发送验证码';
				nums = 10; //重置时间
			}
		}
		
		
		function fun1(){
			var phones=$("#phone").val();
			$.ajax({
				url:"booksystem/member_getVCode",
				data:{"pe":phones},
				dataType:"text",
				error:function(){
					alert("失败");
				},
				success:function(){
				},
				type:"POST"
			});
		}
		
		
		$(function(){
   			$("#insertForm").validate({
   				rules:{
   					mid:{
   					required:true,
   					digits:true
   					},
   					mname:"required",
   					age:{
   						required:true,
   						range:[5,100]
   					},
   					sex:"required",
   					phone:{
   						required:true,
   						rangelength:[11,11],
   						digits:true
   					},
   					code:{
   	   					required:true,
   	   					digits:true
   	   					}
   				},
   				messages:{
   					mid:{
   	   					required:"编号不能为空",
   	   					digits:"请输入数字"
   	   					},
   	   				mname:"不能为空",
   					age:{
   						required:"不能为空",
   						range:"年龄必须是5-100岁之间"
   					},
   					sex:"得选一个",
   					phone:{
   						required:"不能为空",
   						rangelength:"必须是11位",
   						digits:"必须是整数"
   					},
   					code:{
   						required:"验证码不能为空",
   	   					digits:"请输入数字"
   	   					}
   				}
   			});
   		})
   		//ajax验证用户编号是否正确
   		function blur1(){
		//获取文本框的内容
		var $mid=$("input[name=mid]");
		var mid=$mid.val();
		$.ajax({
			url:"/booksystem/member_userMid",
			//传值到后台
			data:{"mid":mid},
			dataType:"text",
			error:function(){
				alert("编号错误");
			},
			success:function(data){
				if(data==1){
					//返回1则用户名存在
					$("#sp1").text("编号不能使用");
				}else{
					//返回2则用户名不存在
					$("#sp1").text("编号名可以使用");
				}
			},
			type:"POST"
		});
	}
	</script>
</html>