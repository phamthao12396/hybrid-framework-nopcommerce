package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class PageGeneratorManager {
	public static HomePageObjects getHomePage(WebDriver driver) {
		return new HomePageObjects(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

}
