package com.fackebook.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.user.PageGeneratorManager;
import pageObjects.facebook.user.UserFacebookPage;

public class Level_13_Element_Undisplay extends BaseTest {
	WebDriver driver;
	private UserFacebookPage fbPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);
		fbPage = PageGeneratorManager.getFBPage(driver);
	}

	@Test
	public void TC_01_Element_Display() {
		fbPage.clickToRegisterLink();
		verifyTrue(fbPage.isEmailTextboxDisplay());

	}

	@Test
	public void TC_02_Element_UnDisplay_In_DOM() {
		fbPage.senkeyToEmailTextBox("thao@hmail.com");
		verifyTrue(fbPage.isConfirmEmailTextboxUnDisplay());
		fbPage.senkeyToEmailTextBox("");
		verifyTrue(fbPage.isConfirmEmailTextboxUnDisplay());
	}

	@Test
	public void TC_03_Element_UnDisplay_Not_In_DOM() {
		fbPage.clickToCloseButton();
		verifyTrue(fbPage.isConfirmEmailTextboxUnDisplay());
	}

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

}
