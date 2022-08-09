package pageObject.wordpress;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.wordpress.AdminPagesAddNewUI;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPagesAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPagesAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToPageTitleTextbox(String pageName) {
		waitForElementVisible(driver, AdminPagesAddNewUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPagesAddNewUI.TITLE_TEXTBOX, pageName);
	}

	public void inputToPageDetailArea(String pageDetail) {
		waitForElementVisible(driver, AdminPagesAddNewUI.DETAIL_TEXTBOX);
		sendkeyToElement(driver, AdminPagesAddNewUI.DETAIL_TEXTBOX, pageDetail);

	}

	public void clickToPublishButton() {
		waitForElemenClickable(driver, AdminPagesAddNewUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPagesAddNewUI.PUBLISH_BUTTON);

	}

	public void clickToPublishConfirmButton() {
		waitForElemenClickable(driver, AdminPagesAddNewUI.CONFIRM_PUBLISH_BUTTON);
		clickToElement(driver, AdminPagesAddNewUI.CONFIRM_PUBLISH_BUTTON);

	}

	public boolean isPublishedOrUpdatedMessageDisplay(String textMessage) {
		waitForElementVisible(driver, AdminPagesAddNewUI.PUBLISHED_OR_UPDATED_SUCCESS_MESSAGE, textMessage);
		return isElementDisplay(driver, AdminPagesAddNewUI.PUBLISHED_OR_UPDATED_SUCCESS_MESSAGE, textMessage);
	}

	public void clickToPageDetailArea() {
		waitForElemenClickable(driver, AdminPagesAddNewUI.DETAIL_BUTTON);
		clickToElement(driver, AdminPagesAddNewUI.DETAIL_BUTTON);
	}

	public void closeDialog() {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME_OUT);
		List<WebElement> elements = getWebElements(driver, AdminPagesAddNewUI.CLOSE_DIALOG_BUTTON);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);
		if (elements.size() > 0) {
			elements.get(0).click();
		}

	}

}
