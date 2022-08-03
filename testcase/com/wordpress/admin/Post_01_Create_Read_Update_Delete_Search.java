package com.wordpress.admin;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.wordpress.admin.AdminDashboardPO;
import pageObject.wordpress.admin.AdminLoginPageObject;
import pageObject.wordpress.admin.AdminPostAddNewPO;
import pageObject.wordpress.admin.PageGeneratorManager;
import reportConfig.ExtentTestManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminPostAddNewPO postAddNewPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPO dashboardPage;
	String username, password, postTitle, postBody, urlPosts;
	Date date;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		date = new Date();
		username = "phamthao12396";
		password = "automation";
		postTitle = "Automation Title " + date.toString();
		postBody = "automation body " + date.toString();
		driver = GetBrowserDriver(browserName, adminUrl);
		log.info("Pre-Condition: Open Browser and Login Admin Page");
		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);

		log.info("Pre-Condition: Input Username: " + username);
		adminLoginPage.enterToUsernameTextbox(username);

		log.info("Pre-Condition: Input Password: " + password);
		adminLoginPage.enterToPasswordTextbox(password);

		log.info("Pre-Condition: Click Login button");
		dashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC01_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Create 01: click To 'Posts' menu");
		urlPosts = dashboardPage.getPageURL(driver);
		dashboardPage.clickToPostsMenu();
		ExtentTestManager.getTest().log(Status.INFO, "Create 02: click 'Add New' button ");
		postAddNewPage = dashboardPage.clickToAddNewButton();
		dashboardPage.SleepInSecond(10);

		ExtentTestManager.getTest().log(Status.INFO, "Create 03: Add Title: " + postTitle);
		postAddNewPage.inputToAddNewPostTitle(postTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Create 04: Add body block: " + postBody);
		postAddNewPage.inputToAddNewPostBody(postBody);

		ExtentTestManager.getTest().log(Status.INFO, "Create 05: click button 'Publish'");
		postAddNewPage.clickToPublishButton();

		ExtentTestManager.getTest().log(Status.INFO, "Create 06: Verify message Post Published");
		assertTrue(postAddNewPage.isPublishedMessageDisplay("Post published."));
	}

	@Test
	public void Post_02_Read(Method method) {

	}

	@Test
	public void Post_03_Update(Method method) {

	}

	@Test
	public void Post_04_Delete() {

	}

	@Test
	public void Post_05_Search() {

	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserAndDriver();
	}
}
