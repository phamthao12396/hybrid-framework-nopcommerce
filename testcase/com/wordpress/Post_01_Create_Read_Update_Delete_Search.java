package com.wordpress;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPageObject;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostsAllPostsPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePageObject;
import pageObject.wordpress.UserPostDetailPageObject;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminPostAddNewPO postAddNewPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPO dashboardPage;
	AdminPostsAllPostsPO adminAllPostsPage;
	UserHomePageObject userHomePage;
	UserPostDetailPageObject userDetailPost;
	String username, password, postTitle, postBody, urlAdminPosts, urlUserHomePage, author, currentDay;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		deleteAllFileInFolder();
		urlUserHomePage = "http://localhost/";
		username = "phamthao12396";
		author = "Automation Study";
		currentDay = getToday();
		password = "automation";
		postTitle = "Automation Title " + randInt();
		postBody = "automation body " + randInt();
		driver = GetBrowserDriver(browserName, adminUrl);
		log.info("Pre-Condition: Open Browser and Login Admin Page");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-Condition: Input Username: " + username);
		adminLoginPage.enterToUsernameTextbox(username);

		log.info("Pre-Condition: Input Password: " + password);
		adminLoginPage.enterToPasswordTextbox(password);

		log.info("Pre-Condition: Click Login button");
		dashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create() {
		log.info("TC01_Create");
		log.info("create 00: save the 'Posts' Menu link");

		log.info("Create 01: click To 'Posts' menu");
		adminAllPostsPage = dashboardPage.clickToPostsMenu();

		log.info("Create 02: click 'Add New' button ");
		urlAdminPosts = dashboardPage.getPageURL(driver);
		postAddNewPage = adminAllPostsPage.clickToAddNewButton();

		log.info("Create 03: close Dialog if appear");
		postAddNewPage.closeDialog();

		log.info("Create 03: Add Title: " + postTitle);
		postAddNewPage.inputToAddNewPostTitle(postTitle);

		log.info("Create 04: Add body block: " + postBody);
		postAddNewPage.inputToAddNewPostBody(postBody);

		log.info("Create 05: click button 'Publish'");
		postAddNewPage.clickToPublishButton();

		log.info("Create 06: Verify message Post Published");
		assertTrue(postAddNewPage.isPublishedMessageDisplay("Post published."));
	}

	@Test
	public void Post_02_Search_And_Read() {
		log.info("TC02_Search_And_Read");
		log.info("Search_And_Read 01: Open Posts Search link");
		adminAllPostsPage = postAddNewPage.openAdminAllPostsPage(urlAdminPosts);

		log.info("Search_And_Read 02: Input Text to search textbox: ");
		adminAllPostsPage.inputToSearchTextbox(postTitle);

		log.info("Search_And_Read 03: Click to 'Search Posts' button ");
		adminAllPostsPage.clickToSearchButton();

		log.info("Search_And_Read 04: Verify Search Table contains title: '" + postTitle + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("title"), postTitle);

		log.info("Search_And_Read 05: Verify Search Table contains Author: '" + author + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("author"), author);

		log.info("Search_And_Read 06: Open End User site");
		userHomePage = adminAllPostsPage.getUserHomePage(driver, urlUserHomePage);

		log.info("Search_And_Read 07: Input Text to search textbox: ");
		userHomePage.inputToSearchTextbox(postTitle);

		log.info("Search_And_Read 08: Click to 'Search Posts' button ");
		userHomePage.clickToSearchButton();

		log.info("Search_And_Read 09: Verify Post information display at Home Page");
		Assert.assertTrue(userHomePage.isPostsDisplayWithPostsTitle(postTitle));
		Assert.assertTrue(userHomePage.isPostsInforDisplayWithPostAuthor(postTitle, author));
		Assert.assertTrue(userHomePage.isPostsInforDisplayWithTime(postTitle, currentDay));

		log.info("Search_And_Read 10: Click to Post title ");
		userDetailPost = userHomePage.clickToPostsTitle(postTitle);

		log.info("Search_And_Read 11: Verify Post information display at Post Detail page");
		Assert.assertTrue(userDetailPost.isPostsDisplayWithPostsTitle(postTitle));
		Assert.assertTrue(userDetailPost.isPostsInforDisplayWithPostAuthor(postTitle, author));
		Assert.assertTrue(userDetailPost.isPostsInforDisplayWithTime(postTitle, currentDay));
	}

	@Test
	public void Post_03_Update() {

	}

	@Test
	public void Post_04_Delete() {

	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserAndDriver();
	}

	public int randInt() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
