<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<ul class="nav shadow">
    <li class="nav-item">
        <a class="nav-link disabled" href="UserServlet?flag=area" style="color: #1d1e1f;">货物管理系统</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="UserServlet?flag=userManger">用户管理</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="CargoServlet?flag=cargoManger">货物管理</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="WarehouseServlet?flag=marehouseManger">仓库管理</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="TableServlet?flag=tableManger">报表管理</a>
    </li>

    <li class="nav-item dropdown ml-md-auto">
        <%User loginUser = (User) request.getAttribute("loginUser");%>
        <a class="nav-link" href="UserServlet?flag=loginOut"><%=loginUser.getUsername()%> 登出</a>
    </li>
</ul>
