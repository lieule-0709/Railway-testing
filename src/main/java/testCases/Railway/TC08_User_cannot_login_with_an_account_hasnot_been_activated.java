package testCases.Railway;

import com.aventstack.extentreports.ExtentTest;
import common.utilities.extentReports.ExtentTestManger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class TC08_User_cannot_login_with_an_account_hasnot_been_activated extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08(Method method) throws Exception {
        //ExtentReports Description
        startTest(method.getName(), "User can't login with an account hasn't been activated");
    }

}
