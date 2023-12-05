import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String userRole = null;
        if (userName.equals("SuperAdmin") && password.equals("admin")) {
            userRole = "admin";
            req.setAttribute("userRole", userRole);
            resp.sendRedirect("SuperManger.jsp");
        } else if (userName.equals("WarehouseManager") && password.equals("admin")) {
            resp.sendRedirect("WarehouseManager.jsp");
        } else if (userName.equals("GoodsManager") && password.equals("admin")) {
            resp.sendRedirect("GoodsManager.jsp");
        } else if (userName.equals("RegularUser") && password.equals("admin")) {
            resp.sendRedirect("RegularUser.jsp");
        } else {
            resp.sendRedirect("/");
        }
    }
}
