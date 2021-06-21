package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

import java.lang.reflect.Method;

public class TC07_User_can_create_new_account extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test(description = "User can create new account")
    public void TC07(Method method) {
        logger = Constant.REPORT.startTest("TC07", "User can create new account");

        logger.log(LogStatus.INFO, "Step 1", "Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.INFO, "Step 2", "Click on \"Register\" tab");
        registerPage = homePage.navigateToRegisterPage();

        logger.log(LogStatus.INFO, "Step 3", "Enter valid information into all fields");
        logger.log(LogStatus.INFO, "Step 4", "Click on \"Register\" button");
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "123456789", "123456789");

        String actualMsg = registerPage.getSuccessMsgText();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "the success message is displayed not correctly");
    }
}
