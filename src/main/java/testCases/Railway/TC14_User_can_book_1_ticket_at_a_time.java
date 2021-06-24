package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.BookTicketSuccessPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

public class TC14_User_can_book_1_ticket_at_a_time extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();

    @Test(dataProvider = "data", description = "User can book 1 ticket at a time")
    public void TC14(Object data) {
        JSONObject jsonData = (JSONObject) data;
        logger = Constant.REPORT.startTest("TC14", "User can book 1 ticket at a time");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Login with a valid account ");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();

        logger.log(LogStatus.INFO, "Step 3", "Click on \"Book ticket\" tab");
        bookTicketPage = homePage.navigateToBookTicketPage();

        logger.log(LogStatus.INFO, "Step 4", "Select " + jsonData.get("date") + " from the list depart date");
        logger.log(LogStatus.INFO, "Step 5", "Select " + jsonData.get("depart station") + " for \"Depart from\" and " + jsonData.get("arriver station") + " for \"Arrive at\".");
        ;
        logger.log(LogStatus.INFO, "Step 6", "Select " + jsonData.get("seat type") + " for \"Seat type\"");
        logger.log(LogStatus.INFO, "Step 7", "Select " + jsonData.get("amount") + " for \"Ticket amount\"");
        logger.log(LogStatus.INFO, "Step 8", "Click on \"Book ticket\" button");
        bookTicketPage.bookTicket((String) jsonData.get("date"), (String) jsonData.get("depart station"), (String) jsonData.get("arriver station"), (String) jsonData.get("seat type"), (String) jsonData.get("amount"));

        String actual = bookTicketSuccessPage.getSuccessMsgText();
        String expected = "Ticket Booked Successfully!";
        Assert.assertEquals(actual, expected, "Success message is displayed not correct");

        actual = bookTicketSuccessPage.getDepartDate();
        Assert.assertEquals(actual, jsonData.get("date"), "Depart date is not correct");

        actual = bookTicketSuccessPage.getDepartStation();
        Assert.assertEquals(actual, jsonData.get("depart station"), "Depart station is not correct");

        actual = bookTicketSuccessPage.getArriveStation();
        Assert.assertEquals(actual, jsonData.get("arriver station"), "Arrive station is not correct");

        actual = bookTicketSuccessPage.getSeatType();
        Assert.assertEquals(actual, jsonData.get("seat type"), "Seat type is not correct");

        actual = bookTicketSuccessPage.getAmount();
        Assert.assertEquals(actual, jsonData.get("amount"), "Ticket amount is not correct");
    }
}
