package com.fackebook.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.user.PageGeneratorManager;
import pageObjects.facebook.user.UserFacebookPage;

public class Level_14_Log4J_ReportNG extends BaseTest {
	WebDriver driver;
	private UserFacebookPage fbPage;
	String email;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);
		fbPage = PageGeneratorManager.getFBPage(driver);
		email = "thao@hmail.com";
	}

	@Test
	public void TC_01_Element_Display() {
		log.info("TC_01_Element_Display: Click To Register Button");
		fbPage.clickToRegisterLink();

		log.info("TC_01_Element_Display: Verify Email Textbox is Display");
		verifyTrue(fbPage.isEmailTextboxDisplay());

	}

	@Test
	public void TC_02_Element_UnDisplay_In_DOM() {
		log.info("TC_02_Element_UnDisplay_In_DOM: send Email to Email Textbox" + email);
		fbPage.senkeyToEmailTextBox(email);

		log.info("TC_02_Element_UnDisplay_In_DOM: Verify Email Textbox is UnDisplay");
		verifyTrue(fbPage.isConfirmEmailTextboxUnDisplay());

		log.info("TC_02_Element_UnDisplay_In_DOM: send Empty Email to Email Textbox");
		fbPage.senkeyToEmailTextBox("");

		log.info("TC_02_Element_UnDisplay_In_DOM: Verify Email Textbox is UnDisplay");
		verifyTrue(fbPage.isConfirmEmailTextboxUnDisplay());
	}

	@Test
	public void TC_03_Element_UnDisplay_Not_In_DOM() {
		log.info("TC_03_Element_UnDisplay_Not_In_DOM: Close register popup");
		fbPage.clickToCloseButton();

		log.info("TC_03_Element_UnDisplay_Not_In_DOM: Verify Email Textbox is UnDisplay");
		verifyTrue(fbPage.isConfirmEmailTextboxUnDisplay());
	}

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

}
