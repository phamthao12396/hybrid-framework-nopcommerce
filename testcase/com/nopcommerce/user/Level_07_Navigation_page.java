package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointsPageObject;

public class Level_07_Navigation_page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private HomePageObjects homePageObj;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private OrdersPageObject orderPage;
	private AddressesPageObject addressPage;
	private RewardPointsPageObject rewardpointPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		firstName = "Thao";
		lastName = "Pham";
		password = "123123";
		email = "email" + randomInt() + "@hmail.vn";
		homePageObj = new HomePageObjects(driver);
	}

	@Test
	public void TC01_Register_Account() {
		homePageObj.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogOutLink();

		homePageObj = new HomePageObjects(driver);
	}

	@Test
	public void TC02_Login_Account() {
		homePageObj.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendKeyToEmailTextBox(email);
		loginPage.senKeyToPasswordTextBox(password);
		loginPage.clickToLoginButton();

		homePageObj = new HomePageObjects(driver);
		Assert.assertTrue(homePageObj.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC03_Veriy_Account_Info() {
		homePageObj.clickToMyAccountLink();
		customerInfoPage = new CustomerInfoPageObject(driver);
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
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
