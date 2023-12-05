<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="col-md-2 d-flex flex-column align-items-center justify-content-center vh-100 sidebar shadow">
    <img src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded-circle" style="margin-top: 10px;"/>
    <h4 style="text-align: center; margin-top: 15px;">用户名</h4>
    <h6 style="text-align: center; margin-top: 15px;">
        <%
            String userRole = (String) request.getAttribute("userRole");
            if(userRole != null && userRole.equals("admin")) {
                out.print("admin");
            }
        %>
    </h6>
</div>
