<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css">
	body{
			
			background-image: url(../image/1.jpg);
			background-repeat: no-repeat;
	}
	#zc{
		width:280px;
		height:320px;
		text-align:center;
		margin: 0 auto;
		margin-top:200px;
	}
	form{
		background-color:#BABABA;
		color:#ffffff;
	}
	.login{
		width: 280px;
		height: 40px;
		margin-bottom:20px;
		display: block;
		background-color: #C0A960;
		color: #FFFFE8;
		line-height:40px;
		text-align: center;
		font-size: 22px;
		letter-spacing: 8px;
	}
</style>
</head>
<body>
	<div id="zc">
	<form action="Emp/add.do">
			<span class="login">注册</span>
			用户名：&nbsp;<input type="text" placeholder="请输入账号" name="yh"><br><br>
			密码：&nbsp;&nbsp;<input type="password" placeholder="请输入密码" name="m"><br><br>
			确认密码：<input type="password" placeholder="请再次输入密码" name="qr"><br><br>
			身份证：&nbsp;<input type="text" placeholder="请输入身份证" name="sf"><br><br>
			电话：&nbsp;&nbsp;<input type="text" placeholder="请输入电话" name="phone" maxlength="11"><br><br>
			<input type="submit" value="提交" class="">
	</form>
	</div>
</body>
</html>