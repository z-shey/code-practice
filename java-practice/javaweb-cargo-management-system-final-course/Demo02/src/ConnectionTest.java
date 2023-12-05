import java.sql.*;

public class ConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cargo";
        String username = "root";
        String password = "Root123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection successful!");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // 从结果集中获取数据并进行处理
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // 关闭资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
