package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import pageObjects.nopComerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_16_Extend_Report_V5 extends BaseTest {
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
	public void TC01_Register_Account(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC01_Register_Account");
		ExtentTestManager.getTest().log(Status.INFO, "NewCustomer - Step 01: Open 'New Customer' page");
		registerPage = homePageObj.clickToRegisterLink(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Register: Send key to first name textbox: " + firstName);
		registerPage.sendkeyToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register: Send key to last name textbox: " + lastName);
		registerPage.sendkeyToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register: Send key to email textbox: " + email);
		registerPage.sendkeyToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register: Send key to password textbox: " + password);
		registerPage.sendkeyToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register: Send key to confirm password textbox: " + password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register: click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register: Assert - get Register success message ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
	}

	@Test
	public void TC02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC02_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login: log out after register success");
		homePageObj = registerPage.clickToLogOutLink(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login: click to login link");
		loginPage = homePageObj.clickToLoginLink(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login: send key to email textbox: " + email);
		loginPage.sendKeyToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Login: send key to password textbox: " + password);
		loginPage.senKeyToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login: click to 'Login' button");
		homePageObj = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login: Assert - My Account Link is display");
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
