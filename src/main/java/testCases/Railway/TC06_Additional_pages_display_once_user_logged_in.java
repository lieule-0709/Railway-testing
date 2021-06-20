package testCases.Railway;

import common.constant.Constant;
import dataObjects.Tabs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC06_Additional_pages_display_once_user_logged_in extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "Additional pages display once user logged in")
    public void TC06(Method method) {
        homePage.open();
        loginPage = homePage.navigateToLoginPage();
        loginPage.login("thanhle@logigear.com", "12345678");
        Assert.assertNotNull(homePage.getTab("My ticket"));
        Assert.assertNotNull(homePage.getTab("Change password"));
        Assert.assertNotNull(homePage.getTab("Log out"));

        homePage.navigateToMyTicketPage();
        Boolean verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("My Ticket") != -1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), Tabs.MY_TICKET, "Selected tab is not correct");

        homePage.navigateToChangePwdPage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Change Password") != -1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), Tabs.CHANGE_PASSWORD, "Selected tab is not correct");
    }
}
