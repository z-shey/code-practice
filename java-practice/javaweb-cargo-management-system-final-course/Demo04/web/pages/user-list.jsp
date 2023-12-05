<%@ page import="java.util.List" %>
<%@ page import="vo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Manager</title>
</head>
<body>
<h1>User List</h1>
<c:if test="${not empty errorMsg}">
    <p>${errorMsg}</p>
</c:if>
<table>
    <thead>
    <tr>
        <th>Username</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getUsername()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

