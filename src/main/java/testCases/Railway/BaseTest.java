package testCases.Railway;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    @Parameters("browserName")
    @BeforeClass
    public void beforeClass(String browserName) {
        Constant.REPORT = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html", false);
        Constant.REPORT.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                Constant.WEBDRIVER = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                Constant.WEBDRIVER = new ChromeDriver();
        }
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        // writing everything to document
        //flush() - to write or update test information to your report.
        Constant.REPORT.flush();
        //Call close() at the very end of your session to clear all resources.
        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream.
        //Once this method is called, calling any Extent method will throw an error.
        //close() - To close all the operation
        Constant.REPORT.close();
        Constant.WEBDRIVER.quit();
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            Constant.LOGGER.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            Constant.LOGGER.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            Constant.LOGGER.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            Constant.LOGGER.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        Constant.REPORT.endTest(Constant.LOGGER);
    }

}
