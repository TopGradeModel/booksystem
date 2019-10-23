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
                    <h1 class="h1">图书列表</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
				<table class="table" style="text-align: center;font-size: 20px;">
					<tr style="font-weight: 800;">
						<td>图书编号</td>
						<td>图书名称</td>
						<td>上架时间</td>
						<td>图书状态</td>
						<td>图书类别</td>
						<td>上架管理员</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${listBooks}" var="books">
						<tr>
						<td>${books.bid }</td>
						<td>${books.name }</td>
						<td>${books.credate }</td>
						<td><c:if test="${books.status==0}">已借</c:if><c:if test="${books.status==1}">空闲</c:if></td>
						<td>${books.item.iname }</td>
						<td>${books.admin.aid }</td>
						<td><button type="button" class="btn btn-success c" data-toggle="modal" data-target="#exampleModal" onclick="fun1(${books.bid })">操作</button></td>
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

	<!-- 模态框 -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
      </div> 
      <form action="/booksystem/book_update" method="post">
      <div class="modal-body">
       <!-- 图书编号 -->
          <div class="form-group">
            <label for="recipient-name" class="control-label">图书编号:</label>
            <input type="hidden" name="bid" id="bid">
        	<input type="text" id="bid2" class="form-control" disabled="disabled">
          </div>
          
           <!-- 图书名称-->
          <div class="form-group">
            <label for="recipient-name" class="control-label">图书名称</label>
            <input type="text" name="name" class="form-control" id="recipient-name">
          </div>
          
           <!-- 上架时间-->
          <div class="form-group">
            <label for="recipient-name" class="control-label">上架时间</label>
            <input type="text" name="credate" class="form-control" id="credate">
          </div>
          
           <!-- 状态-->
          <div class="form-group">
            <label for="recipient-name" class="control-label">上架状态</label>
            <input type="text" name="status" class="form-control" id="status">
          </div>
          
           <!-- 备注-->
          <div class="form-group">
            <label for="recipient-name" class="control-label">备注</label>
            <textarea rows="3" name="note" class="form-control" id="note"></textarea>
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
		  modal.find('.modal-title').text('图书列表管理 ')
			})
			//Ajax发送请求导后台单查内容
			function fun1(date) {
				//获取文本框的内容
				$.ajax({
					url:"/booksystem/book_oneBook",
					//传值到后台
					data:{"bid":date},
					dataType:"json",
					error:function(){
						alert("错误");
					},
					success:function(data){
						$("#bid").val(data.bid);
						$("#bid2").val(data.bid);
						$("#recipient-name").val(data.name);
						$("#credate").val(data.credate);
						$("#status").val(data.status);
						$("#note").val(data.note);
					},
					type:"POST"
				});
			}
		</script>
</html>