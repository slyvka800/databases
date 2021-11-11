package com.slyvka;

import java.sql.*;

public class Application {
    public static final String url = "jdbc:mysql://localhost:3306/Slyvka";
    private static final String user = "root";
    private static final String password = "12345678";

    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT COUNT(*) FROM landlord");

            while(rs.next()) {
                int count = rs.getInt(1);
                System.out.println(count);
            }

        } catch (SQLException throwables) {
            System.out.println("SQLException: " + throwables.getMessage());
            System.out.println("SQLState: " + throwables.getSQLState());
            System.out.println("VendorError: " + throwables.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver is not loaded");
        } finally {
            if (rs != null) try {rs.close();} catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (statement != null) try {statement.close();} catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (connection != null) try {connection.close();} catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
