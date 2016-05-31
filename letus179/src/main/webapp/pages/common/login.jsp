<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<!-- 登录Modal -->
	<form class="navbar-form navbar-right"
		action="${pageContext.request.contextPath }/login/autoLogin.do"
		method="post" onsubmit="return user_login();">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" onmouseout="resetLoginInfo();">
			<div class="modal-dialog" role="document">
				<div class="modal-content login">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h3 class="modal-title" id="myModalLabel"
							style="background-color: #8B864E; border: 0px;text-align: center;">登录</h3>
					</div>
					<div class="modal-body">
						<div class="form-group glyphicon glyphicon-user"
							style="padding: 25px 0 20px 0;">
							<input type="text" placeholder="用户名/邮箱/手机号" class="form-control"
								name="username" style="margin-left: 4px; font-size: 13px">
						</div>
								<div><span class="info" id="login_info"></span></div>
						<div class="form-group glyphicon glyphicon-lock "
							style="padding: 20px 0 25px 0">
							<input type="password" placeholder="请输入密码" class="form-control"
								name="password" style="margin-left: 4px; font-size: 13px">
						</div>
						<div class="loginAbout">
							<div class="nextLogin">
								<input id="remeberMe" type="checkbox" checked="checked"
									style="width: 3px"> <label for="remeberMe"
									class="remeberMe">下次自动登录</label>
							</div>
							<div class="forgetPwd" style="margin-right: 30px">
								<span><a
									href="${pageContext.request.contextPath }/forget/forgetPassword.do"
									target="_blank">记住密码？</a> </span>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">进入</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>