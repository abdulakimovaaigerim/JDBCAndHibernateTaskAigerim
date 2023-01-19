package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static final String url = "jdbc:postgresql://localhost:5432/jdbc1";
    public static final String userName = "postgres";
    public static final String password = "postgres";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection to the PostgresSQL server successfully!");

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
        return connection;
    }

}

