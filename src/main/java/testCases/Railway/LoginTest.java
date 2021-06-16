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

public class LoginTest extends BaseTest{

    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test
    public void TC01() throws Exception {

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
}
