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

public class RegisterTests extends GeneralPage {

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterClass
    public void afterClass(){
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC07(){
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.navigateToRegisterPage();
        registerPage.regist("email"+ (int)(Math.random() * 10000 + 10000) + "@gmail.com", "123456789", "123456789", "123456789");
        String actualMsg = registerPage.getMsgSuccess();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "the success Msg is displayed not correctly");
    }
}
