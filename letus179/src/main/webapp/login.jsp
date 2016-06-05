<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYpE html pUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-Ua-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<%@include file="pages/common/public-statics.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/login.css"
	rel="stylesheet" />
<title>登录-让我们一起走吧</title>
<style type="text/css">
</style>
<style>
</style>

<script type="text/javascript">
	$(function() {
		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseInt($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseInt($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	});
	
</script>
</head>
<body>
	<jsp:include page="/pages/common/nav.jsp" />
	<div>
		<form action="${pageContext.request.contextPath }/loginCheck.do"
			method="post" onsubmit="return login_before();">
			<div class="top_div"></div>
			<div class="login_head">
				<div class="owl">
					<div class="tou"></div>
					<div class="initial_left_hand" id="left_hand"></div>
					<div class="initial_right_hand" id="right_hand"></div>
				</div>
				<p class="username">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
					<input class="ipt" type="text" placeholder="请输入用户名"
						name="username" id="username">
				</p>
				<p class="password">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					<input class="ipt" id="password" type="password"
						placeholder="请输入密码" name="password" id="password">
				</p>
				<div class="login_bottom">
					<p class="p">
						<span style="float: left;"><a style="color: #4F94CD;"
							href="#" title="点这里，帮你找回密码！">忘记密码?</a></span> <span
							style="float: right;"><a
							style="color: #4F94CD; margin-right: 10px;" title="还没注册过？点这里！"
							href="${pageContext.request.contextPath }/pages/register.jsp">注册</a>
							<input class="login_login" type="submit" value="登录"> </span>
					</p>
				</div>
			</div>
		</form>
	</div>
		<%@ include file="pages/common/footer.jsp"%>
</body>
<script type="text/javascript">
	//对错误的登录信息进行返回
	var error = "${Msg}".trim();
	if (error != "") {
		alert(error);
	};
	
	//提交登录前判断用户名或密码是否为空
	function login_before() {
		var username = document.getElementById("username").value.trim();
		if (username == "") {
			alert("用户名未填写！");
			return;
		}
		var password = document.getElementById("password").value.trim();
		if (password == "") {
			alert("密码未填写！");
			return;
		}
	}
</script>
</html>
