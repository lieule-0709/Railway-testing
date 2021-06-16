package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage{
    //Locators
    private final By emailInput = By.xpath("//input[@id='email']");
    private final By sendBtn = By.xpath("//input[@value='Send Instructions']");
    private final By errValidationMsg = By.cssSelector(".validation-error");

    //Elements
    public WebElement getEmailInput(){
        return Constant.WEBDRIVER.findElement(emailInput);
    }

    public WebElement getSendBtn(){
        return Constant.WEBDRIVER.findElement(sendBtn);
    }

    public WebElement getErrValidationMsg(){
        return Constant.WEBDRIVER.findElement(errValidationMsg);
    }

    //Methods
    public void sendResetPwdForm(String email){
        this.getEmailInput().sendKeys(email);
        this.getSendBtn().click();
    }
}
