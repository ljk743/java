<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.*" import="cn.edu.ujn.model.User"%>
<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <title>SING UP</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    <style>
        html {
            background: url(images/reg.jpg) no-repeat 0px 0px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            -moz-background-size: 100% 100%;
        }
    </style>
</head>
<body>

    <div id="loginDiv">
        <form action="UserServlet?action=register" method="post" id="form">
            <h1 style="text-align: center;color: aliceblue;">SING UP</h1>
            <p>用户名：<input type="text" name="username"><label id="name_trip"></label></p>
            <p>密码：<input type="password" name="password"><label id="password_trip"></label></p>
 			<p>确认密码:<input  type="password" name="surePassword"><label id="surePassword_trip"></label></p>
            <div style="text-align: center;margin-top: 30px;">
                <input type="submit" class="button" value="SING UP">
                <input type="reset" class="button" value="Reset">
            </div>
        </form>
    </div>

</body>
</html>


