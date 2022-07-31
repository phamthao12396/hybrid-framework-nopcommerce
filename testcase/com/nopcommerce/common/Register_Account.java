package com.nopcommerce.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserRegisterPageObject;

public class Register_Account extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName;
	public static String email, password;
	private UserHomePageObjects homePageObj;
	private UserRegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void Register_Acoount(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		firstName = "Naomi";
		lastName = "Campbell";
		password = "123123";
		email = "email" + randomInt() + "@mail.net";
		homePageObj = PageGeneratorManager.getUserHomePage(driver);
		homePageObj.clickToRegisterLink(driver);
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);

		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
