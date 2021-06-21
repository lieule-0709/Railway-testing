package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC05_System_shows_message_when_user_enters_wrong_password_several_times extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05(Method method) throws Exception {
        logger = Constant.REPORT.startTest("TC05", "System shows message when user enters wrong password several times");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        for(int i=0; i<4; i++){
            logger.log(LogStatus.INFO, "Step 3", "Enter valid information into \"Username\" textbox except \"Password\" textbox.");
            logger.log(LogStatus.INFO, "Step 4", "Click on \"Login\" button");
            loginPage.login( "abc@xyz.com", "87654321");
        }

        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
