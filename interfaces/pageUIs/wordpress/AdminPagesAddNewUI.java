package pageUIs.wordpress;

public class AdminPagesAddNewUI {
	public static final String TITLE_TEXTBOX = "xpath=//h1[@aria-label='Add title']";
	public static final String DETAIL_BUTTON = "xpath=//p[@role='button']";
	public static final String DETAIL_TEXTBOX = "xpath=//p[@role='document']";
	public static final String PUBLISH_BUTTON = "xpath=//div[@class='edit-post-header__settings']//button[contains(@class,'publish-button')]";
	public static final String CONFIRM_PUBLISH_BUTTON = "xpath=//div[@class='editor-post-publish-panel']//button[contains(@class,'publish-button')]";
	public static final String PUBLISHED_OR_UPDATED_SUCCESS_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
	public static final String CLOSE_DIALOG_BUTTON = "xpath=//button[@aria-label='Close dialog']";

}
