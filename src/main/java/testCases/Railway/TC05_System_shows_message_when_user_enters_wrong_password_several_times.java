package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

public class TC05_System_shows_message_when_user_enters_wrong_password_several_times extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05(Method method) throws Exception {
        //ExtentReports Description
//        startTest(method.getName(), "System shows message when user enters wrong password several times");

        homePage.open();
        loginPage = homePage.navigateToLoginPage();

        for(int i=0; i<4; i++){
            loginPage.login( "abc@xyz.com", "87654321");
        }

        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }
}
