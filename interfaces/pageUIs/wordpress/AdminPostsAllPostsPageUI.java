package pageUIs.wordpress;

public class AdminPostsAllPostsPageUI {
	public static final String POSTS_ADD_NEW_BUTTON = "XPATH=//a[@class='page-title-action']";
	public static final String SEARCH_TEXTBOX = "XPATH=//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "XPATH=//input[@id='search-submit']";
	public static final String TABLE_COLUMN_INDEX_BY_ID = "XPATH=//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_COLUM_INDEX = "XPATH=//tbody[@id='the-list']//tr/*[%s]";
	public static final String POST_LINK_BY_TITLE = "XPATH=//tbody[@id='the-list']//td[contains(@class,'page-title') ]//a[text()='%s']";
	public static final String CHECKBOX_BY_TITLE_POST = "XPATH=//td[strong[a[text()='%s']]]/preceding-sibling::th//input[@type='checkbox']";
	public static final String SELECT_ACTION = "XPATH=//select[@id='bulk-action-selector-top']";
	public static final String APPLY_BUTTON = "XPATH=//input[@id='doaction']";
	public static final String NO_POSTS_FOUND_MESSAGE = "XPATH=//tbody[@id='the-list']//td[text()='No posts found.']";
}
