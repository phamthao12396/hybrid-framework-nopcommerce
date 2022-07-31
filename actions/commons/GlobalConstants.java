package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	public static final String TECHPANDA_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String TECHPANDA_USER_URL = "http://live.techpanda.org/index.php/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String SCREEN_SHOTS_FILE = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final long LONG_TIME_OUT = 30;
	public static final long SHORT_TIME_OUT = 7;

}
