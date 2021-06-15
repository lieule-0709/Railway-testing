package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    //Locators
    private final By emailInput = By.xpath("//input[@id='email']");
    private final By sendBtn = By.xpath("//input[@value='Send Instructions']");

    //Elements
    public WebElement getEmailInput(){
        return Constant.WEBDRIVER.findElement(emailInput);
    }

    public WebElement getSendBtn(){
        return Constant.WEBDRIVER.findElement(sendBtn);
    }

    //Methods
    public void sendResetPwdForm(String email){
        this.getEmailInput().sendKeys(email);
        this.getSendBtn().click();
    }
}
