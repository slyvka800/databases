package com.slyvka.persistant;

import java.sql.*;

public class ConnectionManager {
    public static final String url = "jdbc:mysql://localhost:3306/Slyvka";
    private static final String user = "root";
    private static final String password = "12345678";

    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet rs = null;

    private ConnectionManager() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException throwables) {
                System.out.println("SQLException: " + throwables.getMessage());
                System.out.println("SQLState: " + throwables.getSQLState());
                System.out.println("VendorError: " + throwables.getErrorCode());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) try {connection.close();} catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
