package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "Email-error")
	private WebElement emailErrorMsg;

	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextBox;

	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'message-error')]")
	private WebElement emailUnsuccessErrMsg;

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMsg);
		return getElementText(emailErrorMsg);
	}

	public void sendKeyToEmailTextBox(String Email) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(emailTextBox, Email);
	}

	public void senKeyToPasswordTextBox(String Password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(passwordTextBox, Password);

	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, loginButton);
		clickToElement(loginButton);
	}

	public String getUnsuccessfulEmailErrorMessage() {
		waitForElementVisible(driver, emailUnsuccessErrMsg);
		return getElementText(emailUnsuccessErrMsg);
	}

}
