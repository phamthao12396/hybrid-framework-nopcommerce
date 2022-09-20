package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import pageObjects.nopComerce.user.UserRegisterPageObject;
import utilities.DataFaker;

public class Level_20_Manage_Data_II extends BaseTest {
	private WebDriver driver;
	private DataFaker dataFaker;
	private String firstName, lastName, email, password;
	private UserHomePageObjects homePageObj;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters({ "browser", "url", "firstName", "lastName", "email", "password" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue, String firstName, String lastName, String email, String password) {
		driver = GetBrowserDriver(browserName, urlValue);
		dataFaker = DataFaker.getData();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		homePageObj = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC01_Register_Account() {
		registerPage = homePageObj.clickToRegisterLink(driver);

		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePageObj = registerPage.clickToLogOutLink(driver);

		loginPage = homePageObj.clickToLoginLink(driver);
		loginPage.sendKeyToEmailTextBox(email);
		loginPage.senKeyToPasswordTextBox(password);
		homePageObj = loginPage.clickToLoginButton();
		Assert.assertTrue(homePageObj.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void AfterTest() {
		closeBrowserAndDriver();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
