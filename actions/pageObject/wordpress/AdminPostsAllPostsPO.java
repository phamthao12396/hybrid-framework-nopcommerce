package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostsAllPostsPageUI;

public class AdminPostsAllPostsPO extends BasePage {
	WebDriver driver;

	public AdminPostsAllPostsPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElemenClickable(driver, AdminPostsAllPostsPageUI.POSTS_ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostsAllPostsPageUI.POSTS_ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostsAddNewPage(driver);
	}

	public void inputToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostsAllPostsPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostsAllPostsPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchButton() {
		waitForElemenClickable(driver, AdminPostsAllPostsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostsAllPostsPageUI.SEARCH_BUTTON);
	}

	public String getCellValueByID(String postTitle) {
		waitForElementVisible(driver, AdminPostsAllPostsPageUI.TABLE_COLUMN_INDEX_BY_ID, postTitle);
		int columnIndex = getElementNumber(driver, AdminPostsAllPostsPageUI.TABLE_COLUMN_INDEX_BY_ID, postTitle) + 1;
		return getElementText(driver, AdminPostsAllPostsPageUI.TABLE_ROW_VALUE_BY_COLUM_INDEX, String.valueOf(columnIndex));
	}

	public AdminPostAddNewPO clickToPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostsAllPostsPageUI.POST_LINK_BY_TITLE, postTitle);
		clickToElement(driver, AdminPostsAllPostsPageUI.POST_LINK_BY_TITLE, postTitle);
		return PageGeneratorManager.getAdminPostsAddNewPage(driver);
	}

	public void checktoCheckboxByTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostsAllPostsPageUI.CHECKBOX_BY_TITLE_POST, postTitle);
		checkToRadioOrCheckbox(driver, AdminPostsAllPostsPageUI.CHECKBOX_BY_TITLE_POST, postTitle);
	}

	public void selectActionByText(String action) {
		waitForElementVisible(driver, AdminPostsAllPostsPageUI.SELECT_ACTION);
		selectItemInDefaultDropdown(driver, AdminPostsAllPostsPageUI.SELECT_ACTION, action);
	}

	public void clickToApplyButton() {
		waitForElemenClickable(driver, AdminPostsAllPostsPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostsAllPostsPageUI.APPLY_BUTTON);
	}

	public boolean isNoPostFoundMessageDisplay() {
		waitForElementVisible(driver, AdminPostsAllPostsPageUI.NO_POSTS_FOUND_MESSAGE);
		return isElementDisplay(driver, AdminPostsAllPostsPageUI.NO_POSTS_FOUND_MESSAGE);
	}

}
