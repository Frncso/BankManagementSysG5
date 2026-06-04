package BankManage.DataService;

import java.sql.*;

public class DatabaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/vaultbank_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";           // user
    private static final String PASSWORD = "";           // password (wala)

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found!", e);
        }
    }
   
}