<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="wenjian" method="post" enctype="multipart/form-data">
		选择照片：<input type="file" name='photo'>
		照片的描述：<input name='desc'>
		<input type='submit' value='上传'>
	</form>
		<img src='images/${photo }'>
</body>
</html>