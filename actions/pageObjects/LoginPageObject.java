package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void sendKeyToEmailTextBox(String Email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, Email);
	}

	public void senKeyToPasswordTextBox(String Password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, Password);

	}

	public String getUnsuccessfulEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_UNSUCCESS_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_UNSUCCESS_MESSAGE);
	}

	public HomePageObjects clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);

	}

}
