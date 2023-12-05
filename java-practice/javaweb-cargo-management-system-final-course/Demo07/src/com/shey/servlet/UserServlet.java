package com.shey.servlet;

import com.shey.dao.UserDaoImpl;
import com.shey.dao.api.UserDao;
import com.shey.entity.User;
import com.shey.service.RoleServiceImpl;
import com.shey.service.UserServiceImpl;
import com.shey.service.api.RoleService;
import com.shey.service.api.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        UserService userService = new UserServiceImpl();
        RoleService role = new RoleServiceImpl();

        List<User> allUsers = userService.getAllUsers();

        if (allUsers != null) {
            req.setAttribute("allUsers", allUsers);
            req.setAttribute("role", role);

            req.getRequestDispatcher("userManagement.jsp").forward(req, resp);
        }

//
//        String flag = req.getParameter("flag");
//        System.out.println("flag:" + flag);

//        if (flag.equals("add")) {
//            String name = req.getParameter("name");
//            String username = req.getParameter("username");
//            String password = req.getParameter("password");
//            String roleId = req.getParameter("roleId");
//
//            UserDao userDao = new UserDaoImpl();
//            User newUser = new User();
//            newUser.setName(name);
//            newUser.setUsername(username);
//            newUser.setPassword(password);
//            newUser.setRole_id(Integer.valueOf(roleId));
//
//            userDao.add(newUser);
////            req.getRequestDispatcher("userManagement.jsp").forward(req, resp);
////            resp.sendRedirect("workspace.jsp");
//        }

    }

}
