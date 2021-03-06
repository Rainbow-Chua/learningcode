<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="com.rainbowpro.util.*"%>
<%@ page import="com.rainbowpro.dao.*"%>
<%@ page import="com.rainbowpro.model.*"%>
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
/* Border styles */
#table-2 thead, #table-2 tr {
	border-top-width: 1px;
	border-top-style: solid;
	border-top-color: rgb(230, 189, 189);
}

#table-2 tr:HOVER td {
	background-color: red;
}

#table-2 {
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: rgb(230, 189, 189);
}

/* Padding and font style */
#table-2 td, #table-2 th {
	padding: 10px 60px;
    font-size: 15px;
	font-family: Verdana;
	color: rgb(177, 106, 104);
}

/* Alternating background colors */
#table-2 tr:nth-child(even) {
	background: rgb(238, 211, 210)
}

#table-2 tr:nth-child(odd) {
	background: #FFF
}
</style>
</head>
<%@ include file="Headermain.jsp"%>
<body onload="IniEvent()">
<h2 style = "text-align: center">图书管理</h2>
	<div>
		<form action="bookmanager.do" method="get"
			style="background-color: orange; position: relative; width: 800px; left: 30%; padding-top: 30px; padding-bottom: 30px">
			<p style="display: inline;">
				图书名称:<input id="bookName" type="text" name="bookName"
					style="width: 150px;" />
			</p>
			<p style="display: inline;">
				图书作者:<input id="bookAuthor" type="text" name="bookAuthor"
					style="width: 150px;" />
			</p>
			<p style="display: inline;">
				图书类别: <select name="bookType" style="width: 150px;">
							<option value="all,0">所有</option>
					<%
						DbUtil dbUtil = new DbUtil();
						BookTypeDao bookTypeDao = new BookTypeDao();
						Connection con = null;
						try {
							con = dbUtil.getCon();
							BookType bookType = null;
							ResultSet rs = bookTypeDao.list(con, new BookType());
							while (rs.next()) {
								bookType = new BookType();
								bookType.setId(rs.getInt("id"));
								bookType.setBookTypeName(rs.getString("bookTypeName"));
					%>
					<option
						value="<%=bookType.getBookTypeName()%>,<%=bookType.getId()%>"><%=bookType.getBookTypeName()%></option>
					<%
						}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							try {
								dbUtil.close(con);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					%>
				</select>
			</p>
			<p style="display: inline;">
				<input type="submit" value="搜索">
			</p>
		</form>
	</div>
	<%!ArrayList list = null;%>
	<%
		if (request.getAttribute("list") != null) {
			list = (ArrayList) request.getAttribute("list");
		}
	%>
	<table id="table-2" align="center">
		<tr>
			<th>编号</th>
			<th>图书名称</th>
			<th>图书作者</th>
			<th>图书价格</th>
			<th>作者性别</th>
			<th>图书描述</th>
			<th>图书类别</th>
		</tr>
		<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					Book book = (Book) list.get(i);
		%>
		<tr>
			<th><%=book.getId()%></th>
			<th><%=book.getBookName()%></th>
			<th><%=book.getAuthor()%></th>
			<th><%=book.getPrice()%></th>
			<th><%=book.getSex()%></th>
			<th><%=book.getBookDesc()%></th>
			<th><%=book.getBookTypeName()%></th>
		</tr>
		<%
			}
		}
		%>
	</table>
	<br>
	<div>
		<form action="bookmanager.do" method="post"
			onsubmit="return checkForm(this);"
			style="background-color: orange; position: relative; left: 42%; width: 300px;padding-top: 30px; padding-bottom: 30px ">
			<p>
				编号:<input id="bookId" name="bookId" type="text" readonly="readonly" style="width: 150px;">
			</p>
			<p>
				图书名称: <input id="bookName1" type="text" name="bookName1"
					style="width: 150px;" />
			</p>
			<p>
				图书作者: <input id="bookAuthor1" type="text" name="bookAuthor1"
					style="width: 150px;" />
			</p>
			<p>
				作者性别: <label style="width: 150px;"><input id="male" name="Sex" type="radio" value="男 "/>男 </label> <label><input
					id="female" name="Sex" type="radio" value="女" />女 </label>
			</p>
			<p>
				图书价格: <input id="bookPrice1" type="text" name="bookPrice1"
					style="width: 150px;" />
			</p>
			<p>
				图书类别:
				<select id="bookType1" name="bookType1" style="width: 150px;">
				<%
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
				图书描述: <input id="bookDec1" type="text" name="bookDec1" style="width: 150px;">
			</p>


			<p>
				<input type="submit" name="modify" value="修改"> <input type="submit" name="delete" value="删除">
			</p>
		</form>
	</div>
	<script type="text/javascript">
		function IniEvent() {
			var tbl = document.getElementById("table-2");
			var trs = tbl.getElementsByTagName("tr");
			for (var i = 0; i < trs.length; i++) {
				trs[i].onclick = TrOnClick;
			}
		}
		function TrOnClick() {
			var tbl = document.getElementById("table-2");
			var trs = tbl.getElementsByTagName("tr");
			for (var i = 1; i < trs.length; i++) {
				if (trs[i] == this) { //判断是不是当前选择的行
					trs[i].style.background = "yellow";
					var x=document.getElementById('table-2').rows[i].cells;
					document.getElementById("bookId").setAttribute("value", x[0].innerHTML);
					document.getElementById("bookName1").setAttribute("value", x[1].innerHTML);
					document.getElementById("bookAuthor1").setAttribute("value", x[2].innerHTML);
					document.getElementById("bookPrice1").setAttribute("value", x[3].innerHTML);
					//alert(x[4].innerHTML);
					var male = "男";
					if(x[4].innerHTML == male){
						document.getElementById("male").checked = true;
						document.getElementById("female").checked = false;
					} else {
						document.getElementById("female").checked = true;
						document.getElementById("male").checked = false;
					}
					document.getElementById("bookDec1").setAttribute("value", x[5].innerHTML);
					var all_options = document.getElementById("bookType1").options;
					for (var q=0; q<all_options.length; q++){
					     if (all_options[q].value.indexOf(x[6].innerHTML) >= 0){
					        all_options[q].selected = true;
					     }
					}
				} else {
					if(i%2 == 0){
						trs[i].style.background = "white";
					} else {
						trs[i].style.background = "rgb(238, 211, 210)";
					}
				}
			}
		}
	</script>
</body>
<%@ include file="Footer.jsp"%>
</html>