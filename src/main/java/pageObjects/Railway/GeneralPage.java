package pageObjects.Railway;

import common.constant.Constant;
import dataObjects.Tabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GeneralPage {

    //Locators
    private final By lbWelcome = By.xpath("//div[@class='account']//strong");
    private final By tabSelected = By.cssSelector(" #menu .selected");

    //Element
    protected WebElement getTabSelected() {
        return Constant.WEBDRIVER.findElement(tabSelected);
    }

    protected WebElement getLbWelcome(){
        return Constant.WEBDRIVER.findElement(lbWelcome);
    }

    //Methods
    public WebElement getTab(String name){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[.='" + name+ "']"));
    }

    public String getWelcomeMessage(){
        return this.getLbWelcome().getText();
    }

    public LoginPage navigateToLoginPage(){
        this.getTab(Tabs.LOGIN).click();
        return new LoginPage();
    }

    public HomePage navigateToHomePage(){
        this.getTab(Tabs.HOME).click();
        return new HomePage();
    }

    public FAQPage navigateToFAQPage(){
        this.getTab(Tabs.FAQ).click();
        return new FAQPage();
    }

    public ContactPage navigateToContactPage(){
        this.getTab(Tabs.CONTACT).click();
        return new ContactPage();
    }

    public TimeTablePage navigateToTimeTablePage(){
        this.getTab(Tabs.TIME_TABLE).click();
        return new TimeTablePage();
    }

    public TicketPriceListPage navigateToTicketPriceListPage(){
        this.getTab(Tabs.TICKET_PRICE).click();
        return new TicketPriceListPage();
    }

    public BookTicketPage navigateToBookTicketPage(){
        this.getTab(Tabs.BOOK_TICKET).click();
        return new BookTicketPage();
    }

    public RegisterPage navigateToRegisterPage(){
        this.getTab(Tabs.REGISTER).click();
        return new RegisterPage();
    }

    public MyTicketPage navigateToMyTicketPage(){
        this.getTab(Tabs.MY_TICKET).click();
        return new MyTicketPage();
    }

    public ChangePwdPage navigateToChangePwdPage(){
        this.getTab(Tabs.CHANGE_PASSWORD).click();
        return new ChangePwdPage();
    }

    public void navigateToLogoutPage(){
        this.getTab(Tabs.LOGOUT).click();
    }

    public String getTextOfSelectedTab(){
        return this.getTabSelected().getText();
    }

}
