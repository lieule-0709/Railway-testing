package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
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

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC06(Method method) {
        logger = Constant.REPORT.startTest("TC06", "System shows message when user enters wrong password several times");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        logger.log(LogStatus.INFO, "Step 3", "Login with valid account");
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD"));

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
