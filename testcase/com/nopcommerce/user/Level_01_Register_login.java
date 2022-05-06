package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Level_01_Register_login {
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browserName) {
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe");
			driver =new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
			driver =new FirefoxDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", ".\\browserDrivers\\msedgedriver.exe");
			driver =new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Browser is not support");
		};
	}

	@Test(invocationCount =3)
	public void f() {
		driver.get("https://docs.google.com/document/d/1Icx24E9tRuK0K_KDp96ebPIiGihYNBA_qyAavus3yq0/edit#heading=h.g2uonegtggss");
		System.out.println("get url");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
