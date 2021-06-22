package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import dataObjects.SeatTypes;
import dataObjects.Stations;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.MyTicketPage;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TC16_User_can_cancel_a_ticket extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private MyTicketPage myTicketPage;

    @Test(description = "User can cancel a ticket")
    public void TC16(Method method) throws InterruptedException {
        logger = Constant.REPORT.startTest("TC16", "User can cancel a ticket");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO,"Step 2", "Login with a valid account");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();


        logger.log(LogStatus.INFO, "Step 3", "Book a ticket");
        bookTicketPage = homePage.navigateToBookTicketPage();
        bookTicketPage.bookTicket("6/29/2021", Stations.DA_NANG, Stations.SAI_GON, SeatTypes.HS, "1");

        logger.log(LogStatus.INFO, "Step 4", "Click on \"My ticket\" tab");
        myTicketPage = homePage.navigateToMyTicketPage();

        int countRowsBefore = myTicketPage.countRowsFitInfo(Stations.DA_NANG, Stations.SAI_GON, "", "", "", "New", "1");

        logger.log(LogStatus.INFO, "Step 5", "Click on \"Cancel\" button of ticket which user has just booked.");
        logger.log(LogStatus.INFO, "Step 6", "Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.cancelTicket(Stations.DA_NANG, Stations.SAI_GON, SeatTypes.HS, "", "", "New", "1");
        Thread.sleep(Constant.SHORT_SLEEP);
        int countRowsAfter = myTicketPage.countRowsFitInfo(Stations.DA_NANG, Stations.SAI_GON, "", "", "", "New", "1");
        Assert.assertEquals(countRowsAfter, countRowsBefore-1, "Cancel ticket failed");
    }
}
