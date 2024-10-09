package org.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySql {
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/studentmanagement";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connected to database");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return connection;
    }
}