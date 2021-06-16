package testCases.Railway;

import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.MyTicketPage;

import java.util.concurrent.TimeUnit;

public class MyTicketTests {

    HomePage homePage = new HomePage();

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
//        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {

        homePage.open();
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        MyTicketPage myTicketPage = homePage.navigateToMyTicketPage();

        myTicketPage.cancelTicket("Đà Nẵng", "Sài Gòngit", "", "", "", "", "New");

    }
}
