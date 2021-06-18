package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.ChangePwdPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

public class ChangePasswordTest extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ChangePwdPage changePwdPage;

    @Test
    public void TC09(){
        System.out.println("User can change password");
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
