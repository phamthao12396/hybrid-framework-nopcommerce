package pageUIs.jQuery.uploadPageUI;

public class jQueryUploadPageUI {
	public static final String UPLOAD_FILE = "xpath=//input[@type='file']";
	public static final String FILE_NAME_LOADED = "xpath=//p[@class='name' and contains(text(),'%s')]";
	public static final String START_BUTTON = "xpath=//tbody[@class='files']//button[contains(@class,'btn-primary start')]";
	public static final String IMAGE_UPLOAD_SUCCESS = "xpath=//span[@class='preview']//a[@title='%s']/img";

}
