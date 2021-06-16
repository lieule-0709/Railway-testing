package testCases.Railway;

import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.util.concurrent.TimeUnit;

public class BookTicketTests {

    HomePage homePage = new HomePage();

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

        homePage.open();

        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        homePage.navigateToBookTicketPage();

        BookTicketPage bookTicketPage= homePage.navigateToBookTicketPage();

        bookTicketPage.bookTicket("6/29/2021", "Đà Nẵng", "Nha Trang", "Hard seat", "2");


    }
}
