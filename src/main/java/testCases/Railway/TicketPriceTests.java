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

public class TicketPriceTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private TicketPriceListPage ticketPriceListPage;

    @Test
    public void TC01() {
        homePage.open();
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        ticketPriceListPage = homePage.navigateToTicketPriceListPage();
        ticketPriceListPage.goToCheckPricePage("Quảng Ngãi", "Huế");
    }

}
