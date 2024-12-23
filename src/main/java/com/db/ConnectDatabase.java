package com.db;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectDatabase {
    private static Connection connection;

    @SuppressWarnings("CallToPrintStackTrace")
    public static Connection connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/maven_crud", "root",
                    "Vignesh@2003");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
