<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<h1 style="font-size: 50px; font-weight: bold; color: black;">图书类别修改或删除成功！将在3s后返回</h1>
	</div>
	<%response.setHeader("REFRESH","3;url=BookTypeManager.jsp"); %>
</body>
</html>