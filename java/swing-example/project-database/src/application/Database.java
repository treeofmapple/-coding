package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final static String URL = "jdbc:postgresql://localhost:5432/prova";
    private final static String USER = "delveter";
    private final static String PASSWORD = "9988776655";

    public static Connection connectDb() {
        try {
        	Class.forName("org.postgresql.Driver");
        	
            Connection connect = DriverManager.getConnection(URL, USER, PASSWORD);
            
            return connect;
        } catch (SQLException |	ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
