package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    protected WebElement getCurrentPwdInput(){
        return Constant.WEBDRIVER.findElement(currentPwdInput);
    }

    protected WebElement getNewPwdInput(){
        return Constant.WEBDRIVER.findElement(newPwdInput);
    }

    protected WebElement getConfirmPwdInput(){
        return Constant.WEBDRIVER.findElement(confirmPwdInput);
    }

    protected WebElement getChangePwdBtn(){
        return Constant.WEBDRIVER.findElement(changePwdBtn);
    }

    protected WebElement getSuccessMsg(){
        return Constant.WEBDRIVER.findElement(successMsg);
    }

    protected WebElement getErrorMsg(){
        return Constant.WEBDRIVER.findElement(errorMsg);
    }

    protected WebElement getErrCurrentPwdLbl(){
        return Constant.WEBDRIVER.findElement(errCurrentPwdLbl);
    }

    protected WebElement getErrNewPwdLbl(){
        return Constant.WEBDRIVER.findElement(errNewPwdLbl);
    }

    protected WebElement getErrConfirmPwdLbl(){
        return Constant.WEBDRIVER.findElement(errConfirmPwdLbl);
    }

    //Methods
    public void changePwd(String currentPwd, String newPwd, String confirmPwd){
        this.getCurrentPwdInput().sendKeys(currentPwd);
        this.getNewPwdInput().sendKeys(newPwd);
        this.getConfirmPwdInput().sendKeys(confirmPwd);

        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getChangePwdBtn());
        this.getChangePwdBtn().click();
    }

    public String getSuccessMsgText(){
        return this.getSuccessMsg().getText();
    }

    public String getErrMsgText(){
        return this.getErrorMsg().getText();
    }
}
