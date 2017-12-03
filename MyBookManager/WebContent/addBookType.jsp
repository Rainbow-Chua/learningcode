<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.rainbowpro.util.*" %>
<%@ page import="com.rainbowpro.dao.*" %>
<%@ page import="com.rainbowpro.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
div {
	text-align: center;
}

body {
	background-image: url("images/bgi.jpg");
	background-repeat: repeat;
}
h2 {
	text-align: center;
}
</style>
</head>
<%@ include file="Headermain.jsp"%>
<body>
	<h2>图书类别增加</h2>
	<div>
		<form action="addbooktype.do" method="post"
			onsubmit="return checkForm(this);"
			style="background-color: orange; position: relative; left: 42%; width: 300px;padding-top: 30px; padding-bottom: 30px ">
			<p>
				图书类别名称:<input id="bookTypeName" type="text" name="bookTypeName"
					style="width: 100px;" />
			</p>
			<p>
				图书类别描述:<input id="bookTypeDesc" type="text" name="bookTypeDesc"
					style="width: 100px;" />
			</p>

			<p>
				<input type="submit" value="确定"> <input type="button"
					value="重置" onclick="reset()">
			</p>
		</form>
	</div>
	<script type="text/javascript">
	function checkForm(form) {
		if(form.bookTypeName.value == "") {
			alert("类别名不能为空!");
			form.bookName.focus();
			return false;
		}
		if(form.bookTypeDesc.value == "") {
			alert("描述不能为空!");
			form.bookAuthor.focus();
			return false;
		}
		return true;
	}
	function reset(){
		document.getElementById("bookTypeName").setAttribute("value","");
		document.getElementById("bookTypeDesc").setAttribute("value","");
	}
	</script>
</body>
<%@ include file="Footer.jsp"%>
</html>