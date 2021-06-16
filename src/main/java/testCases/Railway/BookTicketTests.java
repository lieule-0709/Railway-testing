package testCases.Railway;

import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.util.concurrent.TimeUnit;

public class BookTicketTests {

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
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {

        homePage.open();

        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        homePage.navigateToBookTicketPage();

        BookTicketPage bookTicketPage= homePage.navigateToBookTicketPage();

        bookTicketPage.bookTicket("6/29/2021", "Đà Nẵng", "Nha Trang", "Hard seat", "2");


    }
}
