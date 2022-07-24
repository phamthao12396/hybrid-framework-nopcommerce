package pageObject.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadPageUI.jQueryUploadPageUI;

public class JQueryUploadPage extends BasePage {
	WebDriver driver;

	public JQueryUploadPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadByName(String fileName) {
		waitForElementVisible(driver, jQueryUploadPageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplay(driver, jQueryUploadPageUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileImageUploadByName(String fileName) {
		waitForElementVisible(driver, jQueryUploadPageUI.IMAGE_UPLOAD_SUCCESS, fileName);
		return isImageLoaded(driver, jQueryUploadPageUI.IMAGE_UPLOAD_SUCCESS, fileName);
	}

	public void clickStartUploadFile() {
		waitForElemenClickable(driver, jQueryUploadPageUI.START_BUTTON);
		List<WebElement> buttons = getWebElements(driver, jQueryUploadPageUI.START_BUTTON);
		for (WebElement webElement : buttons) {
			webElement.click();
			SleepInSecond(3);
		}

	}

}
