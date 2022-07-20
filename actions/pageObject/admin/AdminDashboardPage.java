package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AdminDashboardPageUI;

public class AdminDashboardPage extends BasePage {
	private WebDriver driver;

	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLogOutLink() {
		waitForElemenClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
	}

}
