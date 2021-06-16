package testCases.Railway;

import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.TicketPriceListPage;
import pageObjects.Railway.TicketPricePage;

import java.util.concurrent.TimeUnit;

public class TicketPriceTests {

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
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        TicketPriceListPage ticketPriceListPage = homePage.navigateToTicketPriceListPage();

        ticketPriceListPage.goToCheckPricePage("Quảng Ngãi", "Huế");

    }

}
