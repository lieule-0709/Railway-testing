package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By userNameInput = By.cssSelector("#username");
    private final By passwordInput = By.cssSelector("#password");
    private final By loginBtn = By.xpath("//input[@value='Login']");
    private final By registerLink = By.xpath("//a[.='Registration Page']");
    private final By forgotPwdLink = By.xpath("//a[.='Forgot Password page']");

    private final By errorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By errEmailLbl = By.xpath("//label[@for='username' and @class='validation-error']");
    private final By errPwdLbl = By.xpath("//label[@for='password' and @class='validation-error']");


    //Elements
    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(userNameInput);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(passwordInput);
    }

    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(loginBtn);
    }

    protected WebElement getRegisterLink(){
        return Constant.WEBDRIVER.findElement(registerLink);
    }

    protected WebElement getForgotPwdLink(){
        return Constant.WEBDRIVER.findElement(forgotPwdLink);
    }

    protected WebElement getErrMsg() {
        return Constant.WEBDRIVER.findElement(errorMsg);
    }

    protected WebElement getErrEmailLbl() {
        return Constant.WEBDRIVER.findElement(errEmailLbl);
    }

    protected WebElement getErrPwdLbl() {
        return Constant.WEBDRIVER.findElement(errPwdLbl);
    }

    //Methods
    public HomePage login(String username, String password) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getBtnLogin());

        this.getTxtUsername().clear();
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);

        this.getBtnLogin().click();
        return new HomePage();
    }

    public RegisterPage clickRegistLink(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getRegisterLink());
        this.getRegisterLink().click();
        return new RegisterPage();
    }

    public ForgotPasswordPage clickForgotPwdLink(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getForgotPwdLink());
        this.getForgotPwdLink().click();
        return new ForgotPasswordPage();
    }

    public String getErrMsgText(){
        return this.getErrMsg().getText();
    }

    public String getErrEmailMsg(){
        return this.getErrEmailLbl().getText();
    }

    public String getErrPwdMsg(){
        return this.getErrPwdLbl().getText();
    }
}
