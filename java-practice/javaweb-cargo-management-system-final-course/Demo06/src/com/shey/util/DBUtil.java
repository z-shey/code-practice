package com.shey.util;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    public static final String DRIVER_CLASS;

    public static final String URL;
    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("com.shey.util/db");
        DRIVER_CLASS = bundle.getString("jdbc.driver");
        URL = bundle.getString("jdbc.url");
        USERNAME = bundle.getString("jdbc.username");
        PASSWORD = bundle.getString("jdbc.password");
    }

    public static HikariDataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS);
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
