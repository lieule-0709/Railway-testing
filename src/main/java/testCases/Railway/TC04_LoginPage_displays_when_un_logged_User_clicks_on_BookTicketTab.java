package testCases.Railway;

import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class TC04_LoginPage_displays_when_un_logged_User_clicks_on_BookTicketTab extends BaseTest {
    private HomePage homePage = new HomePage();

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04(Method method) {
        startTest(method.getName(), "Login page displays when un-logged User clicks on \"Book ticket\" tab");

        homePage.open();
        homePage.navigateToBookTicketPage();
        Boolean verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Login") != -1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Login", "Selected tab is not correct");
    }
}
