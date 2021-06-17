package testCases.Railway;


import common.constant.Constant;
import common.utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

public class LoginTest extends BaseTest{

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test
    public void TC01() throws Exception {
        System.out.println("User can log into Railway with valid username and password");
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

    @Test
    public void TC02() throws Exception {
        System.out.println("User can't login with blank \"Username\" textbox");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login( "", "12345678");
        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }

    @Test
    public void TC03() throws Exception {
        System.out.println("User cannot log into Railway with invalid password");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login( "thanhle@logigear.com", "87654321");
        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }

    @Test
    public void TC05() throws Exception {
        System.out.println("System shows message when user enters wrong password several times");
        loginPage = homePage.navigateToLoginPage();
        loginPage.login( "abc@xyz.com", "87654321");
        loginPage.login( "abc@xyz.com", "87654321");
        loginPage.login( "abc@xyz.com", "87654321");
        loginPage.login( "abc@xyz.com", "87654321");
        String actualMsg = loginPage.getErrMsgText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not correctly");
    }

}
