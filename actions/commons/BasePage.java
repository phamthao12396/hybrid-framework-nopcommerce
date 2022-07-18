package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String Url) {
		driver.get(Url);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		driver.switchTo().alert().dismiss();
	}

	public void getAlertText(WebDriver driver) {
		waitForAlertPresence(driver);
		driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String keysToSend) {
		waitForAlertPresence(driver);
		driver.switchTo().alert().sendKeys(keysToSend);
	}

	public void SleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> windowsID = driver.getWindowHandles();
		for (String window : windowsID) {
			if (!window.equals(parentID)) {
				driver.switchTo().window(window);
				SleepInSecond(2);
			}
		}

	}

	public void switchToWindowsByTittle(WebDriver driver, String windowTitle) {
		Set<String> windowsID = driver.getWindowHandles();
		for (String window : windowsID) {
			driver.switchTo().window(window);
			String tittle = driver.getTitle();
			if (tittle.equals(windowTitle)) {
				break;
			}
		}
	}

	public void switchToParentPageAndCloseOtherWindows(WebDriver driver, String parentID) {
		Set<String> windowsID = driver.getWindowHandles();
		for (String window : windowsID) {
			if (!window.equals(parentID)) {
				driver.switchTo().window(window);
				SleepInSecond(3);
				driver.close();
			}
		}
	}

	public By getByXpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}

	public WebElement getWebElement(WebDriver driver, String xpathExpression) {
		return driver.findElement(getByXpath(xpathExpression));
	}

	public List<WebElement> getWebElements(WebDriver driver, String xpathExpression) {
		return driver.findElements(getByXpath(xpathExpression));
	}

	public void clickToElement(WebDriver driver, String xpathExpression) {
		getWebElement(driver, xpathExpression).click();
	}

	public void sendkeyToElement(WebDriver driver, String xpathExpression, String keyToSend) {
		getWebElement(driver, xpathExpression).sendKeys(keyToSend);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathExpression, String itemText) {
		new Select(getWebElement(driver, xpathExpression)).selectByVisibleText(itemText);
	}

	public String getSelectextInDefaultDropdown(WebDriver driver, String xpathExpression) {
		return new Select(getWebElement(driver, xpathExpression)).getFirstSelectedOption().getText();
	}

	public void isDropdownMultiple(WebDriver driver, String xpathExpression) {
		new Select(getWebElement(driver, xpathExpression)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parent, String child, String value) {
		clickToElement(driver, parent);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(child)));
		List<WebElement> allItems = getWebElements(driver, child);
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(value)) {
				if (item.isDisplayed()) {
					item.click();
				} else {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
					item.click();
				}
			}

		}
	}

	public String getElementText(WebDriver driver, String xpathExpression) {
		return getWebElement(driver, xpathExpression).getText();
	}

	public String getElementAttribute(WebDriver driver, String xpathExpression, String value) {
		return getWebElement(driver, xpathExpression).getAttribute(value);
	}

	public String getElementCssValue(WebDriver driver, String xpathExpression, String value) {
		return getWebElement(driver, xpathExpression).getCssValue(value);

	}

	public String getHexaColorByRGBAColor(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex();
	}

	public int getElementNumber(WebDriver driver, String xpathExpression) {
		return getWebElements(driver, xpathExpression).size();
	}

	public void checkToRadioOrCheckbox(WebDriver driver, String xpathExpression) {
		if (!(getWebElement(driver, xpathExpression).isSelected())) {
			clickToElement(driver, xpathExpression);
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String xpathExpression) {
		if ((getWebElement(driver, xpathExpression).isSelected())) {
			clickToElement(driver, xpathExpression);
		}
	}

	public boolean isElementDisplay(WebDriver driver, String xpathExpression) {
		return getWebElement(driver, xpathExpression).isDisplayed();
	}

	public boolean isElementEnable(WebDriver driver, String xpathExpression) {
		return getWebElement(driver, xpathExpression).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathExpression) {
		return getWebElement(driver, xpathExpression).isSelected();
	}

	public WebDriver switchToFrame(WebDriver driver, String frame) {
		return driver.switchTo().frame(frame);
	}

	public WebDriver switchToDefaultContentPage(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathExpression) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathExpression)).perform();
	}

	public void pressKeyboardToElement(WebDriver driver, CharSequence key) {
		Actions action = new Actions(driver);
		action.sendKeys(key).perform();
	}

	public Object executeJavascriptForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(WebDriver driver, String xpathExpression) {
		WebElement element = getWebElement(driver, xpathExpression);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathExpression));
	}

	public void scrollToElementOnTop(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathExpression));
	}

	public void scrollToElementOnDown(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathExpression));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, xpathExpression));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathExpression, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathExpression));
	}

	public String getElementValidationMessage(WebDriver driver, String xpathExpression) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathExpression));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathExpression) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, xpathExpression));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String xpathExpression) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathExpression)));
	}

	public void waitForElemenClickable(WebDriver driver, String xpathExpression) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.elementToBeClickable(getByXpath(xpathExpression)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathExpression) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathExpression)));
	}

	public void waitForAlertPresence(WebDriver driver) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.alertIsPresent());
	}

	private long longTimeout = 30;
}
