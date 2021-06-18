package testCases.Railway;


import common.constant.Constant;
import common.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class LoginTest extends BaseTest{

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01(Method method) throws Exception {

        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

        homePage.open();
        Object[][] data = Utilities.readCSVData(Constant.DATA_LOGIN_PATH);
        for(int i=0; i< data.length; i++){
            loginPage = homePage.navigateToLoginPage();
            String actualMsg = loginPage.login(data[i][0]+"", data[i][1]+"").getWelcomeMessage();
            String expectedMsg = "Welcome " + data[i][0];
            Assert.assertEquals(actualMsg,expectedMsg, "welcome msg is not correctly");
            homePage.navigateToLogoutPage();
        }
    }

    @Test(description = "User can't login with blank \"Username\" textbox")
    public void TC02(Method method) throws Exception {

        //ExtentReports Description
        startTest(method.getName(), "User can't login with blank \"Username\" textbox");

        loginPage = homePage.navigateToLoginPage();
        loginPage.login( "", "12345678");
        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03(Method method) throws Exception {

        //ExtentReports Description
        startTest(method.getName(), "User cannot log into Railway with invalid password");

        loginPage = homePage.navigateToLoginPage();
        loginPage.login( "thanhle@logigear.com", "87654321");
        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05(Method method) throws Exception {

        //ExtentReports Description
        startTest(method.getName(), "System shows message when user enters wrong password several times");

        loginPage = homePage.navigateToLoginPage();

        for(int i=0; i<4; i++){
            loginPage.login( "abc@xyz.com", "87654321");
        }

        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
