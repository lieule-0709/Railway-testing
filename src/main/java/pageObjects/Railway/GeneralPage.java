package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By lbWelcome = By.xpath("//div[@class='account']//strong");
    private final By tabSelected = By.cssSelector(" #menu .selected");

    //Element
    public WebElement getTabSelected() {
        return Constant.WEBDRIVER.findElement(tabSelected);
    }

    public WebElement getLbWelcome(){
        return Constant.WEBDRIVER.findElement(lbWelcome);
    }

    public WebElement getTab(String name){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[.='" + name+ "']"));
    }

    //Methods
    public String getWelcomeMessage(){
        return this.getLbWelcome().getText();
    }

    public LoginPage navigateToLoginPage(){
        this.getTab("Login").click();
        return new LoginPage();
    }

    public HomePage navigateToHomePage(){
        this.getTab("Home").click();
        return new HomePage();
    }

    public FAQPage navigateToFAQPage(){
        this.getTab("FAQ").click();
        return new FAQPage();
    }

    public ContactPage navigateToContactPage(){
        this.getTab("Contact").click();
        return new ContactPage();
    }

    public TimeTablePage navigateToTimeTablePage(){
        this.getTab("Timetable").click();
        return new TimeTablePage();
    }

    public TicketPriceListPage navigateToTicketPriceListPage(){
        this.getTab("Ticket price").click();
        return new TicketPriceListPage();
    }

    public BookTicketPage navigateToBookTicketPage(){
        this.getTab("Book ticket").click();
        return new BookTicketPage();
    }

    public RegisterPage navigateToRegisterPage(){
        this.getTab("Register").click();
        return new RegisterPage();
    }

    public void navigateToLogoutPage(){
        this.getTab("Logout").click();
    }

    public String getTextOfSelectedTab(){
        return this.getTabSelected().getText();
    }

}
