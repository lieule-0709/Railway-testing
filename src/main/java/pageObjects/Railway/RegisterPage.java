package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{

    //Locator
    private final By inputEmail = By.xpath("//input[@id='email']");
    private final By inputPass = By.xpath("//input[@id='password']");
    private final By inputConfirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By inputPID = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By pSuccess = By.xpath("//div[@id='content']/p");
    private final By errorMsg = By.cssSelector("..message");
    private final By errEmailLbl = By.xpath("//label[@for='email' and @class='validation-error']");
    private final By errPwdLbl = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By errConfirmPwdLbl = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
    private final By errPIDLbl = By.xpath("//label[@for='pid' and @class='validation-error']");


    //Elements
    protected WebElement getInputEmail(){
        return Constant.WEBDRIVER.findElement(inputEmail);
    }

    protected WebElement getInputPass(){
        return Constant.WEBDRIVER.findElement(inputPass);
    }

    protected WebElement getInputConfirmpass(){
        return Constant.WEBDRIVER.findElement(inputConfirmPass);
    }

    protected WebElement getInputPID(){
        return Constant.WEBDRIVER.findElement(inputPID);
    }

    protected WebElement getbtnRegister(){
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    protected WebElement getpSuccess(){
        return Constant.WEBDRIVER.findElement(pSuccess);
    }

    protected WebElement getErrMsg(){
        return Constant.WEBDRIVER.findElement(errorMsg);
    }

    protected WebElement getErrEmailLbl(){
        return Constant.WEBDRIVER.findElement(errEmailLbl);
    }

    protected WebElement getErrPwdLbl(){
        return Constant.WEBDRIVER.findElement(errPwdLbl);
    }

    protected WebElement getErrConfirmPwdLbl(){
        return Constant.WEBDRIVER.findElement(errConfirmPwdLbl);
    }

    protected WebElement getErrPIDLbl(){
        return Constant.WEBDRIVER.findElement(errPIDLbl);
    }

    //Methods
    public RegisterPage regist(String email, String pass, String confirmPass, String pid){
        this.getInputEmail().sendKeys(email);
        this.getInputPass().sendKeys(pass);
        this.getInputConfirmpass().sendKeys(confirmPass);
        this.getInputPID().sendKeys(pid);

        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getbtnRegister());
        this.getbtnRegister().click();

        return this;
    }

    public String getMsgSuccess(){
        return this.getpSuccess().getText();
    }
}
