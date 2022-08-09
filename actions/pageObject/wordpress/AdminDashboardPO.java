package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMenuByText(String menuText) {
		waitForElemenClickable(driver, AdminDashboardPageUI.MENU_BY_TEXT, menuText);
		clickToElement(driver, AdminDashboardPageUI.MENU_BY_TEXT, menuText);
	}

}
