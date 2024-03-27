<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<style type="text/css">
	#icon{
		width:50px;
		height: 50px;
		border-radius:50%;
		border:1px solid #000;
	}
</style>
</head>
<body>
	头像：<img id='icon' src='../images/${user.head }'><br>
	姓名：${user.uname }<br>
	电话：${user.phone }<br>
	地址：${user.address }<br>
	<form action="tou" method="post" enctype="multipart/form-data">
		选择照片：<input type="file" name='photo'>
		<input type='submit' value='上传'>
	</form>
</body>
</html>