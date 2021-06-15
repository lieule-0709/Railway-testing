package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePwdPage {
    //Locators
    private final By currentPwdInput = By.xpath("//input[@id='currentPassword']");
    private final By newPwdInput = By.xpath("//input[@id='newPassword']");
    private final By confirmPwdInput = By.xpath("//input[@id='confirmPassword']");
    private final By changePwdBtn = By.xpath("//input[@value='Change Password']");

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

    //Methods
    public void changePwd(String currentPwd, String newPwd, String confirmPwd){
        this.getCurrentPwdInput().sendKeys(currentPwd);
        this.getNewPwdInput().sendKeys(newPwd);
        this.getConfirmPwdInput().sendKeys(confirmPwd);
        this.getChangePwdBtn().click();
    }
}
