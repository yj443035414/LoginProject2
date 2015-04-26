<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
	<form action="login" method="post">
		账户：<input type="text" id="userName" name="userName"><br>
		密码：<input type="password" id="password" name="password"><br>
		<input type="submit" value="登录" onclick="return check()"/>
	</form>
</body>
<script type="text/javascript">
	function check() {
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		if (userName == "" || password == "") {
			alert("用户名或者密码不能为空!");
			return false;
		}
		return true;
	}
</script>
</html>