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
<h2 style = "text-align: center">图书类别管理</h2>
	<div>
		<form action="booktypemanager.do" method="get"
			style="background-color: orange; position: relative; width: 800px; left: 30%; padding-top: 30px; padding-bottom: 30px">
			<p style="display: inline;">
				图书类别名称:<input id="bookTypeName" type="text" name="bookTypeName"
					style="width: 150px;" />
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
			<th>图书类别名称</th>
			<th>总数</th>
			<th>图书类别描述</th>
		</tr>
		<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					BookType booktype = (BookType) list.get(i);
		%>
		<tr>
			<th><%=booktype.getId()%></th>
			<th><%=booktype.getBookTypeName()%></th>
			<th><%=booktype.getNum()%></th>
			<th><%=booktype.getBookTypeDesc()%></th>
		</tr>
		<%
			}
		}
		%>
	</table>
	<br>
	<div>
		<form action="booktypemanager.do" method="post"
			onsubmit="return checkForm(this);"
			style="background-color: orange; position: relative; left: 42%; width: 300px;padding-top: 30px; padding-bottom: 30px ">
			<p>
				<span style="position: relative; left:31px;">编号: <input id="bookTypeId" name="bookTypeId" type="text" readonly="readonly" style="width: 150px;"></span>
			</p>
			<p>
				图书类别名称: <input id="bookTypeName1" type="text" name="bookTypeName1"
					style="width: 150px;" />
			</p>
			<p>
				图书类别描述: <input id="bookTypeDec1" type="text" name="bookTypeDec1" style="width: 150px;">
			</p>
			<p>
				<span style="position: relative; left:16px;">图书数量: <input id="bookNum1" type="text" name="bookNum1" readonly="readonly" style="width: 150px;"></span>
			</p>
			<p>
				<input type="submit" name="modify" value="修改"> <input type="submit" name="delete" value="删除">
			</p>
		</form>
	</div>
	<script type="text/javascript">
	function checkForm(form) {
		if(parseInt(form.bookNum1.value) > 0) {
			alert("该类别下还有图书!请勿删除");
			return false;
		}
		return true;
	}
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
					document.getElementById("bookTypeId").setAttribute("value", x[0].innerHTML);
					document.getElementById("bookTypeName1").setAttribute("value", x[1].innerHTML);
					document.getElementById("bookTypeDec1").setAttribute("value", x[3].innerHTML);
					document.getElementById("bookNum1").setAttribute("value", x[2].innerHTML);
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