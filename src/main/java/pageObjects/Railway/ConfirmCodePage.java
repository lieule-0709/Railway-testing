package pageObjects.Railway;

import common.constant.Constant;
import org.jsoup.helper.W3CDom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmCodePage extends GeneralPage {
    //Locators
    private final By codeInput = By.cssSelector("#confirmationCode");
    private final By confirmBtn = By.xpath("//input[@value='Confirm']");

    //Elements
    protected WebElement getCodeInput(){
        return Constant.WEBDRIVER.findElement(codeInput);
    }

    protected WebElement getConfirmBtn(){
        return Constant.WEBDRIVER.findElement(confirmBtn);
    }

    //Methods
    public void confirmCode(String code){
        this.getCodeInput().sendKeys(code);
        this.getConfirmBtn().click();
    }
}
