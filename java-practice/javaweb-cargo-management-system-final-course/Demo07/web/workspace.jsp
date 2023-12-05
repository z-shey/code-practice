<%@ page import="com.shey.entity.User" %>
<%@ page import="com.shey.entity.Role" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://kit.fontawesome.com/3b6cde5636.js"></script>
    <script src="assets/js/style.js"></script>
</head>
<body>

<%
    HttpSession loginUserSession = request.getSession();
    User loginUser = (User) loginUserSession.getAttribute("loginUser");
    Role loginRole = (Role) loginUserSession.getAttribute("loginRole");
    int role_id = -1;
    if (loginUser == null) {
        response.sendRedirect("login.jsp");
    } else {
        role_id = loginUser.getRole_id();
    }
    assert loginUser != null;%>

<div class="wrapper">
    <div class="sidebar">
        <div class="bg_shadow">
        </div>
        <div class="sidebar_inner">
            <div class="close">
                <i class="fa-solid fa-xmark"></i>
            </div>
            <div class="profile_info">
                <div class="profile_img">
                    <img src="http://q.qlogo.cn/headimg_dl?dst_uin=3317229064&spec=640&img_type=jpg" alt="">
                </div>
                <div class="profile_data">
                    <p class="name"><%=loginUser.getName()%>
                    </p>
                    <span class="span-info">
                        <%=loginUser.getUsername()%>
                    </span>
                    <span class="span-info">
                        <i class="fa-solid fa-user"></i>
                        <%=loginRole.getRole_name()%>
                    </span>
                </div>
            </div>

            <ul class="sidebar_menu">

                <li class="active">
                    <a id="workArea" class="nav-link">
                        <div class="icon">
                            <i class="fa-solid fa-table-columns"></i>
                        </div>
                        <div class="title">
                            工作区
                        </div>
                    </a>
                </li>


                <% if (role_id == 1) {%>
                <li>
                    <a href="#" class="nav-link" data-servlet="user">
                        <div class="icon">
                            <i class="fa-solid fa-users"></i>
                        </div>
                        <div class="title">
                            用户管理
                        </div>
                    </a>
                </li>
                <%}%>

                <% if (role_id == 1 || role_id == 2 || role_id == 3 || role_id == 4) {%>
                <li>
                    <a>
                        <div class="icon">
                            <i class="fa-solid fa-box-open"></i>
                        </div>
                        <div class="title">
                            货物管理
                        </div>
                    </a>
                </li>
                <%}%>

                <% if (role_id == 1 || role_id == 2) {%>
                <li>
                    <a>
                        <div class="icon">
                            <i class="fa-solid fa-house-flag"></i>
                        </div>
                        <div class="title">
                            仓库管理
                        </div>
                    </a>
                </li>
                <%}%>

                <% if (role_id == 1 || role_id == 2 || role_id == 3) {%>
                <li>
                    <a>
                        <div class="icon">
                            <i class="fa-solid fa-chart-pie"></i>
                        </div>
                        <div class="title">
                            报表统计
                        </div>
                    </a>
                </li>
                <%}%>
            </ul>

            <div class="logout_btn">
                <a href="LogoutServlet">登出</a>
            </div>

        </div>
    </div>

    <div class="main_container">
        <div class="navbar">
            <div class="hamburger">
                <i class="fa-solid fa-bars"></i>
            </div>
            <div class="logo">
                <a href="#">货物管理系统</a>
                <small class="version">Beta ver 1.0.0</small>
            </div>

        </div>


        <div class="content">


            sfgsfgsfgdsfr
<%--            <%@ include file="userManagement.jsp" %>--%>

        </div>


    </div>
</div>

</body>
</html>
