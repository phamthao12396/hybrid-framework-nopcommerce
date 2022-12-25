package pageObject.wordpress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import utilities.MySQLConnUtils;
import pageUIs.wordpress.AdminUsersUI;

public class AdminUsersPO extends BasePage {
	WebDriver driver;

	public AdminUsersPO(WebDriver driver) {
		this.driver = driver;
	}

	public Integer getAllUsersAtUI(WebDriver driver) {
		String text_count = getElementText(driver, AdminUsersUI.ALL_USER);
		String new_string = text_count.replace("(", "");
		String final_string = new_string.replace(")", "");
		System.out.println(final_string);

		return Integer.parseInt(final_string);
	}

	public Integer getAllUsersAtDB(WebDriver driver) {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement statement;
		ArrayList<String> listNumber = new ArrayList<>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM `wp_users`";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				listNumber.add(rs.getString("user_login"));
				System.out.println(rs.getString("user_login"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listNumber.size();
	}
}
