package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.MyTicketPage;

public class TC16_User_can_cancel_a_ticket extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private MyTicketPage myTicketPage;

    @Test(dataProvider = "data", description = "User can cancel a ticket")
    public void TC16(Object data) throws InterruptedException {
        logger = Constant.REPORT.startTest("TC16", "User can cancel a ticket");
        JSONObject jsonData = (JSONObject) data;

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Login with a valid account");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();

        logger.log(LogStatus.INFO, "Step 3", "Book a ticket");
        bookTicketPage = homePage.navigateToBookTicketPage();
        bookTicketPage.bookTicket((String) jsonData.get("date"), (String) jsonData.get("depart station"), (String) jsonData.get("arriver station"), (String) jsonData.get("seat type"), (String) jsonData.get("amount"));

        logger.log(LogStatus.INFO, "Step 4", "Click on \"My ticket\" tab");
        myTicketPage = homePage.navigateToMyTicketPage();

        int countRowsBefore = myTicketPage.countRowsFitInfo((String) jsonData.get("depart station"), (String) jsonData.get("arriver station"), "", "", "", "New", (String) jsonData.get("amount"));

        logger.log(LogStatus.INFO, "Step 5", "Click on \"Cancel\" button of ticket which user has just booked.");
        logger.log(LogStatus.INFO, "Step 6", "Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.cancelTicket((String) jsonData.get("depart station"), (String) jsonData.get("arriver station"), "", "", "", "New", (String) jsonData.get("amount"));

        Thread.sleep(Constant.SHORT_SLEEP);
        int countRowsAfter = myTicketPage.countRowsFitInfo((String) jsonData.get("depart station"), (String) jsonData.get("arriver station"), "", "", "", "New", (String) jsonData.get("amount"));
        Assert.assertEquals(countRowsAfter, countRowsBefore - 1, "Cancel ticket failed");
    }
}
