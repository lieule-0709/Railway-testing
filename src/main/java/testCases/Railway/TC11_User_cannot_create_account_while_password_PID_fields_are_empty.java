package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

public class TC11_User_cannot_create_account_while_password_PID_fields_are_empty extends BaseTest {
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test(dataProvider = "data", description = "User can't create account while password and PID fields are empty")
    public void TC11(Object data) {
        logger = Constant.REPORT.startTest("TC11", "User can't create account while password and PID fields are empty");
        JSONObject jsonData = (JSONObject) data;

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Register\" tab");
        registerPage = homePage.navigateToRegisterPage();

        logger.log(LogStatus.INFO, "Step 3", "Enter valid email address and leave other fields empty");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Register\" button");
        registerPage.regist("" + (int) (Math.random() * 10000 + 10000) + jsonData.get("email"), (String) jsonData.get("password"), (String) jsonData.get("confirm password"), (String) jsonData.get("pid"));

        String actualMsg = registerPage.getErrMsgText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct");

        actualMsg = registerPage.getErrPwdLblText();
        expectedMsg = "Invalid password length";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct next to password field");

        actualMsg = registerPage.getErrPIDLblText();
        expectedMsg = "Invalid ID length";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct next to PID field");
    }
}
