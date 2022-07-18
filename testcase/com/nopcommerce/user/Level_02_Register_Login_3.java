package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_3 extends BasePage {
	WebDriver driver;
	String email;

	@BeforeClass
	public void BeforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		email = "rmail" + randomInt() + "@hmail.vn";
	}

	@Test
	public void TC01_Empty_Data() {
		openUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC02_Invalid_Data() {
		openUrl(driver, "https://demo.nopcommerce.com/");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "fisrt Name");
		sendkeyToElement(driver, "//input[@id='LastName']", "fisr Name");
		sendkeyToElement(driver, "//input[@id='Email']", "fisrtName");
		sendkeyToElement(driver, "//input[@id='Password']", "1231231");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1231231");

		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC03_Success() {
		openUrl(driver, "https://demo.nopcommerce.com/");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "fisrt Name");
		sendkeyToElement(driver, "//input[@id='LastName']", "fisr Name");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", "1231231");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1231231");

		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

	}

	@AfterClass
	public void AfterTest() {
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(99);
	}
}
