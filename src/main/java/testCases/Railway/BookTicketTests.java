package testCases.Railway;

import common.constant.Constant;
import dataObjects.SeatTypes;
import dataObjects.Stations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.*;

public class BookTicketTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    private TimeTablePage timeTablePage;

    @Test
    public void TC14() {
        System.out.println("User can book 1 ticket at a time");
        homePage.open();
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        bookTicketPage = homePage.navigateToBookTicketPage();
        bookTicketPage.bookTicket("6/29/2021", Stations.SAI_GON, Stations.NHA_TRANG, SeatTypes.SBC, "1");

        String actual = bookTicketSuccessPage.getSuccessMsgText();
        String expected = "Ticket booked successfully!";
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

    @Test
    public void TC15() {
        System.out.println("User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
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
