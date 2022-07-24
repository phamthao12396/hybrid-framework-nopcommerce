package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.user.UserLoginPageUI;

public class UserLoginPage extends BasePage {
	WebDriver driver;

	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPage clickToCreateAnAccountButton() {
		waitForElemenClickable(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
}
