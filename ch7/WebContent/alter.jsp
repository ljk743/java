<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.*" import="cn.edu.ujn.model.User"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ALTER_PAGE</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    <style>
        html {
            background: url(images/alter.jpg) no-repeat 0px 0px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            -moz-background-size: 100% 100%;
        }
    </style>
</head>
 
<body>
	<% 
		User us = (User)session.getAttribute("alter"); 
	%>
    <div id="loginDiv">
        <form action="UserServlet?action=Alter" method="post" id="form">
            <h1 style="text-align: center;color: aliceblue;">Alter</h1>
            <p>ID：<input  type="text" name="id" value="<%=us.getId()%>" readonly="readonly"></p>
            <p>用户名：<input  type="text" name="username" value="<%=us.getUsername()%>"></p>
            <p>密码：<input type="password" name="password" value="<%=us.getPassword()%>"></p>
 			<p>性别：<input type="text" name="sex" value="<%=us.getSex()%>"></p>
            <div style="text-align: center;margin-top: 30px;">
                <input type="submit" class="button" value="Alter">
                <input type="reset" class="button" value="Reset">
            </div>
        </form>
    </div>
</body>
</html>


