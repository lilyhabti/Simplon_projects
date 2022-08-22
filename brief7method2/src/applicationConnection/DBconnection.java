package applicationConnection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	private static String dbURL = "jdbc:postgresql://localhost:5432/brief7";
	private static String username = "postgres";
	private static String password = "postgres";
	 
	public static Connection getconnect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}

