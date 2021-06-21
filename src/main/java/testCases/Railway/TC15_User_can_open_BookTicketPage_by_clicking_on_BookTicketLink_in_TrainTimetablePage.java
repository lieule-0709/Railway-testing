package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import dataObjects.Stations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.TimeTablePage;

import java.lang.reflect.Method;

public class TC15_User_can_open_BookTicketPage_by_clicking_on_BookTicketLink_in_TrainTimetablePage extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private TimeTablePage timeTablePage;
    private BookTicketPage bookTicketPage;

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15(Method method) {
        logger = Constant.REPORT.startTest("TC15", "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Login with a valid account");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();

        logger.log(LogStatus.INFO, "Step 3", "Click on \"Timetable\" tab");
        timeTablePage = homePage.navigateToTimeTablePage();

        logger.log(LogStatus.INFO, "Step 4", "Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");
        bookTicketPage = timeTablePage.goToBookTicketpage(Stations.HUE, Stations.SAI_GON);

        String actual = bookTicketPage.getDepartStation();
        String expected = Stations.HUE;
        Assert.assertEquals(actual, expected, "Depart station is not correct");

        actual = bookTicketPage.getArriveStation();
        expected = Stations.SAI_GON;
        Assert.assertEquals(actual, expected, "Arrive station is not correct");
    }
}
