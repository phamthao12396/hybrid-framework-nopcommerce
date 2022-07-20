package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameTextBoxValue(String string) {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, string);
	}

	public String getLastNameTextBoxValue(String string) {
		waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, string);
	}

	public String getEmailTextBoxValue(String string) {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, string);
	}

}
