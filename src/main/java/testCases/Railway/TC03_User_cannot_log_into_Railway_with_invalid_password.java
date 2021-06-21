package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC03_User_cannot_log_into_Railway_with_invalid_password extends  BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03(Method method) throws Exception {
        logger = Constant.REPORT.startTest("TC03", "User cannot log into Railway with invalid password");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        logger.log(LogStatus.INFO, "Step 3", "Enter valid Email and invalid Password");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Login\" button");
        loginPage.login( "thanhle@logigear.com", "87654321");

        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
