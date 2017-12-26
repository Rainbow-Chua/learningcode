
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.h {
	width: 100%;
	background: orange;
	color: black;
	text-align: center;
	text-shadow: silver;
}
</style>
</head>
<body>
<div class="h">
		<h1 style="font-size: 50px; font-weight: bold; color: black;">登录失败！请检查帐号密码或者联系系统管理员，将在3s后返回</h1>
	</div>
<%
response.setHeader("REFRESH","3;url=login.jsp");//其中的3为延迟的3秒.
%>
</body>
</html>