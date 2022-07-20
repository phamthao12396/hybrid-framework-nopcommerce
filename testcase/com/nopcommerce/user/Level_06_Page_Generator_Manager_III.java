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
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private HomePageObjects homePageObj;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;

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
		System.out.println("1" + firstName);
		System.out.println("2" + customerInfoPage.getFirstNameTextBoxValue("value"));
		Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue("value"), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextBoxValue("value"), lastName);
		Assert.assertEquals(customerInfoPage.getEmailTextBoxValue("value"), email);

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
