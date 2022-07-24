package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopComerce.admin.AdminDashboardPage;
import pageObject.nopComerce.admin.AdminLoginPage;
import pageObjects.nopComerce.user.UserAddressesPageObject;
import pageObjects.nopComerce.user.UserCustomerInfoPageObject;
import pageObjects.nopComerce.user.UserHomePageObjects;
import pageObjects.nopComerce.user.UserLoginPageObject;
import pageObjects.nopComerce.user.UserOrdersPageObject;
import pageObjects.nopComerce.user.UserRegisterPageObject;
import pageObjects.nopComerce.user.UserRewardPointsPageObject;

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
