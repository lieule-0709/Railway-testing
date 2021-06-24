package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    //Locators
    private final By createAccountLink = By.xpath("//a[@href= '/Account/Register.cshtml']");

    //Elements
    protected WebElement getCreateAccountLink(){
        return Constant.WEBDRIVER.findElement(createAccountLink);
    }

    //methods
    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public RegisterPage goToRegisterPage(){
        getCreateAccountLink().click();
        return new RegisterPage();
    }
}
