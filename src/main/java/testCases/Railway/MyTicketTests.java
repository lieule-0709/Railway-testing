package testCases.Railway;

import common.constant.Constant;
import dataObjects.Stations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.MyTicketPage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;


public class MyTicketTests extends BaseTest{

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private MyTicketPage myTicketPage;

    @Test(description = "User can cancel a ticket")
    public void TC16(Method method) {
        startTest(method.getName(), "User can cancel a ticket");

        homePage.open();
        loginPage = homePage.navigateToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        myTicketPage = homePage.navigateToMyTicketPage();

        int countRowsBefore = myTicketPage.countRowsFitInfo(Stations.SAI_GON, Stations.NHA_TRANG, "", "", "", "New", "1");
        myTicketPage.cancelTicket(Stations.SAI_GON, Stations.NHA_TRANG, "", "", "", "New", "1");

        int countRowsAfter = myTicketPage.countRowsFitInfo(Stations.SAI_GON, Stations.NHA_TRANG, "", "", "", "New", "1");

        Assert.assertEquals(countRowsAfter, countRowsBefore-1, "Cancel ticket failed");
    }
}
