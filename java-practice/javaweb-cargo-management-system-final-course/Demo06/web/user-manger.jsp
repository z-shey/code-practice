<%@ page import="com.shey.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


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

    <div class="row" style="margin-left: 10%;margin-right: 10%;">
        <div class="col-md-12">
            <a class="btn btn-primary" href="user-add.jsp" style="margin-top: 20px;">新增</a>
            <a class="btn btn-primary" href="UserServlet?flag=area" style="margin-top: 20px;">主页</a>
            <table class="table shadow" style="margin-top: 20px; background-color: white; height: 100px; padding: 10px;">

                <thead>
                <tr>
                    <th>序号</th>
                    <th>工号</th>
                    <th>用户名</th>
                    <th>身份标识</th>
                    <th>备注</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <% int index = 1;
                    List<User> userList = (List<User>) request.getAttribute("userList");
                    if (userList != null) {
                        for (User user : userList) {
                %>
                <% if (index % 2 == 0) {%>
                <tr>
                    <td><%=index++%>
                    </td>
                    <td><%=user.getUser_id()%>
                    </td>
                    <td><%=user.getUsername()%>
                    </td>
                    <td><%=user.getIdentity()%>
                    </td>
                    <td><%=user.getRemarks()%>
                    </td>
                    <td><a class="btn btn-primary" href="UserServlet?flag=preUpdate&id=<%=user.getUser_id()%>">修改</a></td>
                    <td><a class="btn" href="UserServlet?flag=delete&id=<%=user.getUser_id()%>">删除</a></td>
                </tr>
                <% } else { %>
                <tr class="table-active">
                    <td><%=index++%>
                    </td>
                    <td><%=user.getUser_id()%>
                    </td>
                    <td><%=user.getUsername()%>
                    </td>
                    <td><%=user.getIdentity()%>
                    </td>
                    <td><%=user.getRemarks()%>
                    </td>
                    <td><a class="btn btn-primary" href="UserServlet?flag=preUpdate&id=<%=user.getUser_id()%>">修改</a></td>
                    <td><a class="btn" href="UserServlet?flag=delete&id=<%=user.getUser_id()%>">删除</a></td>
                </tr>
                <%
                            }
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%@ include file="footer.jsp" %>
</body>


</html>