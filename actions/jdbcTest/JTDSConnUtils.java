package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class JTDSConnUtils {
	public static Connection getSQLServerConnection() {
		String hostname = "localhost";
		String sqlIntanceName = "SQLEXPRESS";
		String dbName = "automationtest";
		String userName = "sa";
		String password = "phamthao12396";
		return getSQLConnection(hostname, sqlIntanceName, dbName, userName, password);
	}

	private static Connection getSQLConnection(String hostname, String sqlIntanceName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// khai bao class Driver cho SQL server, viec nay can thiet voi java5
			// Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// cau truc URL gianh cho sql khi su dung jtds driver
			String connectionURL = "jdbc:jtds:sqlserver://" + hostname + ":1433/" + dbName + ";instance=" + sqlIntanceName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
