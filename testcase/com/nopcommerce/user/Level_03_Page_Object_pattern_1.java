package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObjects;
import pageObjects.RegisterPageObject;
import pageUIs.RegisterPageUI;

public class Level_03_Page_Object_pattern_1 extends BasePage {
	private WebDriver driver;
	private String email;
	private HomePageObjects homePageObj;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void BeforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		email = "rmail" + randomInt() + "@hmail.vn";
		openUrl(driver, "https://demo.nopcommerce.com/");
		homePageObj = new HomePageObjects(driver);
	}

	@Test
	public void TC01_Empty_Data() {

		homePageObj.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFistNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void TC02_Invalid_Data() {
		homePageObj.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

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

		homePageObj.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox("fisrt Name");
		registerPage.sendkeyToLastNameTextbox("fisr Name");
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox("1231231");
		registerPage.sendkeyToConfirmPasswordTextbox("1231231");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogOutLink();

		homePageObj = new HomePageObjects(driver);
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
