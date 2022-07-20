package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalContants;
import commons.PageGeneratorManager;
import pageObject.admin.AdminDashboardPage;
import pageObject.admin.AdminLoginPage;
import pageObjects.user.UserHomePageObjects;
import pageObjects.user.UserLoginPageObject;

public class Level_07_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String adminEmail, adminPassword, usermail, userPassword;
	private UserHomePageObjects userHomePageObj;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPage adminLoginPage;
	private AdminDashboardPage adminHomePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void BeforeTest(String browserName) {
		driver = GetBrowserDriver(browserName, GlobalContants.USER_URL);
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
		usermail = "te20722@mail.us";
		userPassword = "123456";
		userHomePageObj = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC01_Switch_User_To_Admin_Role() {
		// Home -> login
		userLoginPage = userHomePageObj.clickToLoginLink(driver);

		// login-> customer info
		userHomePageObj = userLoginPage.loginAsUser(usermail, userPassword);

		// anypage -> logout
		userHomePageObj.clickToLogOutLink();

		// switch to admin url-login
		userHomePageObj.openUrl(driver, GlobalContants.ADMIN_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		// login-> dashbroad
		adminHomePage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);

		// dashbroad -> logout
		adminHomePage.clickToLogOutLink();

	}

	@Test
	public void TC02_Login_Account() {
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
