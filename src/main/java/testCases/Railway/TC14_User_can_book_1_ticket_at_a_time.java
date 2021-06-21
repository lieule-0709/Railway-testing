package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import dataObjects.SeatTypes;
import dataObjects.Stations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.BookTicketSuccessPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import java.lang.reflect.Method;

public class TC14_User_can_book_1_ticket_at_a_time extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();

    @Test(description = "User can book 1 ticket at a time")
    public void TC14(Method method) {
        logger = Constant.REPORT.startTest("TC14", "User can book 1 ticket at a time");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Login with a valid account ");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();

        logger.log(LogStatus.INFO, "Step 3", "Click on \"Book ticket\" tab");
        bookTicketPage = homePage.navigateToBookTicketPage();

        logger.log(LogStatus.INFO, "Step 4", "Select a \"Depart date\" from the list");
        logger.log(LogStatus.INFO, "Step 5", "Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");;
        logger.log(LogStatus.INFO, "Step 6", "Select \"Soft bed with air conditioner\" for \"Seat type\"");
        logger.log(LogStatus.INFO, "Step 7", "Select \"1\" for \"Ticket amount\"");
        logger.log(LogStatus.INFO, "Step 8", "Click on \"Book ticket\" button");
        bookTicketPage.bookTicket("6/29/2021", Stations.SAI_GON, Stations.NHA_TRANG, SeatTypes.SBC, "1");

        String actual = bookTicketSuccessPage.getSuccessMsgText();
        String expected = "Ticket Booked Successfully!";
        Assert.assertEquals(actual, expected, "Success message is displayed not correct");

        actual = bookTicketSuccessPage.getDepartDate();
        expected = "6/29/2021";
        Assert.assertEquals(actual, expected, "Depart date is not correct");

        actual = bookTicketSuccessPage.getDepartStation();
        expected = Stations.SAI_GON;
        Assert.assertEquals(actual, expected, "Depart station is not correct");

        actual = bookTicketSuccessPage.getArriveStation();
        expected = Stations.NHA_TRANG;
        Assert.assertEquals(actual, expected, "Arrive station is not correct");

        actual = bookTicketSuccessPage.getSeatType();
        expected = SeatTypes.SBC;
        Assert.assertEquals(actual, expected, "Seat type is not correct");

        actual = bookTicketSuccessPage.getAmount();
        expected = "1";
        Assert.assertEquals(actual, expected, "Ticket amount is not correct");
    }
}
