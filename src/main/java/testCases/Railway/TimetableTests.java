package testCases.Railway;

import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.TimeTablePage;

import java.util.concurrent.TimeUnit;

public class TimetableTests {
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        HomePage homePage = new HomePage();
        homePage.open();

        TimeTablePage timeTablePage = homePage.navigateToTimeTablePage();

        timeTablePage.goToBookTicketpage("Sài Gòn", "Huế");
    }
}
