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

}
