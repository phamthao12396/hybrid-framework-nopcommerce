package pageObjects.facebook.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.user.FacebookPageUI;

public class UserFacebookPage extends BasePage {
	WebDriver driver;

	public UserFacebookPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElemenClickable(driver, FacebookPageUI.REGISTER_BUTTON);
		clickToElement(driver, FacebookPageUI.REGISTER_BUTTON);
	}

	public boolean isEmailTextboxDisplay() {
		waitForElementVisible(driver, FacebookPageUI.EMAIL_TEXTBOX);
		return isElementDisplay(driver, FacebookPageUI.EMAIL_TEXTBOX);
	}

	public void senkeyToEmailTextBox(String email) {
		waitForElementVisible(driver, FacebookPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, FacebookPageUI.EMAIL_TEXTBOX, email);
	}

	public boolean isConfirmEmailTextboxUnDisplay() {
		waitForElementInvisible(driver, FacebookPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementUnDisplay(driver, FacebookPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseButton() {
		waitForElemenClickable(driver, FacebookPageUI.REGISTER_POPUP_CLOSE_BUTTON);
		clickToElement(driver, FacebookPageUI.REGISTER_POPUP_CLOSE_BUTTON);
	}
}
