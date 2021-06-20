package testCases.Railway;

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
//import static common.utilities.extentReports.ExtentTestManger.startTest;


public class TC14_User_can_book_1_ticket_at_a_time extends BaseTest {
    private HomePage homePage = new HomePage();
    private BookTicketPage bookTicketPage;
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();

    @Test(description = "User can book 1 ticket at a time")
    public void TC14(Method method) {
        //ExtentReports Description
//        startTest(method.getName(), "User can book 1 ticket at a time");

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
}
