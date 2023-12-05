<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://kit.fontawesome.com/3b6cde5636.js"></script>
    <script src="assets/js/style.js"></script>
</head>
<body>

<div class="login-container">
    <div class="login-content">
        <h1>登录</h1>
        <p style="<%= request.getAttribute("errorMessage") == null ? "" : "color: red;" %>">
            <%= request.getAttribute("errorMessage") == null ? "请登录继续操作，或者创建新账户" : request.getAttribute("errorMessage") %>
        </p>
        <form class="login-form" action="login" method="post">
            <input type="text" name="username" placeholder="用户名">
            <input type="password" name="password" placeholder="密码">
            <div class="button-group">
                <button type="submit">登录</button>
                <button type="button" onclick="location.href='register.jsp'">注册</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
