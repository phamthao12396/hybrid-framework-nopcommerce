package com.wordpress;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPageObject;
import pageObject.wordpress.AdminUsersPO;
import pageObject.wordpress.PageGeneratorManager;

public class User_Manage_With_DB extends BaseTest {
	WebDriver driver;
	AdminDashboardPO adminDashBoardPage;
	AdminLoginPageObject adminLoginPage;
	AdminUsersPO adminUsersPage;
	private String username, password;
	private Integer UsersAtUI, UsersAtDB;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		username = "phamthao12396";
		password = "123123";
		driver = GetBrowserDriver(browserName, adminUrl);
		log.info("Pre-Condition: Open Browser and Login Admin Page");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-Condition: Input Username: " + username);
		adminLoginPage.enterToUsernameTextbox(username);

		log.info("Pre-Condition: Input Password: " + password);
		adminLoginPage.enterToPasswordTextbox(password);

		log.info("Pre-Condition: Click Login button");
		adminDashBoardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void TC01_Check_User_At_UI_And_DB() {

		log.info("Create 01: click to 'Users'");
		adminDashBoardPage.clickToMenuByText("Users");
		adminUsersPage = PageGeneratorManager.getAdminUsersPage(driver);

		log.info("Create 02:get all users at UI");
		UsersAtUI = adminUsersPage.getAllUsersAtUI(driver);

		log.info("Create 03: get all users at DB");
		UsersAtDB = adminUsersPage.getAllUsersAtDB(driver);

		log.info("Create 04: verify User at UI and DB");
		assertEquals(UsersAtUI, UsersAtDB);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int randInt() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
