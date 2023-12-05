package servlet;  // 定义包名

import jakarta.servlet.ServletException;  // 导入Servlet异常类
import jakarta.servlet.annotation.WebServlet;  // 导入Servlet注解类
import jakarta.servlet.http.HttpServlet;  // 导入HttpServlet类
import jakarta.servlet.http.HttpServletRequest;  // 导入HttpServletRequest类
import jakarta.servlet.http.HttpServletResponse;  // 导入HttpServletResponse类
import org.apache.commons.dbutils.QueryRunner;  // 导入QueryRunner类
import org.apache.commons.dbutils.handlers.BeanHandler;  // 导入BeanHandler类
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.pool2.SwallowedExceptionListener;

import javax.sql.DataSource;
import java.io.IOException;  // 导入IO异常类
import java.sql.Connection;  // 导入数据库连接类
import java.sql.DriverManager;  // 导入数据库驱动管理类
import java.sql.SQLException;  // 导入SQL异常类

@WebServlet(name = "LoginServlet", value = "/LoginServlet")  // 使用@WebServlet注解定义Servlet类并设置访问路径
public class LoginServlet extends HttpServlet {  // 继承HttpServlet类
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");  // 设置请求编码为UTF-8
//        resp.setCharacterEncoding("utf-8");  // 设置响应编码为UTF-8，防止乱码

        String username = req.getParameter("username");  // 获取请求参数user的值
        String password = req.getParameter("password");  // 获取请求参数pwd的值

        int identity = new UserDao().loginUser(username, password);  // 调用UserDao的loginUser方法进行用户登录验证
        if (identity == 0) {  // 如果返回值为0，表示登录失败
            req.getSession().setAttribute("identity", "失败");  // 在会话中设置属性value为"失败"
            resp.sendRedirect("index.jsp");  // 重定向到index.jsp页面
        } else if (identity == 1) {  // 如果返回值为1，表示登录成功
            resp.sendRedirect("index.jsp");  // 重定向到index.jsp页面
        } else {  // 其他情况
            resp.sendRedirect("index.jsp");  // 重定向到index.jsp页面
        }
    }
}

class UserDao {
    private final QueryRunner queryRunner;

    public UserDao() {
        this.queryRunner = new QueryRunner(JdbcUtil.getDataSource());  // 使用JdbcUtil类获取数据源并创建QueryRunner对象实例
    }

    public int loginUser(String username, String password) {
        String sql = "SELECT * FROM user WHERE username=? and password=?";
        User user = null;

        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String identity = user != null ? user.getIdentity() : null;

        if (identity == null) {
            return 0;
        } else if (identity.equals("1")) {
            return 1;
        } else {
            return 2;
        }
    }
}

//class UserDao {  // 定义UserDao类 用于访问和操作用户数据的对象 User Data Access Object
//    private final Connection connection;  // 声明连接对象
//    private final QueryRunner queryRunner;  // 声明查询运行器对象
//
//    public UserDao() {
//        this.connection = JdbcUtil.getConnection();  // 使用JdbcUtil类获取数据库连接并赋值给connection对象
//        this.queryRunner = new QueryRunner();  // 创建QueryRunner对象实例
//    }
//
//    /**
//     * 用户登录方法
//     *
//     * @param username  用户名
//     * @param password 密码
//     * @return 登录结果代码，0表示失败，1表示成功，2表示其他情况
//     */
//    public int loginUser(String username, String password) {  // 定义用户登录方法
//        String sql = "SELECT * FROM user WHERE username=? and password=?";  // 定义查询语句
//
//        User user = null;  // 声明用户对象
//
//        try {
//            user = queryRunner.query(connection, sql, new BeanHandler<>(User.class), username, password);  // 执行查询并将结果映射到User对象
//        } catch (SQLException e) {
//            throw new RuntimeException(e);  // 捕获SQL异常并抛出运行时异常
//        }
//
//
//        String identity = user.getIdentity();  // 获取用户值
//
//        if (identity == null) {  // 判断用户值是否为空
//            return 0;  // 返回登录结果代码
//        } else if (identity.equals("1")) {  // 判断用户值是否为"1"
//            return 1;  // 返回登录结果代码
//        } else {
//            return 2;  // 返回登录结果代码
//        }
//    }
//
//    /**
//     * 注册用户方法
//     *
//     * @param user 用户对象
//     * @return 注册结果代码，1表示成功
//     */
//    public int registerUser(User user) {  // 定义注册用户方法
//        String sql = "INSERT INTO user(username,password) VALUES(?,?)";  // 定义插入语句
//        try {
//            queryRunner.update(sql, user.getUsername(), user.getPassword());  // 执行更新操作
//        } catch (SQLException e) {
//            throw new RuntimeException(e);  // 捕获SQL异常并抛出运行时异常
//        }
//        return 1;  // 返回注册结果代码
//    }
//}

class JdbcUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/Cargo";
    private static final String USER = "root";
    private static final String PASSWORD = "Root123";

    public static DataSource getDataSource() {  // 获取数据源方法
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

//class JdbcUtil {  // 定义JdbcUtil类
//
//    private static final String URL = "jdbc:mysql://localhost:3306/cargo";  // 数据库连接URL
//    private static final String USER = "root";  // 数据库用户名
//    private static final String PASSWORD = "Root123";  // 数据库密码
//
//    public static Connection getConnection() {  // 获取数据库连接方法
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);  // 使用DriverManager获取数据库连接
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public static void closeConnection(Connection connection) {  // 关闭数据库连接方法
//        if (connection != null) {
//            try {
//                connection.close();  // 关闭连接
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

class UserDaoTest {
    public static void main(String[] args) {
        int result = new UserDao().loginUser("admin", "admin");
        System.out.println("登录结果代码：" + result);
    }
}