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
<title>关于我们</title>
<style type="text/css">
	#nav1 {
		display: none;
	}
	#nav2{
		display: block;
	}
	#nav3{
		display: none;
	}
</style>
</head>
<body>
	<div class="container">
	<jsp:include page="/pages/common/nav.jsp" />
	<div>
		<%@ include file="pages/common/footer.jsp"%>
	</div>
	</div>
</body>
</html>
