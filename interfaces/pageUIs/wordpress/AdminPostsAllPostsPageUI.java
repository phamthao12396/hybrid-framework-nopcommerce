package pageUIs.wordpress;

public class AdminPostsAllPostsPageUI {
	public static final String POSTS_ADD_NEW_BUTTON = "XPATH=//a[@class='page-title-action']";
	public static final String SEARCH_TEXTBOX = "XPATH=//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "XPATH=//input[@id='search-submit']";
	public static final String TABLE_COLUMN_INDEX_BY_ID = "XPATH=//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_COLUM_INDEX = "XPATH=//tbody[@id='the-list']//tr/*[%s]";
}
