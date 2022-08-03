package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.common.Register_Share_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.UserHomePageObjects;
import reportConfig.ExtentTestManager;

public class Level_17_Close_Browser_Driver extends BaseTest {
	private WebDriver driver;
	private UserHomePageObjects homePageObj;

	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		deleteAllFileInFolder();
	}

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String urlValue) {
		driver = GetBrowserDriver(browserName, urlValue);
		homePageObj = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC01_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC01_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login: set cookies");
		Set<Cookie> cookies = Register_Share_Cookie.loggedCookies;
		// driver = null;
		homePageObj.setAllCookies(driver, cookies);

		ExtentTestManager.getTest().log(Status.INFO, "Login: refresh page");
		homePageObj.refreshPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login: Assert - check My Account Link is display");
		Assert.assertTrue(homePageObj.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void AfterTest() {
		closeBrowserAndDriver();
	}

}
