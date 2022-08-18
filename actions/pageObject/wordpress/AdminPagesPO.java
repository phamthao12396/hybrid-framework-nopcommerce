package pageObject.wordpress;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.wordpress.AdminPagesUI;

public class AdminPagesPO extends BasePage {
	WebDriver driver;

	public AdminPagesPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPagesAddNewPO clickToAddNewButton() {
		waitForElemenClickable(driver, AdminPagesUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPagesUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPagesAddNewPage(driver);
	}

	public void inputTextToSearchTextBox(String pageName) {
		waitForElementVisible(driver, AdminPagesUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPagesUI.SEARCH_TEXTBOX, pageName);
	}

	public void clickToSearchButton() {
		waitForElemenClickable(driver, AdminPagesUI.SEARCH_PAGES_BUTTON);
		clickToElement(driver, AdminPagesUI.SEARCH_PAGES_BUTTON);
	}

	public String getCellValueByID(String string) {
		int number = getElementNumber(driver, AdminPagesUI.COLUMN_INDEX_BY_ID, string) + 1;
		return getElementText(driver, AdminPagesUI.CELL_VALUE_BY_INDEX, String.valueOf(number));
	}

	public void clickToPagesTitle(String pageName) {
		waitForElemenClickable(driver, AdminPagesUI.PAGE_TITLE_BY_TEXT, pageName);
		clickToElement(driver, AdminPagesUI.PAGE_TITLE_BY_TEXT, pageName);
	}

	public void clickToCheckboxByText(String editPageName) {
		waitForElemenClickable(driver, AdminPagesUI.CHECKBOX_BY_TITLE_NAME, editPageName);
		checkToRadioOrCheckbox(driver, AdminPagesUI.CHECKBOX_BY_TITLE_NAME, editPageName);
	}

	public void selectAtionByText(String action) {
		waitForElementVisible(driver, AdminPagesUI.SELECTOR_ACTION_TOP);
		selectItemInDefaultDropdown(driver, AdminPagesUI.SELECTOR_ACTION_TOP, action);
	}

	public void clickToApplyButton() {
		waitForElemenClickable(driver, AdminPagesUI.APPLY_BUTTON);
		clickToElement(driver, AdminPagesUI.APPLY_BUTTON);

	}

	public boolean isSearchNotFoundMessageDisplay() {
		waitForElementVisible(driver, AdminPagesUI.SEARCH_NOT_FOUND_MESSAGE);
		return isElementDisplay(driver, AdminPagesUI.SEARCH_NOT_FOUND_MESSAGE);
	}

	public boolean isDeleteSuccessMessageDisplay() {
		waitForElementVisible(driver, AdminPagesUI.DELETE_SUCCESS_MESSAGE);
		return isElementDisplay(driver, AdminPagesUI.DELETE_SUCCESS_MESSAGE);
	}

}
