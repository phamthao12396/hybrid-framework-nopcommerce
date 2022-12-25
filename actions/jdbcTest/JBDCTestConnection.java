package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JBDCTestConnection {
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return JBDCconnUtils.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException {
		System.out.println("Get connection ...");

		// lay ra doi tuong conn de ket noi vao db
		Connection conn = JTDSConnUtils.getSQLServerConnection();

		//
		System.out.println("Opended connection .." + conn);

		// tao moi 1
		Statement statement = conn.createStatement();

		String sql = "SELECT * FROM EMPLOYEE";

		// thuc thi cau lenh SQL va tra ve ket qua duoi dang resultSet
		ResultSet rs = statement.executeQuery(sql);

		// duyet ket qua tra ve va in ra
		while (rs.next()) {
			int empId = rs.getInt("EMP_ID");
			String empFirstName = rs.getString("FIRST_NAME");
			String empLastName = rs.getString("LAST_NAME");
			System.out.println("===========");
			System.out.println("Emp ID: " + empId);
			System.out.println("Emp First Name: " + empFirstName);
			System.out.println("Emp Last Name" + empLastName);

		}
		conn.close();
		System.out.println("Closed connection .." + conn);

	}
}
