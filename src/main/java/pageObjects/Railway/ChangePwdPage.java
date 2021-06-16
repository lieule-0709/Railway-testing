package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePwdPage extends GeneralPage{
    //Locators
    private final By currentPwdInput = By.xpath("//input[@id='currentPassword']");
    private final By newPwdInput = By.xpath("//input[@id='newPassword']");
    private final By confirmPwdInput = By.xpath("//input[@id='confirmPassword']");
    private final By changePwdBtn = By.xpath("//input[@value='Change Password']");
    private final By successMsg = By.cssSelector(".success");
    private final By errorMsg = By.cssSelector(".error");
    private final By errCurrentPwdLbl = By.xpath("//label[@for='currentPassword' and @class='validation-error']");
    private final By errNewPwdLbl = By.xpath("//label[@for='newPassword' and @class='validation-error']");
    private final By errConfirmPwdLbl = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");

    //Elements

    public WebElement getCurrentPwdInput(){
        return Constant.WEBDRIVER.findElement(currentPwdInput);
    }

    public WebElement getNewPwdInput(){
        return Constant.WEBDRIVER.findElement(newPwdInput);
    }

    public WebElement getConfirmPwdInput(){
        return Constant.WEBDRIVER.findElement(confirmPwdInput);
    }

    public WebElement getChangePwdBtn(){
        return Constant.WEBDRIVER.findElement(changePwdBtn);
    }

    public WebElement getSuccessMsg(){
        return Constant.WEBDRIVER.findElement(successMsg);
    }

    public WebElement getErrorMsg(){
        return Constant.WEBDRIVER.findElement(errorMsg);
    }

    public WebElement getErrCurrentPwdLbl(){
        return Constant.WEBDRIVER.findElement(errCurrentPwdLbl);
    }

    public WebElement getErrNewPwdLbl(){
        return Constant.WEBDRIVER.findElement(errNewPwdLbl);
    }

    public WebElement getErrConfirmPwdLbl(){
        return Constant.WEBDRIVER.findElement(errConfirmPwdLbl);
    }

    //Methods
    public void changePwd(String currentPwd, String newPwd, String confirmPwd){
        this.getCurrentPwdInput().sendKeys(currentPwd);
        this.getNewPwdInput().sendKeys(newPwd);
        this.getConfirmPwdInput().sendKeys(confirmPwd);
        this.getChangePwdBtn().click();
    }
}
