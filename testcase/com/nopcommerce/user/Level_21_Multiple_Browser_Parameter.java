package com.nopcommerce.user;

import java.util.Random;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Environment;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserAddressesPageObject;
import pageObjects.nopComerce.user.UserCustomerInfoPageObject;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import pageObjects.nopComerce.user.UserOrdersPageObject;
import pageObjects.nopComerce.user.UserRegisterPageObject;
import pageObjects.nopComerce.user.UserRewardPointsPageObject;
import utilities.DataFaker;

public class Level_21_Multiple_Browser_Parameter extends BaseTest {
	private WebDriver driver;
	private DataFaker dataFaker;
	private String firstName, lastName, email, password;
	private UserHomePageObjects homePageObj;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrdersPageObject orderPage;
	private UserAddressesPageObject addressPage;
	private UserRewardPointsPageObject rewardpointPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);
		dataFaker = DataFaker.getData();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		password = dataFaker.getPassword();
		email = dataFaker.getEmail();
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
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
