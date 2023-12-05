<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<center>
    <div style="background-color: white; border-radius: 10px; padding: 20px; text-align:center; width: 250px; margin-top: 10%;">
        <h4>登录</h4>

        <form role="form" action="login" method="post">
            <div class="form-group" style="margin-top: 30px;">
                <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名">
            </div>
            <div class="form-group" style="margin-top: 20px;">
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>

            <center style="margin-top: 20px;">
                <button type="submit" class="btn btn-primary">登录</button>
                <button type="button" class="btn btn-link">忘记密码</button>
            </center>
        </form>
    </div>
</center>