package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;

public class Level_05_Page_Factory extends BaseTest {
	private WebDriver driver;
	private String validEmail, invalidEmail, validPassword;
	private HomePageObject homePageObj;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);

		validPassword = "123123";
		validEmail = "rmail" + randomInt() + "@hmail.vn";
		invalidEmail = "fdsaf";
		homePageObj = new HomePageObject(driver);
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

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(99);
	}
}
