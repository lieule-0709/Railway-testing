package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.Railway.ForgotPasswordPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC12_Errors_display_when_password_reset_token_is_blank extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Test(description = "Errors display when password reset token is blank")
    public void TC12() {
        logger = Constant.REPORT.startTest("TC12", "Errors display when password reset token is blank");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Login page");
        homePage.open();
        loginPage = homePage.navigateToLoginPage();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Forgot Password page\" link");
        forgotPasswordPage = loginPage.clickForgotPwdLink();

        logger.log(LogStatus.INFO, "Step 3", "Enter the email address of the created account in Pre-condition");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Send Instructions\" button");
        forgotPasswordPage.sendResetPwdForm(System.getenv("USERNAME"));

        logger.log(LogStatus.INFO, "Step 5", "Open mailbox and click on reset password link");
        logger.getTest().setStatus(LogStatus.SKIP);
        throw new SkipException("Mailbox not received anything");
    }
}
