<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<meta name="description" content="Multi-Level Push Menu: Off-screen navigation with multiple levels" />
		<meta name="keywords" content="multi-level, menu, navigation, off-canvas, off-screen, mobile, levels, nested, transform" />
		<meta name="author" content="Codrops" />
		<%@include file="/pages/common/public-statics.jsp"%>
		<script src="${pageContext.request.contextPath }/resources/js/classie.js"></script>
		<script src="${pageContext.request.contextPath }/resources/js/modernizr.custom.js"></script>
		<script src="${pageContext.request.contextPath }/resources/js/mlpushmenu.js"></script>
		<link href="${pageContext.request.contextPath }/resources/css/menu.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath }/resources/css/icons.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath }/resources/css/component.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath }/resources/css/normalize.css" rel="stylesheet"/> 
		<title>${user.realname }的个人空间</title>
		<style type="text/css">
			#nav1{
				display: none;
			}
			.container {
				height:110%;
				width:100%;
			}
			.footers {
				z-index: 1000
			}
		</style>
		</head>
		<body>
		
			<div class="container">
					<!-- Push Wrapper -->
					<div class="mp-pusher" id="mp-pusher">
						<!-- mp-menu -->
						<nav id="mp-menu" class="mp-menu">
							<div class="mp-level">
								<h2 class="icon icon-world">All Categories</h2>
								<ul>
									<li class="icon icon-arrow-left">
										<a class="icon icon-display" href="#">Devices</a>
										<div class="mp-level">
											<h2 class="icon icon-display">Devices</h2>
											<a class="mp-back" href="#">back</a>
											<ul>
												<li class="icon icon-arrow-left">
													<a class="icon icon-phone" href="#">Mobile Phones</a>
													<div class="mp-level">
														<h2>Mobile Phones</h2>
														<a class="mp-back" href="#">back</a>
														<ul>
															<li><a href="#">Super Smart Phone</a></li>
															<li><a href="#">Thin Magic Mobile</a></li>
															<li><a href="#">Performance Crusher</a></li>
															<li><a href="#">Futuristic Experience</a></li>
														</ul>
													</div>
												</li>
												<li class="icon icon-arrow-left">
													<a class="icon icon-tv" href="#">Televisions</a>
													<div class="mp-level">
														<h2>Televisions</h2>
														<a class="mp-back" href="#">back</a>
														<ul>
															<li><a href="#">Flat Superscreen</a></li>
															<li><a href="#">Gigantic LED</a></li>
															<li><a href="#">Power Eater</a></li>
															<li><a href="#">3D Experience</a></li>
															<li><a href="#">Classic Comfort</a></li>
														</ul>
													</div>
												</li>
												<li class="icon icon-arrow-left">
													<a class="icon icon-camera" href="#">Cameras</a>
													<div class="mp-level">
														<h2>Cameras</h2>
														<a class="mp-back" href="#">back</a>
														<ul>
															<li><a href="#">Smart Shot</a></li>
															<li><a href="#">Power Shooter</a></li>
															<li><a href="#">Easy Photo Maker</a></li>
															<li><a href="#">Super Pixel</a></li>
														</ul>
													</div>
												</li>
											</ul>
										</div>
									</li>
									<li class="icon icon-arrow-left">
										<a class="icon icon-news" href="#">Magazines</a>
										<div class="mp-level">
											<h2 class="icon icon-news">Magazines</h2>
											<a class="mp-back" href="#">back</a>
											<ul>
												<li><a href="#">National Geographic</a></li>
												<li><a href="#">Scientific American</a></li>
												<li><a href="#">The Spectator</a></li>
												<li><a href="#">The Rambler</a></li>
												<li><a href="#">Physics World</a></li>
												<li><a href="#">The New Scientist</a></li>
											</ul>
										</div>
									</li>
									<li class="icon icon-arrow-left">
										<a class="icon icon-shop" href="#">Store</a>
										<div class="mp-level">
											<h2 class="icon icon-shop">Store</h2>
											<a class="mp-back" href="#">back</a>
											<ul>
												<li class="icon icon-arrow-left">
													<a class="icon icon-t-shirt" href="#">Clothes</a>
													<div class="mp-level">
														<h2 class="icon icon-t-shirt">Clothes</h2>
														<a class="mp-back" href="#">back</a>
														<ul>
															<li class="icon icon-arrow-left">
																<a class="icon icon-female" href="#">Women's Clothing</a>
																<div class="mp-level">
																	<h2 class="icon icon-female">Women's Clothing</h2>
																	<a class="mp-back" href="#">back</a>
																	<ul>
																		<li><a href="#">Tops</a></li>
																		<li><a href="#">Dresses</a></li>
																		<li><a href="#">Trousers</a></li>
																		<li><a href="#">Shoes</a></li>
																		<li><a href="#">Sale</a></li>
																	</ul>
																</div>
															</li>
															<li class="icon icon-arrow-left">
																<a class="icon icon-male" href="#">Men's Clothing</a>
																<div class="mp-level">
																	<h2 class="icon icon-male">Men's Clothing</h2>
																	<a class="mp-back" href="#">back</a>
																	<ul>
																		<li><a href="#">Shirts</a></li>
																		<li><a href="#">Trousers</a></li>
																		<li><a href="#">Shoes</a></li>
																		<li><a href="#">Sale</a></li>
																	</ul>
																</div>
															</li>
														</ul>
													</div>
												</li>
												<li>
													<a class="icon icon-diamond" href="#">Jewelry</a>
												</li>
												<li>
													<a class="icon icon-music" href="#">Music</a>
												</li>
												<li>
													<a class="icon icon-food" href="#">Grocery</a>
												</li>
											</ul>
										</div>
									</li>
									<li><a class="icon icon-photo" href="#">Collections</a></li>
									<li><a class="icon icon-wallet" href="#">Credits</a></li>
								</ul>
									
							</div>
						</nav>
						<!-- /mp-menu -->
		
						<div class="scroller"><!-- this is for emulating position fixed of the nav -->
							<div class="scroller-inner">
								<jsp:include page="/pages/common/nav.jsp" />								<header class="codrops-header">
									<h1>Multi-Level Push Menu <span>Off-screen navigation with multiple levels</span></h1>
								</header>
								<div class="content clearfix">
									<div class="block block-40 clearfix">
										<p><a href="#" id="trigger" class="menu-trigger">开/关</a></p>
									</div>
									<div class="block block-60">
										<p><strong>个性签名</strong> 不一样的我</p>
										<p>This menu will open by pushing the website content to the right. It has multi-level functionality, allowing endless nesting of navigation elements.</p>
										<p>The next level can optionally overlap or cover the previous one.</p>
									</div>
									<div class="info">
										<p>If you enjoyed this you might also like:</p>
										<p><a href="http://goo.gl/JLJ4v5">Responsive Multi-Level Menu</a></p>
										<p><a href="http://goo.gl/qjbq9Y">Google Nexus Website Menu</a></p>
									</div>
								</div>
							</div><!-- /scroller-inner -->
						</div><!-- /scroller -->
		
					</div><!-- /pusher -->
					<div class="footers">
						<jsp:include page="/pages/common/footer.jsp" />
					</div>
				</div><!-- /container -->
			<script>
				new mlPushMenu( document.getElementById( 'mp-menu' ), document.getElementById( 'trigger' ) );
			</script>
		</body>
</html>