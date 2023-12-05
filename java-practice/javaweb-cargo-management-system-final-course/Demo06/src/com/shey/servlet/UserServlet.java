package com.shey.servlet;

import com.shey.entity.User;
import com.shey.service.UserService;
import com.shey.service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//@WebServlet(name = "UserServlet", value = "/UserServlet")
//public class UserServlet extends BaseServlet {
//    private UserService userService;
//
//    private User loginUser;
//
//    public UserServlet() {
//        this.userService = new UserServiceImpl();
//    }
//
//    public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        loginUser = userService.getUser(username, password);
//
//        boolean valid = userService.isValid(username, password);
//
//        if (loginUser != null) {
//            int identity = loginUser.getIdentity();
//            if (valid) {
//                req.setAttribute("loginUser", loginUser);
//
//                if (identity == 1) {
//                    return "redirect:UserServlet?flag=area";
//                }
//            }
//        }
//        req.setAttribute("error", "用户名或密码错误！");
//        return "forward:/";
//    }
//
//    public String loginOut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        req.removeAttribute("loginUser");
//        return "forward:/";
//    }
//
//    public String preUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        Integer userId = Integer.valueOf(req.getParameter("id"));
//        User user = userService.getUser(userId);
//        req.setAttribute("userUpdate", user);
//        req.setAttribute("loginUser", loginUser);
//        return "forward:user-update.jsp";
//    }
//
//    public String update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String userId = req.getParameter("userId");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String identity = req.getParameter("identity");
//        String remarks = req.getParameter("remarks");
//
//        User user = new User();
//        user.setUser_id(Integer.valueOf(userId));
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setIdentity(Integer.valueOf(identity));
//        user.setRemarks(remarks);
//
//        userService.userUpdate(user);
//        return userManger(req, resp);
//    }
//
//    public String addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String identity = req.getParameter("identity");
//        String remarks = req.getParameter("remarks");
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setIdentity(Integer.valueOf(identity));
//        user.setRemarks(remarks);
//
//        userService.userAdd(user);
//        return userManger(req, resp);
//    }
//
//    public String delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String userId = req.getParameter("id");
//        userService.userDelete(Integer.valueOf(userId));
//
//        return userManger(req, resp); // Or return "redirect:UserServlet?flag=userList";
//    }
//
//        public String area(HttpServletRequest req, HttpServletResponse resp) {
//        req.setAttribute("loginUser", loginUser);
//        return "forward:working-area.jsp";
//    }
//
//
//    public String userManger(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        List<User> userList = userService.userList();
//        req.setAttribute("userList", userList);
//        req.setAttribute("loginUser", loginUser);
//        return "forward:user-manger.jsp";
//    }
//}

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService;

    private User loginUser;

    public UserServlet() {
        this.userService = new UserServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");


        userManger(req, resp);
    }

    public void userManger(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        List<User> userList = userService.userList();
        req.setAttribute("userList", userList);
        req.setAttribute("loginUser", loginUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("working-area.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}