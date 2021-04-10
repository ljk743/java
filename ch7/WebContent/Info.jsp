<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.*" import="cn.edu.ujn.model.User"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>INFO</title>
</head>
<body>
	<% ArrayList<User> users=(ArrayList<User>)session.getAttribute("list");  
	  if(users!=null&&users.size()>0){
	%>
	<table border="0" cellspacing="0" cellpadding="0">
	 	<tr>
	 		<th>ID</th>
	 		<th>用户名</th>
	 		<th>密码</th>
	 		<th>性别</th>
	 	</tr>
	<% for(int i=0; i<users.size();i++){
		User us=new User();
		us=users.get(i);
		if (us.getUsername().equals(session.getAttribute("select_user"))){%>
		<tr>
			<td><%=us.getId()%></td>
	 		<td><%=us.getUsername()%></td>
	 		<td><%=us.getPassword()%></td>
	 		<td><%=us.getSex()%></td>
	 	</tr>
	<%		}
		}
	%>
	</table>
	
	
	<%} %>
</body>
</html>