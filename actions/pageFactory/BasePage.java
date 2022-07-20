package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void clickToElement(WebElement element) {
		element.click();
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.visibilityOf(element));
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public void sendkeyToElement(WebElement element, String keyToSend) {
		element.sendKeys(keyToSend);
	}

	private static final int longTimeout = 30;
}
