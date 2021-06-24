package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

public class TC05_System_shows_message_when_user_enters_wrong_password_several_times extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(dataProvider = "data", description = "System shows message when user enters wrong password several times")
    public void TC05(Object data) throws Exception {
        logger = Constant.REPORT.startTest("TC05", "System shows message when user enters wrong password several times");
        JSONObject jsonData = (JSONObject) data;

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        for (int i = 0; i < 4; i++) {
            logger.log(LogStatus.INFO, "Step 3", "Enter valid information into \"Username\" textbox except \"Password\" textbox.");
            logger.log(LogStatus.INFO, "Step 4", "Click on \"Login\" button");
            loginPage.login((String) jsonData.get("userName"), (String) jsonData.get("password"));
        }

        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
