import java.sql.*;

class DatabaseHelper {
    private Connection connection;

    /**
     * 连接数据库
     */
    public DatabaseHelper() {
        connection = getConnection();
    }

    /**
     * 获取连接数据库
     * @return
     */
    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC"); // 连接SQLite数据库
            conn = DriverManager.getConnection("jdbc:sqlite:data/data");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 权限认证
     * @param userName 用户名
     * @param password 密码
     * @return 布尔值
     */
    public boolean isValidUser(String userName, String password) {
        boolean isValidUser = false;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE user_name = ? AND password = ?");
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValidUser = true;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValidUser;
    }

    /**
     * 获取用户类型
     * @param userName 用户民
     * @return 返回字符串的用户名类型
     */
    public String getUserType(String userName) {
        String userType = "";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT user_type FROM users WHERE user_name = ?");
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userType = resultSet.getString("user_type");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }

    /**
     * 获取所有用户
     * @return 返回所有用户
     * @throws SQLException 异常抛出
     */
    public ResultSet getUsers() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM users");
    }

    /**
     * 获取所有仓库
     * @return 返回所有仓库
     * @throws SQLException 异常抛出
     */
    public ResultSet getWarehouses() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM warehouses");
    }

    /**
     * 增加用户
     * @param userName 用户名
     * @param userType 用户类型
     * @throws SQLException 异常抛出
     */
    public void addUser(String userName, String userType, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO users (user_name, user_type, password) VALUES (?, ?, ?)");
        statement.setString(1, userName);
        statement.setString(2, userType);
        statement.setString(3, password);
        statement.executeUpdate();
        statement.close();
    }

    /**
     * 删除用户
     * @param userName 用户名
     * @throws SQLException 异常抛出
     */
    public void removeUser(String userName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE user_name = ?");
        statement.setString(1, userName);
        statement.executeUpdate();
        statement.close();
    }
}
