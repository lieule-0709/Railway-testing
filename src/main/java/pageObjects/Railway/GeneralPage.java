package pageObjects.Railway;

import common.constant.Constant;
import dataObjects.Tabs;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.LOGIN));
        this.getTab(Tabs.LOGIN).click();
        return new LoginPage();
    }

    public HomePage navigateToHomePage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.HOME));
        this.getTab(Tabs.HOME).click();
        return new HomePage();
    }

    public FAQPage navigateToFAQPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.FAQ));
        this.getTab(Tabs.FAQ).click();
        return new FAQPage();
    }

    public ContactPage navigateToContactPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.CONTACT));
        this.getTab(Tabs.CONTACT).click();
        return new ContactPage();
    }

    public TimeTablePage navigateToTimeTablePage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.TIME_TABLE));
        this.getTab(Tabs.TIME_TABLE).click();
        return new TimeTablePage();
    }

    public TicketPriceListPage navigateToTicketPriceListPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.TICKET_PRICE));
        this.getTab(Tabs.TICKET_PRICE).click();
        return new TicketPriceListPage();
    }

    public BookTicketPage navigateToBookTicketPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.BOOK_TICKET));
        this.getTab(Tabs.BOOK_TICKET).click();
        return new BookTicketPage();
    }

    public RegisterPage navigateToRegisterPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.REGISTER));
        this.getTab(Tabs.REGISTER).click();
        return new RegisterPage();
    }

    public MyTicketPage navigateToMyTicketPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.MY_TICKET));
        this.getTab(Tabs.MY_TICKET).click();
        return new MyTicketPage();
    }

    public ChangePwdPage navigateToChangePwdPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.CHANGE_PASSWORD));
        this.getTab(Tabs.CHANGE_PASSWORD).click();
        return new ChangePwdPage();
    }

    public void navigateToLogoutPage(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getTab(Tabs.LOGOUT));
        this.getTab(Tabs.LOGOUT).click();
    }

    public String getTextOfSelectedTab(){
        return this.getTabSelected().getText();
    }
}
