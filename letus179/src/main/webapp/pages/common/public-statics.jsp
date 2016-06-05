<%-- 所有的静态资源导入都放在这里--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String contextPath = (String) request.getContextPath();
%>
<script type="text/javascript">var contextPath="<%=contextPath %>";</script>
<%-- 样式 默认就有 type="text/css" --%>
<link href="<%=contextPath%>/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"  />

<script src="<%=contextPath%>/resources/js/jquery-1.12.3.min.js"></script>
<script src="<%=contextPath%>/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=contextPath%>/resources/js/rootpath.js"></script>
<link href="<%=contextPath%>/resources/css/nav.css" rel="stylesheet"/>

<%-- 菜单css,js--%>
