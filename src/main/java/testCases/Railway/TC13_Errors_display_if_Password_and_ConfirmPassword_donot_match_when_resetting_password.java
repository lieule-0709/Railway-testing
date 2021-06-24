package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.Railway.ForgotPasswordPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

public class TC13_Errors_display_if_Password_and_ConfirmPassword_donot_match_when_resetting_password extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Test(description = "Errors display if password and confirm password don't match when resetting password")
    public void TC13() {
        logger = Constant.REPORT.startTest("TC13", "Errors display if password and confirm password don't match when resetting password");

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
