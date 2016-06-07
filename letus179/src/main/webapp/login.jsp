<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYpE html pUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-Ua-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<%@include file="pages/common/public-statics.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/validateCode.js"></script>
<title>登录-让我们一起走吧</title>
<style type="text/css">
	#nav3{
		display: none;
	}
	.mycode{
     display: inline-block;
     width: 80px;
     height: 20px;
     vertical-align: middle;
     background-color: #C1FFC1;
     margin: 4px;
 }
  .validate input{
     display: inline-block;
     height: 25px;
     background: #EEE9E9;
     vertical-align: middle;
     border: none;
     border-radius: 10px;
     border-bottom: #DDDDDD solid 2px;
     box-shadow: 0 1px 1px #FFFFFF;
     -webkit-box-shadow: 0 1px 1px #FFFFFF;
     color: #E9967A;
     padding-left: 20px;
     font-size: 23px;
  }
  #inputCode {
  	width:95px
  }
</style>
<script type="text/javascript">
	$(function() {
		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseInt($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseInt($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	
		//验证码
		var inp = document.getElementById('inputCode');
    var code = document.getElementById('code');
    $("#codeErro").html("&nbsp;请输入验证码");
    var c = new KinerCode({
        len: 4,//需要产生的验证码长度
        chars: [
            1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        ],//经典模式:指定产生验证码的词典，若不给或数组长度为0则试用默认字典
        question:false,//若给定词典为算数题，则此项必须选择true,程序将自动计算出结果进行校验【若选择此项，则可不配置len属性】,若选择经典模式，必须选择false
        copy: false,//是否允许复制产生的验证码
        bgColor:"",//背景颜色[与背景图任选其一设置]
        bgImg:"bg.jpg",//若选择背景图片，则背景颜色失效
        randomBg : false,//若选true则采用随机背景颜色，此时设置的bgImg和bgColor将失效
        inputArea: inp,//输入验证码的input对象绑定【 HTMLInputElement 】
        codeArea: code,//验证码放置的区域【HTMLDivElement 】
        click2refresh:true,//是否点击验证码刷新验证码
        false2refresh:true,//在填错验证码后是否刷新验证码
        validateEven : "blur",//触发验证的方法名，如click，blur等
        validateFn : function(result,code){//验证回调函数
        		$("#vali").val(code.strCode);
				    //清空，移除
						$("#codeErro").empty();
						$("#codeErro").removeAttr("class","glyphicon glyphicon-ok");
						$("#codeErro").removeAttr("class","glyphicon glyphicon-remove");
            if(result){
                $("#codeErro").attr("class","glyphicon glyphicon-ok");
                $("#codeErro").css("color","#00CD00");
            }else{
            	var inputCode = $("#inputCode").val().trim();
            	if(inputCode != "") {
                $("#codeErro").attr("class","glyphicon glyphicon-remove");
                $("#codeErro").html("&nbsp;验证码错误");
                $("#codeErro").css("color","red");
								document.getElementById("inputCode").css("color","red");
            	}
            }
        }
    });
	});
</script>
</head>
<body>
	<jsp:include page="/pages/common/nav.jsp" />
	<div>
		<form action="${pageContext.request.contextPath }/loginCheck.do"
			method="post" onsubmit="return login_before();">
			<div class="top_div"></div>
			<div class="login_head">
				<div class="owl">
					<div class="tou"></div>
					<div class="initial_left_hand" id="left_hand"></div>
					<div class="initial_right_hand" id="right_hand"></div>
				</div>
				<p class="username">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
					<input class="ipt" type="text" placeholder="请输入用户名"
						name="username" id="username">
				</p>
				<p class="password">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					<input class="ipt" id="password" type="password"
						placeholder="请输入密码" name="password" id="password">
				</p>
				<p class="validate">
					<input type="text" id="inputCode" name="validate">
					<span id="code" class="mycode"></span>
					<span id="codeErro" class="codeErro"></span>
				</p>
				<div class="login_bottom">
					<p class="p">
						<span style="float: left;"><input type="checkbox" name="rememberMe">记住我？</span> 
						<span style="float: left;"><a style="color: #4F94CD;margin-left: 43px" href="#" title="点这里，帮你找回密码！">忘记密码?</a></span> 
						<span style="float: right;"><a style="color: #4F94CD; margin-right: 10px;" title="还没注册过？点这里！" href="${pageContext.request.contextPath }/pages/register.jsp">注册</a>
						<input class="login_login" type="submit" value="登录"> </span>
					</p>
				</div>
			</div>
			<input type="hidden" id="vali">
		</form>
	</div>
		<%@ include file="pages/common/footer.jsp"%>
</body>
<script type="text/javascript">
	//对错误的登录信息进行返回
	var error = "${Msg}".trim();
	if (error != "") {
		alert(error);
	};
	
	//提交登录前判断用户名或密码是否为空
	function login_before() {
		var username = document.getElementById("username").value.trim();
		if (username == "") {
			alert("用户名未填写！");
			return false;
		}
		var password = document.getElementById("password").value.trim();
		if (password == "") {
			alert("密码未填写！");
			return false;
		}
		var inputCode = $("#inputCode").val().toLowerCase().trim();
		var code = $("#vali").val().toLowerCase().trim();
		if (inputCode == "" || inputCode != code) {
			alert("请输入正确的验证码");
			return false;
		}
	}
</script>
</html>
