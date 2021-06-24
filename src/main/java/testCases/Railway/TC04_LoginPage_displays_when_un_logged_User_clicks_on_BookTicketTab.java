package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;

public class TC04_LoginPage_displays_when_un_logged_User_clicks_on_BookTicketTab extends BaseTest {
    private HomePage homePage = new HomePage();

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        logger = Constant.REPORT.startTest("TC04", "Login page displays when un-logged User clicks on \"Book ticket\" tab");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Book ticket\" tab");
        homePage.navigateToBookTicketPage();

        Boolean verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Login") != -1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Login", "Selected tab is not correct");
    }
}
