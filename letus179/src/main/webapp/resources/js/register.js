$(function() {
		//注册：出生日期，年月日
		$.ms_DatePicker({
			YearSelector : ".sel_year",
			MonthSelector : ".sel_month",
			DaySelector : ".sel_day"
		});
		//注册：所在地，省市区
		setup();
		//注册：真实姓名，离焦事件
		$("#realname").blur(function(){
			//清空内容，移除图标
			$("#realname_Info").empty();
			$("#realname_Info").removeAttr("class","glyphicon glyphicon-ok");
			$("#realname_Info").removeAttr("class","glyphicon glyphicon-remove");
			var realname = $("#realname").val().trim(); 
			if (realname != "") {
				if (realname.length > 10) {
					$("#realname_Info").attr("class","glyphicon glyphicon-remove");
					$("#realname_Info").html("&nbsp;您的姓名也太长了!");
				} else {
					$("#realname_Info").html("欢迎您,"+realname +"!");
				}
			$("#realname_Info").css("color","red");
			document.getElementById("realname_Info").style.display="block";
			}
		});
		
		//注册：用户名
		 $("#username").blur(function() {
			//清空内容，移除图标
			 $("#username_info").empty();
			 $("#username_info").removeAttr("class","glyphicon glyphicon-ok");
			 $("#username_info").removeAttr("class","glyphicon glyphicon-remove");
			 var username = $("#username").val().trim();
			if (username.length > 10) {
				 $("#username_info").attr("class","glyphicon glyphicon-remove");
					$("#username_info").html("&nbsp;用户名不能超过10个字符");
					$("#username_info").css("color","red");
					return;
			 } 
			if (username.length == 0) {
				return;
			}
			$.ajax({
				type : "get",
				url : getRootPath()+"/register/queryUsernamIsExists.do",
				data : {username : $("#username").val()},
				dateType : "json",
				success : function(data) {
					// data 为true 表明存在
					if (data.data) {
						$("#username_info").attr("class","glyphicon glyphicon-ok");
						$("#username_info").css("color","#00CD00");
					} else {
						$("#username_info").attr("class","glyphicon glyphicon-remove");
						$("#username_info").html("该用户名已经被占用");
						$("#username_info").css("color","red");
					}
						document.getElementById("username_info").style.display="block";
				}
			});
	});
		
		//注册：密码校验
		$("#pwd1").blur(function(){
			//清空内容，移除图标
			$("#pwd1_info").empty();
			$("#pwd1_info").removeAttr("class","glyphicon glyphicon-ok");
			$("#pwd1_info").removeAttr("class","glyphicon glyphicon-remove");
			var pwdFirst = $("#pwd").val().trim();
			var pwdSecond = $("#pwd1").val().trim();
			if (pwdFirst == ""){
				$("#pwd1_info").attr("class","glyphicon glyphicon-remove");
				$("#pwd1_info").html("&nbsp;请先填写密码，再进行确认！");
				$("#pwd1_info").css({"color":"red"});
				return;
			} 
			if (pwdFirst != pwdSecond) {
				$("#pwd1_info").attr("class","glyphicon glyphicon-remove");
				$("#pwd1_info").html("&nbsp;密码不一致！");
				$("#pwd1_info").css({"color":"red"});
				return;
			}
			$("#pwd1_info").attr("class","glyphicon glyphicon-ok");
			$("#pwd1_info").css("color","#00CD00");
		});
		
		$(".sel_year,.sel_month,.sel_day,.province").blur(function(){
				$("#birthday_info").empty();
				$("#birthday_info").removeAttr("class","glyphicon glyphicon-remove");
				$("#from_info").empty();
				$("#from_info").removeAttr("class","glyphicon glyphicon-remove");
		});
	});
	
	//***********************************************//
	function valpwd() {
		//清空内容，移除图标
		$("#pwd_info").empty();
		$("#pwd_info").removeAttr("class","glyphicon glyphicon-ok");
		$("#pwd_info").removeAttr("class","glyphicon glyphicon-remove");
		var pwd = document.getElementById("pwd").value;
		var reg = /^[A-Za-z0-9]+$/;
		if (!reg.test(pwd) || pwd.length<6 || pwd.length>12) {
			$("#pwd_info").attr("class","glyphicon glyphicon-remove");
			$("#pwd_info").html("&nbsp;密码必须为6-12位的数字和字母的组合");
			$("#pwd_info").css({"color":"red"});
		} else {
			$("#pwd_info").attr("class","glyphicon glyphicon-ok");
			$("#pwd_info").css("color","#00CD00");
		}
	}
	
	//注册：重置
	function formReset() {
		document.getElementById("regester").reset();
			$("#realname_Info").empty();
			$("#realname_Info").removeAttr("class","glyphicon glyphicon-ok");
			$("#realname_Info").removeAttr("class","glyphicon glyphicon-remove");
			$("#username_info").empty();
			$("#username_info").removeAttr("class","glyphicon glyphicon-ok");
			$("#username_info").removeAttr("class","glyphicon glyphicon-remove");
			$("#pwd_info").empty();
			$("#pwd_info").removeAttr("class","glyphicon glyphicon-ok");
			$("#pwd_info").removeAttr("class","glyphicon glyphicon-remove");
			$("#pwd1_info").empty();
			$("#pwd1_info").removeAttr("class","glyphicon glyphicon-ok");
			$("#pwd1_info").removeAttr("class","glyphicon glyphicon-remove");
			$("#birthday_info").empty();
			$("#birthday_info").removeAttr("class","glyphicon glyphicon-remove");
			$("#from_info").empty();
			$("#from_info").removeAttr("class","glyphicon glyphicon-remove");
	}

	function register() {
		$("#from_info").empty();
		$("#birthday_info").empty();
		$("#birthday_info").removeAttr("class","glyphicon glyphicon-remove");
		$("#from_info").removeAttr("class","glyphicon glyphicon-remove");
		var realname = $("#realname").val().trim(); 
		var username = $("#username").val().trim();
		var pwdFirst = $("#pwd").val().trim();
		var pwdSecond = $("#pwd1").val().trim();
		var sel_year = $(".sel_year").val();
		var sel_month = $(".sel_month").val();
		var sel_day = $(".sel_day").val();
		var province = $(".province").val();
		if (realname == "") {
			alert("您的真实姓名未填写");
			return false;
		}
		if (username == "") {
			alert("您的用户名未填写");
			return false;
		}
		if (pwdFirst == "") {
			alert("您的密码未填写");
			return false;
		}
		if (pwdSecond == "") {
			alert("您未进行密码确认");
			return false;
		}
		if (sel_year == 0) {
			alert("您出生日期中'年份'未选择");
			$("#birthday_info").attr("class","glyphicon glyphicon-remove");
			$("#birthday_info").html("&nbsp;您出生日期中'年份'未选择");
			$("#birthday_info").css({"color":"red"});
			return false;
		}
		if (sel_month == 0 ) {
			alert("您出生日期中'月份'未选择");
			$("#birthday_info").attr("class","glyphicon glyphicon-remove");
			$("#birthday_info").html("&nbsp;您出生日期中'月份'未选择");
			$("#birthday_info").css({"color":"red"});
			return false;
		}
		if (sel_day == 0) {
			alert("您出生日期中'日'未选择");
			$("#birthday_info").attr("class","glyphicon glyphicon-remove");
			$("#birthday_info").html("&nbsp;您出生日期中'日'未选择");
			$("#birthday_info").css({"color":"red"});
			return false;
		}
		if (province == "省份") {
			alert("您所在地中'省份'未选择");
			$("#from_info").attr("class","glyphicon glyphicon-remove");
			$("#from_info").html("&nbsp;您所在地中'省份'未选择");
			$("#from_info").css({"color":"red"});
			return false;
		}
	};
	
	//登录
	function user_login() {
		var username = $("input[name=username]").val().trim();
		var pwd = $("input[name=password]").val().trim();
		if (username == "" || pwd == "") {
			$("#login_info").css({"color":"red","font-size":"7px"});
			$("#login_info").attr("class","glyphicon glyphicon-remove");
			$("#login_info").html("&nbsp;用户名或密码不能为空");
			return false;
		}
	}
	
	//清理掉错误信息
	function resetLoginInfo() {
		$("#login_info").empty();
		$("#login_info").removeAttr("class","glyphicon glyphicon-remove");
	}
	
	
	