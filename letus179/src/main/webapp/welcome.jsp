<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<%@include file="pages/common/public-statics.jsp"%>
<link
	href="${pageContext.request.contextPath }/resources/css/welcome.css"
	rel="stylesheet">
<title>欢迎来到 ——让我们一起走吧</title>
<script type="text/javascript">
	var second = 6;
	function calc() {
		if (second > 0) {
			second--;
			document.getElementById("times").innerHTML = second;
		} else {
			location.href = "${pageContext.request.contextPath }/index.jsp";
		}
		setTimeout('calc()', 1000);
	}
</script>
</head>
<body onload="calc();">
	<div class="first"> 欢迎归来： 
		<span class="name">${user.username }</span>&nbsp;${user.gender}, 
		<a href="${pageContext.request.contextPath }/index.jsp">让我们一起走吧!</a> 倒计时: 
		<span id="times" class="times">5</span><span  class="times" >s</span> 
		跳转...或者直接点击 <a href="${pageContext.request.contextPath }/index.jsp">进入</a>
	</div>
	<div class="second">
		<img alt="welcome"
			src="${pageContext.request.contextPath }/resources/images/welcome.jpg">
	</div>
	<div style="">
		<%@ include file="pages/common/footer.jsp"%>
	</div>
</body>
</html>
