package servlet;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        UserDao userDao = new UserDao();
        boolean haveUser = userDao.haveUser(username, password);
        int identity = userDao.getUserIdentity(username);

        req.getSession().setAttribute("username", username);
        req.getSession().setAttribute("identity", identity);
//        && identity == 1
        if (haveUser ) {
            resp.sendRedirect("pages/working-area.jsp");
        } else {
            resp.getWriter().println("Login failed!");
        }

    }

//    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        System.out.println(userDao.getUserByName("admin").getUsername());
//        System.out.println(userDao.getUserIdentity("admin"));
//    }
}
