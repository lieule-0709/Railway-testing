package testCases.Railway;


import common.constant.Constant;
import common.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;


public class TC01_User_can_log_into_Railway_with_valid_username_and_password extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01(Method method) throws Exception {
        //ExtentReports Description
//        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        homePage.open();
        Object[][] data = Utilities.readCSVData(Constant.DATA_LOGIN_PATH);
        for (int i = 0; i < data.length; i++) {
            loginPage = homePage.navigateToLoginPage();
            String actualMsg = loginPage.login(data[i][0] + "", data[i][1] + "").getWelcomeMessage();
            String expectedMsg = "Welcome " + data[i][0];
            Assert.assertEquals(actualMsg, expectedMsg, "welcome msg is not correctly");
            homePage.navigateToLogoutPage();
        }
    }
}
