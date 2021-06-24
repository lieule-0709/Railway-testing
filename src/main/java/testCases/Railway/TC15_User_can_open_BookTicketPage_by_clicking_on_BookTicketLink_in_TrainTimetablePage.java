package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.TimeTablePage;

public class TC15_User_can_open_BookTicketPage_by_clicking_on_BookTicketLink_in_TrainTimetablePage extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private TimeTablePage timeTablePage;
    private BookTicketPage bookTicketPage;

    @Test(dataProvider = "data", description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15(Object data) {
        logger = Constant.REPORT.startTest("TC15", "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        JSONObject jsonData = (JSONObject) data;

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Login with a valid account");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();

        logger.log(LogStatus.INFO, "Step 3", "Click on \"Timetable\" tab");
        timeTablePage = homePage.navigateToTimeTablePage();

        logger.log(LogStatus.INFO, "Step 4", "Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");
        bookTicketPage = timeTablePage.goToBookTicketpage((String) jsonData.get("depart station"), (String) jsonData.get("arriver station"));

        String actual = bookTicketPage.getDepartStation();
        Assert.assertEquals(actual, jsonData.get("depart station"), "Depart station is not correct");

        actual = bookTicketPage.getArriveStation();
        Assert.assertEquals(actual, jsonData.get("arriver station"), "Arrive station is not correct");
    }
}
