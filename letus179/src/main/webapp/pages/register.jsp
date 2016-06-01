<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="/pages/common/public-statics.jsp"%>
<link href="${pageContext.request.contextPath }/resources/css/index.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/css/register.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/resources/js/birthday.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/procitydis.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/register.js"></script>
<title>注册 letus179账号</title>
<style type="text/css">
	.foot{
		margin-top: 70px;
	}
	.navbar-right {
		margin-right:6px;
	}
</style>
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
			<a class="navbar-brand"
				href="${pageContext.request.contextPath }/index.jsp">让我们一起走吧</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<div>
				<ul class="form-group navbar-form navbar-right">
					<li><span style="font-size: 10px">已有账号？</span> <a
						data-toggle="modal" data-target="#myModal"
						class="glyphicon glyphicon-hand-right">&nbsp;登录</a></li>
				</ul>
			</div>
		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>
	 <!-- 登录Modal -->
	<jsp:include page="/pages/common/login.jsp" />

	<div style="float: left; width: 95%; height: 600px;">
		<div class="regeste0">
			<!-- 宣传图片 -->
			<img alt=""
				src="${pageContext.request.contextPath }/resources/images/register.jpg">
		</div>

		<div class="regeste0" id="main">
			<div class="reg_head">
				<span style="color: red">*</span>&nbsp;必填内容
			</div>
			<div>
				<form onsubmit="return register()" id="regester"
					action="${pageContext.request.contextPath }/register/register.do"
					method="post" >
					<table height="501px">
						<tr>
							<td class="reg"><span style="color: red">*</span>真实姓名</td>
							<td class="reg_put"><input type="text"
								id="realname" name="realname" placeholder="注册后不可更改"></td>
							<td class="return_info"><span class="info" id="realname_Info"></span></td>
						</tr>
						<tr>
							<td class="reg"><span style="color: red">*</span>用户名</td>
							<td class="reg_put"><input type="text" id="username"
								name="username" placeholder="昵称"></td>
							<td class="return_info"><span class="info" id="username_info"></span></td>
						</tr>
						<tr>
							<td class="reg"><span style="color: red">*</span>性别</td>
							<td class="reg_put"><input class="sex" type="radio"
								name="sex" id="male" value="1" checked="checked"><label
								for="male">男</label> <input class="sex" type="radio" name="sex"
								id="female" value="0"><label for="female">女</label> <input
								class="sex" type="radio" name="sex" id="nomale" value="2"><label
								for="nomale">O</label></td>
						</tr>
						<tr>
							<td class="reg"><span style="color: red">*</span>密码</td>
							<td class="reg_put"><input type="password"
								onblur="valpwd();" id="pwd" name="pwd"
								placeholder="请输入6~12位的数字、字母组合"></td>
							<td class="return_info"><span class="info" id="pwd_info"></span></td>
						</tr>
						<tr>
							<td class="reg"><span style="color: red">*</span>确认密码</td>
							<td class="reg_put"><input type="password" id="pwd1"
								name="pwd1" placeholder="请重复上述密码"></td>
							<td class="return_info"><span class="info" id="pwd1_info"></span></td>
						</tr>
						<tr>
							<td class="reg"><span style="color: red">*</span>出生日期</td>
							<td class="reg_put">
								<select class="sel_year" name="b_year" rel="-"></select>&nbsp;年 &nbsp;&nbsp; 
								<select class="sel_month" name="b_month" rel="-"></select>&nbsp;月 &nbsp;&nbsp; 
								<select class="sel_day" name="b_day" rel="-"></select>&nbsp;日&nbsp;
							</td>
							<td class="return_info"><span class="info" id="birthday_info"></span></td>
						</tr>
						<tr>
							<td class="reg"><span style="color: red">*</span>所在地</td>
							<td class="reg_put">
								<select class="province" name="province" id="province" rel="-"></select> 
								<select class="city" name="city" id="city" rel="-"></select> 
								<select class="district" name="district" id="district" rel="-"></select>
							</td>
							<td class="return_info"><span class="info" id="from_info"></span></td>
						</tr>
						<tr>
							<td class="reg">Email</td>
							<td class="reg_put"><input type="text" id="email"
								name="email"></td>
							<td><span class="info"></span></td>
						</tr>
						<tr>
							<td class="reg">手机号</td>
							<td class="reg_put"><input type="text" id="phone"
								name="phone"></td>
							<td><span class="info"></span></td>
						</tr>
					</table>
					<div class="reg_bottom">
						<input type="submit" name="submit" value="注册">&nbsp;&nbsp; <input type="button"
							value="重置" onClick="formReset();">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div>
		<jsp:include page="/pages/common/footer.jsp" />
	</div>
</body>
</html>