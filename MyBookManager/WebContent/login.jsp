<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	/*
	*request.getSchema()可以返回当前页面使用的协议，就是上面例子中的“http”
	*request.getServerName()可以返回当前页面所在的服务器的名字，就是上面例子中的“localhost"
	*request.getServerPort()可以返回当前页面所在的服务器使用的端口,就是80，
	*request.getContextPath()可以返回当前页面所在的应用的名字，就是上面例子中的myblog
	*/
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style>
.div {
	text-align: center;
    margin: 0 auto;
    width: 60%;
    height: 621px;
    position: relative;
    top: 10%;
}

body {
	background-image: url("images/bgi.jpg");
	background-repeat: repeat;
}
</style>
</head>

<%@ include file="Header.jsp"%>
<body>
	<div class="div">
		<img alt="" src="images/timg1.jpg"
			style="position: absolute; left: 200px;">
		<form action="login.do" method="post" onsubmit="return checkForm(this);"
			style="background-color: orange; position: absolute; left: 693px; width: 300px; height: 326px;">
			<!--所提交的表单，action为"login.do"，发出请求是post-->
			<p>
				账号:<input id="username" type="text" name="id" style="width: 100;"/>
			</p>
			<!--所输入的"账号"在提交后的标示是"id"，下同 -->

			<p>
				密码:<input id="password" type="password" name="password"
					style="width: 100;" />
			</p>
			<p>
				<input type="submit" value="登录"> <input type="button"
					value="重置" onclick="reset()">
			</p>
			<!--表单提交按钮，显示名称为"登录"-->
		</form>
	</div>
</body>
<%@ include file="Footer.jsp"%>
<script type="text/javascript">
	function checkForm(form) {
		if(form.username.value == "") {
			alert("用户名不能为空!");
			form.username.focus();
			return false;
		}
		if(form.password.value == "") {
			alert("密码不能为空!");
			form.password.focus();
			return false;
		}
		return true;
	}
	function reset(){
		document.getElementById("username").setAttribute("value","");
		document.getElementById("password").setAttribute("value","");
	}
</script>
</html>