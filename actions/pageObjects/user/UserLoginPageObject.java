package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void sendKeyToEmailTextBox(String Email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, Email);
	}

	public void senKeyToPasswordTextBox(String Password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, Password);

	}

	public String getUnsuccessfulEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_UNSUCCESS_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_UNSUCCESS_MESSAGE);
	}

	public UserHomePageObjects clickToLoginButton() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public UserHomePageObjects loginAsUser(String usermail, String userPassword) {
		sendKeyToEmailTextBox(usermail);
		senKeyToPasswordTextBox(userPassword);
		return clickToLoginButton();

	}

}
