package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;

	public static AdminPostAddNewPO getAdminPostsAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}

	public static AdminPostsAllPostsPO getAdminPostsAllPostsPage(WebDriver driver) {
		return new AdminPostsAllPostsPO(driver);
	}

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserPostDetailPageObject getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPageObject(driver);
	}

	public static AdminPagesPO getAdminPagesPage(WebDriver driver) {
		return new AdminPagesPO(driver);
	}

	public static AdminPagesAddNewPO getAdminPagesAddNewPage(WebDriver driver) {
		return new AdminPagesAddNewPO(driver);
	}
}
