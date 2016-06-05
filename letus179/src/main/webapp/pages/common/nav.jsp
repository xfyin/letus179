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
<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/resources/js/register.js"></script>
<link href="${pageContext.request.contextPath }/resources/css/nav.css" rel="stylesheet"  />
<title>导航</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid" id="nav1">
    <div class="navbar-header">
    	<div class="head_div">
      	<a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">让我们一起走吧</a>
      </div>
      <div class="head_div">
    	<form class="navbar-form navbar-left" role="search">
    		<div class="col-lg-2">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">主题 <span class="caret"></span></button>
        <ul class="dropdown-menu">
          <li><a href="#">视频</a></li>
          <li><a href="#">文章</a></li>
          <li><a href="#">图片</a></li>
        </ul>
    		</div>
        <div class="col-lg-6">
		    <div class="input-group">
		      <input type="text" class="form-control" id="searchInfo" placeholder="搜一下就知道了">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button">搜</button>
			      </span>
			    </div> 
			  </div> 
      </form>
      </div>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">视频 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">最新</a></li>
            <li><a href="#">最热</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">我的</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">图片 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">趣图</a></li>
            <li><a href="#">动图</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">我的</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">文章 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">最新</a></li>
            <li><a href="#">最热</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">我的</a></li>
          </ul>
        </li>
				<li id="mySpaceInfo"><a  href="${pageContext.request.contextPath }/userroom/main.do?realname=${activeUser.realname}"><label class="mySpace" id="mySpace">我的空间</label></a></li>
				<li id="aboutusInfo"><a  href="${pageContext.request.contextPath }/aboutus.jsp"><label class="aboutus" id="aboutus">关于我们</label></a></li>
        <li id="loginInfo"><a data-toggle="modal" href="${pageContext.request.contextPath }/login/main.do">登录</a></li>
        <li id="info"><span>|</span></li>
				<li id="registerInfo"><a href="${pageContext.request.contextPath }/pages/register.jsp" target="_top">注册</a></li>
				<li><label class="welcomeInfo" id="welcomeInfo">欢迎您：<span class="welcomeName" id="welcomeName">${activeUser.realname}&nbsp;</span></label></li>
				<li><label class="logoutInfo" id="logoutInfo"> <a href="${pageContext.request.contextPath }/logout/logout.do?realname=${activeUser.realname}&nbsp;&nbsp;">[退出]</a></label></li>
      </ul>
    </div>
  </div>
	<!-- 两种导航栏，分界线 -->
  <div class="container-fluid" id="nav2">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">让我们一起走吧</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">视频 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">最新</a></li>
            <li><a href="#">最热</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">我的</a></li>
          </ul>
        </li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">图片 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">趣图</a></li>
            <li><a href="#">动图</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">我的</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">文章 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">最新</a></li>
            <li><a href="#">最热</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">我的</a></li>
          </ul>
        </li>
        <li id="mySpaceInfo"><a  href="${pageContext.request.contextPath }/userroom/main.do?realname=${activeUser.realname}"><label class="mySpace" id="mySpace">我的空间</label></a></li>
				<li id="aboutusInfo"><a  href="${pageContext.request.contextPath }/aboutus.jsp"><label class="aboutus" id="aboutus">关于我们</label></a></li>
				<li><label class="welcomeInfo" id="welcomeInfo">欢迎您：<span class="welcomeName" id="welcomeName">${activeUser.realname}&nbsp;</span></label></li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>
