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
<script
	src="${pageContext.request.contextPath }/resources/js/jquery.countdown.js"></script>
<title>欢迎来到 ——让我们一起走吧</title>
<script type="text/javascript">
	$(function() {
		$(".digits")
				.countdown(
						{
							image : "${pageContext.request.contextPath }/resources/images/cutdown.png",
							format : "s",
							startTime : "5"
						});
	});
	var second = 6;
	function calc() {
		if (second > 0) {
			second--;
			/* document.getElementById("times").innerHTML = second;  */
		} else {
			location.href = "${pageContext.request.contextPath }/index/index.do?realname=${activeUser.realname }";
		}
		setTimeout('calc()', 1000);
	}
</script>
<style type="text/css">
	#nav3{
		display: none;
	}
</style>
</head>
<body onload="calc();">
	<jsp:include page="/pages/common/nav.jsp" />
	<div class="container">
		<div class="all">
			<div class="first">
				<div class="first_1">
					欢迎归来： <span class="name">${activeUser.realname }</span>&nbsp;${activeUser.gender},
					<a href="${pageContext.request.contextPath }/index/index.do">让我们一起走吧!</a>
					倒计时:
				</div>
				<div class="first_2">
					<span id="times"></span> <br> <br> <span class="digits"></span>
					<br> <br> <br> <br> <br>
				</div>
				<div class="first_3">
					s&nbsp;跳转...或者直接点击 <a
						href="${pageContext.request.contextPath }/index/index.do">进入</a>
				</div>
			</div>
		
			<div class="second">
				<img alt="welcome" d
					src="${pageContext.request.contextPath }/resources/images/welcome.jpg">
			</div>
		</div>
		<div class="foot">
			<table>
				<tbody>
					<tr>
						<td>&copy; Letus179| <a
							href="${pageContext.request.contextPath}/aboutus.jsp">关于我们</a> |
							<a href="mailto:xfyin179@163.com">广告联系</a> | <a target="_blank"
							href="https://github.com/xfyin/letus179">@github</a>
						</td>
					</tr>
					<tr class="copyRight" style="text-align: center;">
						<td>letus179.com 版权信息 2016</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
