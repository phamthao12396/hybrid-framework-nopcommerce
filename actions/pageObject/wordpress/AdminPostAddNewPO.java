package pageObject.wordpress;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAddNewPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTAREA);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTAREA, postTitle);
	}

	public void clickToAddNewPostBody() {
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
	}

	public void inputToAddNewPostBody(String postBody) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_BODY_TEXTAREA);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADD_BODY_TEXTAREA, postBody);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElemenClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickToPublishConfirmButton() {
		waitForElemenClickable(driver, AdminPostAddNewPageUI.CONFIRM_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.CONFIRM_PUBLISH_BUTTON);
	}

	public boolean isPublishedAndUpdatedMessageDisplay(String message) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISHED_SUCCESS_MESSAGE, message);
		return isElementDisplay(driver, AdminPostAddNewPageUI.POST_PUBLISHED_SUCCESS_MESSAGE, message);
	}

	public void closeDialog() {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME_OUT);
		List<WebElement> elements = getWebElements(driver, AdminPostAddNewPageUI.CLOSE_DIALOG_BUTTON);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);
		if (elements.size() > 0) {
			elements.get(0).click();
		}
	}

	public AdminPostsAllPostsPO openAdminAllPostsPage(String urlAdminPosts) {
		openUrl(driver, urlAdminPosts);
		return PageGeneratorManager.getAdminPostsAllPostsPage(driver);
	}

}
