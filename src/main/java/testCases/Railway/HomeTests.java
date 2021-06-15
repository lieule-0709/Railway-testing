package testCases.Railway;


import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;

public class HomeTests {

    HomePage homePage = new HomePage();

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
    public void TC02(){
        homePage.open();

        homePage.navigateToHomePage();
        Boolean verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Home")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Home", "Selected tab is not correct");

        homePage.navigateToContactPage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Contact")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Contact", "Selected tab is not correct");

        homePage.navigateToTimeTablePage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Timetable")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Timetable", "Selected tab is not correct");

        homePage.navigateToTicketPricePage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("ticket price")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Ticket price", "Selected tab is not correct");

        homePage.navigateToBookTicketPage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Login")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Login", "Selected tab is not correct");

        homePage.navigateToRegisterPage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Register")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Register", "Selected tab is not correct");

        homePage.navigateToLoginPage();
        verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Login")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Login", "Selected tab is not correct");

    }


    @Test
    public void TC04(){
        homePage.open();
        homePage.goToRegisterPage();
        System.out.println(Constant.WEBDRIVER.getTitle());
        Boolean verifyTitle = Constant.WEBDRIVER.getTitle().indexOf("Register")!=-1;
        Assert.assertTrue(verifyTitle);
        Assert.assertEquals(homePage.getTextOfSelectedTab(), "Register", "Selected tab is not correct");
    }
}
