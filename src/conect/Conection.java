package conect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    public static final String url = "jdbc:mysql://localhost:3306/JavaCRUD";
    private static final String user = "root";
    private static final String password = "root";

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