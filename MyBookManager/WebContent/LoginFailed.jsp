
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
out.print("Login failed. Please check your user name and password. You will be back to login page in 3s.");
response.setHeader("REFRESH","3;url=login.jsp");//其中的3为延迟的3秒.
%>
</head>
<body>
</body>
</html>