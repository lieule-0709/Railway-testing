package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPriceListPage {
    //Elements
    public WebElement getCheckPriceLink(String departPlace, String arrivePlace){
        return Constant.WEBDRIVER.findElement(By.xpath("//tr//li[text()='" + departPlace + " to " + arrivePlace + "']/ancestor::tr//a"));
    }


    //Methods
    public void goToCheckPricePage(String departPlace, String arrivePlace){
        this.getCheckPriceLink(departPlace, arrivePlace).click();
    }
}
