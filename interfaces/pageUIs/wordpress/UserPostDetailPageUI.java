package pageUIs.wordpress;

public class UserPostDetailPageUI {
	public static final String SEARCH_RESULT_POST_TITLE = "xpath=//h1[@class='entry-title' and text()='%s']";
	public static final String SEARCH_RESULT_POST_AUTHOR = "xpath=//h1[@class='entry-title' and text()='%s']/following-sibling::div//span[@class='byline']//span[@class='author vcard']//a[text()='%s']";
	public static final String SEARCH_RESULT_POST_PUBLISH_TIME = "xpath=//h1[@class='entry-title' and text()='%s']/following-sibling::div//span[@class='posted-on']//time[contains(@class,'entry-date published') and text()='%s']";

}
