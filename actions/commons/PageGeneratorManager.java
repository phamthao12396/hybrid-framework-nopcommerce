package commons;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminDashboardPage;
import pageObject.admin.AdminLoginPage;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObjects;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrdersPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserRewardPointsPageObject;

public class PageGeneratorManager {
	public static UserHomePageObjects getUserHomePage(WebDriver driver) {
		return new UserHomePageObjects(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserOrdersPageObject getUserOrderPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}

	public static UserAddressesPageObject getAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}

	public static UserRewardPointsPageObject getRewardPointPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}

	public static AdminLoginPage getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPage(driver);
	}

	public static AdminDashboardPage getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPage(driver);
	}

}
