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

public class TimetableTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private TimeTablePage timeTablePage;

    @Test
    public void TC01() {
        homePage.open();
        timeTablePage = homePage.navigateToTimeTablePage();
        timeTablePage.goToBookTicketpage("Sài Gòn", "Huế");
    }
}
