<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<ul class="nav shadow">
    <li class="nav-item">
        <a class="nav-link disabled" href="/" style="color: #1d1e1f;">货物管理系统</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="../pages/user-list.jsp">用户管理</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">货物管理</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">仓库管理</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">报表管理</a>
    </li>

    <li class="nav-item dropdown ml-md-auto">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown"><%= session.getAttribute("username") %></a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">

            <a class="dropdown-item" href="#">身份</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/">登出</a>
        </div>
    </li>
</ul>
