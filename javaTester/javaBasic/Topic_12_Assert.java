package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Topic_12_Assert extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;

	@Parameters("browser")
	@BeforeTest
	public void BeforeClass(String browserName) {
		driver = GetBrowserDriver(browserName, "https://www.facebook.com/");
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Assert() {
		// display
		driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='reg_email__']"))).sendKeys("test@hotmail.vn");
		verifyTrue(driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).isDisplayed());

		// invisiable in dom
		driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("");
		SleepInSecond(2);
		verifyTrue(driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).isDisplayed());

		// text wrong
		verifyEquals(driver.findElement(By.xpath("//div[@id='reg_pages_msg']")).getText(), " for a celebrity, brand or business.");

		// text correct
		verifyEquals(driver.findElement(By.xpath("//div[@id='reg_pages_msg']/a")).getText(), "Create a Page");

	}

	@AfterClass
	public void AfterClass() {
		driver.quit();
	}

	public void SleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
