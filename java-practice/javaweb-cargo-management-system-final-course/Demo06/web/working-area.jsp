<%@ page import="com.shey.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Title</title>

    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/bootstrap-grid.css">
    <link rel="stylesheet" href="assets/css/bootstrap-reboot.css">
    <link rel="stylesheet" href="assets/css/style.css">


</head>
<body class="body-bg">



<div class="container-fluid">
    <%@ include file="header.jsp" %>
    <div class="row">
        <div class="col-md-12">



            <div class="row">
                <div class="col-md-2 d-flex flex-column align-items-center justify-content-center vh-100 sidebar shadow">
                    <img src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded-circle" style="margin-top: 10px;"/>

                    <h4 style="text-align: center; margin-top: 15px;"><%=loginUser.getUsername()%></h4>
                    <h6 style="text-align: center; margin-top: 15px;"><%=loginUser.getRemarks()%></h6>
                </div>

                <div class="col-md-10">
                    <h4 style="text-align: center; margin-top: 15px;"><%=loginUser.getUsername()%></h4>
                    <h6 style="text-align: center; margin-top: 15px;"><%=loginUser.getRemarks()%></h6>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/scripts.js"></script>
<script src="assets/js/style.js"></script>
</body>
</html>
