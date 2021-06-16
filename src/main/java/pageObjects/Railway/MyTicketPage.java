package pageObjects.Railway;

import common.constant.Constant;
import common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    //Elements
    public WebElement getOperationBtn(String departPlace, String arrivePlace, String seatType, String departDate, String bookDate, String expiredDate, String status){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']//td[contains(.,'" + departPlace +
                "')]/following-sibling::td[contains(.,'"+ arrivePlace +
                "')]/following-sibling::td[contains(.,'"+ seatType +
                "')]/following-sibling::td[contains(.,'"+ departDate +
                "')]/following-sibling::td[contains(.,'"+ bookDate +
                "')]/following-sibling::td[contains(.,'"+ expiredDate +
                "')]/following-sibling::td[contains(.,'"+ status + "')]/following-sibling::td/input"));
    }

    public WebElement getErrFilterMsg(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='error message']"));
    }

    public WebElement getDepartStationCbx(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterDpStation']"));
    }

    public WebElement getArriveStationCbx(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterArStation']"));
    }

    public WebElement getDepartDateTxt(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']"));
    }

    public WebElement getStatusCbx(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterStatus']"));
    }

    public WebElement getFilterBtn(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@value='Apply Filter']"));
    }

    public WebElement getFilterResultLbl(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//strong/span"));
    }


    //Methods
    public void cancelTicket(String departPlace, String arrivePlace, String seatType, String departDate, String bookDate, String expiredDate, String status){
        WebElement btn = this.getOperationBtn(departPlace,arrivePlace, seatType, departDate, bookDate,expiredDate,status);

        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();

        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public void filterTicket(String departPlace, String arriveStation, String departDate, String status){
        Utilities.selectOption(this.getDepartStationCbx(), departPlace);
        Utilities.selectOption(this.getArriveStationCbx(), arriveStation);
        this.getDepartDateTxt().sendKeys(departDate);
        Utilities.selectOption(this.getStatusCbx(), status);
        this.getFilterBtn().click();
    }
}
