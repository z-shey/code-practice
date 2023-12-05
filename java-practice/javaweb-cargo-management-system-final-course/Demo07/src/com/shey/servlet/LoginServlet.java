package com.shey.servlet;

import com.shey.entity.Role;
import com.shey.entity.User;
import com.shey.service.RoleServiceImpl;
import com.shey.service.UserServiceImpl;
import com.shey.service.api.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = new UserServiceImpl().login(username, password);

        Role loginRole = null;
        if (loginUser != null) {
            loginRole = new RoleServiceImpl().getRoleById(loginUser.getRole_id());
        }

        if (loginUser != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", loginUser);
            session.setAttribute("loginRole", loginRole);
            resp.sendRedirect("workspace.jsp");
        } else {
            req.setAttribute("errorMessage", "用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
