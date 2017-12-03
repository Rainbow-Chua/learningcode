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
	<h2>图书增加</h2>
	<div>
		<form action="addbook.do" method="post"
			onsubmit="return checkForm(this);"
			style="background-color: orange; position: relative; left: 42%; width: 300px;padding-top: 30px; padding-bottom: 30px ">
			<p>
				图书名称:<input id="bookName" type="text" name="bookName"
					style="width: 100px;" />
			</p>
			<p>
				图书作者:<input id="bookAuthor" type="text" name="bookAuthor"
					style="width: 100px;" />
			</p>
			<p>
				作者性别:<label style="width: 100px;"><input name="Sex" type="radio" value="男 " checked="checked"/>男 </label> <label><input
					name="Sex" type="radio" value="女" />女 </label>
			</p>
			<p>
				图书价格:<input id="bookPrice" type="text" name="bookPrice"
					style="width: 100px;" />
			</p>
			<p>
				图书类别:
				<select name="bookType" style="width: 100px;">
				<%
				DbUtil dbUtil = new DbUtil();
				BookTypeDao bookTypeDao = new BookTypeDao();
				Connection con = null;
				try{
					con = dbUtil.getCon();
					BookType bookType = null;
					ResultSet rs = bookTypeDao.list(con, new BookType());
					while(rs.next()){
						bookType = new BookType();
						bookType.setId(rs.getInt("id"));
						bookType.setBookTypeName(rs.getString("bookTypeName"));
				%>
						<option value="<%= bookType.getBookTypeName()%>,<%= bookType.getId()%>"><%= bookType.getBookTypeName() %></option>
				<% 
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try {
						dbUtil.close(con);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				%>
				</select>
			</p>
			<p>
				图书描述:<input id="bookDec" type="text" name="bookDec" style="width: 100px;">
			</p>


			<p>
				<input type="submit" value="确定"> <input type="button"
					value="重置" onclick="reset()">
			</p>
		</form>
	</div>
	<script type="text/javascript">
	function checkForm(form) {
		if(form.bookName.value == "") {
			alert("书名不能为空!");
			form.bookName.focus();
			return false;
		}
		if(form.bookAuthor.value == "") {
			alert("作者不能为空!");
			form.bookAuthor.focus();
			return false;
		}
		if(form.bookPrice.value == "") {
			alert("价格不能为空!");
			form.bookPrice.focus();
			return false;
		}
		if(isNaN(form.bookPrice.value)){
			alert("价格只能为数字");
			return false;
		}
		return true;
	}
	function reset(){
		document.getElementById("bookName").setAttribute("value","");
		document.getElementById("bookAuthor").setAttribute("value","");
		document.getElementById("bookPrice").setAttribute("value","");
		document.getElementById("bookDec").setAttribute("value","");
	}
	</script>
</body>
<%@ include file="Footer.jsp"%>
</html>