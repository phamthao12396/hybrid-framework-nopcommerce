package pageObject.wordpress;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchButton() {
		waitForElemenClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
	}

	public boolean isPostsDisplayWithPostsTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_RESULT_POST_TITLE, postTitle);
		return isElementDisplay(driver, UserHomePageUI.SEARCH_RESULT_POST_TITLE, postTitle);
	}

	public UserPostDetailPageObject clickToPostsTitle(String postTitle) {
		waitForElemenClickable(driver, UserHomePageUI.SEARCH_RESULT_POST_TITLE, postTitle);
		clickToElement(driver, UserHomePageUI.SEARCH_RESULT_POST_TITLE, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public boolean isPostsInforDisplayWithPostAuthor(String postTitle, String author) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_RESULT_POST_AUTHOR, postTitle, author);
		return isElementDisplay(driver, UserHomePageUI.SEARCH_RESULT_POST_AUTHOR, postTitle, author);
	}

	public boolean isPostsInforDisplayWithTime(String postTitle, String currentDay) {
		isElementDisplay(driver, UserHomePageUI.SEARCH_RESULT_POST_PUBLISH_TIME, postTitle, currentDay);
		return isElementDisplay(driver, UserHomePageUI.SEARCH_RESULT_POST_PUBLISH_TIME, postTitle, currentDay);
	}

	public boolean isNothingFoundMessageDisplay() {
		waitForElementVisible(driver, UserHomePageUI.NOTHING_FOUND_MESSAGE);
		return isElementDisplay(driver, UserHomePageUI.NOTHING_FOUND_MESSAGE);
	}

	public boolean isPageNameDisplayOnMenu(String pageName) {
		waitForElementVisible(driver, UserHomePageUI.MENU_ITEM_BY_TEXT, pageName);
		return isElementDisplay(driver, UserHomePageUI.MENU_ITEM_BY_TEXT, pageName);
	}

	public boolean isPageNameUnDisplayOnMenu(String pageName) {
		boolean check = true;
		List<WebElement> elements = getWebElements(driver, UserHomePageUI.ALL_MENU_ITEM);
		waitForAllElementVisible(driver, elements);
		for (WebElement webElement : elements) {
			if (pageName.equals(webElement.getText())) {
				check = false;
			}
		}
		return check;
	}

	public UserPagesDetailPagePO clickToPageByPageName(String pageName) {
		waitForElemenClickable(driver, UserHomePageUI.MENU_ITEM_BY_TEXT, pageName);
		clickToElement(driver, UserHomePageUI.MENU_ITEM_BY_TEXT, pageName);
		return PageGeneratorManager.getUserPagesDetailPage(driver);
	}

}
