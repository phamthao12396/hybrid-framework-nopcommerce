package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPagesDetailPageUI;

public class UserPagesDetailPagePO extends BasePage {
	WebDriver driver;

	public UserPagesDetailPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageNameDisplayOnDetailPage(String pageTitle) {
		waitForElementVisible(driver, UserPagesDetailPageUI.PAGE_TITLE, pageTitle);
		return isElementDisplay(driver, UserPagesDetailPageUI.PAGE_TITLE, pageTitle);
	}

	public boolean isPageDetailDisplayOnDetailPage(String pageDetail) {
		waitForElementVisible(driver, UserPagesDetailPageUI.PAGE_DETAIL, pageDetail);
		return isElementDisplay(driver, UserPagesDetailPageUI.PAGE_DETAIL, pageDetail);
	}
}
