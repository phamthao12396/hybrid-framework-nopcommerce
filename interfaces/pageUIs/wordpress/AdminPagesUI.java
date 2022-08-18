package pageUIs.wordpress;

public class AdminPagesUI {
	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='page-title-action' and text()='Add New']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String SEARCH_PAGES_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String COLUMN_INDEX_BY_ID = "xpath=//thead//th[@id='%s']/preceding-sibling::*";
	// public static final String ROW_INDEX_BY_TEXT = "xpath=//tbody[@id='the-list']//tr[td[strong[a[text()='%s']]]]/preceding-sibling::tr";
	public static final String CELL_VALUE_BY_INDEX = "xpath=//tbody[@id='the-list']//tr/*[%s]";
	public static final String PAGE_TITLE_BY_TEXT = "xpath=//td[@data-colname='Title']//a[text()='%s']";
	public static final String CHECKBOX_BY_TITLE_NAME = "xpath=//td[strong[a[text()='%s']]]/preceding-sibling::th//input[@type='checkbox']";
	public static final String SELECTOR_ACTION_TOP = "xpath=//select[@id='bulk-action-selector-top']";
	public static final String APPLY_BUTTON = "xpath=//input[@id='doaction']";
	public static final String DELETE_SUCCESS_MESSAGE = "xpath=//div[@id='message']/p";
	public static final String SEARCH_NOT_FOUND_MESSAGE = "xpath=//tbody[@id='the-list']//td[text()='No pages found.']";

}
