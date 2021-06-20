package testCases.Railway;

import com.relevantcodes.extentreports.LogStatus;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC03_User_cannot_log_into_Railway_with_invalid_password extends  BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03(Method method) throws Exception {
        //ExtentReports Description
//        startTest(method.getName(), "User cannot log into Railway with invalid password");
        Constant.LOGGER = Constant.REPORT.startTest("TC03", "User cannot log into Railway with invalid password");

        homePage.open();
        loginPage = homePage.navigateToLoginPage();
        loginPage.login( "thanhle@logigear.com", "87654321");
        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
