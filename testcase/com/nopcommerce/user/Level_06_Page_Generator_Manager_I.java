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
import commons.PageGeneratorManager;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
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
		homePageObj = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC01_Register_Account() {
		registerPage = homePageObj.clickToRegisterLink();

		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.sendkeyToEmailTextbox(email);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePageObj = registerPage.clickToLogOutLink();
	}

	@Test
	public void TC02_Login_Account() {

		loginPage = homePageObj.clickToLoginLink();
		loginPage.sendKeyToEmailTextBox(email);
		loginPage.senKeyToPasswordTextBox(password);
		homePageObj = loginPage.clickToLoginButton();
	}

	@Test
	public void TC03_Veriy_Account_Info() {
		customerInfoPage = homePageObj.clickToMyAccountLink();
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
