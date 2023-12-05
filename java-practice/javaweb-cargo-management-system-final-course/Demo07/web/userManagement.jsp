<%@ page import="com.shey.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shey.service.api.RoleService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


rdtnnt ytyuhdrtfyuhfdtyj dr terdby ty


<%
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");
    RoleService role = (RoleService) request.getAttribute("role");

    int count = 0;
    for (User user : allUsers) {
        count++;
    }
%>


<div class="operation">
    <div class="count">
        <div class="count-content">
            <div class="count-line">
                <label>用户数量</label>
                <span>(<%= count %>)</span>
            </div>
            <a type="button" class="btn add" href='userAdd.jsp'>新增用户</a>
        </div>
    </div>

    <div class="search">
        <input type="text" class="search-input" placeholder="搜索...">
        <button type="button" class="btn">搜索</button>
    </div>
</div>


<%--<% for (User user : allUsers) { %>--%>

<%--<div class="info-container item">--%>
<%--    <div class="info-content">--%>
<%--        <h2><%= user.getName() %></h2>--%>
<%--        <div class="info-row">--%>
<%--            <label>用户ID</label>--%>
<%--            <span><%= user.getId() %></span>--%>
<%--        </div>--%>
<%--        <div class="info-row">--%>
<%--            <label>用户名</label>--%>
<%--            <span><%= user.getUsername() %></span>--%>
<%--        </div>--%>
<%--        <div class="info-row">--%>
<%--            <label>用户权限</label>--%>
<%--            <span><%=role.getRoleById(user.getRole_id()).getRole_name()%></span>--%>
<%--        </div>--%>
<%--        <div class="info-row">--%>
<%--            <label>用户昵称</label>--%>
<%--            <span><%= user.getName() %></span>--%>
<%--        </div>--%>
<%--        <div class="info-row">--%>
<%--            <label>用户描述</label>--%>
<%--            <span>暂无</span>--%>
<%--        </div>--%>
<%--        <div class="button-group">--%>
<%--            <button type="button">查看详情</button>--%>
<%--            <button type="button">修改信息</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<% } %>--%>