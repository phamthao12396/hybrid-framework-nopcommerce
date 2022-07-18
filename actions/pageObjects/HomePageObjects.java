package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUIs;

public class HomePageObjects extends BasePage {
	private WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElemenClickable(driver, HomePageUIs.REGISTER_LINK);
		clickToElement(driver, HomePageUIs.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementVisible(driver, HomePageUIs.LOGIN_LINK);
		clickToElement(driver, HomePageUIs.LOGIN_LINK);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUIs.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUIs.MY_ACCOUNT_LINK);
	}

}
