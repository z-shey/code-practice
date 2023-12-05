<%@ page import="com.shey.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/bootstrap-grid.css">
    <link rel="stylesheet" href="assets/css/bootstrap-reboot.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/scripts.js"></script>
    <script src="assets/js/style.js"></script>

</head>
<body class="body-bg">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" style="margin-top: 30px;">


            <div class="col-md-4">
            </div>
            <center>
                <div class="col-md-4">
                    <form role="form" action="UserServlet?flag=addUser" method="post">
                        <div class="form-group">
                            <label for="userId">用户ID</label>
                            <input type="text" name="userId" value="系统分配" readonly class="form-control" id="userId"
                                   placeholder="请输入用户名"/>
                        </div>
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" name="username" class="form-control" id="username"
                                   placeholder="请输入用户名"/>
                        </div>
                        <div class="form-group">
                            <label for="identity">身份</label>
                            <input type="number" name="identity" class="form-control" id="identity"
                                   placeholder="请输入身份类型"/>
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="password" name="password" class="form-control" id="password"
                                   placeholder="请输入密码"/>
                        </div>
                        <div class="form-group">
                            <label for="remarks">备注</label>
                            <input type="text" name="remarks" class="form-control" id="remarks"
                                   placeholder="请输入备注"/>
                        </div>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </form>


                </div>
            </center>
            <div class="col-md-4">
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
