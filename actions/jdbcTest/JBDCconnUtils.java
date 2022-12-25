package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class JBDCconnUtils {
	public static Connection getSQLServerConnection() {
		String hostname = "localhost";
		String sqlIntanceName = "localhost";
		String dbName = "phamthao12396";
		String userName = "";
		String password = "";
		return getSQLServerConnection(hostname, sqlIntanceName, dbName, userName, password);
	}

	private static Connection getSQLServerConnection(String hostname, String sqlIntanceName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// khai bao class Driver cho SQL server, viec nay can thiet voi java5
			// Class.forName("net.sourcefogce.jtds.jdbc.Driver");
			// cau truc url khi su dung thu vien jbdc
			String connectionURL = "jdbc:sqlserver://" + hostname + ":1433/" + ";instance=" + sqlIntanceName + ";databaseName=" + dbName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
