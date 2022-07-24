package pageObjects.nopComerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameTextBoxValue(String string) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, string);
	}

	public String getLastNameTextBoxValue(String string) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, string);
	}

	public String getEmailTextBoxValue(String string) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, string);
	}

}
