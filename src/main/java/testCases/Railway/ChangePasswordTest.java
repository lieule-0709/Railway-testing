package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.ChangePwdPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class ChangePasswordTest extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ChangePwdPage changePwdPage;

    @Test(description = "User can change password")
    public void TC09(Method method){

        startTest(method.getName(), "User can change password");

        homePage.open();

        loginPage = homePage.navigateToLoginPage();
        loginPage.login("abc@xyz.com", "12345678");

        changePwdPage = homePage.navigateToChangePwdPage();
        changePwdPage.changePwd("12345678", "12345678", "12345678");

        String actual = changePwdPage.getSuccessMsgText();
        String expected =  "Your password has been updated";
        Assert.assertEquals(actual, expected, "Message is not correct");
    }
}
