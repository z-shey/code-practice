package dao;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private JdbcUtil jdbcUtil;

    public UserDao() {
        jdbcUtil = new JdbcUtil();
    }

    public boolean isValidUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isValid = false;

        try {
            connection = jdbcUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM users WHERE username=? AND password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                isValid = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.closeResultSet(resultSet);
            jdbcUtil.closeStatement(preparedStatement);
            jdbcUtil.closeConnection(connection);
        }

        return isValid;
    }
}
