package pageObject.jQuery.dataTable;

import org.openqa.selenium.WebDriver;

import pageObject.jQuery.uploadFile.JQueryUploadPage;

public class PageGeneratorManager {
	WebDriver driver;

	public static UserHomePage getHomePage(WebDriver driver) {
		return new UserHomePage(driver);
	}

	public static AdminHomePage getAdminHomePage(WebDriver driver) {
		return new AdminHomePage(driver);
	}

	public static UserLoginPage getUserLoginPage(WebDriver driver) {
		return new UserLoginPage(driver);
	}

	public static AdminLoginPage getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPage(driver);
	}

	public static UserRegisterPage getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPage(driver);
	}

}
