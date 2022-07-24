package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPage extends BasePage {
	private WebDriver driver;

	public AdminLoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public void sendKeyToEmailTextBox(String Email) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, Email);
	}

	public void senKeyToPasswordTextBox(String Password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, Password);

	}

	public AdminDashboardPage clickToLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		areJQueryAndJSLoadedSuccess(driver);
		return PageGeneratorManager.getAdminDashboardPage(driver);

	}

	public AdminDashboardPage loginAsAdmin(String adminEmail, String adminPassword) {
		sendKeyToEmailTextBox(adminEmail);
		senKeyToPasswordTextBox(adminPassword);
		return clickToLoginButton();
	}
}
