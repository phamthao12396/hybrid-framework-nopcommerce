package pageUIs.wordpress;

public class UserHomePageUI {
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='wp-block-search__input-1']";
	public static final String SEARCH_BUTTON = "xpath=//input[@id='wp-block-search__input-1']/following-sibling::button";
	public static final String SEARCH_RESULT_POST_TITLE = "xpath=//h2[@class='entry-title']/a[text()='%s']";
	public static final String SEARCH_RESULT_POST_AUTHOR = "xpath=//h2[@class='entry-title'][a[text()='%s']]/following-sibling::div//span[@class='byline']//span[@class='author vcard']//a[text()='%s']";
	public static final String SEARCH_RESULT_POST_PUBLISH_TIME = "xpath=//h2[@class='entry-title'][a[text()='%s']]/following-sibling::div//span[@class='posted-on']//time[contains(@class,'entry-date published') and text()='%s']";
	public static final String NOTHING_FOUND_MESSAGE = "xpath=//section[@class='no-results not-found']//h1[text()='Nothing Found']";
	public static final String MENU_ITEM_BY_TEXT = "xpath=//ul[@id='primary-menu']//a[text()='%s']";
	public static final String ALL_MENU_ITEM = "xpath=//ul[@id='primary-menu']//a";

}
