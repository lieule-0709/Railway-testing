package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

import java.lang.reflect.Method;

public class TC11_User_cannot_create_account_while_password_PID_fields_are_empty extends BaseTest {
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11(Method method) {
        logger = Constant.REPORT.startTest("TC11", "User can't create account while password and PID fields are empty");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Register\" tab");
        registerPage = homePage.navigateToRegisterPage();

        logger.log(LogStatus.INFO, "Step 3", "Enter valid email address and leave other fields empty");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Register\" button");
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "", "", "");

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
