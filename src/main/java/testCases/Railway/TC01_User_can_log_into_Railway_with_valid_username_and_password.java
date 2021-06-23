package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import common.utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC01_User_can_log_into_Railway_with_valid_username_and_password extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() throws Exception {
        logger = Constant.REPORT.startTest("TC01", "User can log into Railway with valid username and password");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        logger.log(LogStatus.INFO, "step 3", "Enter valid Email and Password");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Login\" button");
        String actualMsg = loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();
        String expectedMsg = "Welcome " + System.getenv("USERNAME");

        Assert.assertEquals(actualMsg, expectedMsg, "welcome msg is not correctly");
    }
}
