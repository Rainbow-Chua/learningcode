<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
<script type="text/javascript">
	function resetValue(){
		document.getElementById("userName").value="";
		document.getElementById("password").value="";
	}
</script>
<%
	String userName=null;
	String pwd=null;
	Cookie[] cookie=request.getCookies();
	for(int i=0;cookie!=null&&i<cookie.length;i++){
		if(cookie[i].getName().equals("userNameAndPwd")){
			userName=cookie[i].getValue().split("-")[0];
			pwd=cookie[i].getValue().split("-")[1];
		}
	}
	if(userName==null){
		userName="";
	}
	if(pwd==null){
		pwd="";
	}
%>
</head>
<body>
<form action="userLogin.jsp" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" id="userName" name="userName" value="<%=userName%>" style="width:160px"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" id="password" name="password" value="<%=pwd%>" style="width:160px"/></td>
		</tr>
		<tr>
			<td>是否记住密码：</td>
			<td><input type="checkbox" id="remember" name="remember"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="登录"/></td>
			<td><input type="button" value="重置" onclick="resetValue()"/></td>
		</tr>
	</table>
</form>
</body>
</html>