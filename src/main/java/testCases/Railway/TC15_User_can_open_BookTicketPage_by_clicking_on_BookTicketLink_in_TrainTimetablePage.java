package testCases.Railway;

import dataObjects.Stations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.TimeTablePage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class TC15_User_can_open_BookTicketPage_by_clicking_on_BookTicketLink_in_TrainTimetablePage extends BaseTest{
    private HomePage homePage = new HomePage();
    private TimeTablePage timeTablePage;
    private BookTicketPage bookTicketPage;

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15(Method method) {
        startTest(method.getName(), "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        homePage.open();
        timeTablePage = homePage.navigateToTimeTablePage();
        bookTicketPage = timeTablePage.goToBookTicketpage(Stations.HUE, Stations.SAI_GON);

        String actual = bookTicketPage.getDepartStation();
        String expected = Stations.HUE;
        Assert.assertEquals(actual, expected, "Depart station is not correct");

        actual = bookTicketPage.getArriveStation();
        expected = Stations.SAI_GON;
        Assert.assertEquals(actual, expected, "Arrive station is not correct");
    }
}
