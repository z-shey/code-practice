<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>货物管理系统 Beta 1.0.0</title>

    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/bootstrap-grid.css">
    <link rel="stylesheet" href="../assets/css/bootstrap-reboot.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <script src="../assets/js/bootstrap.min.js"></script>
    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/js/popper.min.js"></script>
    <script src="../assets/js/scripts.js"></script>
    <script src="../assets/js/style.js"></script>

</head>
<body class="body-bg">

<h2 style="margin-top: 50px; text-align: center; color: white;">货物管理系统</h2>

<center>
    <div style="background-color: white; border-radius: 10px; padding: 20px; text-align:center; width: 250px; margin-top: 10%;">
        <h4>登录</h4>
        <p style="color: red;margin-top: 10px;margin-bottom: 10px;"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
        </p>
        <form role="form" action="UserServlet?flag=login" method="post">
            <div class="form-group" style="margin-top: 10px;">
                <input type="text" class="form-control" id="userName" name="username" placeholder="请输入用户名">
            </div>
            <div class="form-group" style="margin-top: 20px;">
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>

            <center style="margin-top: 20px;">
                <button type="submit" class="btn btn-primary">登录</button>
                <button type="button" class="btn btn-link">忘记密码</button>
            </center>
        </form>
    </div>
</center>

<%@ include file="footer.jsp" %>

</body>
</html>
