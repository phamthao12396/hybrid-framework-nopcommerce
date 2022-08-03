package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToPostsMenu() {
		waitForElemenClickable(driver, AdminDashboardPageUI.MENU_POSTS);
		clickToElement(driver, AdminDashboardPageUI.MENU_POSTS);
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElemenClickable(driver, AdminDashboardPageUI.POSTS_ADD_NEW_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.POSTS_ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPO(driver);
	}

}
