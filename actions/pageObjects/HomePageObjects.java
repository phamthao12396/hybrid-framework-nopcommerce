package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUIs;

public class HomePageObjects extends BasePage {
	private WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElemenClickable(driver, HomePageUIs.REGISTER_LINK);
		clickToElement(driver, HomePageUIs.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, HomePageUIs.LOGIN_LINK);
		clickToElement(driver, HomePageUIs.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUIs.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUIs.MY_ACCOUNT_LINK);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUIs.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);

	}

}
