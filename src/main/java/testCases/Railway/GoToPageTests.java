package testCases.Railway;

import common.constant.Constant;
import dataObjects.Tabs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.GeneralPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import javax.swing.text.GapContent;

public class GoToPageTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC04(){
        System.out.println("Login page displays when un-logged User clicks on \"Book ticket\" tab");
        homePage.open();
        homePage.navigateToBookTicketPage();
        Boolean verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Login")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Login", "Selected tab is not correct");
    }


    @Test
    public void TC06(){
        loginPage.login("thanhle@logigear.com", "12345678");
        Assert.assertNotNull(homePage.getTab("My ticket"));
        Assert.assertNotNull(homePage.getTab("Change password"));
        Assert.assertNotNull(homePage.getTab("Log out"));

        homePage.navigateToMyTicketPage();
        Boolean verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("My Ticket")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), Tabs.MY_TICKET, "Selected tab is not correct");

        homePage.navigateToChangePwdPage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Change Password")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), Tabs.CHANGE_PASSWORD, "Selected tab is not correct");
    }

}
