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
	int totalBuffer=out.getBufferSize();//获取总共缓冲区的大小
	int available=out.getRemaining();//获取未使用的缓冲区大小
	int using=totalBuffer-available;
	out.println("总共的缓冲区大小："+totalBuffer);
	out.println("获取未使用的缓冲区大小："+available);
	out.println("使用中的的缓冲区大小："+using);
%>
</body>
</html>