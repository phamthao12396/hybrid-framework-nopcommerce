package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostsAllPostsPO clickToPostsMenu() {
		waitForElemenClickable(driver, AdminDashboardPageUI.MENU_POSTS);
		clickToElement(driver, AdminDashboardPageUI.MENU_POSTS);
		return PageGeneratorManager.getAdminPostsAllPostsPage(driver);
	}

}
