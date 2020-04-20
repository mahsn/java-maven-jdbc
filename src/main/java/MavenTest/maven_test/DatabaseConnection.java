package MavenTest.maven_test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	private static String databaseUrl = "jdbc:mysql://localhost:3306/studentsdatabase?useTimezone=true&serverTimezone=UTC";
	private static String databaseUser = "root";
	private static String databasePassword = "admin";
	private static Connection databaseConnection = null;
	private static String mysqlClassName = "com.mysql.cj.jdbc.Driver";
	
	
	static {
		conector();
	}
	
	public DatabaseConnection() {
		conector();
	}
	
	private static void conector() {
		try {
			if (databaseConnection == null) {
				Class.forName(mysqlClassName);
				databaseConnection = DriverManager.getConnection(databaseUrl,databaseUser, databasePassword);
				databaseConnection.setAutoCommit(false);
				System.out.println("Connected to database successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getDatabaseConnection() {
		return databaseConnection;
	}
}
