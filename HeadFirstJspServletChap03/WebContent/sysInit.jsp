<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
</head>
<body>
<%
	String s=config.getInitParameter("jdbcName");
	String d=config.getInitParameter("dbUrl");
%>
<h1>驱动名称：<%=s %></h1>
<h1>驱动地址：<%=d %></h1>
</body>
</html>