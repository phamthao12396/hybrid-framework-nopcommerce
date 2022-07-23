package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.UserHomePageObjects;
import pageObjects.user.UserRegisterPageObject;

public class Level_04_Page_Object_pattern_2 extends BaseTest {
	private WebDriver driver;
	private String email;
	private UserHomePageObjects homePageObj;
	private UserRegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);

		email = "rmail" + randomInt() + "@hmail.vn";
		homePageObj = new UserHomePageObjects(driver);
	}

	@Test
	public void TC01_Empty_Data() {

		homePageObj.clickToRegisterLink(driver);

		registerPage = new UserRegisterPageObject(driver);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFistNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void TC02_Invalid_Data() {
		homePageObj.clickToRegisterLink(driver);
		registerPage = new UserRegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox("fisrt Name");
		registerPage.sendkeyToLastNameTextbox("fisr Name");
		registerPage.sendkeyToEmailTextbox("fisrtName");
		registerPage.sendkeyToPasswordTextbox("1231231");
		registerPage.sendkeyToConfirmPasswordTextbox("1231231");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void TC03_Success() {

		homePageObj.clickToRegisterLink(driver);
		registerPage = new UserRegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox("fisrt Name");
		registerPage.sendkeyToLastNameTextbox("fisr Name");
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox("1231231");
		registerPage.sendkeyToConfirmPasswordTextbox("1231231");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogOutLink(driver);

		homePageObj = new UserHomePageObjects(driver);
	}

	@Test
	public void TC04_Existing_Email() {

		homePageObj.clickToRegisterLink(driver);
		registerPage = new UserRegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox("fisrt Name");
		registerPage.sendkeyToLastNameTextbox("fisr Name");
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox("1231231");
		registerPage.sendkeyToConfirmPasswordTextbox("1231231");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getExistedEmailErrorMessage(), "The specified email already exists");
	}

	@Test
	public void TC05_Password_less_than_6() {

		homePageObj.clickToRegisterLink(driver);
		registerPage = new UserRegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox("fisrt Name");
		registerPage.sendkeyToLastNameTextbox("fisr Name");
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox("123");
		registerPage.sendkeyToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC06_Invalid_Confirm_Password() {

		homePageObj.clickToRegisterLink(driver);
		registerPage = new UserRegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox("fisrt Name");
		registerPage.sendkeyToLastNameTextbox("fisr Name");
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox("1231231");
		registerPage.sendkeyToConfirmPasswordTextbox("3212312");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(99);
	}
}
