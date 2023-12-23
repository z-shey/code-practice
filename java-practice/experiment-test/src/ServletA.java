import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "ServletA", value = "/a")
public class ServletA extends HttpServlet {
    private Map<String, Integer> dataMap = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String testData = req.getParameter("data");
        int testDataInt = 0;
        try {
            testDataInt = Integer.parseInt(testData);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameter: data should be an integer");
            return;
        }
        System.out.println("ServletA: " + testDataInt);

        dataMap.put("dataForB", testDataInt);
        dataMap.put("dataForC", testDataInt);
    }
}

@WebServlet(name = "ServletB", value = "/b")
class ServletB extends HttpServlet {
    private Map<String, Integer> dataMap = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();

        int data = dataMap.getOrDefault("dataForB", 0);
        System.out.println("Data received in ServletB: " + data);

        resp.setContentType("text/plain");
        resp.getWriter().write("Data received in ServletB: " + data);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

@WebServlet(name = "ServletC", value = "/c")
class ServletC extends HttpServlet {
    private Map<String, Integer> dataMap = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();

        int data = dataMap.getOrDefault("dataForC", 0);
        System.out.println("Data received in ServletC: " + data);

        resp.setContentType("text/plain");
        resp.getWriter().write("Data received in ServletC: " + data);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
