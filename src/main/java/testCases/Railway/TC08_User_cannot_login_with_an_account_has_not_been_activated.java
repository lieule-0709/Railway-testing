package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import javax.management.monitor.GaugeMonitor;
import java.lang.reflect.Method;

public class TC08_User_cannot_login_with_an_account_has_not_been_activated extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        logger = Constant.REPORT.startTest("TC08", "User can't login with an account hasn't been activated");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Login\" tab");
        loginPage = homePage.navigateToLoginPage();

        logger.log(LogStatus.INFO, "Step 3", "Enter username and password of account hasn't been activated.");
        logger.getTest().setStatus(LogStatus.SKIP);
        throw new SkipException("There isn't any account hasn't been activated");
    }

}
