package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserPostDetailPageObject extends BasePage {
	WebDriver driver;

	public UserPostDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostsDisplayWithPostsTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.SEARCH_RESULT_POST_TITLE, postTitle);
		return isElementDisplay(driver, UserPostDetailPageUI.SEARCH_RESULT_POST_TITLE, postTitle);
	}

	public boolean isPostsInforDisplayWithPostAuthor(String postTitle, String author) {
		waitForElementVisible(driver, UserPostDetailPageUI.SEARCH_RESULT_POST_AUTHOR, postTitle, author);
		return isElementDisplay(driver, UserPostDetailPageUI.SEARCH_RESULT_POST_AUTHOR, postTitle, author);
	}

	public boolean isPostsInforDisplayWithTime(String postTitle, String currentDay) {
		isElementDisplay(driver, UserPostDetailPageUI.SEARCH_RESULT_POST_PUBLISH_TIME, postTitle, currentDay);
		return isElementDisplay(driver, UserPostDetailPageUI.SEARCH_RESULT_POST_PUBLISH_TIME, postTitle, currentDay);
	}

}
