<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>财金图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<style type="text/css">
	.error{
	color:red;
	}
	#l-map{height:300px;width:100%;}
	</style>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6yAoynmTPNlTBa8z1X4LfwGE"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#loginForm").validate({
			rules:{
				aid:{
					required:true,
					rangelength:[1,10]
				},
				password:{
					required:true,
					rangelength:[1,10]
				}
			},
			messages:{
				aid:{
					required:"账号不能为空",
					rangelength:"请输入1-10个字符"
				},
				password:{
					required:"密码不能为空",
					rangelength:"请输入1-10个字符"
				}
			}
		});
	});
	</script>
</head>
<body style="background-color: #E2E2E2;">
	<!-- 联系我们 -->
		<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		    	<h3 style="margin-left: 15px;">联系我们</h3>
		    	<hr />
		      <div id="l-map"></div>
		    </div>
		  </div>
		</div>

    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <h2>财金图书管理系统</h2>
            </div>
        </div>
         <div class="row ">
               
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                           
                            <div class="panel-body">
                                <form id="loginForm" role="form" action="booksystem/user_login" method="post">
                                    <hr />
                                    <h5>Enter Details to Login</h5>
                                       <br />
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-user"  ></i></span>
                                            <input type="text" name="aid" class="form-control" placeholder="Your Username " style="color: #000000;" />
                                        </div>
                                                                              <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <input type="password" name="password" class="form-control"  placeholder="Your Password"  style="color: #000000;" />
                                        </div>

                                     <Button type="submit" href="index.html" class="btn btn-primary col-md-offset-7">Login Now</Button>
                                    <hr />
                                    找到我们 ? <a data-toggle="modal" data-target=".bs-example-modal-lg">点击这里 </a> 或者联系QQ： <a href="#">111222333</a>
                                    </form>
                            </div>
                        </div>
        </div>
    </div>
</body>
	<!-- 百度地图API -->
	<script type="text/javascript">
		// 百度地图API功能
		var map = new BMap.Map("l-map");            // 创建Map实例
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
		var local = new BMap.LocalSearch(map, {
			renderOptions: {map: map, panel: "r-result"}
		});
		local.search("河南财政金融学院");
	</script>

</html>
