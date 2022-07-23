package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObjects;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrdersPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserRewardPointsPageObject;

public class Level_09_Dynamic_Locator_RestParam extends BaseTest {
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

		// orderPage = addressPage.clickToOrdersLink(driver);
		// System.out.println("// addresses -> orders");
		//
		// rewardpointPage = orderPage.clickToRewardPointLink(driver);
		// System.out.println("// orders -> reward point");
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
