package pageObjects.Railway;

import common.constant.Constant;
import common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    public BookTicketSuccessPage bookTicket(String departDate, String departPlace, String arrivePlace, String seatType, String amount){
        Utilities.selectOption(this.getDepartDateCbx(), departDate);
        Utilities.selectOption(this.getDepartStationCbx(), departPlace);
        Utilities.selectOption(this.getArriverStationCbx(), arrivePlace);
        Utilities.selectOption(this.getSeatTypeCbx(), seatType);
        Utilities.selectOption(this.getTicketAmountCbx(), amount);
        this.getBookTicketBtn().click();
        return new BookTicketSuccessPage();
    }

}
