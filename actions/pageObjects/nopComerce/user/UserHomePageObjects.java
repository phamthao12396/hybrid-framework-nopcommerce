package pageObjects.nopComerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserHomePageUIs;

public class UserHomePageObjects extends BasePage {
	private WebDriver driver;

	public UserHomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink(WebDriver driver) {
		waitForElemenClickable(driver, UserHomePageUIs.REGISTER_LINK);
		clickToElement(driver, UserHomePageUIs.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink(WebDriver driver) {
		waitForElementVisible(driver, UserHomePageUIs.LOGIN_LINK);
		clickToElement(driver, UserHomePageUIs.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink(WebDriver driver) {
		waitForElementVisible(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);

	}

	public void clickToLogOutLink() {
		waitForElemenClickable(driver, UserHomePageUIs.LOG_OUT_LINK);
		clickToElement(driver, UserHomePageUIs.LOG_OUT_LINK);
	}

	public ComputerPageObject clickToPageByText(String menuPageTitle) {
		waitForElementVisible(driver, UserHomePageUIs.DYNAMIC_MENU_PAGE_TITLE_BY_TEXT, menuPageTitle);
		clickToElement(driver, UserHomePageUIs.DYNAMIC_MENU_PAGE_TITLE_BY_TEXT, menuPageTitle);
		return PageGeneratorManager.getComputerPageObject(driver);
	}

}
