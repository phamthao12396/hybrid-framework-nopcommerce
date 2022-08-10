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
import pageObject.wordpress.UserPagesDetailPagePO;

public class Page_Create_Search_Read_Update_Delete extends BaseTest {
	WebDriver driver;
	AdminDashboardPO adminDashBoardPage;
	AdminPagesPO adminPages;
	AdminPagesAddNewPO adminAddNew;
	UserHomePageObject userHomePage;
	AdminLoginPageObject adminLoginPage;
	UserPagesDetailPagePO userDetailPage;
	private String pageName, pageDetail, allPagesURL, authorName, publishedDate, urlUserHomePage, username, password, editPageName, editPageDetail;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		authorName = "Automation Study";
		urlUserHomePage = "http://localhost/";
		username = "phamthao12396";
		password = "automation";
		pageName = "Menu Name " + randInt();
		pageDetail = "Page detail " + randInt();
		editPageName = "Menu Name " + randInt();
		editPageDetail = "Page detail " + randInt();
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

		log.info("Create 02:get allPagesURL");
		allPagesURL = adminPages.getPageURL(driver);

		log.info("Create 03: click to 'Add New' button and get 'AddNew' Page");
		adminAddNew = adminPages.clickToAddNewButton();

		log.info("Create 04: close Dialog if appear");
		adminAddNew.closeDialog();

		log.info("Create 05: input Page Title");
		adminAddNew.inputToPageTitleTextbox(pageName);

		log.info("Create 06: click to Page details");
		adminAddNew.clickToPageDetailArea();

		log.info("Create 07: input Page details");
		adminAddNew.inputToPageDetailArea(pageDetail);

		log.info("Create 08: click to 'Publish' button");
		adminAddNew.clickToPublishButton();

		log.info("Create 09: click to 'Publish' confirm button");
		adminAddNew.clickToPublishConfirmButton();

		log.info("Create 10: verify 'Page published.' meassage is display ");
		Assert.assertTrue(adminAddNew.isPublishedOrUpdatedMessageDisplay("Page published."));

	}

	@Test
	public void TC02_Search_And_View() {
		log.info("Search_And_View 01: Open 'Pages' page ");
		adminAddNew.openUrl(driver, allPagesURL);
		adminPages = PageGeneratorManager.getAdminPagesPage(driver);

		log.info("Search_And_View 02: input category name to Search textbox: " + pageName);
		adminPages.inputTextToSearchTextBox(pageName);

		log.info("Search_And_View 03: click to Search Pages button ");
		adminPages.clickToSearchButton();

		log.info("Search_And_View 04: Verify Search table contains category name: " + pageName);
		Assert.assertEquals(adminPages.getCellValueByID("title"), pageName);

		log.info("Search_And_View 05: Verify Search table contains author name: " + authorName);
		Assert.assertEquals(adminPages.getCellValueByID("author"), authorName);

		log.info("Search_And_View 06: Verify Search table contains published date: " + publishedDate);
		Assert.assertTrue(adminPages.getCellValueByID("date").contains(publishedDate));

		log.info("Search_And_View 07: Open User Home Page ");
		adminPages.getUserHomePage(driver, urlUserHomePage);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Search_And_View 08: Verify Menu item contains Page name: " + pageName);
		Assert.assertTrue(userHomePage.isPageNameDisplayOnMenu(pageName));

		log.info("Search_And_View 09: click to Page name: " + pageName);
		userDetailPage = userHomePage.clickToPageByPageName(pageName);

		log.info("Search_And_View 10: Verify informations in '" + pageName + "'");
		Assert.assertTrue(userDetailPage.isPageNameDisplayOnDetailPage(pageName));
		Assert.assertTrue(userDetailPage.isPageDetailDisplayOnDetailPage(pageDetail));

	}

	@Test
	public void TC03_Update_Page() {
		log.info("Update 01: Open 'Pages' page ");
		adminAddNew.openUrl(driver, allPagesURL);
		adminPages = PageGeneratorManager.getAdminPagesPage(driver);

		log.info("Update 02: input category name to Search textbox: " + pageName);
		adminPages.inputTextToSearchTextBox(pageName);

		log.info("Update 03: click to Search Pages button ");
		adminPages.clickToSearchButton();

		log.info("Update 04: click to Page Title and Open 'Edit Pages' page");
		adminPages.clickToPagesTitle(pageName);
		adminAddNew = PageGeneratorManager.getAdminPagesAddNewPage(driver);

		log.info("Update 05: Edit Page Title ");
		adminAddNew.inputToPageTitleTextbox(editPageName);

		log.info("Update 06: Edit Page Detail ");
		adminAddNew.inputToPageDetailArea(editPageDetail);

		log.info("Update 07: click to 'Publish' button");
		adminAddNew.clickToPublishButton();

		log.info("Update 08: verify 'Page updated.' meassage is display ");
		Assert.assertTrue(adminAddNew.isPublishedOrUpdatedMessageDisplay("Page updated."));

		log.info("Update 09: Open AllPagesURL ");
		adminAddNew.openUrl(driver, allPagesURL);

		log.info("Update 10: input category name to Search textbox: " + pageName);
		adminPages.inputTextToSearchTextBox(editPageName);

		log.info("Update 11: click to Search Pages button ");
		adminPages.clickToSearchButton();

		log.info("Update 12: Verify Search table contains Page name: " + editPageName);
		Assert.assertEquals(adminPages.getCellValueByID("title"), editPageName);

		log.info("Update 13: Verify Search table contains author name: " + authorName);
		Assert.assertEquals(adminPages.getCellValueByID("author"), authorName);

		log.info("Update 14: Verify Search table contains published date: " + publishedDate);
		Assert.assertTrue(adminPages.getCellValueByID("date").contains(publishedDate));

		log.info("Update 15: Open User Home Page ");
		adminPages.getUserHomePage(driver, urlUserHomePage);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Update 16: Verify Menu item contains Page name: " + editPageName);
		Assert.assertTrue(userHomePage.isPageNameDisplayOnMenu(editPageName));

		log.info("Update 17: click to Page name: " + editPageName);
		userDetailPage = userHomePage.clickToPageByPageName(editPageName);

		log.info("Update 18: Verify informations in '" + editPageName + "'");
		Assert.assertTrue(userDetailPage.isPageNameDisplayOnDetailPage(editPageName));
		Assert.assertTrue(userDetailPage.isPageDetailDisplayOnDetailPage(editPageDetail + pageDetail));
	}

	@Test
	public void TC04_Delete_Page() {

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
