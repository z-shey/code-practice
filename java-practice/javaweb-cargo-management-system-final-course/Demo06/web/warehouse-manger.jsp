<%@ page import="com.shey.entity.Cargo" %>
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
    <div class="row">
        <div class="col-md-12" style="padding-left: 30px;padding-right: 30px;">

            <a class="btn btn-primary" href="user-add.jsp" style="margin-top: 20px;margin-bottom: 20px;">新增</a>
            <a class="btn btn-primary" href="UserServlet?flag=area" style="margin-top: 20px;margin-bottom: 20px;">主页</a>
            <div class="row">

                <% int index = 1;
                    List<Cargo> cargoList = (List<Cargo>) request.getAttribute("cargoList");
                    if (cargoList != null) {
                        for (Cargo cargo : cargoList) {
                %>

                <div class="col-md-4" style="margin-bottom: 30px;">
                    <div class="card">
                        <div class="card-block">
                            <h5 class="card-title">
                                <%=cargo.getCargo_name()%>
                                <span class="badge badge-primary"><%=cargo.getCargo_id()%></span>
                                <span class="badge badge-primary"><%=cargo.getCargo_type()%></span>
                                <span class="badge badge-primary"><%=cargo.getQuantity()%></span>
                                <span class="badge badge-primary"><%=cargo.getWarehouse_id()%>仓库</span>
                            </h5>
                            <p class="card-text">
                                <%=cargo.getCargo_type()%>
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">查询</a>
                            </p>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>

            </div>
        </div>
    </div>
</div>

</body>
</html>
