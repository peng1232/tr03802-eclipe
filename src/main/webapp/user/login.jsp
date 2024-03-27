<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<h1>登录</h1>
	<form action="login" method="post">
		账号：<input type="text" name='name' value="${name }"><br>
		密码：<input type="password" name='passwrod' value="${passwrod }"><br>
		验证码：<input name='yzm'><img id="img" src="yzm"><br>
		<input type="submit" value='登录'>
	</form>
	<a href="zhuce.jsp">注册</a>
	<c:if test="${flag==1 }">
		<script type="text/javascript">
			alert("验证码错误")
		</script>
	</c:if>
	<c:if test="${flag==2 }">
		<script type="text/javascript">
			alert("账号密码错误")
		</script>
	</c:if>
</body>
</html>