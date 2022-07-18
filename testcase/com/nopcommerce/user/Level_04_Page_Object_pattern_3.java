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
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Page_Object_pattern_3 extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, validEmail, invalidEmail, existedEmail, password, invalidPassword, validPassword;
	private HomePageObjects homePageObj;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		firstName = "hoahoa";
		lastName = "kiki";
		password = "";
		invalidPassword = "32123";
		validPassword = "123123";
		validEmail = "rmail" + randomInt() + "@hmail.vn";
		invalidEmail = "fdsaf";
		existedEmail = "rmail" + randomInt() + "@hmail.vn";
		homePageObj = new HomePageObjects(driver);
		homePageObj.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.sendkeyToEmailTextbox(existedEmail);
		registerPage.sendkeyToPasswordTextbox(validPassword);
		registerPage.sendkeyToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogOutLink();
		homePageObj = new HomePageObjects(driver);
	}

	@Test
	public void TC01_Empty_Data() {
		homePageObj.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void TC02_Invalid_Email() {
		homePageObj.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendKeyToEmailTextBox(invalidEmail);
		loginPage.senKeyToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC03_Valid_Email() {
		homePageObj.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendKeyToEmailTextBox(validEmail);
		loginPage.senKeyToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulEmailErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC04_Existed_Email_Without_Password() {
		homePageObj.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendKeyToEmailTextBox(existedEmail);
		loginPage.senKeyToPasswordTextBox(password);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulEmailErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC05_Existed_Email_Wrong_Password() {
		homePageObj.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendKeyToEmailTextBox(existedEmail);
		loginPage.senKeyToPasswordTextBox(invalidPassword);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulEmailErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC06_Existed_Email_Valid_Password() {
		homePageObj.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendKeyToEmailTextBox(existedEmail);
		loginPage.senKeyToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();

		homePageObj = new HomePageObjects(driver);
		Assert.assertTrue(homePageObj.isMyAccountLinkDisplayed());
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
