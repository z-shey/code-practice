import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Java Servlet或Controller
@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        // 创建List对象并填充数据
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 25));
        personList.add(new Person("Alice", 30));

        // 将List对象设置为Java Bean的属性，并存储在请求的属性中
        request.setAttribute("personList", personList);

        // 转发到JSP页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("/example.jsp");
        dispatcher.forward(request, response);
    }
}