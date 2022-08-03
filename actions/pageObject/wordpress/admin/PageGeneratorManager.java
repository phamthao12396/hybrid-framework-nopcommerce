package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;

	public static AdminAllPostPO getAdminAllPostPO(WebDriver driver) {
		return new AdminAllPostPO(driver);
	}

	public static AdminPostAddNewPO getAdminPostAddNewPO(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}

	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPO getAdminDashboardPO(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
}
