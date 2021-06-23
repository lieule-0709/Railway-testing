package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.ChangePwdPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

//import static common.utilities.extentReports.ExtentTestManger.startTest;

public class TC09_User_can_change_password extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ChangePwdPage changePwdPage;

    @Test(description = "User can change password")
    public void TC09(Method method) {
        logger = Constant.REPORT.startTest("TC09", "User can change password");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Login with valid account");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login("abc@xyz.com", "12345678");

        logger.log(LogStatus.INFO, "Step 3", "Click on \"Change Password\" tab");
        changePwdPage = homePage.navigateToChangePwdPage();

        logger.log(LogStatus.INFO, "Step 4", "Enter valid value into all fields.");
        logger.log(LogStatus.INFO, "Step 5", "Click on \"Change Password\" button");
        changePwdPage.changePwd("12345678", "12345678", "12345678");

        String actual = changePwdPage.getSuccessMsgText();
        String expected = "Your password has been updated!";
        Assert.assertEquals(actual, expected, "Message is not correct");
    }
}
