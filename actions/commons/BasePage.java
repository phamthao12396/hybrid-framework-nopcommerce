package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.nopComerce.user.UserAddressesPageObject;
import pageObjects.nopComerce.user.UserOrdersPageObject;
import pageObjects.nopComerce.user.UserRewardPointsPageObject;
import pageUIs.jQuery.uploadPageUI.jQueryUploadPageUI;
import pageUIs.nopCommerce.user.BasePageUI;

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

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("ID") || locatorType.startsWith("id") || locatorType.startsWith("Id")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("Name") || locatorType.startsWith("NAME") || locatorType.startsWith("name")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("Class") || locatorType.startsWith("ClASS") || locatorType.startsWith("class")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("Css") || locatorType.startsWith("css") || locatorType.startsWith("CSS")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("Xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("XPath") || locatorType.startsWith("xpath")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not support");
		}
		return by;

	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public WebElement getWebElement(WebDriver driver, String locatorType, String... dynamicValue) {
		return driver.findElement(getByLocator(getDynamicXpath(locatorType, dynamicValue)));
	}

	public List<WebElement> getWebElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public List<WebElement> getWebElements(WebDriver driver, String locatorType, String... dynamicValue) {
		return driver.findElements(getByLocator(getDynamicXpath(locatorType, dynamicValue)));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValue) {
		getWebElement(driver, locatorType, dynamicValue).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String keyToSend) {
		getWebElement(driver, locatorType).clear();
		getWebElement(driver, locatorType).sendKeys(keyToSend);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String keyToSend, String... dynamicValue) {
		getWebElement(driver, locatorType, dynamicValue).clear();
		getWebElement(driver, locatorType, dynamicValue).sendKeys(keyToSend);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String itemText) {
		new Select(getWebElement(driver, locatorType)).selectByVisibleText(itemText);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String itemText, String... dynamicValue) {
		new Select(getWebElement(driver, locatorType, dynamicValue)).selectByVisibleText(itemText);
	}

	public String getSelectextInDefaultDropdown(WebDriver driver, String locatorType) {
		return new Select(getWebElement(driver, locatorType)).getFirstSelectedOption().getText();
	}

	public String getSelectextInDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValue) {
		return new Select(getWebElement(driver, locatorType, dynamicValue)).getFirstSelectedOption().getText();
	}

	public void isDropdownMultiple(WebDriver driver, String locatorType) {
		new Select(getWebElement(driver, locatorType)).isMultiple();
	}

	public void isDropdownMultiple(WebDriver driver, String locatorType, String... dynamicValue) {
		new Select(getWebElement(driver, locatorType, dynamicValue)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parent, String child, String value) {
		clickToElement(driver, parent);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(child)));
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

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, locatorType, dynamicValue).getText();
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String value, String... dynamicValue) {
		return getWebElement(driver, locatorType, dynamicValue).getAttribute(value);
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String value, String... dynamicValue) {
		return getWebElement(driver, locatorType, dynamicValue).getCssValue(value);

	}

	public String getHexaColorByRGBAColor(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex();
	}

	public int getElementNumber(WebDriver driver, String locatorType) {
		return getWebElements(driver, locatorType).size();
	}

	public int getElementNumber(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElements(driver, locatorType, dynamicValue).size();
	}

	public void checkToRadioOrCheckbox(WebDriver driver, String locatorType) {
		if (!(getWebElement(driver, locatorType).isSelected())) {
			clickToElement(driver, locatorType);
		}
	}

	public void checkToRadioOrCheckbox(WebDriver driver, String locatorType, String... dynamicValue) {
		if (!(getWebElement(driver, locatorType, dynamicValue).isSelected())) {
			clickToElement(driver, locatorType, dynamicValue);
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locatorType) {
		if ((getWebElement(driver, locatorType).isSelected())) {
			clickToElement(driver, locatorType);
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locatorType, String... dynamicValue) {
		if ((getWebElement(driver, locatorType, dynamicValue).isSelected())) {
			clickToElement(driver, locatorType, dynamicValue);
		}
	}

	public boolean isElementDisplay(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}

	public boolean isElementDisplay(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, locatorType, dynamicValue).isDisplayed();
	}

	public boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementEnable(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, locatorType, dynamicValue).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, locatorType, dynamicValue).isSelected();
	}

	public WebDriver switchToFrame(WebDriver driver, String frame) {
		return driver.switchTo().frame(frame);
	}

	public WebDriver switchToDefaultContentPage(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType, dynamicValue)).perform();
	}

	public void pressKeyboardToElement(WebDriver driver, String locatorType, CharSequence key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyboardToElement(WebDriver driver, String locatorType, CharSequence key, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType, dynamicValue), key).perform();
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

	public void hightlightElement(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void hightlightElement(WebDriver driver, String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(driver, locatorType, dynamicValue);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locatorType, dynamicValue));
	}

	public void scrollToElementOnTop(WebDriver driver, String locatorType) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnTop(WebDriver driver, String locatorType, String... dynamicValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType, dynamicValue));
	}

	public void scrollToElementOnDown(WebDriver driver, String locatorType) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnDown(WebDriver driver, String locatorType, String... dynamicValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locatorType, dynamicValue));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locatorType, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locatorType));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locatorType, String value, String... dynamicValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locatorType, dynamicValue));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove, String... dynamicValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType, dynamicValue));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType, String... dynamicValue) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType, dynamicValue));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		return status;
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		System.out.println(getWebElement(driver, locatorType, dynamicValue));
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType, dynamicValue));
		return status;
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForElemenClickable(WebDriver driver, String locatorType) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElemenClickable(WebDriver driver, String locatorType, String... dynamicValue) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideGlobalTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideGlobalTimeout(driver, longTimeout);
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideGlobalTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
		overrideGlobalTimeout(driver, longTimeout);
	}

	public void waitForAlertPresence(WebDriver driver) {
		(new WebDriverWait(driver, longTimeout)).until(ExpectedConditions.alertIsPresent());
	}

	public UserOrdersPageObject clickToOrdersLink(WebDriver driver) {
		waitForElemenClickable(driver, BasePageUI.ORDERS_LINK);
		clickToElement(driver, BasePageUI.ORDERS_LINK);
		return PageGeneratorManager.getUserOrderPage(driver);
	}

	public UserAddressesPageObject clickToAddressesLink(WebDriver driver) {
		waitForElemenClickable(driver, BasePageUI.ADDRESSES_LINK);
		clickToElement(driver, BasePageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}

	public UserRewardPointsPageObject clickToRewardPointLink(WebDriver driver) {
		waitForElemenClickable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}

	private String getDynamicXpath(String locatorType, String... dynamicValue) {
		if (locatorType.startsWith("Xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("XPath") || locatorType.startsWith("xpath")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValue);
		}
		return locatorType;
	}

	public void clickToPageAtMyAccountPage(WebDriver driver, String dynamicValue) {
		waitForElemenClickable(driver, getDynamicXpath(BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, dynamicValue));
		String locator = getDynamicXpath(BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, dynamicValue);
		Assert.assertTrue(areJQueryAndJSLoadedSuccess(driver));
		clickToElement(driver, locator);
	}

	public void uploadMultipleFile(WebDriver driver, String... fileName) {
		String pathFile = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String name : fileName) {
			fullFileName = fullFileName + pathFile + name + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, jQueryUploadPageUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public boolean isElementUnDisplay(WebDriver driver, String locatorType) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getWebElements(driver, locatorType);
		overrideGlobalTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("not display + in DOM");
			return true;
		} else {
			System.out.println("display");
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setAllCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	private long longTimeout = GlobalConstants.LONG_TIME_OUT;
	private long shortTimeout = GlobalConstants.SHORT_TIME_OUT;

}
