<%@ page language="java"
	import="java.util.*,java.sql.*,com.mysql.cj.jdbc.Driver"
	pageEncoding="UTF-8"%> 
<html>
	<head>
		<title>login</title>
	</head>
	<body>
		<%
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//String url = "jdbc:mysql://localhost:3306/javaee";
				String url = "jdbc:mysql://localhost:3306/javaee?useUnicode=true&characterEncoding=UTF-8";
				Connection con = DriverManager.getConnection(url, "root","ljk123456");
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery("select * from user where username='"	+ username + "' and password='" + pwd + "'");
				if (rs.next()) {
		%>
		登录成功！
		<%
			} else {
		%>
		登录失败！
		<%
			}
				rs.close();
				s.close();
				con.close();
			} catch (Exception ce) {
		%>
		数据库操作失败，请联系管理员。
		<%
			}
		%>
	</body>
</html>
