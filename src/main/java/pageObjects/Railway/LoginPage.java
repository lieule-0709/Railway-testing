package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By _txtUserName = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By registLink = By.xpath("//a[.='Registration Page']");
    private final By forgotPwdLink = By.xpath("//a[.='Forgot Password page']");

    private final By errorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By errEmailLbl = By.xpath("//label[@for='username' and @class='validation-error']");
    private final By errPwdLbl = By.xpath("//label[@for='password' and @class='validation-error']");


    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUserName);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getRegistLink(){
        return Constant.WEBDRIVER.findElement(registLink);
    }

    public WebElement getForgotPwdLink(){
        return Constant.WEBDRIVER.findElement(forgotPwdLink);
    }

    public WebElement getErrMsg() {
        return Constant.WEBDRIVER.findElement(errorMsg);
    }

    public WebElement getErrEmailLbl() {
        return Constant.WEBDRIVER.findElement(errEmailLbl);
    }

    public WebElement getErrPwdLbl() {
        return Constant.WEBDRIVER.findElement(errPwdLbl);
    }

    //Methods
    public HomePage login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        return new HomePage();
    }

    public RegisterPage clickRegistLink(){
        this.getRegistLink().click();
        return new RegisterPage();
    }

    public ForgotPasswordPage clickForgotPwdLink(){
        this.getForgotPwdLink().click();
        return new ForgotPasswordPage();
    }

}
