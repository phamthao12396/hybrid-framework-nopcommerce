package pageUIs.techpanda.admin;

public class AdminHomePageUI {
	public static final String CLOSE_POPUP_BUTTON = "xpath=//div[@class='message-popup-head']/a[@title='close']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[span//span[contains(text(),'%s')]]//preceding-sibling::th";
	public static final String FILTER_TEXTBOX_BY_COLUMN_INDEX = "xpath=//tr[@class='filter']/th[%s]//input";
	public static final String FILTER_BUTTON_BY_NAME = "xpath=//td[@class='filter-actions a-right']//button//span[contains(text(),'%s')]";
	public static final String ALL_CUSTOMER_DISPLAY = "xpath=//table[@id='customerGrid_table']//tbody//tr";
	public static final String PAGE_RESULT = "xpath=//tbody//td[@class='pager']";
	public static final String PAGE_TEXTBOX = "xpath=//tbody//td[@class='pager']/input[@name='page']";

}
