<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404啊，404</title>
<link
	href="${pageContext.request.contextPath }/resources/css/404.css"
	rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>
			<div id="head">
			<div id="errorBox">
				<div id="errorText">
					<h1>Sorry..页面弄丢了！</h1>
					<p>
						似乎你所寻找的网页已移动或丢失了。
						<p>或者也许你只是键入错误了一些东西。</p>
						请不要担心，这没事。如果该资源对你很重要，请与管理员联系。
					</p>

					<p>
						火星不太安全，我可以免费送你回地球
					</p>
				</div>
				<a href="${pageContext.request.contextPath }/index.jsp" title="返回Letus179首页">
					<div class="link" id="home"></div>
				</a>
				<a href="${pageContext.request.contextPath }/aboutus.jsp" title="联系管理员">
					<div class="link" id="contact"></div>
				</a>
			</div>
		</div>
		<div>
			<jsp:include page="/pages/common/footer.jsp" />
		</div>
</body>
</html>