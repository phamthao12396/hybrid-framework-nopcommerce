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

public class Level_07_Navigation_page extends BaseTest {
	private WebDriver driver;
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
		registerPage = homePageObj.clickToRegisterLink(driver);

		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePageObj = registerPage.clickToLogOutLink(driver);
	}

	@Test
	public void TC02_Login_Account() {
		loginPage = homePageObj.clickToLoginLink(driver);
		loginPage.sendKeyToEmailTextBox(email);
		loginPage.senKeyToPasswordTextBox(password);

		homePageObj = loginPage.clickToLoginButton();
		Assert.assertTrue(homePageObj.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC03_Veriy_Account_Info() {
		customerInfoPage = homePageObj.clickToMyAccountLink(driver);
		Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue("value"), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextBoxValue("value"), lastName);
		Assert.assertEquals(customerInfoPage.getEmailTextBoxValue("value"), email);

	}

	@Test
	public void TC04_Navigation_Page() {

		orderPage = customerInfoPage.clickToOrdersLink(driver);
		System.out.println("// customer info -> orders");

		addressPage = orderPage.clickToAddressesLink(driver);
		System.out.println("// orders -> addresses");

		rewardpointPage = addressPage.clickToRewardPointLink(driver);
		System.out.println("// addresses -> reward points");

		addressPage = rewardpointPage.clickToAddressesLink(driver);
		System.out.println("// reward point -> addresses");

		orderPage = addressPage.clickToOrdersLink(driver);
		System.out.println("// addresses -> orders");

		rewardpointPage = orderPage.clickToRewardPointLink(driver);
		System.out.println("// orders -> reward point");
	}

	@AfterClass
	public void AfterTest() {
		// driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
