package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() {
		String hostname = "localhost";
		String dbName = "phamthao12396";
		String userName = "root";
		String password = "";
		return getMySQLConnection(hostname, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostname, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// cấu trúc url connection giành cho mySQL: jbdc:mysql://localhost:3306/phamthao12396
			String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
