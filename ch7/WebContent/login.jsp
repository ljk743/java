<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SING IN</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    <style>
    	html {
        	    background: url(images/Desert.jpg) no-repeat 0px 0px;
            	background-repeat: no-repeat;
            	background-size: 100% 100%;
            	-moz-background-size: 100% 100%;
    	}
    </style>
</head>
<body>
    <div id="loginDiv">
        <form action="UserServlet?action=login" method="post" id="form">
            <h1 style="text-align: center;color: aliceblue;">SING IN</h1>
            <p>User Name:<input id="userNname" type="text" name="username"></p>
 
            <p>Password:  <input id="password" type="password" name="password"></p>
 
            <div style="text-align: center;margin-top: 30px;">
                <input type="submit" class="button" value="login">
                <input type="reset" class="button" value="Reset">
            </div>
            <p align="center">还未注册？请<a href="register.jsp">点击</a>进行注册</p>
        </form>
    </div>
 
</body>
</html>


