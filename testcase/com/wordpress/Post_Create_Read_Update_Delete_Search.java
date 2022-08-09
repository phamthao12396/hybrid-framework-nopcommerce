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

public class Post_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminPostAddNewPO postAddNewPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPO dashboardPage;
	AdminPostsAllPostsPO adminAllPostsPage;
	UserHomePageObject userHomePage;
	UserPostDetailPageObject userDetailPost;
	String username, password, postTitle, editTitle, editBody, postBody, urlAllPostsPage, urlAdminPage, urlUserHomePage, author, currentDay;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		deleteAllFileInFolder();
		urlAdminPage = adminUrl;
		urlUserHomePage = "http://localhost/";
		username = "phamthao12396";
		author = "Automation Study";
		currentDay = getToday();
		password = "automation";
		postTitle = "Automation Title " + randInt();
		postBody = "automation body " + randInt();
		editTitle = "Edit Title" + randInt();
		editBody = "Edit Body" + randInt();
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
		log.info("Create 01: click To 'Posts' menu");
		dashboardPage.clickToMenuByText("Posts");
		adminAllPostsPage = PageGeneratorManager.getAdminPostsAllPostsPage(driver);

		urlAllPostsPage = dashboardPage.getPageURL(driver);

		log.info("Create 02: click 'Add New' button ");
		postAddNewPage = adminAllPostsPage.clickToAddNewButton();

		log.info("Create 03: close Dialog if appear");
		postAddNewPage.closeDialog();

		log.info("Create 03: Add Title: " + postTitle);
		postAddNewPage.inputToAddNewPostTitle(postTitle);

		log.info("Create 04.1: click to body block ");
		postAddNewPage.clickToAddNewPostBody();

		log.info("Create 04.2: Add body block: " + postBody);
		postAddNewPage.inputToAddNewPostBody(postBody);

		log.info("Create 05: click button 'Publish'");
		postAddNewPage.clickToPublishOrUpdateButton();
		log.info("Create 05: click button 'Publish' confirm");
		postAddNewPage.clickToPublishConfirmButton();

		log.info("Create 06: Verify message Post Published");
		assertTrue(postAddNewPage.isPublishedAndUpdatedMessageDisplay("Post published."));
	}

	@Test
	public void Post_02_Search_And_Read() {
		log.info("TC02_Search_And_Read");
		log.info("Search_And_Read 01: Open Posts Search link");
		adminAllPostsPage = postAddNewPage.openAdminAllPostsPage(urlAllPostsPage);

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
		log.info("Update 01: Open Admin site");
		dashboardPage = userDetailPost.getAdminPage(driver, urlAdminPage);

		log.info("Update 02: click To 'Posts' menu");
		dashboardPage.clickToMenuByText("Posts");
		adminAllPostsPage = PageGeneratorManager.getAdminPostsAllPostsPage(driver);

		log.info("Update 03: Input Text to search textbox: ");
		adminAllPostsPage.inputToSearchTextbox(postTitle);

		log.info("Update 04: Click to 'Search Posts' button ");
		adminAllPostsPage.clickToSearchButton();

		log.info("Update 05: Verify Search Table contains title: '" + postTitle + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("title"), postTitle);

		log.info("Update 06: Verify Search Table contains Author: '" + author + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("author"), author);

		log.info("Update 07: Click to Post title and get 'Edit Post Page'");
		postAddNewPage = adminAllPostsPage.clickToPostTitle(postTitle);

		log.info("Update 08: Edit Post Title");
		postAddNewPage.inputToAddNewPostTitle(editTitle);

		log.info("Update 09.1: Clear Text at Post Body");

		log.info("Update 09.2: Edit Post Body");
		postAddNewPage.inputToAddNewPostBody(editBody);

		log.info("Update 10: Click Update button");
		postAddNewPage.clickToPublishOrUpdateButton();

		log.info("Update 11: Verify message 'Posts Updated'");
		Assert.assertTrue(postAddNewPage.isPublishedAndUpdatedMessageDisplay("Post updated."));

		log.info("Update 12: Open Posts Search link");
		adminAllPostsPage = postAddNewPage.openAdminAllPostsPage(urlAllPostsPage);

		log.info("Update 13: Input Text to search textbox: ");
		adminAllPostsPage.inputToSearchTextbox(editTitle);

		log.info("Update 14: Click to 'Search Posts' button ");
		adminAllPostsPage.clickToSearchButton();

		log.info("Update 15: Verify Search Table contains title: '" + editTitle + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("title"), editTitle);

		log.info("Update 16: Verify Search Table contains Author: '" + author + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("author"), author);

		log.info("Update 17: Open End User site");
		userHomePage = adminAllPostsPage.getUserHomePage(driver, urlUserHomePage);

		log.info("Update 18: Input Text to search textbox: ");
		userHomePage.inputToSearchTextbox(editTitle);

		log.info("Update 19: Click to 'Search Posts' button ");
		userHomePage.clickToSearchButton();

		log.info("Update 20: Verify Post information display at Home Page");
		Assert.assertTrue(userHomePage.isPostsDisplayWithPostsTitle(editTitle));
		Assert.assertTrue(userHomePage.isPostsInforDisplayWithPostAuthor(editTitle, author));
		Assert.assertTrue(userHomePage.isPostsInforDisplayWithTime(editTitle, currentDay));

		log.info("Update 21: Click to Post title ");
		userDetailPost = userHomePage.clickToPostsTitle(editTitle);

		log.info("Update 22: Verify Post information display at Post Detail page");
		Assert.assertTrue(userDetailPost.isPostsDisplayWithPostsTitle(editTitle));
		Assert.assertTrue(userDetailPost.isPostsInforDisplayWithPostAuthor(editTitle, author));
		Assert.assertTrue(userDetailPost.isPostsInforDisplayWithTime(editTitle, currentDay));
	}

	@Test
	public void Post_04_Delete() {
		log.info("Delete 01: Open Admin site");
		dashboardPage = userDetailPost.getAdminPage(driver, urlAdminPage);

		log.info("Delete 02: click To 'Posts' menu");
		dashboardPage.clickToMenuByText("Posts");
		adminAllPostsPage = PageGeneratorManager.getAdminPostsAllPostsPage(driver);

		log.info("Delete 03: Input Text to search textbox: ");
		adminAllPostsPage.inputToSearchTextbox(editTitle);

		log.info("Delete 04: Click to 'Search Posts' button ");
		adminAllPostsPage.clickToSearchButton();

		log.info("Delete 05: Verify Search Table contains title: '" + editTitle + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("title"), editTitle);

		log.info("Delete 06: Verify Search Table contains Author: '" + author + "'");
		Assert.assertEquals(adminAllPostsPage.getCellValueByID("author"), author);

		log.info("Delete 07: Click to checkbox");
		adminAllPostsPage.checktoCheckboxByTitle(editTitle);

		log.info("Delete 08: click to dropdown and select action");
		adminAllPostsPage.selectActionByText("Move to Trash");

		log.info("Delete 09: click apply button");
		adminAllPostsPage.clickToApplyButton();

		log.info("Delete 10: Input Text to search textbox: ");
		adminAllPostsPage.inputToSearchTextbox(editTitle);

		log.info("Delete 11: Click to 'Search Posts' button ");
		adminAllPostsPage.clickToSearchButton();

		log.info("Delete 12: Verify Search Table contains text: 'No posts found.'");
		Assert.assertTrue(adminAllPostsPage.isNoPostFoundMessageDisplay());

		log.info("Delete 13: Open End User site");
		userHomePage = adminAllPostsPage.getUserHomePage(driver, urlUserHomePage);

		log.info("Delete 14: Input Text to search textbox: ");
		userHomePage.inputToSearchTextbox(editTitle);

		log.info("Delete 15: Click to 'Search Posts' button ");
		userHomePage.clickToSearchButton();

		log.info("Delete 16: Verify Post information undisplay at Home Page");
		Assert.assertTrue(userHomePage.isNothingFoundMessageDisplay());

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
