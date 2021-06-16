package testCases.Railway;


import common.constant.Constant;
import common.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() throws Exception {
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = null;

        Object[][] data = Utilities.readCSVData(Constant.DATA_LOGIN_PATH);
        
        for(int i=0; i< data.length; i++){
            loginPage = homePage.navigateToLoginPage();
            String actualMsg = loginPage.login(data[i][0]+"", data[i][1]+"").getWelcomeMessage();
            String expectedMsg = "Welcome " + data[i][0];
            Assert.assertEquals(actualMsg,expectedMsg, "welcome msg is not correctly");

            homePage.navigateToLogoutPage();
        }
    }
}
