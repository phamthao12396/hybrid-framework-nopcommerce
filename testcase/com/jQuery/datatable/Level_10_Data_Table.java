package com.jQuery.datatable;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalContants;
import pageObject.jQuery.AdminHomePage;
import pageObject.jQuery.AdminLoginPage;
import pageObject.jQuery.PageGeneratorManager;
import pageObject.jQuery.UserHomePage;
import pageObject.jQuery.UserLoginPage;
import pageObject.jQuery.UserRegisterPage;

public class Level_10_Data_Table extends BaseTest {
	WebDriver driver;
	UserHomePage userHomePage;
	UserLoginPage userLoginPage;
	UserRegisterPage userRegisterPage;
	AdminLoginPage adminLoginPage;
	AdminHomePage adminHomePage;
	String fisrtName, lastName, email, password, adminEmail, adminPass;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		fisrtName = "Naomi";
		lastName = "Campell";
		email = "Naomi" + randomInt() + "@mail.us";
		password = "123456";
		adminEmail = "user01";
		adminPass = "guru99com";
		driver = GetBrowserDriver(browserName, GlobalContants.TECHPANDA_USER_URL);
		userHomePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC01_Register_Account() {
		userLoginPage = userHomePage.clickToLinkByTitle(driver, "My Account");
		userRegisterPage = userLoginPage.clickToCreateAnAccountButton();
		userRegisterPage.sendKeyToFirstNameTextBox(fisrtName);
		userRegisterPage.sendKeyToLastNameTextBox(lastName);
		userRegisterPage.sendKeyToEmailTextBox(email);
		userRegisterPage.sendKeyToPassWordTextBox(password);
		userRegisterPage.sendKeyToConfirmPassWordTextBox(password);
		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.isRegisteredSuccessMessageDisplay(), "Thank you for registering with Main Website Store.");

	}

	@Test
	public void TC02_Admin_page() {
		userRegisterPage.openUrl(driver, GlobalContants.TECHPANDA_ADMIN_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.sendKeyToUserNameTextBox(adminEmail);
		adminLoginPage.sendKeyToPasswordTextBox(adminPass);
		adminHomePage = adminLoginPage.clickToLoginButton();
		adminHomePage.closeAlertIfPresence(driver);

	}

	@Test
	public void TC03_Verify_Account() {

		adminHomePage.sendKeytoFilterTextboxByName("Name", lastName);
		adminHomePage.sendKeytoFilterTextboxByName("Email", email);
		adminHomePage.clickToFilterActionByName("Search");
		adminHomePage.SleepInSecond(2);
		List<String> allCustomers = adminHomePage.getAllCustomer();

		if (allCustomers.size() != 0) {
			for (String string : allCustomers) {
				System.out.println("--------------------------------");
				System.out.println(string);
			}
		}
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();
	}

	public int randomInt() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
