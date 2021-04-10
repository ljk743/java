<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.*" import="cn.edu.ujn.model.User"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>DIM_RESULT</title>
	<link rel="stylesheet" type="text/css" href="CSS/table.css">
</head>
<body>
	<% 
		ArrayList<User> users=(ArrayList<User>)session.getAttribute("result");  
	  	if(users!=null&&users.size()>0){
	%>
	<form action="UserServlet?action=Dim" method="post">
		通过名字关键字模糊查询:<input  type="text" name="dimName">
		<input type="submit" class="button" value="查询">
	</form>
	<table align="center" class="Tab">
	 	<tr align="center">
	 		<th>ID</th>
	 		<th>用户名</th>
	 		<th>性别</th>

	 	</tr>
	<% 
			for(int i=0; i<users.size();i++){
				User us=new User();
				us=users.get(i);
	%>
		
		<tr align="center">
			<td><%=us.getId()%></td>
	 		<td><a href="UserServlet?action=Info&select_user=<%=us.getUsername()%>"><%=us.getUsername()%></a></td>
	 		<td><%=us.getSex()%></td>
	 		<td>
	 			<form action="UserServlet?action=AlterPage&select_user=<%=us.getUsername()%>" method="post" id="form" >
					<p><input type="submit" class="button" value="修改"></p>
				</form>
			</td>
			<td>
	 			<form action="UserServlet?action=Delete&select_user=<%=us.getUsername()%>" method="post" id="form" onSubmit="javascript:return window.confirm('确认提交吗？')">
					<p><input type="submit" class="button" value="删除"></p>
				</form>
			</td>
	 		
	 	</tr>
	<%
			} 
	%>
	</table>
	<%
		} 
	%>
</body>
</html>