package testCases.Railway;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected ExtentTest logger;
    protected String pathFile = System.getProperty("user.dir") + "/src/main/java/testCases/Railway/data.csv";

    @DataProvider(name = "data")
    public Object[][] readCSVData() throws Exception {
        String[][] testData;

        Reader fileInputStream = new FileReader(pathFile);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(fileInputStream);

        int numberOfRecords = 0;
        int numberOfColumns = 0;

        for (CSVRecord record : records
        ) {
            System.out.println("Reading record line #" + ++numberOfRecords);
            numberOfColumns = record.size();
        }

        testData = new String[numberOfRecords - 1][numberOfColumns];

        int currentRecord = 0;

        fileInputStream = new FileReader(pathFile);
        records = CSVFormat.EXCEL.parse(fileInputStream);

        for (CSVRecord record : records) {
            System.out.println("Reading test data ");
            if (record.getRecordNumber() == 1) {
                System.out.println("record = " + record);
                continue;
            }

            for (int i = 0; i < record.size(); i++) {
                testData[currentRecord][i] = record.get(i);

            }
            currentRecord++;
        }
        return testData;
    }

    @Parameters("browserName")
    @BeforeSuite
    public void beforeSuite(String browserName){
        switch (browserName) {
            case "chrome":
                Constant.REPORT = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults_Chrome.html");
                break;
            case "firefox":
                Constant.REPORT = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults_Firefox.html");
                break;
            case "edge":
                Constant.REPORT = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults_Edge.html");
                break;
            default:
                Constant.REPORT = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
        }
        Constant.REPORT.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
    }

    @Parameters("browserName")
    @BeforeTest
    public void beforeTest(String browserName) {
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

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            logger.log(LogStatus.PASS, "PASSED", "Test Case "+result.getName() + " is Passed");
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, "FAILED", "Test Case "+result.getName() + " is Failed");
            logger.log(LogStatus.FAIL, "Reason for fail", result.getThrowable().getMessage());
            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Constant.WEBDRIVER).getScreenshotAs(OutputType.BASE64);
            logger.log(LogStatus.INFO, "Snapshot below: " + logger.addBase64ScreenShot(base64Screenshot));
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(LogStatus.SKIP, "SKIPPED", "Test Case "+result.getName() + " is Skipped");
            logger.log(LogStatus.SKIP, "Reason for skip", result.getThrowable().getMessage());
        }
        Constant.REPORT.endTest(logger);
    }

    @AfterTest
    public void afterTest() {
        Constant.WEBDRIVER.quit();
    }

    @AfterSuite
    public void afterSuite(){
        Constant.REPORT.flush();
        Constant.REPORT.close();
    }
}
