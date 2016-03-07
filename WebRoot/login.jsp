<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="重大新闻网">
	
	<link rel="stylesheet" href="css/normalize.min.css">
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">

	<script src="js/main.js"></script>

  </head>
  
  <body>
    <div class="box">
		<div class="logo">
			<a href="index.jsp"><h1>重大新闻网</h1></a>
		</div>
		<div class="main">
			<div class="main-left">
				<div class="row">
					<span class="icon-user icon"></span>
					<input type="text" name="username" placeholder="用户名">
				</div>
				<!-- <div class="row">
					<span class="icon-email"></span>
					<input type="text" name="email" placeholder="邮箱">
				</div> -->
				<div class="row">
					<span class="icon-key icon"></span>
					<input type="password" name="password" placeholder="密码">
				</div>
				<div class="row">
					<a href="#" id="remember"><span class="icon-check-empty icon" id="icon-remember"></span>记住登录状态</a>
					<a href="#" id="forget">忘记密码</a>
				</div>
				<div class="row">
					<a href="#" class="btn" id="login">登录</a>
					<a href="reg.jsp" class="reg">注册</a>
				</div>

			</div>
			<div class="main-right">
				<div class="row">
					<a href="#" class="weibo"><span>微博登录</span></a>
				</div>
				<div class="row">
					<a href="#" class="qq"><span>QQ登录</span></a>
				</div>
				
			</div>
		</div>
	</div>
  </body>
</html>
