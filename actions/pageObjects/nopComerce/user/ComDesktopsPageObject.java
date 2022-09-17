package pageObjects.nopComerce.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.ComDesktopsPageUI;

public class ComDesktopsPageObject extends BasePage {
	WebDriver driver;

	public ComDesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortProductDropdown(String selectOption) {
		waitForElementVisible(driver, ComDesktopsPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, ComDesktopsPageUI.SORT_DROPDOWN, selectOption);
		SleepInSecond(3);
	}

	public boolean isProductNameSortByAscending() {
		List<WebElement> elements = getWebElements(driver, ComDesktopsPageUI.ALL_PRODUCT_TITLE);
		ArrayList<String> allProductName = new ArrayList<String>();
		for (WebElement element : elements) {
			allProductName.add(element.getText());
		}
		ArrayList<String> productNames = new ArrayList<String>();
		for (String string : allProductName) {
			productNames.add(string);
		}
		Collections.sort(productNames);
		return productNames.equals(allProductName);
	}

	public boolean isProductNameSortByDecending() {
		List<WebElement> elements = getWebElements(driver, ComDesktopsPageUI.ALL_PRODUCT_TITLE);
		ArrayList<String> allProductName = new ArrayList<String>();
		for (WebElement element : elements) {
			allProductName.add(element.getText());
		}
		ArrayList<String> productNames = new ArrayList<String>();
		for (String string : allProductName) {
			productNames.add(string);
		}
		Collections.reverse(productNames);
		return productNames.equals(allProductName);
	}

	public boolean isProductPricesSortByAscending() {
		List<WebElement> elements = getWebElements(driver, ComDesktopsPageUI.ALL_PRODUCT_PRICE);
		ArrayList<Float> allProductPrices = new ArrayList<Float>();
		for (WebElement element : elements) {
			String price = element.getText();
			String price1 = price.replace(",", "");
			allProductPrices.add(Float.parseFloat(price1.replace("$", "")));
		}
		ArrayList<Float> productPrices = new ArrayList<Float>();
		for (Float itemPrice : allProductPrices) {
			productPrices.add(itemPrice);
			System.out.println("before sort: " + itemPrice);
		}
		Collections.sort(productPrices);
		for (Float float1 : productPrices) {
			System.out.println("after sort: " + float1);
		}
		return productPrices.equals(allProductPrices);
	}

	public boolean isProductPricesSortByDecending() {
		List<WebElement> elements = getWebElements(driver, ComDesktopsPageUI.ALL_PRODUCT_PRICE);
		ArrayList<Float> allProductPrices = new ArrayList<Float>();
		for (WebElement element : elements) {
			String price = element.getText();
			String price1 = price.replace(",", "");
			price1 = price1.replace("$", "");
			allProductPrices.add(Float.parseFloat(price1));
		}
		ArrayList<Float> productPrices = new ArrayList<Float>();
		for (Float itemPrice : allProductPrices) {
			productPrices.add(itemPrice);
			System.out.println("before sort: " + itemPrice);
		}
		Collections.sort(productPrices);
		Collections.reverse(productPrices);
		for (Float float1 : productPrices) {
			System.out.println("after sort: " + float1);
		}
		return productPrices.equals(allProductPrices);
	}

}
