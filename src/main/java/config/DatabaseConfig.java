package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://monorail.proxy.rlwy.net:27388/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "tDRzVAIHIHIDGGOZHNSKMojzNlePshrI";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
