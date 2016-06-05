<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页脚</title>
<style type="text/css">
	.footer{
		height:60px;
		bottom:0; 
		margin-top:4%;
		margin-bottom:15px;
		float: right;
		margin-right:45%;
	}
	.copyRight {
		height:29px
	}
</style>
</head>
<body>
	<div class="footer">
		<table >
			<tbody>
				<tr>
					<td>&copy; Letus179| <a
						href="${pageContext.request.contextPath}/aboutus.jsp">关于我们</a> | <a
						href="mailto:xfyin179@163.com">广告联系</a> | <a target="_blank"
						href="https://github.com/xfyin/letus179">@github</a>
					</td>
				</tr>
				<tr class="copyRight" style="text-align: center;">
					<td>letus179.com 版权信息  2016</td>
				</tr>
			</tbody>
		</table>
		</div>
</body>
</html>