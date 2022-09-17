package pageObjects.nopComerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.ComputerPageUI;

public class ComputerPageObject extends BasePage {
	WebDriver driver;

	public ComputerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ComDesktopsPageObject clickToSublistByText(String sublistText) {
		waitForElemenClickable(driver, ComputerPageUI.SUBLIST_BY_TEXT, sublistText);
		clickToElement(driver, ComputerPageUI.SUBLIST_BY_TEXT, sublistText);
		return PageGeneratorManager.getComDesktopsPageObject(driver);
	}

}
