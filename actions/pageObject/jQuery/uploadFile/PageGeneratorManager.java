package pageObject.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static JQueryUploadPage getJQueryUploadPage(WebDriver driver) {
		return new JQueryUploadPage(driver);
	}
}
