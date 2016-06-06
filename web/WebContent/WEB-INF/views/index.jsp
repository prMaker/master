<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css" />
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}  

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
} 
.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
.alert{
    width: 300px;
	height: 60px;
	background-color: red;
	font-size: 30px;
	
}

</style>

</head>
<body>
	<div class="container">
	
		<c:choose>
			<c:when test="${param.code == '1001'}">
				<div class="alert">
					账号或密码错误
				</div>
			</c:when>
			<c:when test="${param.code == '1002'}">
				<div class="alert">
					请登录后再访问
    			</div>
			</c:when>
		
		</c:choose>
	
		<form class="form-signin" action="/login.do" method="post">

			<h2 class="form-signin-heading">Please sign in</h2>

			<label for="inputEmail" class="sr-only">用户名</label> 
			<input type="text" id="inputEmail" class="form-control"
				placeholder="请输入用户名" required autofocus name="username" />
				 
			<label for="inputPassword" class="sr-only">密码</label> 
			<input type="password" id="inputPassword" class="form-control"
				placeholder="请输入密码" required name="password" />
			<label class="checkbox">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="rememberme" value="yes"/>记住我
			
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>

</body>
</html>