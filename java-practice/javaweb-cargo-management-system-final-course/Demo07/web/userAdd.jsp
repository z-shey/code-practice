<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户信息</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://kit.fontawesome.com/3b6cde5636.js"></script>
    <script src="assets/js/style.js"></script>
</head>
<body>

<div class="form-container">
    <div class="form-content">
        <h1>新增用户</h1>
        <p>请填写以下信息以创建新用户</p>
        <form class="input-form" action="user?flag=add" method="post">
            <input type="text" name="name" placeholder="姓名">
            <input type="text" name="username" placeholder="用户名">
            <input type="password" name="password" placeholder="密码">
            <input type="number" name="roleId" placeholder="权限" min="1" max="5">
            <button type="submit">新增</button>
        </form>
    </div>
</div>


</body>
</html>
