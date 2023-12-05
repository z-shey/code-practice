<%@ page import="vo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../static/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../static/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/bootstrap-grid.css">
    <link rel="stylesheet" href="../static/css/bootstrap-reboot.css">


</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

<!--
            <div class="row">
                <div class="col-md-2">

                    <div class="card">
                        <img class="card-img-top" alt="Bootstrap Thumbnail First" src="https://www.layoutit.com/img/people-q-c-600-200-1.jpg"/>
                        <div class="card-block">
                            <h5 class="card-title">
                                用户ID
                            </h5>
                            <p class="card-text">
                                用户名
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">修改</a>
                                <a class="btn" href="#">删除</a>
                            </p>
                        </div>
                    </div>

                </div>
            </div>

     -->

            <h2>All Users</h2>
            <ul>
                <%
                    UserDao userDao = new UserDao();
                    List<User> users = userDao.getAllUsers();
                    for (User user : users) {
                %>
                <li><%= user.getUsername() %></li>
                <%
                    }
                %>
            </ul>

            <!--
                        <div class="row">

                            <div class="col-md-4">
                            </div>

                            <div class="col-md-4">
                                <form role="form">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="用户名"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" placeholder="请输入密码"/>
                                    </div>

                                    <div class="radio">
                                        <label><input type="radio" name="role" value="highest_admin"/>最高管理员</label>
                                    </div>
                                    <div class="radio">
                                        <label><input type="radio" name="role" value="warehouse_admin"/>仓库管理员</label>
                                    </div>
                                    <div class="radio">
                                        <label><input type="radio" name="role" value="goods_admin"/>货物管理员</label>
                                    </div>
                                    <div class="radio">
                                        <label><input type="radio" name="role" value="normal_employee"/>普通员工</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary">添加</button>

                                </form>
                            </div>

                            <div class="col-md-4">
                            </div>
                        </div>
            -->
        </div>
    </div>
</div>


<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script src="../static/js/scripts.js"></script>
<script src="../static/js/style.js"></script>
</body>


</html>