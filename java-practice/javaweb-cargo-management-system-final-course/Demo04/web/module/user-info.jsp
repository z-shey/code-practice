<%@ page import="dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="col-md-2 d-flex flex-column align-items-center justify-content-center vh-100 sidebar shadow">
    <img src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded-circle" style="margin-top: 10px;"/>
    <h4 style="text-align: center; margin-top: 15px;"><%= session.getAttribute("username") %></h4>
    <h6 style="text-align: center; margin-top: 15px;">
        <%
            Integer identity = (Integer) session.getAttribute("identity");
            int id = identity.intValue();
            if (id == 1) {
                out.write("Admin");
            } else if (id == 2) {
                out.write("Warehouse Admin");
            } else if (id == 3) {
                out.write("Cargo Admin");
            } else {
                out.write("Employee");
            }

        %>
    </h6>
</div>
