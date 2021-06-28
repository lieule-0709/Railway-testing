package pageObjects.Railway;

import common.constant.Constant;
import common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By departDateCbx = By.xpath("//select[@name='Date']");
    private final By departStationCbx = By.xpath("//select[@name='DepartStation']");
    private final By arriveStationCbx = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeCbx = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountCbx = By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketBtn = By.xpath("//input[@value='Book ticket']");
    private final By errMsg = By.xpath("//p[@class='message error']");
    private final By errValidationMsg = By.xpath("//label[@class='validation-error']");

    //Elements
    protected WebElement getDepartDateCbx(){
        return Constant.WEBDRIVER.findElement(departDateCbx);
    }

    protected WebElement getDepartStationCbx(){
        return Constant.WEBDRIVER.findElement(departStationCbx);
    }

    protected WebElement getArriverStationCbx(){
        return Constant.WEBDRIVER.findElement(arriveStationCbx);
    }

    protected WebElement getSeatTypeCbx(){
        return Constant.WEBDRIVER.findElement(seatTypeCbx);
    }

    protected WebElement getTicketAmountCbx(){
        return Constant.WEBDRIVER.findElement(ticketAmountCbx);
    }

    protected WebElement getBookTicketBtn(){
        return Constant.WEBDRIVER.findElement(bookTicketBtn);
    }

    protected WebElement getErrMsg(){
        return Constant.WEBDRIVER.findElement(errMsg);
    }

    protected WebElement getErrValidationMsg(){
        return Constant.WEBDRIVER.findElement(errValidationMsg);
    }

    //Methods
    public void bookTicket(String departDate, String departPlace, String arrivePlace, String seatType, String amount){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getBookTicketBtn());

        Utilities.selectOption(this.getDepartDateCbx(), departDate);
        Utilities.selectOption(this.getDepartStationCbx(), departPlace);

        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='ArriveStation']/option[normalize-space(.) = '" + arrivePlace + "']")));
        Utilities.selectOption(this.getArriverStationCbx(), arrivePlace);

        Utilities.selectOption(this.getSeatTypeCbx(), seatType);
        Utilities.selectOption(this.getTicketAmountCbx(), amount);

        this.getBookTicketBtn().click();
    }

    //Methods
    public void bookTicketWithDate(String departDate){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getBookTicketBtn());

        Utilities.selectOption(this.getDepartDateCbx(), departDate);

        this.getBookTicketBtn().click();
    }

    public String getDepartStation(){
        Select select = new Select(Constant.WEBDRIVER.findElement(departStationCbx));
        return select.getFirstSelectedOption().getText();
    }

    public String getArriveStation(){
        Select select = new Select(Constant.WEBDRIVER.findElement(arriveStationCbx));
        return select.getFirstSelectedOption().getText();
    }

    public String getSeatType(){
        Select select = new Select(Constant.WEBDRIVER.findElement(seatTypeCbx));
        return select.getFirstSelectedOption().getText();
    }

    public String getDepartDate(){
        Select select = new Select(Constant.WEBDRIVER.findElement(departDateCbx));
        return select.getFirstSelectedOption().getText();
    }

    public String getAmount(){
        Select select = new Select(Constant.WEBDRIVER.findElement(departStationCbx));
        return select.getFirstSelectedOption().getText();
    }
}
