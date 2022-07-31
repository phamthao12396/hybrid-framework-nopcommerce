package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.common.Register_Account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import reportConfig.ExtentTestManager;

public class Level_16_Share_Data_A extends BaseTest {
	private WebDriver driver;
	private UserHomePageObjects homePageObj;
	private UserLoginPageObject loginPage;
	private String email, password;

	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		deleteAllFileInFolder();
	}

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		homePageObj = PageGeneratorManager.getUserHomePage(driver);
		email = Register_Account.email;
		password = Register_Account.password;
	}

	@Test
	public void TC01_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC01_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login: click to login link");
		loginPage = homePageObj.clickToLoginLink(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login: send key to email textbox: " + email);
		loginPage.sendKeyToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Login: send key to password textbox: " + password);
		loginPage.senKeyToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login: click to 'Login' button");
		homePageObj = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login: Assert - My Account Link is display");
		Assert.assertTrue(homePageObj.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

}
