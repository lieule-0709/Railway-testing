package testCases.Railway;

import com.mongodb.util.JSON;
import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC03_User_cannot_log_into_Railway_with_invalid_password extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(dataProvider = "data", description = "User cannot log into Railway with invalid password")
    public void TC03(Object data) throws Exception {
        logger = Constant.REPORT.startTest("TC03", "User cannot log into Railway with invalid password");
        JSONObject jsonData = (JSONObject) data;

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        logger.log(LogStatus.INFO, "Step 3", "Enter valid Email and invalid Password");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Login\" button");
        loginPage.login((String) jsonData.get("userName"), (String) jsonData.get("password"));

        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
