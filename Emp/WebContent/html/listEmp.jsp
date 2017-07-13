<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.tedu.entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工信息</title>
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
		height: 500px;
		width:960px;
		margin: 0 auto;
		margin-top:10px;
		padding: 0 20px 0 20px;
	}
	.table_header td{
		padding: 5px 10px;
		color:rgb(70,122,167);
		border: 1px solid #CBD6DE;
		border-bottom: 1px solid #ADBECB;
		font-size:1.1em;
		font-weight:bold;
		background-color:#d4e3ef;
		text-align:center;
	}
	.row1 td,.row2 td,.er{
		border: 1px solid #CBD6DE;
		text-align:center;
	}
	.table{
		margin-bottom: 15px;
		width: 100%;
		border-collapse: collapse;
	}
	.row1 td{
		background-color:#ffffff;
	}
	.row2 td{
		background-color:#eeeeee;
	}
	h2{
		width:1000px;
		background-color: #cfe7e6;
		height:80px;
		margin: 0 0 2px -20px;
		font-size:20px;
	}
	.er{
		text-align:center;
		color: #df263f;
		
	}
	body{
		margin: 0 auto;
		padding: 15px 0;
		background-color: #eeeeee;
	}
</style>
</head>
<body>
	<div id="top">
		导航区域
	</div>
	<div id="content">
		<h2>欢迎</h2>
		<table class="table">
			<tr class="table_header">
				<td>ID</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>工资</td>
				<td>操作</td>
			</tr>
			<%
				List<Emp> emps = (List<Emp>)request.getAttribute("emps");
				if(null == emps){
			%>
				<tr class="er">
					<td colspan="5">没有数据</td>
				</tr>
			<%
				}else{
					for(int i=0;i<emps.size();i++){
						Emp emp = emps.get(i);
			%>
				<tr class="row<%=i%2+1 %>">
					<td><%=emp.getId()%></td>
					<td><%=emp.getName()%></td>
					<td><%=emp.getAge()%></td>
					<td><%=emp.getSalary()%></td>
					<td>
						<a href="del.do?id=<%=emp.getId()%>" onclick="return confirm('确定删除<%=emp.getName()%>吗?');">删除</a>
						&nbsp;<a href="load.do?id=<%=emp.getId()%>">修改</a>
					</td>
				</tr>
			<% 
					}
				}
			%>
		</table>
		<p>
			<input type="button" value="增加员工" class="but" onclick="location='html/addEmp.jsp'"/>
		</p>
	</div>
</body>
</html>