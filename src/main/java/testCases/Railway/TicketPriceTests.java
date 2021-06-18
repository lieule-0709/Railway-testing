package testCases.Railway;

import common.constant.Constant;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.TicketPriceListPage;

public class TicketPriceTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private TicketPriceListPage ticketPriceListPage;

    @Test
    public void TC003() {
        homePage.open();
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        ticketPriceListPage = homePage.navigateToTicketPriceListPage();
        ticketPriceListPage.goToCheckPricePage("Quảng Ngãi", "Huế");
    }
}
