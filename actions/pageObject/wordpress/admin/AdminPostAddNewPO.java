package pageObject.wordpress.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAddNewPostTitle(String postTitle) {
		closeDialog();
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTAREA);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTAREA, postTitle);
	}

	public void inputToAddNewPostBody(String postBody) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_BODY_TEXTAREA);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADD_BODY_TEXTAREA, postBody);
	}

	public void clickToPublishButton() {
		waitForElemenClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		waitForElemenClickable(driver, AdminPostAddNewPageUI.CONFIRM_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.CONFIRM_PUBLISH_BUTTON);
	}

	public boolean isPublishedMessageDisplay(String message) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISHED_SUCCESS_MESSAGE, message);
		return isElementDisplay(driver, AdminPostAddNewPageUI.POST_PUBLISHED_SUCCESS_MESSAGE, message);
	}

	private void closeDialog() {
		List<WebElement> elements = getWebElements(driver, AdminPostAddNewPageUI.CLOSE_DIALOG_BUTTON);
		if (elements.size() > 0) {
			elements.get(0).click();
		}
	}
}
