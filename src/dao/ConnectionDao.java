package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDao {

    public Connection getConnection () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_crud/mvc", "admin", "Admin13.");
        } catch (Exception e) {
            throw new RuntimeException("Erro 1: " + e);
        }
    }
}
