package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageObjects.nopComerce.user.UserLoginPageObject;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;

	public UserLoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, loginLink);
		clickToElement(loginLink);
		return new UserLoginPageObject(driver);
	}
}
