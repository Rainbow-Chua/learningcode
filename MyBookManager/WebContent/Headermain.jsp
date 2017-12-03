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
.menus {
    z-index: 2;
    margin: 10px 0;
    background: #fff;
}
.g-gc {
    display: inline-block;
    vertical-align: top;
    margin: 10px;
    margin-left: 130px;
    padding:6px;
    padding-left: 10px;
    padding-right: 10px;
    background: #5a98de;
    position:relative;
    right: 50px;
}
.a-1 {
    color: #fff;
    text-decoration: none;
    outline: 0;
}
.a-1:HOVER {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="h">
		<h1 style="font-size: 50px; font-weight: bold; color: black;">彩虹图书管理系统</h1>
		<ul class="menus">
			<li class="g-gc"><a href="addBook.jsp" class="a-1">图书增加</a></li>
			<li class="g-gc"><a href="BookManager.jsp" class="a-1">图书管理</a></li>
			<li class="g-gc"><a href="addBookType.jsp" class="a-1">图书类别增加</a></li>
			<li class="g-gc"><a href="BookTypeManager.jsp" class="a-1">图书类别管理</a></li>
		</ul>
	</div>
</body>
</html>