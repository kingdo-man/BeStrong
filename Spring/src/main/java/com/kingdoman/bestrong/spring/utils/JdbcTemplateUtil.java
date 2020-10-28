package com.kingdoman.bestrong.spring.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTemplateUtil {
    private static DataSource data;

    static {
        Properties ps = new Properties();
        try {
            ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            data = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return data.getConnection();
    }

    public static DataSource getDataSource() {
        return data;
    }
}