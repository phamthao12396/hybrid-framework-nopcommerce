package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.techpanda.admin.AdminHomePageUI;

public class AdminHomePage extends BasePage {
	WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void closeAlertIfPresence(WebDriver driver) {
		areJQueryAndJSLoadedSuccess(driver);
		List<WebElement> alert = getWebElements(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
		if (alert.size() != 0) {
			clickToElement(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
			// cancelAlert(driver);
		}
	}

	public void sendKeytoFilterTextboxByName(String columnName, String keytoSend) {
		waitForElementVisible(driver, AdminHomePageUI.COLUMN_INDEX_BY_NAME, columnName);
		List<WebElement> element = getWebElements(driver, AdminHomePageUI.COLUMN_INDEX_BY_NAME, columnName);
		int cols = element.size() + 1;
		waitForElementVisible(driver, AdminHomePageUI.FILTER_TEXTBOX_BY_COLUMN_INDEX, String.valueOf(cols));
		sendkeyToElement(driver, AdminHomePageUI.FILTER_TEXTBOX_BY_COLUMN_INDEX, keytoSend, String.valueOf(cols));
	}

	public void clickToFilterActionByName(String actionName) {
		waitForElementVisible(driver, AdminHomePageUI.FILTER_BUTTON_BY_NAME, actionName);
		clickToElement(driver, AdminHomePageUI.FILTER_BUTTON_BY_NAME, actionName);
		areJQueryAndJSLoadedSuccess(driver);
	}

	public String getPageResult() {
		waitForElementVisible(driver, AdminHomePageUI.PAGE_RESULT);
		String text = getElementText(driver, AdminHomePageUI.PAGE_RESULT);
		String[] arr = text.split("\\s");
		return arr[2];
	}

	public void goToPageByPageNumber(String pageNumber) {
		waitForElementVisible(driver, AdminHomePageUI.PAGE_TEXTBOX);
		sendkeyToElement(driver, AdminHomePageUI.PAGE_TEXTBOX, pageNumber);
		pressKeyboardToElement(driver, AdminHomePageUI.PAGE_TEXTBOX, Keys.ENTER);
		SleepInSecond(1);
	}

	public List<String> getAllCustomer() {
		int page = Integer.parseInt(getPageResult());
		List<String> allCustomers = new ArrayList<String>();

		for (int i = 1; i <= page; i++) {
			goToPageByPageNumber(String.valueOf(i));
			List<WebElement> numbers = getWebElements(driver, AdminHomePageUI.ALL_CUSTOMER_DISPLAY);
			for (WebElement customer : numbers) {
				allCustomers.add(customer.getText());
			}
		}
		return allCustomers;
	}

}
