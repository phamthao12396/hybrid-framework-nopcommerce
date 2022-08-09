package com.wordpress;

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
import pageObject.wordpress.AdminPagesAddNewPO;
import pageObject.wordpress.AdminPagesPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePageObject;

public class Page_Create_Search_Read_Update_Delete extends BaseTest {
	WebDriver driver;
	AdminDashboardPO adminDashBoardPage;
	AdminPagesPO adminPages;
	AdminPagesAddNewPO adminAddNew;
	UserHomePageObject userHomePage;
	AdminLoginPageObject adminLoginPage;
	private String pageName, pageDetail, allPagesURL, authorName, publishedDate, urlUserHomePage, username, password;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		authorName = "Automation Study";
		urlUserHomePage = "http://localhost/";
		username = "phamthao12396";
		password = "automation";
		pageName = "Menu Name " + randInt();
		pageDetail = "Page detail " + randInt();
		publishedDate = getCurrentYear() + "/" + getCurrentMonth() + "/" + getCurrentDay();
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
	public void TC01_Create() {
		log.info("Create 01: click to 'Pages'");
		adminDashBoardPage.clickToMenuByText("Pages");
		adminPages = PageGeneratorManager.getAdminPagesPage(driver);

		log.info("Create 01:get allPagesURL");
		allPagesURL = adminPages.getPageURL(driver);

		log.info("Create 01: click to 'Add New' button and get 'AddNew' Page");
		adminAddNew = adminPages.clickToAddNewButton();

		log.info("Create 03: close Dialog if appear");
		adminAddNew.closeDialog();

		log.info("Create 01: input Page Title");
		adminAddNew.inputToPageTitleTextbox(pageName);

		log.info("Create 01: click to Category details");
		adminAddNew.clickToPageDetailArea();

		log.info("Create 01: input Category details");
		adminAddNew.inputToPageDetailArea(pageDetail);

		log.info("Create 01: click to 'Publish' button");
		adminAddNew.clickToPublishButton();

		log.info("Create 01: click to 'Publish' confirm button");
		adminAddNew.clickToPublishConfirmButton();

		log.info("Create 01: verify 'Page published.' meassage is display ");
		Assert.assertTrue(adminAddNew.isPublishedOrUpdatedMessageDisplay("Page published."));

	}

	@Test
	public void TC02_Search_And_View() {
		log.info("Create 01: Open 'Pages' page ");
		adminAddNew.openUrl(driver, allPagesURL);
		adminPages = PageGeneratorManager.getAdminPagesPage(driver);

		log.info("Create 01: input category name to Search textbox: " + pageName);
		adminPages.inputTextToSearchTextBox(pageName);

		log.info("Create 01: click to Search Pages button ");
		adminPages.clickToSearchButton();

		log.info("Create 01: Verify Search table contains category name: " + pageName);
		Assert.assertEquals(adminPages.getCellValueByID("title"), pageName);

		log.info("Create 01: Verify Search table contains author name: " + authorName);
		Assert.assertEquals(adminPages.getCellValueByID("author"), authorName);

		log.info("Create 01: Verify Search table contains published date: " + publishedDate);
		Assert.assertTrue(adminPages.getCellValueByID("date").contains(publishedDate));

		log.info("Create 01: Open User Home Page ");
		adminPages.getUserHomePage(driver, urlUserHomePage);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// log.info("Create 01: Verify Menu item contains Page name: " + pageName);
		// Assert.assertTrue(userHomePage.isPageNameDisplayOnMenu(pageName));
		//
		// log.info("Create 01: click to Page name: " + pageName);
		// userHomePage.clickToPageByPageName(pageName);
		//
		// log.info("Create 01: Verify informations in '" + pageName + "'");
		// Assert.assertTrue(userHomePage.isTextDisplayOnDetailPage(pageName));
		// Assert.assertTrue(userHomePage.isTextDisplayOnDetailPage(pageDetail));

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
