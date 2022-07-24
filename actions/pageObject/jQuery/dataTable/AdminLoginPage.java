package pageObject.jQuery.dataTable;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.admin.AdminLoginPageUI;

public class AdminLoginPage extends BasePage {
	WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeyToUserNameTextBox(String adminEmail) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminEmail);
	}

	public void sendKeyToPasswordTextBox(String adminPass) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPass);

	}

	public AdminHomePage clickToLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminHomePage(driver);
	}
}
