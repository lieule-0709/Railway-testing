package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

public class RegisterTests extends BaseTest {
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test
    public void TC07() {
        System.out.println("User can create new account");
        homePage = new HomePage();
        homePage.open();
        registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "123456789", "123456789");
        String actualMsg = registerPage.getSuccessMsgText();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "the success Msg is displayed not correctly");
    }

    @Test
    public void TC10() {
        System.out.println("User can't create account with \"Confirm password\" is not the same with \"Password\"");
        homePage = new HomePage();
        homePage.open();
        registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email" + (int) (Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "1321", "");

        String actualMsg = registerPage.getErrMsgText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "the error message is displayed not correct");
    }

    @Test
    public void TC11() {
        System.out.println("User can't create account while password and PID fields are empty");
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
