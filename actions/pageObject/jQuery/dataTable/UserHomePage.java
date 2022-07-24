package pageObject.jQuery.dataTable;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.user.UserHomePageUI;

public class UserHomePage extends BasePage {
	WebDriver driver;

	public UserHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public UserLoginPage clickToLinkByTitle(WebDriver driver, String string) {
		waitForElemenClickable(driver, UserHomePageUI.FOOTER_LINK_PAGE, string);
		clickToElement(driver, UserHomePageUI.FOOTER_LINK_PAGE, string);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

}
