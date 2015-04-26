<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="c" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
				<div class="name">
					<label>用户名</label><input type="text" class="text" id="userName" placeholder="用户名" name="userName" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码</label><input type="password" class="text" id="password" placeholder="密码" name="password" tabindex="2">
					<input type="button" class="submit" tabindex="3" value="登录" onclick="return checkLogin();">
					<div id="tip" style="height: 25px;text-align:center;"></div>
				</div>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script.js"></script>

<!--[if IE 6]>
<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->

</body>
<script type="text/javascript">
	//回车事件
	$(function(){
	
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	checkLogin();//验证登录
		     }
		}
	});
	
	//用户名 及 密码 框获得焦点时，将提示消息去掉
	$("#userName").focus(function(){
		$("#tip").html("");
	});
	
	$("#password").focus(function(){
		$("#tip").html("");
	});
	
	//验证登录
	function checkLogin() {
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		if (userName == "" || password == "") {
			$("#tip").html("用户名或者密码不能为空!");
			return false;
		}
		$.ajax({
			type: "post",
			url : "<c:url value='/login'/>",
			data: {
				userName: userName,
				password: password
			},
			cache: false,
			dataType: "json",
			success: function(data){
				var message = data.message;
				var userID  = data.userName;
				if(message == "OK"){
					$("#tip").html("登录成功！欢迎您：" + userID);
					//window.location.href = "<c:url value='/success.jsp'/>";
				}else{
					$("#tip").html("登陆失败！用户名或者密码错误！");
					//window.location.href = "<c:url value='/failure.jsp'/>";
				}
			},
			error: function(){
				alert("程序出现异常，请联系管理员。");
			}
		});
		return true;
	}
</script>
</html>