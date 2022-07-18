package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Level_01_Register_Login_1 {
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
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "Password is required.");

	}

	@Test
	public void TC02_Invalid_Data() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("fisrt Name");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("last Name");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("email");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1231231");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1231231");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Wrong email");

	}

	@Test
	public void TC03_Success() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("fisrt Name");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("last Name");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1231231");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1231231");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");

	}

	@AfterClass
	public void AfterTest() {
		// driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(99);
	}
}
