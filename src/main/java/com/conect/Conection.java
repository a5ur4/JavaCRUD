package com.conect;

import java.sql.*;

public class Conection {
    public static String myDriver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/JavaCRUD";
    private static final String user = "root";
    private static final String password = "root";

    static {
        try {
            Class.forName(myDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection conn;

    public static Connection getConection() {
        try {
            if(conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}