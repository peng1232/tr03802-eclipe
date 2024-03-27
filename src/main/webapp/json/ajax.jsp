<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='../jquery.min.js'></script>
<title>Insert title here</title>
</head>
<body>
	<form action="insert2" method='post' id='sub'>
		<div>内容：</div>
		<div>
			<textarea class='content' name='content'></textarea>
		</div>
		<div>
			留言人：<input class='user' name='user' />
		</div>
		<div>
			<input type='submit'>
		</div>
	</form>
	<button id='liu'>获取留言</button>
	<div id='rultset'></div>
	<script type="text/javascript">
		$(function() {
			$("#liu").click(function() {
				$.getJSON("select2", function(v) {
					$("#rultset").empty();
					for (var i = 0; i < v.length; i++) {
						var div = $("<div>");
						div.css("height", "20px")
						div.css("border-bottom", "1px solid #000")
						var span1 = $("<span>");
						span1.css('float', 'right');
						var span2 = $("<span>");
						span2.css('float', 'left');
						span2.text(v[i].scontent)
						span1.text(v[i].stime)
						$("#rultset").append(div);
						div.append(span1).append(span2);
					}
				})
			})
			$("#liu").trigger("click");
			$("#sub").submit(function(){
				event.preventDefault(); // 阻止表单默认提交行为

			    var formData = $(this).serialize(); // 获取表单数据
				$.getJSON("insert2",formData, function(v) {
					$("#rultset").empty();
					for (var i = 0; i < v.length; i++) {
						var div = $("<div>");
						div.css("height", "20px")
						div.css("border-bottom", "1px solid #000")
						var span1 = $("<span>");
						span1.css('float', 'right');
						var span2 = $("<span>");
						span2.css('float', 'left');
						span2.text(v[i].scontent)
						span1.text(v[i].stime)
						$("#rultset").append(div);
						div.append(span1).append(span2);
					}
				})
			})
		})
	</script>
</body>
</html>