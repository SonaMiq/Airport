package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection dbConnection;
    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/airport";
    private final String USERNAME = "root";
    private final String PASSWORD = "Yelena";

    private DatabaseConnection() {
            try {
                this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public static DatabaseConnection getDbConnection() {
        if(dbConnection==null){
            dbConnection=new DatabaseConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
