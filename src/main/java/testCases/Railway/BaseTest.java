package testCases.Railway;

import common.constant.Constant;
import common.utilities.logs.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @Parameters("browserName")
    @BeforeClass
    public void beforeClass(String browserName) {
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
        Log.info("Tests is starting!");
    }

    @AfterClass
    public void afterClass() {
        Log.info("Tests are ending!");
        Constant.WEBDRIVER.quit();
    }

    public WebDriver getDriver() {
        return Constant.WEBDRIVER;
    }

}
