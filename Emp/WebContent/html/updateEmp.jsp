<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.tedu.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改员工</title>
<style type="text/css">
	#top{
		border: 1px solid #CBD6DE;
		background-color:#85C329;
		width:980px;
		height:30px;
		line-height:30px;
		margin: 0 auto;
		color:#ffffff;
		font-size:16px;
		font-weight:bold;
		letter-spacing:5px;
		padding-left:20px;
	}
	#content{
		border: 1px solid #CBD6DE;
		height: 300px;
		width:960px;
		margin: 0 auto;
		margin-top:10px;
		padding: 0 20px 0 20px;
	}
	h2{
		width:1000px;
		background-color: #cfe7e6;
		height:80px;
		margin: 0 0 2px -20px;
		font-size:20px;
	}
	body{
		margin: 0 auto;
		padding: 15px 0;
		background-color: #eeeeee;
	}
</style>
</head>
<body>
	<div id="top">导航区域</div>
	<div id="content">
		<h2>修改员工</h2>
		<%
			Emp emp = (Emp)request.getAttribute("emp");
		%>
		<form action="Emp/modify.do">
			<table cellpadding="2" cellspacing="0" border="0" class="form_table">
				<tr>
					<td valign="middle" align="right">ID:</td>
					<td valign="middle" align="left"><%=emp.getId() %></td>
				</tr>
				<tr>
					<td valign="middle" align="right">姓名</td>
					<td valign="middle" align="left">
						<input type="text" class="inputgri" name="name" value="<%=emp.getName()%>">
					</td>
				</tr>
				<tr>
					<td valign="middle" align="right">薪水</td>
					<td valign="middle" align="left">
						<input type="text" class="inputgri" name="salary" value="<%=emp.getSalary()%>">
					</td>
				</tr>
				<tr>
					<td valign="middle" align="right">年龄</td>
					<td valign="middle" align="left">
						<input type="text" class="inputgri" name="age" value="<%=emp.getAge()%>">
					</td>
				</tr>		
			</table>
			<input type="hidden" name="id" value="<%=emp.getId() %>">
			<p>
				<input type="submit" class="button" value="确定" >
			</p>
		</form>
	</div>
</body>
</html>