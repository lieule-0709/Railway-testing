package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC02_User_can_not_login_with_blank_UsernameTextbox extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(dataProvider = "data", description = "User can't login with blank \"Username\" textbox")
    public void TC02(Object data) throws Exception {
        JSONObject jsonData = (JSONObject) data;
        logger = Constant.REPORT.startTest("TC02", "User can't login with blank \"Username\" textbox");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        logger.log(LogStatus.INFO, "Step 3", "User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Login\" button");
        loginPage.login((String) jsonData.get("userName"), (String) jsonData.get("password"));

        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
