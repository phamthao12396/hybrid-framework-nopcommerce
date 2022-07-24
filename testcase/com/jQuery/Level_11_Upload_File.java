package com.jQuery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	String catImg = "cat.png";
	String dogImg = "dog.png";
	String[] mutipleFile = { roseImg, lotusImg, catImg, dogImg };

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void BeforeTest(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);
		jQueryUploadPage = PageGeneratorManager.getJQueryUploadPage(driver);
	}

	@Test
	public void TC01_Upload_Single_File() {
		jQueryUploadPage.uploadMultipleFile(driver, roseImg);
		Assert.assertTrue(jQueryUploadPage.isFileLoadByName(roseImg));
		jQueryUploadPage.clickStartUploadFile();
		Assert.assertTrue(jQueryUploadPage.isFileImageUploadByName(roseImg));

	}

	@Test
	public void TC02_Upload_Multiple_File() {
		jQueryUploadPage.uploadMultipleFile(driver, mutipleFile);

		Assert.assertTrue(jQueryUploadPage.isFileLoadByName(roseImg));
		Assert.assertTrue(jQueryUploadPage.isFileLoadByName(lotusImg));
		Assert.assertTrue(jQueryUploadPage.isFileLoadByName(catImg));
		Assert.assertTrue(jQueryUploadPage.isFileLoadByName(dogImg));

		jQueryUploadPage.clickStartUploadFile();
		Assert.assertTrue(jQueryUploadPage.isFileImageUploadByName(roseImg));
		Assert.assertTrue(jQueryUploadPage.isFileImageUploadByName(lotusImg));
		Assert.assertTrue(jQueryUploadPage.isFileImageUploadByName(catImg));
		Assert.assertTrue(jQueryUploadPage.isFileImageUploadByName(dogImg));

	}

	@AfterTest
	public void AfterClass() {
		// driver.quit();
	}
}
