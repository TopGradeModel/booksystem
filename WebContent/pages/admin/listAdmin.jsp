<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <h1 class="h1">管理员详情</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
				<table class="table" style="text-align: center;font-size: 20px;">
					<tr style="font-weight: 800;">
						<td>账号名</td>
						<td>最后登陆时间</td>
						<td>是否为超级管理员</td>
						<td>账号状态</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${listAdmin}" var="admin">
						<tr>
						<td>${admin.aid}</td>
						<td>${admin.lastdate}</td>
						<td><c:if test="${admin.flag==1}">是</c:if><c:if test="${admin.flag==2}">否</c:if></td>
						<td><c:if test="${admin.status==0}">锁定</c:if><c:if test="${admin.status==1}">正常</c:if></td>
						<td><button type="button" class="btn btn-success c" data-toggle="modal" data-target="#exampleModal" onclick="fun1('${admin.aid}')">操作</button></td>
						</tr>
					
					</c:forEach>
				</table>
				
            </div>
        </div>
    </div>

	<!-- 模态框 -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
      </div> 
      <form action="/booksystem/admin_updateAdmin" method="post">
      <div class="modal-body">
       <!-- 是否为超级管理员 -->
          <div class="form-group">
            <label for="recipient-name" class="control-label">是否为超级管理员:</label>
            <br>
            <input type="hidden" id="aid">
        	<input type="radio" name="flag" id="flag1" value="1">是
        	<input type="radio" name="flag" id="flag2" value="2">否
          </div>
          
           <!-- 图书名称-->
          <div class="form-group">
            <label for="recipient-name" class="control-label">账号状态</label>
            <br>
            <input type="radio" name="status" id="status1" value="0">锁定
        	<input type="radio" name="status" id="status2" value="1">正常
          </div>
          
                    
      </div>
     
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">保存</button>
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

	<script type="text/javascript">
			$('#exampleModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var recipient = button.data('whatever') // Extract info from data-* attributes
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.modal-title').text('管理员信息 ')
			})
			//Ajax发送请求导后台单查内容
			function fun1(date) {
				//获取文本框的内容
				$.ajax({
					url:"/booksystem/admin_oneAdmin",
					//传值到后台
					data:{"aid":date},
					dataType:"json",
					error:function(){
						alert("错误");
					},
					success:function(data){
						if(data.flag==1){
							$("#flag1").attr("checked","checked"); 
						}else{
							$("#flag2").attr("checked","checked"); 
						}
						
						if(data.status==0){
							$("#status1").attr("checked","checked"); 
						}else{
							$("#status2").attr("checked","checked"); 
						}
						$("#aid").val(data.aid);
						
					},
					type:"POST"
				});
			}
		</script>
</html>