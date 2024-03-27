<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>统计</title>
<script src='jquery.min.js'></script>
<style>
	*{
		margin:0 auto;
		padding:0;
		font-size:14px;
	}
	.c{
		height:25px;
		line-height:25px;
		background: red;
		margin: 10px 0px;
		color:#fff;
		text-align: right;
		position: relative;
		width:0px;
	}
	.da{
		position: absolute;
		top: 2px;
		right: -84px;
		color:#000;
	}
</style>
</head>
<body>
	<h1 class='title'>统计</h1>
	<c:forEach items="${list }" var='item'>
		<div class='c' >
			<span class='wen'>${item.count }</span>
			<div class='da'>
				${item.date }
			</div>
		</div>
	</c:forEach>
	
	<c:if test="${list==null }">
		<script type="text/javascript">
			$(function(){
				window.location.href = 'chartDC';
			})
		</script>
	</c:if>
	<c:forEach items="${list }" var='item' varStatus="ind">
	
		<script type="text/javascript">
			$(function(){
				$(".c").eq('${ind.index }').css('width','${400*(item.count/total)}px').css('transition','1s')
			})
		</script>
	</c:forEach>
	
</body>
</html>