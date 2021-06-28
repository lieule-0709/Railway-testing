package testCases.Railway;

import com.mongodb.util.JSON;
import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.MyTicketPage;

public class TC17_User_can_filter_ticket_with_DepartDate extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private MyTicketPage myTicketPage;

    @Test(dataProvider = "data", description = "User can cancel a ticket")
    public void TC17(Object data) throws InterruptedException {
        logger = Constant.REPORT.startTest("TC17", "User can filter tickets with Depart Date");
        JSONArray dates = (JSONArray) ((JSONObject) data).get("dates");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Login with a valid account");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();

        for (Object date : dates
        ) {
            bookTicketPage = homePage.navigateToBookTicketPage();
            bookTicketPage.bookTicketWithDate((String) date);
        }

        logger.log(LogStatus.INFO, "Step 4", "Click on \"My ticket\" tab");
        myTicketPage = homePage.navigateToMyTicketPage();

        logger.log(LogStatus.INFO, "Step 5", "Enter Depart date in filter form");
        logger.log(LogStatus.INFO, "Step 6", "Click on \"submit filter\" button");
        myTicketPage.filterTicketByDate("7/7/2021");

        Thread.sleep(Constant.SHORT_SLEEP);
        Assert.assertTrue(myTicketPage.checkDateFilter("7/7/2021"));
    }
}
