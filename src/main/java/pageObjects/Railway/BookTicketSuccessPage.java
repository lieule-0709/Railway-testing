package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketSuccessPage extends GeneralPage {
    //Locators
    private final By title = new By.ByCssSelector("#content h1");
    private final By departStationTd = By.xpath("//td[count(//th[.='Depart Station']/preceding-sibling::th)+1]");
    private final By arriveStationTd = By.xpath("//td[count(//th[.='Arrive Station']/preceding-sibling::th)+1]");
    private final By seatTypeTd = By.xpath("//td[count(//th[.='Seat Type']/preceding-sibling::th)+1]");
    private final By departDateTd = By.xpath("//td[count(//th[.='Depart Date']/preceding-sibling::th)+1]");
    private final By expiredDateTd = By.xpath("//td[count(//th[.='Expired Date']/preceding-sibling::th)+1]");
    private final By bookDateTd = By.xpath("//td[count(//th[.='Book Date']/preceding-sibling::th)+1]");
    private final By amountTd = By.xpath("//td[count(//th[.='Amount']/preceding-sibling::th)+1]");
    private final By totalPriceTd = By.xpath("//td[count(//th[.='Total Price']/preceding-sibling::th)+1]");

    //Elements
    protected WebElement getTitle(){
        return Constant.WEBDRIVER.findElement(title);
    }

    protected WebElement getDepartStaionTd(){
        return Constant.WEBDRIVER.findElement(departStationTd);
    }

    protected WebElement getArriveStationTd(){
        return Constant.WEBDRIVER.findElement(arriveStationTd);
    }

    protected WebElement getSeatTypeTd(){
        return Constant.WEBDRIVER.findElement(seatTypeTd);
    }

    protected WebElement getDepartDateTd(){
        return Constant.WEBDRIVER.findElement(departDateTd);
    }

    protected WebElement getExpiredDateTd(){
        return Constant.WEBDRIVER.findElement(expiredDateTd);
    }

    protected WebElement getBookDateTd(){
        return Constant.WEBDRIVER.findElement(bookDateTd);
    }

    protected WebElement getAmountTd(){
        return Constant.WEBDRIVER.findElement(amountTd);
    }

    protected WebElement getTotalPricetd(){
        return Constant.WEBDRIVER.findElement(totalPriceTd);
    }

}
