package servlet;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.UserBean;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();
        boolean isValidUser = userDao.isValidUser(username, password);

        if (isValidUser) {
            resp.getWriter().println("Login successful!");
        } else {
            resp.getWriter().println("Invalid username or password!");
        }
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        boolean isValidUser = userDao.isValidUser("admin", "admin");
        System.out.println(isValidUser);
    }
}
