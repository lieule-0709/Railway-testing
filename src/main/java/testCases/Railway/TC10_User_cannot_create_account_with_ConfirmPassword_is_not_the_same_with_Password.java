package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

public class TC10_User_cannot_create_account_with_ConfirmPassword_is_not_the_same_with_Password extends BaseTest {
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test(dataProvider = "data", description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10(Object data) {
        logger = Constant.REPORT.startTest("TC10", "User can't create account with \"Confirm password\" is not the same with \"Password\"");
        JSONObject jsonData = (JSONObject) data;

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Register\" tab");
        registerPage = homePage.navigateToRegisterPage();

        logger.log(LogStatus.INFO, "Step 3", "Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Register\" button");
        registerPage.regist("" + (int) (Math.random() * 10000 + 10000) + jsonData.get("email"), (String) jsonData.get("password"), (String) jsonData.get("confirm password"), (String) jsonData.get("pid"));

        String actualMsg = registerPage.getErrMsgText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct");
    }
}
