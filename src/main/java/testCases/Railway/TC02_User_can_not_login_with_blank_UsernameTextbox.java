package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class TC02_User_can_not_login_with_blank_UsernameTextbox extends BaseTest{

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User can't login with blank \"Username\" textbox")
    public void TC02(Method method) throws Exception {
        //ExtentReports Description
        startTest(method.getName(), "User can't login with blank \"Username\" textbox");

        homePage.open();
        loginPage = homePage.navigateToLoginPage();
        loginPage.login( "", "12345678");
        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }

}
