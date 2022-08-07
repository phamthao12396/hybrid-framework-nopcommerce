package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String ADD_TITLE_TEXTAREA = "xpath=//h1[@aria-label='Add title']";
	public static final String BODY_BUTTON = "xpath=//p[@role='button']";
	public static final String ADD_BODY_TEXTAREA = "xpath=//p[@role='document']";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "xpath=//button[contains(@class,'editor-post-publish-button')]";
	public static final String CONFIRM_PUBLISH_BUTTON = "xpath=//button[contains(@class,'publish-button')]/parent::div[contains(@class,'post-publish-panel')]";
	public static final String POST_PUBLISHED_SUCCESS_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
	public static final String CLOSE_DIALOG_BUTTON = "xpath=//button[@aria-label='Close dialog']";

}
