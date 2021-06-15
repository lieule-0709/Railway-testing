package pageObjects.Railway;

import common.constant.Constant;
import org.apache.hc.core5.http.nio.support.BasicPushProducer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimeTablePage {
    //Element
    public WebElement getCheckPriceLink(String departPlace, String arrivePlace){
        return Constant.WEBDRIVER.findElement(By.xpath("//td[count(//th[.='Depart Station']/preceding-sibling::th) + 1][.='" + departPlace+  "']/../td[.='" + arrivePlace+ "']/../td[count(//th[.='Check Price']/preceding-sibling::th) + 1]"));
    }

    public WebElement getBookTicketLink(String departPlace, String arrivePlace){
        return Constant.WEBDRIVER.findElement(By.xpath("//td[count(//th[.='Depart Station']/preceding-sibling::th) + 1][.='" + departPlace+  "']/../td[.='" + arrivePlace+ "']/../td[count(//th[.='Book ticket']/preceding-sibling::th) + 1]"));
    }

    //Methods
    public TicketPricePage goToCheckPricePage(String departPlace, String arrivePlace){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getCheckPriceLink(departPlace, arrivePlace));
        this.getCheckPriceLink(departPlace, arrivePlace).click();
        return new TicketPricePage();
    }
    public BookTicketPage goToBookTicketpage(String departPlace, String arrivePlace){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", this.getBookTicketLink(departPlace, arrivePlace));
        this.getBookTicketLink(departPlace, arrivePlace).click();
        return new BookTicketPage();
    }

}
