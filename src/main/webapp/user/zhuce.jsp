<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册</h1>
	<form action="zhece" method="post">
		账号：<input type="text" name='name' value="${name }"><br>
		密码：<input type="password" name='passwrod' value="${passwrod }"><br>
		电话号码：<input type="text" name='tel' value="${name }"><br>
		地址：<input type="text" name='address' value="${name }"><br>
		<input type="submit" value='注册'>
	</form>
	<a href="login.jsp">登录</a>
</body>
</html>