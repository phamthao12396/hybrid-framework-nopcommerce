package com.jQuery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFile.PageGeneratorManager;
import pageObject.jQuery.uploadFile.JQueryUploadPage;

public class Level_11_Upload_File extends BaseTest {
	WebDriver driver;
	JQueryUploadPage jQueryUploadPage;
	String roseImg = "hhong.jpg";
	String lotusImg = "hsen.jpg";
	String orangeImg = "orange.jpg";

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void BeforeTest(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);
		jQueryUploadPage = PageGeneratorManager.getJQueryUploadPage(driver);
	}

	@Test
	public void TC01_Upload_Single_File() {
		jQueryUploadPage.addFileToUploadByName(roseImg);
		jQueryUploadPage.clickStartUploadFileByName(roseImg);
		jQueryUploadPage.verifiedFileUploadSucces(roseImg);

	}

	@Test
	public void TC02_Upload_Multiple_File() {

	}

	@AfterTest
	public void AfterClass() {
		driver.quit();
	}
}
