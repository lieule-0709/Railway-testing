package common.constant;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railway2.somee.com/";
    public static ExtentReports REPORT;
    public static final String DATA_LOGIN_PATH = System.getProperty("user.dir") + "/src/main/java/dataObjects/dataLogin.csv";
}
