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
import pageObjects.nopComerce.user.UserAddressesPageObject;
import pageObjects.nopComerce.user.UserCustomerInfoPageObject;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import pageObjects.nopComerce.user.UserOrdersPageObject;
import pageObjects.nopComerce.user.UserRegisterPageObject;
import pageObjects.nopComerce.user.UserRewardPointsPageObject;
import utilities.DataFaker;

public class Level_20_Manage_Data_I extends BaseTest {
	private WebDriver driver;
	private DataFaker dataFaker;
	private String email, password;
	private UserHomePageObjects homePageObj;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrdersPageObject orderPage;
	private UserAddressesPageObject addressPage;
	private UserRewardPointsPageObject rewardpointPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		dataFaker = DataFaker.getData();
		email = dataFaker.getEmail();
		password = dataFaker.getPassword();
		homePageObj = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC01_Register_Account() {
		registerPage = homePageObj.clickToRegisterLink(driver);

		registerPage.sendkeyToFirstNameTextbox(dataFaker.getFirstName());
		registerPage.sendkeyToLastNameTextbox(dataFaker.getLastName());
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

	@Test
	public void TC02_Navigation_Page() {
		customerInfoPage = homePageObj.clickToMyAccountLink(driver);

		customerInfoPage.clickToPageAtMyAccountPage(driver, "Orders");
		orderPage = PageGeneratorManager.getUserOrderPage(driver);

		orderPage.clickToPageAtMyAccountPage(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressesPage(driver);

		addressPage.clickToPageAtMyAccountPage(driver, "Reward points");
		rewardpointPage = PageGeneratorManager.getRewardPointPage(driver);

		rewardpointPage.clickToPageAtMyAccountPage(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressesPage(driver);
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
