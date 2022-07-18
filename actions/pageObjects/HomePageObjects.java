package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUIs;

public class HomePageObjects extends BasePage {
	private WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElemenClickable(driver, HomePageUIs.REGISTER_LINK);
		clickToElement(driver, HomePageUIs.REGISTER_LINK);
	}

}
