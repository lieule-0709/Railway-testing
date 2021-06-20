package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

import java.lang.reflect.Method;

//import static common.utilities.extentReports.ExtentTestManger.startTest;

public class TC07_User_can_create_new_account extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test(description = "User can create new account")
    public void TC07(Method method) {
//        startTest(method.getName(), "User can create new account");

        System.out.println("");
        homePage = new HomePage();
        homePage.open();
        registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "123456789", "123456789");
        String actualMsg = registerPage.getSuccessMsgText();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "the success Msg is displayed not correctly");
    }
}
