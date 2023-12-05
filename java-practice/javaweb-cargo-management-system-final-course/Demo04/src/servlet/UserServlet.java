package servlet;


import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.User;

import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private UserDao userDao;
    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.getAllUsers();
        if (users != null) {
            req.setAttribute("users", users);
        } else {
            req.setAttribute("errorMsg", "Failed to retrieve user list.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/user-list.jsp");
        dispatcher.forward(req, resp);
    }

    public static void main(String[] args) {
        List<User> users = new UserDao().getAllUsers();
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}
