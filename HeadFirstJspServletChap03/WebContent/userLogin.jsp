<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
</head>
<body>
<%
	String userName=request.getParameter("userName");//获取用户名
	String password=request.getParameter("password");//获取密码
	String remember=request.getParameter("remember");//获取是否记住密码
	System.out.println("userName"+userName);
	System.out.println("password"+password);
	System.out.println("remember"+remember);
	if("on".equals(remember)){
		Cookie userNameAndPwd=new Cookie("userNameAndPwd",userName+"-"+password);
		userNameAndPwd.setMaxAge(1*60*60*24*7);//Cookie记录一个星期
		response.addCookie(userNameAndPwd);//保存Cookie
		System.out.println("记录cookie成功");
	}
	response.sendRedirect("response03.jsp");

%>
</body>
</html>