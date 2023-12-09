import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JtdsExample {

    public static void main(String[] args) {
        try {
            // 加载jTDS驱动程序
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // 建立与SQL Server数据库的连接
            String url = "jdbc:jtds:sqlserver://192.168.136.141/Algorithm_SQL";
            String username = "sa";
            String password = "Root123";

            Connection connection = DriverManager.getConnection(url, username, password);

            // 执行查询
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ALG.Alumni");

            while (resultSet.next()) {
                // 处理查询结果
                int id = resultSet.getInt("sno");
                String name = resultSet.getString("email");
                // 其他列类似地获取数据

                System.out.println("ID: " + id + ", Name: " + name);
            }

            resultSet.close();
            statement.close();

            // 关闭连接
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
