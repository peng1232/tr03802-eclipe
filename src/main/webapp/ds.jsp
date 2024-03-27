<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		font-size:14px;
	}
	.content{
		width:400px;
		height:100px;
	}
</style>
<script src='jquery.min.js'></script>
</head>
<body>
	<h1>留言内容</h1>
	<form action = "insert" method='post' id='sub'>
		<div>内容：</div>
		<div>
			<textarea class='content' name = 'content'></textarea>
		</div>
		<div>
			留言人：<input class='user' name = 'user'/>
		</div>
		<div>
			<input type='submit'>
		</div>
	</form>
	<script type="text/javascript">
		$(function(){
			$("#sub").submit(function(){
				if( $('.content').val().trim().length>0&& $('.user').val().trim().length>0){
					return true;
				}else{
					alert("请填写完整")
					return false;
				}
			});
		})
	</script>
</body>
</html>