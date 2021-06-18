package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class RegisterTests extends BaseTest {
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test(description = "User can create new account")
    public void TC07(Method method) {
        startTest(method.getName(), "User can create new account");

        System.out.println("");
        homePage = new HomePage();
        homePage.open();
        registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "123456789", "123456789");
        String actualMsg = registerPage.getSuccessMsgText();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "the success Msg is displayed not correctly");
    }

    @Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10(Method method) {
        startTest(method.getName(), "User can't create account with \"Confirm password\" is not the same with \"Password\"");

        homePage = new HomePage();
        homePage.open();
        registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "1321", "");

        String actualMsg = registerPage.getErrMsgText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11(Method method) {
        startTest(method.getName(), "User can't create account while password and PID fields are empty");

        homePage = new HomePage();
        homePage.open();
        registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "", "", "");

        String actualMsg = registerPage.getErrMsgText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct");

        actualMsg = registerPage.getErrPwdLblText();
        expectedMsg = "Invalid password length.";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct next to password field");

        actualMsg = registerPage.getErrPIDLblText();
        expectedMsg = "Invalid ID length.";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct next to PID field");
    }
}
