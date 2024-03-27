<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='jquery.min.js'></script>
<style>
	*{
		margin:0 auto;
		padding:0;
		font-size:14px;
	}
	.title{
		text-align: center;
		font-size: 30px
	}
	.tab{
		width: 50%;
	}
	.tab tr td{
		padding:5px 10px;
		text-align: center;
	}
	.la:last-child{
		display: none;
	}
	.check{
		transform: scale(1.5)
	}
	.btn{
		padding: 10px 18px;
	    background: #4faae8;
	    color: #fff;
	    transition: 0.3s;
	    text-decoration: none;
	    border-radius: 20px;
	    display: block;
	    float: left;
	    margin-bottom: 8px;
	    border:none;
	    outline:none;
	    cursor: pointer;
	}
	.box{
		display: flex;
    	width: 50%;
	}
	
	.box:after {
	    content: "";
	    display: block;
	    clear: both;
	}
	
	.right_title{
		width: 100%;
		height: 6vh;
		border-bottom:1px solid #383a3b ;
		color: #fff;
		display: block;
		line-height: 6vh;
		text-align: center;
		background-color: #383a3b;
	}
	.doing2{
		width: 100%;
		height: 100%;
		position: absolute;
		z-index: 999;
		top: 0%;
		left: 0;
		overflow: hidden;
		transition: 0.6s;
		display: none;
	}
	.zhe2{
		width: 100%;
		height: 100%;
		background-color: #282a2d;
		position: absolute;
		z-index: 999;
		top: 0%;
		left: 0;
		opacity: 0;
		transition: 0.3s;
	}
	.nr2{
		/* box-shadow: 1px 1px 1px 1px #fff; */
		overflow: hidden;
		width: 40%;
		height: 60vh;
		background-color: #fff;
		transform: translateY(34%);
		position: relative;
		z-index: 9999;
		border-radius: 1vh;
		transform: scale(0);
		transition: 0.3s;
	}
	.uan{
		font-size: 2vh;
	    outline: none;
	    padding: 1.2vh 2.2vh;
	    cursor: pointer;
	    border: none;
	   	margin-left: 1.5vh;
	   	margin-top:3vh;
   		border-radius: 0.5vh;
   		border:1px solid #dedfe2;
   		background:#fff;
   		float:right;
   		color:#626263;
	}
	#kai,#del,#guan5{
		background:#409efe;
		border-color:#409efe;
		color:#fff;
	}
	.nr2,.nr4{
		width: 56vh;
    	height: 37vh;
	}
	.wenzi{
		padding: 5vh 0vh 5vh 4vh;
   		 width: 100%;
    	font-size: 2.5vh;
    	color: red;
   		 letter-spacing: 0.2vh;
	}
	#guan2{
		margin-left: 3.5vh;
		float:left;
	}
	.cen{
		width: 63%;
    	padding-right: 4vh;
	}
	.content{
		width:300px;
		max-width:300px;
		max-height:100px;
		height:100px;
	}
</style>
</head>
<body>
	<h1 class='title'>留言列表</h1>
	<div class='box'>
		<a href='ds.jsp' class='btn'>添加留言</a>
		<button class='btn'>删除留言</button>
		<button class='btn'>批量删除</button>
		<button class='btn'>修改留言</button>
		<button class='btn'>统计留言数</button>
	</div>
	<div>
		<table border="1" cellspacing='0' class='tab'>
			<c:forEach items="${list }"  var="item">
				<tr>
					<td rowspan="2"><input type="checkbox" value="${item['sid'] }" class='check'/></td>
					<td><b>留言人</b></td>
					<td class='zhi1'>${item['suser'] }</td>
					<td><b>留言时间</b></td>
					<td>
						<fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${item['stime'] }"/>
					</td>
				</tr>
				<tr>
					<td><b>留言内容</b></td>
					<td colspan='3' class='zhi2'>${item['scontent'] }</td>
				</tr>
				<tr class='la'>
					<td colspan='5'></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 修改弹窗 -->
	<!-- 弹窗 -->
	<div class="doing2">
		<div class="zhe2"></div>
		<div class="nr2">
			<div class="right_title">
				<span class="f">修改</span>
			</div>
			
			<div class='clearfix cen'>
				<form action = "insert" method='post' id='sub'>
				<div>内容：</div>
				<div>
					<textarea class='content' name = 'content'></textarea>
				</div>
				<div>
					留言人：<input class='user' name = 'user'/>
				</div>
			</form>
				<button class='uan' id='del'>确定</button>
				<button class='uan' id='guan2'>取消</button>
			</div>
		</div>
	</div>
	<c:if test="${list==null }">
		<script type="text/javascript">
			$(function(){
				window.location.href = 'select';
			})
		</script>
	</c:if>
	<script type="text/javascript">
		$(function(){
			$(".btn:contains('删除留言')").click(function(){
			   	var query = $(".check:checked");
			   	if(query.length<1){
			   		alert("请选择之后在删除！")
			   		return false;
			   	}
				if(query.length>1){
			   		alert("只能删除一个！")
			   		return false;
			   	}
				if(confirm("确定删除选中的数据嘛？")){
					del(query.val());
				}
			})
			function del(sid){
				var formData = "sid=" + encodeURIComponent(sid);
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "delete", true);
				xhr.onreadystatechange = function() {
				   if(xhr.readyState === 4 && xhr.status === 200) {
				       var response = xhr.responseText; 
					   window.location.href = 'select';
				   }
				};
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xhr.send(formData);
			}
			$(".btn:contains('批量删除')").click(function(){
			   	var query = $(".check:checked");
			   	if(query.length<1){
			   		alert("请选择之后在删除！")
			   		return false;
			   	}
				if(confirm("确定删除选中的数据嘛？")){
					var queue = [];
					query.each(function(a){
						 queue.push($(this).val());
					})
					del(queue);
				}
			})
			var query;
			$(".btn:contains('修改留言')").click(function(){
				query = $(".check:checked");
			   	if(query.length<1){
			   		alert("请选择之后在修改！")
			   		return false;
			   	}
				if(query.length>1){
			   		alert("只能修改一个！")
			   		return false;
			   	}
				$('.doing2').css('display','block');
				$(".zhe2").animate({
					opacity: 0.8
				},100)
				$('.nr2').css('transform','scale(1) translateY(66%)');
				var zhi1 =query.parent().parent().find('.zhi1').text()
				var zhi2 = query.parent().parent().next().find('.zhi2').text();
				$(".content").val(zhi2);
				$(".user").val(zhi1)
			})
			$('#guan2').click(function(){
					$('.zhe2').trigger("click");
			})
			$('.zhe2').click(function(){
					$(".zhe2").animate({
						opacity: 0
					},100)
					
					$('.nr2').css('transform','scale(0) translateY(0%)')
					$(".doing2").animate({
					    opacity: 1
					}, 300, function() {
					    $(this).hide(); // 动画完成后隐藏元素
					});
				})
				$("#del").click(function(){
					var zhi1 = $(".content").val();
					var zhi2 =  $(".user").val()
					var formData = "sid=" + encodeURIComponent(query.val()) + "&zhi1=" + encodeURIComponent(zhi1) + "&zhi2=" + encodeURIComponent(zhi2);
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "update", true);
					xhr.onreadystatechange = function() {
					   if(xhr.readyState === 4 && xhr.status === 200) {
					       var response = xhr.responseText; 
						   window.location.href = 'select';
					   }
					};
					xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					xhr.send(formData);
				})
		})
	</script>
</body>
</html>