package pageObjects.Railway;

import common.constant.Constant;
import common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //Locators
    private final By departDateCbx = By.xpath("//select[@name='Date']");
    private final By departStationCbx = By.xpath("//select[@name='DepartStation']");
    private final By arriveStationCbx = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeCbx = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountCbx = By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketBtn = By.xpath("//input[@value='Book ticket']");

    //Elements
    public WebElement getDepartDateCbx(){
        return Constant.WEBDRIVER.findElement(departDateCbx);
    }

    public WebElement getDepartStationCbx(){
        return Constant.WEBDRIVER.findElement(departStationCbx);
    }

    public WebElement getArriverStationCbx(){
        return Constant.WEBDRIVER.findElement(arriveStationCbx);
    }

    public WebElement getSeatTypeCbx(){
        return Constant.WEBDRIVER.findElement(seatTypeCbx);
    }

    public WebElement getTicketAmountCbx(){
        return Constant.WEBDRIVER.findElement(ticketAmountCbx);
    }

    public WebElement getBookTicketBtn(){
        return Constant.WEBDRIVER.findElement(bookTicketBtn);
    }


    //Methods
    public void bookTicket(String departDate, String departPlace, String arrivePlace, String seatType, String amount){
        Utilities.selectOption(this.getDepartDateCbx(), departDate);
        Utilities.selectOption(this.getDepartStationCbx(), departPlace);
        Utilities.selectOption(this.getArriverStationCbx(), arrivePlace);
        Utilities.selectOption(this.getSeatTypeCbx(), seatType);
        Utilities.selectOption(this.getTicketAmountCbx(), amount);
        this.getBookTicketBtn().click();
    }

}
