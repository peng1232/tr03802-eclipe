<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='../jquery.min.js'></script>
<style>
	.img{
		width: 50px;
	    height: 50px;
	    border-radius: 50%;
	    border: 1px solid #000;
	}
</style>
</head>
<body>
	<h1>用户列表</h1>
	<table id="tab" border=1 style="border-collapse: collapse;text-align: center">
		<tr>
			<th>头像</th>
			<th>姓名</th>
			<th>电话</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
	</table>
	<script type="text/javascript">
		$(function(){
			//显示列表
			$.getJSON("query",function(e){
				querys(e);
			})
			//删除
			$(document).on('click', '.btn', function() {
				var uid = $(this).prop("name");
				//拼接出表单一样的参数
				var params = {
					"name":uid
				};
				//提交请求
				$.getJSON("del",params,function(e){
					querys(e);
				})
			});
			//创建对应的元素
			function querys(e){
				$(".tr").detach();
				for(var i=0;i<e.length;i++){
					var tr = $("<tr>");
					var td1 = $("<td>");
					var td2 = $("<td>");
					var td3 = $("<td>");
					var td4 = $("<td>");
					var td5 = $("<td>");
					var img = $("<img>")
					var btn = $("<button>")
					tr.addClass("tr")
					img.prop('src',"../images/"+e[i].head).addClass("img");
					td1.append(img);
					td2.text(e[i].uname)
					td3.text(e[i].phone)
					td4.text(e[i].address)
					btn.prop("name",e[i].uid).html("删除").addClass("btn");;
					td5.append(btn)
					tr.append(td1).append(td2).append(td3).append(td4).append(td5);
					$("#tab").append(tr);
				}
			}
		})
	</script>
</body>
</html>