<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.*" import="cn.edu.ujn.model.User"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>USER</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
    <style>
        html {
            background: url(images/login_s.jpg) no-repeat 0px 0px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            -moz-background-size: 100% 100%;
        }
        .button {
            border-color: cornsilk;
            background-color: rgba(0, 221, 119, .6);
            border-style: hidden;
            border-radius: 5px;
            width: 300px;
            height: 40px;
            font-size: 19px;
        }
    </style>
</head>
<body>
<%User us=(User)session.getAttribute("user"); %>
		<div id="forrm_style">
			<h1 style="text-align: center;color: aliceblue;"><%=us.getUsername()%>欢迎你</h1>
			<form action="UserServlet?action=findUser" method="post" id="form">
					<p><input type="submit" class="button" value="点击此进入管理系统"></p><br>
			</form>
			<form action="UserServlet?action=Exit" method="post" id="form">
					<p><input type="submit" class="button" value="退出登录"></p>
			</form>
		</div>
	
</body>
</html>