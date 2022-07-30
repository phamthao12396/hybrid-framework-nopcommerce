package pageObjects.facebook.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;

	public static UserFacebookPage getFBPage(WebDriver driver) {
		return new UserFacebookPage(driver);
	}
}
