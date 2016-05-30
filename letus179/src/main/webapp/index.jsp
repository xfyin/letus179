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
<link href="${pageContext.request.contextPath}/resources/css/index.css"
	rel="stylesheet">
<title>让我们一起走吧-随时随地随心情</title>
<script type="text/javascript">
$(function(){
		var name = $(".welcomeName").text();
		if (name.trim() != "") {
			document.getElementById("welcomeInfo").style.display="block";
			document.getElementById("loginInfo").style.display="none";
			document.getElementById("info").style.display="none";
			document.getElementById("registerInfo").style.display="none";
			document.getElementById("logoutInfo").style.display="block";
		}
	
	function search() {
		//检索  ajax	
		//href="${pageContext.request.contextPath}/search/search.do"
	}
	
});
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">让我们一起走吧</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<div>
				<form class="navbar-form navbar-left .form-inline" role="search"
					id="searchForm">
					<div class="form-group">
						<input type="text" id="mySearch" class="form-control"
							placeholder="搜一下就知道了"> <a
							class="glyphicon glyphicon-search form-control-feedback"
							aria-hidden="true" target="_top" title="搜索" onclick="search();">
						</a>
					</div>
				</form>
			</div>
			<div>
				<ul class="form-group navbar-form navbar-right">
					<li id="loginInfo">
						<button type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#myModal" >登录</button>
					</li>
					<li id="info"><span>|</span></li>
					<li class="btn btn-primary btn-sm" id="registerInfo"><a
						href="${pageContext.request.contextPath }/pages/register.jsp"
						target="_top">注册</a></li>
					<li>
						<label class="logoutInfo" id="logoutInfo">
							<a href="${pageContext.request.contextPath }/logout/logout.do?username=${username}">退出</a>
						</label>
					</li>
					<li>
					<label class="welcomeInfo" id="welcomeInfo">欢迎您：<span class="welcomeName">${username}&nbsp;&nbsp;</span></label>
					</li>
				</ul>
			</div>
		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>

	<!-- 登录Modal -->
	<form class="navbar-form navbar-right"
		action="${pageContext.request.contextPath}/login/autoLogin.do" method="post">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content login">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h3 class="modal-title" id="myModalLabel"
							style="text-align: center; color: #515151">登录</h3>
					</div>
					<div class="modal-body">
						<div class="form-group glyphicon glyphicon-user"
							style="padding: 25px 0 20px 0;">
							<input type="text" placeholder="用户名/邮箱/手机号" class="form-control"
								name="username">
						</div>
						<div class="form-group glyphicon glyphicon-lock "
							style="padding: 20px 0 25px 0">
							<input type="password" placeholder="请输入密码" class="form-control"
								name="password">
						</div>
						<div class="loginAbout">
							<div class="nextLogin">
								<input id="remeberMe" type="checkbox" checked="checked">
								<label for="remeberMe" class="remeberMe">下次自动登录</label>
							</div>
							<div class="forgetPwd">
								<span><a
									href="${pageContext.request.contextPath }/forget/forgetPassword.do"
									target="_blank">记住密码？</a> </span>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button style="text-align: center; color: #515151" type="submit"
							class="btn btn-primary">进入</button>
					</div>
				</div>
			</div>
		</div>
	</form>


	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Letus179</h1>
			<p>"让我们一起走吧"专为我们得生活......</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">详细
					&raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa j.conusto sit amet risus.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
		</div>
	</div>

	<hr>
	<div>
		<%@ include file="pages/common/footer.jsp"%>
	</div>
</body>
</html>
