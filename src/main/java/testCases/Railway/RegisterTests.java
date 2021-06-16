package testCases.Railway;


import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Railway.GeneralPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.RegisterPage;

public class RegisterTests extends BaseTest {
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage;

    @Test
    public void TC07(){
        homePage = new HomePage();
        homePage.open();
        registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email"+ (int)(Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "123456789", "123456789");
        String actualMsg = registerPage.getMsgSuccess();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "the success Msg is displayed not correctly");
    }
}
