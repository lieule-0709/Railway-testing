package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TicketPriceListPage extends GeneralPage {
    //Elements
    public WebElement getCheckPriceLink(String departPlace, String arrivePlace){
        return Constant.WEBDRIVER.findElement(By.xpath("//tr//li[text()='" + departPlace + " to " + arrivePlace + "']/ancestor::tr//a"));
    }

    //Methods
    public void goToCheckPricePage(String departPlace, String arrivePlace){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getCheckPriceLink(departPlace, arrivePlace));
        this.getCheckPriceLink(departPlace, arrivePlace).click();
    }
}
