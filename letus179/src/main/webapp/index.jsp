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
<title>让我们一起走吧-随时随地随心情</title>
<%@include file="pages/common/public-statics.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/resources/js/register.js"></script>
<style type="text/css">
	#nav1 {
		display: block;
	}
	#nav2{
		display: none;
	}
</style>
<script type="text/javascript">
function search() {
	//检索  ajax	
	//href="${pageContext.request.contextPath}/search/search.do"
}
</script>
</head>
<body>
	<jsp:include page="/pages/common/nav.jsp" />
	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Letus179</h1>
			<p>"让我们一起走吧"专为我们得生活......</p>
			<p><a class="btn btn-primary glyphicon glyphicon glyphicon-hand-down" role="button" data-toggle="collapse" href="#readme" 
					aria-expanded="false" aria-controls="collapseExample">详细</a>
			</p>
			<div class="collapse" id="readme">
  		  <div class="well">
		    	小说：是四大文学样式(散文、小说、诗歌、戏剧)之一，以塑造人物形象为中心，通过
		    	完整故事情节的叙述和具体的环境描写反映社会生活的一种文学体裁，它是拥有完整布局、
		    	发展及主题的文学作品。 小说三要素是：人物、情节、环境。
					小说是文学的一种样式，一般描写人物故事，塑造多种多样的人物形象，但亦有例外。
					它是拥有完整布局、发展及主题的文学作品。而对话是不是具有鲜明的个性，每个人物说
					的话是不是有独特的语言风格，是衡量小说水平的一个重要标准。
		  	</div>
			</div>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>价值性</h2>
				<p>小说的价值本质是以时间为序列、以某一人物或几个人物为主线的，非常详细地、<br>
				全面地反映社会生活中各种角色的价值关系(政治关系、经济关系和文化关系)的产生、<br></p>
				<p>
					<a class="btn btn-default" href="#" role="button">详情
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>容量性</h2>
				<p>与其他文学样式相比，小说的容量较大，它可以细致地展现人物性格和人物命运，
				可以表现错综复杂的矛盾冲突，同时还可以描述人物所处的社会生活环境。小说的优势
				是可以提供整体的、广阔的社会生活。</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详情
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>情节性</h2>
				<p>小说主要是通过故事情节来展现人物性格、表现中心的。故事来源于生活，
				但它通过整理、提炼和安排，就比现实生活中发生的真实实例更加集中，
				更加完整，更具有代表性.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详情
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>情节性</h2>
				<p>小说主要是通过故事情节来展现人物性格、表现中心的。故事来源于生活，
				但它通过整理、提炼和安排，就比现实生活中发生的真实实例更加集中，
				更加完整，更具有代表性.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详情
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>情节性</h2>
				<p>小说主要是通过故事情节来展现人物性格、表现中心的。故事来源于生活，
				但它通过整理、提炼和安排，就比现实生活中发生的真实实例更加集中，
				更加完整，更具有代表性.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详情
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>情节性</h2>
				<p>小说主要是通过故事情节来展现人物性格、表现中心的。故事来源于生活，
				但它通过整理、提炼和安排，就比现实生活中发生的真实实例更加集中，
				更加完整，更具有代表性.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详情
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
	<script type="text/javascript">
		var name = $(".welcomeName").text().trim();
		if (name != "") {
			document.getElementById("welcomeInfo").style.display = "block";
			document.getElementById("loginInfo").style.display = "none";
			document.getElementById("info").style.display = "none";
			document.getElementById("registerInfo").style.display = "none";
			document.getElementById("logoutInfo").style.display = "block";
		}
</script>
</html>
