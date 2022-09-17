package com.nopcommerce.user;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Register_Share_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopComerce.user.ComDesktopsPageObject;
import pageObjects.nopComerce.user.ComputerPageObject;
import pageObjects.nopComerce.user.UserHomePageObjects;

public class Level_18_Sort_Data extends BaseTest {
	private WebDriver driver;
	private UserHomePageObjects homePageObj;
	private ComputerPageObject comPO;
	private ComDesktopsPageObject desktopsPO;

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
	public void TC01_Sort_By_Name(Method method) {
		log.info("Set cookie login and refresh page");
		Set<Cookie> cookies = Register_Share_Cookie.loggedCookies;
		homePageObj.setAllCookies(driver, cookies);
		homePageObj.refreshPage(driver);

		log.info("Step 01: Click to Computers by text");
		comPO = homePageObj.clickToPageByText("Computers ");

		log.info("Step 02: Navigate to Computers > Desktops by sublist text");
		desktopsPO = comPO.clickToSublistByText("Desktops ");

		log.info("Step 03: click to Sort by Name: A to Z");
		desktopsPO.selectItemInSortProductDropdown("Name: A to Z");

		log.info("Step 04: verify the result sort by name A to Z");
		assertTrue(desktopsPO.isProductNameSortByAscending());

		log.info("Step 05: click to Sort by Price: Low to High");
		desktopsPO.selectItemInSortProductDropdown("Price: Low to High");

		log.info("Step 06: verify the result sort by Price: Low to High");
		assertTrue(desktopsPO.isProductPricesSortByAscending());

		log.info("Step 07: click to Sort by Price: High to Low");
		desktopsPO.selectItemInSortProductDropdown("Price: High to Low");

		log.info("Step 08: verify the result sort by Price: High to Low");
		assertTrue(desktopsPO.isProductPricesSortByDecending());

		log.info("Step 09: click to Sort by Name: z to a");
		desktopsPO.selectItemInSortProductDropdown("Name: Z to A");

		log.info("Step 10: verify the result sort by Name: Z to A");
		assertTrue(desktopsPO.isProductNameSortByDecending());

	}

	@AfterClass(alwaysRun = true)
	public void AfterTest() {
		closeBrowserAndDriver();
	}

}
