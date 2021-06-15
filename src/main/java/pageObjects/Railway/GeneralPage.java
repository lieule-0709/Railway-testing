package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabHome = By.xpath("//div[@id='menu']//a[.='Home']");
    private final By tabFAQ = By.xpath("//div[@id='menu']//a[.='FAQ']");
    private final By tabContact = By.xpath("//div[@id='menu']//a[.='Contact']");
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[.='Timetable']");
    private final By tabTicketPrice = By.xpath("//div[@id='menu']//a[.='Ticket price']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[.='Book ticket']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[.='Register']");
    private final By tabLogin = By.xpath("//div[@id='menu']//a[.='Login']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[.='Logout']");
    private final By lbWelcome = By.xpath("//div[@class='account']//strong");
    private final By tabSelected = By.cssSelector(" #menu .selected");

    //Element
    public WebElement getTabHome(){
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    public WebElement getTabFAQ(){
        return Constant.WEBDRIVER.findElement(tabFAQ);
    }

    public WebElement getTabContact(){
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    public WebElement getTabTimetable(){
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    public WebElement getTabTicketPrice(){
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    public WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    public WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    public WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    public WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    public WebElement getTabSelected() {
        return Constant.WEBDRIVER.findElement(tabSelected);
    }

    public WebElement getLbWelcome(){
        return Constant.WEBDRIVER.findElement(lbWelcome);
    }

    //method

    public WebElement getTab(String name){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[.='" + name+ "']"));
    }

    public String getWelcomeMessage(){
        return this.getLbWelcome().getText();
    }

    public LoginPage navigateToLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public void navigateToHomePage(){
        this.getTabHome().click();
    }

    public void navigateToFAQPage(){
        this.getTabFAQ().click();
    }

    public void navigateToContactPage(){
        this.getTabContact().click();
    }

    public TimeTablePage navigateToTimeTablePage(){
        this.getTabTimetable().click();
        return new TimeTablePage();
    }

    public void navigateToTicketPricePage(){
        this.getTabTicketPrice().click();
    }

    public void navigateToBookTicketPage(){
        this.getTabBookTicket().click();
    }

    public RegisterPage navigateToRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public void navigateToLogoutPage(){
        this.getTabLogout().click();
    }

    public String getTextOfSelectedTab(){
        return this.getTabSelected().getText();
    }


}
