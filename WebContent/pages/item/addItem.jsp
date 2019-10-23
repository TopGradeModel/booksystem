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
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<style type="text/css">
.error{
color: red;
}
</style>
</head>
<body>
    <div id="wrapper">
       <jsp:include page="/pages/header.jsp"></jsp:include>

          <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                    <h1 class="h1">增加分类操作</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写数据增加表单--%>
                <form action="/booksystem/item_addItem" method="post" class="form-horizontal" id="insertForm">
                    <%--分类名称--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">分类名称</label>
                        <div class="col-md-6">
                            <input type="text" name="iname" id="iname" class="form-control input-sm" onblur="blur1()">
                       			<span id="sp1" style="color: red;"></span>
                        </div>
                    </div>
                    <%--分类说明--%>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">分类说明</label>
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
				iname:"required",
				note:"required"
			},
			messages:{
				iname:"分类不能为空",
				note:"简介不能为空"
			}
		});
	});
	
	//ajax验证分类是否存在
   		function blur1(){
		//获取文本框的内容
		var $iname=$("input[name=iname]");
		var iname=$iname.val();
		$.ajax({
			url:"/booksystem/item_inameItem",
			//传值到后台
			data:{"iname":iname},
			dataType:"text",
			error:function(){
				alert("编号错误");
			},
			success:function(data){
				if(data==1){
					//返回1则用户名存在
					$("#sp1").text("分类编号不可以使用");
				}else{
					//返回2则用户名不存在
					$("#sp1").text("分类编号可以使用");
				}
			},
			type:"POST"
		});
	}
	</script>
</body>
</html>