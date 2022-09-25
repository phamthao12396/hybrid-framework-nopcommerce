package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import pageObjects.nopComerce.user.UserRegisterPageObject;

public class Level_20_Manage_Data_IV extends BaseTest {
	private WebDriver driver;
	private UserDataMapper userData;
	private String email;
	private UserHomePageObjects homePageObj;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		homePageObj = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getData();
		System.out.println("email " + userData.getEmail());
		email = userData.getEmail() + randomInt() + "@fakemail.com";
	}

	@Test
	public void TC01_Register_Account() {
		registerPage = homePageObj.clickToRegisterLink(driver);

		registerPage.sendkeyToFirstNameTextbox(userData.getFirstName());
		registerPage.sendkeyToLastNameTextbox(userData.getLastName());
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox(userData.getPassword());
		registerPage.sendkeyToConfirmPasswordTextbox(userData.getPassword());

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePageObj = registerPage.clickToLogOutLink(driver);

		loginPage = homePageObj.clickToLoginLink(driver);
		loginPage.sendKeyToEmailTextBox(email);
		loginPage.senKeyToPasswordTextBox(userData.getPassword());
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
