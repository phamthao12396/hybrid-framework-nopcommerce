package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import pageObjects.nopComerce.user.UserRegisterPageObject;

public class Level_15_Attach_Screenshots extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObjects homePageObj;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		deleteAllFileInFolder();
	}

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		firstName = "Thao";
		lastName = "Pham";
		password = "123123";
		email = "email" + randomInt() + "@hmail.vn";
		homePageObj = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC01_Register_Account() {
		log.info("Register: Click To Register link");
		registerPage = homePageObj.clickToRegisterLink(driver);

		log.info("Register: Send key to first name textbox: " + firstName);
		registerPage.sendkeyToFirstNameTextbox(firstName);

		log.info("Register: Send key to last name textbox: " + lastName);
		registerPage.sendkeyToLastNameTextbox(lastName);

		log.info("Register: Send key to email textbox: " + email);
		registerPage.sendkeyToEmailTextbox(email);

		log.info("Register: Send key to password textbox: " + password);
		registerPage.sendkeyToPasswordTextbox(password);

		log.info("Register: Send key to confirm password textbox: " + password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		log.info("Register: click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register: Assert - get Register success message ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
	}

	@Test
	public void TC02_Login() {
		log.info("Login: log out after register success");
		homePageObj = registerPage.clickToLogOutLink(driver);

		log.info("Login: click to login link");
		loginPage = homePageObj.clickToLoginLink(driver);

		log.info("Login: send key to email textbox: " + email);
		loginPage.sendKeyToEmailTextBox(email);

		log.info("Login: send key to password textbox: " + password);
		loginPage.senKeyToPasswordTextBox(password);

		log.info("Login: click to 'Login' button");
		homePageObj = loginPage.clickToLoginButton();

		log.info("Login: Assert - My Account Link is display");
		Assert.assertTrue(homePageObj.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
