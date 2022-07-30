package com.fackebook.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_12_Verify_Assert extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);
	}

	@Test
	public void TC_01_Verify() {

	}

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

}
