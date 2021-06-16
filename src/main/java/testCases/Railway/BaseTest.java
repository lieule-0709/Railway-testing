package testCases.Railway;

import common.constant.Constant;
import common.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        Constant.WEBDRIVER.quit();
    }

}
