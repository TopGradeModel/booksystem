<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h1 class="h1">查看分类</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
		 	 <table class="table" style="text-align: center;font-size: 20px;">
		 	 <tr style="font-weight: 800;">
		 	 	<td>编号</td>
		 	 	<td>分类名称</td>
		 	 	<td>分类说明</td>
		 	 	<td>操作</td>
		 	 </tr>
			<c:forEach items="${listItem}" var="item">
		 	 <c:forEach begin="" end="" >
		 	${books.name}
		 	 </c:forEach>
			<tr>
		 	 	<td>${item.iid}</td>
		 	 	<td>${item.iname}</td>
		 	 	<td>${item.note}</td>
		 	 	<td><button type="button" class="btn btn-success c" data-toggle="modal" data-target="#exampleModal" onclick="fun1(${item.iid})">操作</button></td>
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
      <form action="/booksystem/item_updateItem" method="post">
      <div class="modal-body">
       <!-- 分类编号 -->
        	<input type="hidden" name="iid" id="iid" class="form-control">
           <!--分类名称-->
          <div class="form-group">
            <label for="recipient-name" class="control-label">分类名称:</label>
            <input type="text" name="iname"  class="form-control" id="iname">
          </div>
          
          <div class="form-group">
            <label for="message-text" class="control-label">备注:</label>
            <br />
            <div style="margin-top: 5px;">
            	  <textarea rows="3" name="note" class="form-control" id="note"></textarea>
            </div>
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
		  modal.find('.modal-title').text('图书分类管理 ')
		  modal.find('#recipient-name').val(recipient)
			})
			//Ajax发送请求导后台单查内容
			function fun1(date) {
				//获取文本框的内容
				$.ajax({
					url:"/booksystem/item_oneItem",
					//传值到后台
					data:{"iid":date},
					dataType:"json",
					error:function(){
						alert("错误");
					},
					success:function(data){
						$("#iname").val(data.iname);
						$("#iid").val(data.iid);
						$("#note").val(data.note);
					},
					type:"POST"
				});
			}
		</script>
</html>