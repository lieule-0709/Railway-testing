package testCases.Railway;

import common.constant.Constant;
import common.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @Parameters("browserName")
    @BeforeClass
    public void beforeClass(String browserName){
        if(browserName.equalsIgnoreCase("chrome")) {
            //initializing and starting the Chromebrowser
            WebDriverManager.chromedriver().setup();
            Constant.WEBDRIVER = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")) {
            //initializing and starting the Chromebrowser
            WebDriverManager.firefoxdriver().setup();
            Constant.WEBDRIVER = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            Constant.WEBDRIVER = new EdgeDriver();
        }

        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        Constant.WEBDRIVER.quit();
    }

}
