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

public class MyTicketTests extends BaseTest{

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private MyTicketPage myTicketPage;

    @Test
    public void TC01() {
        homePage.open();
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        myTicketPage = homePage.navigateToMyTicketPage();
        myTicketPage.cancelTicket("Đà Nẵng", "Sài Gòngit", "", "", "", "", "New");
    }

}
