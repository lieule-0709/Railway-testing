package pageObjects.Railway;

import common.constant.Constant;
import common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    //Elements
    protected WebElement getOperationBtn(String departPlace, String arrivePlace, String seatType, String departDate, String bookDate, String status, String amount){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']//td[contains(.,'" + departPlace +
                "')]/following-sibling::td[contains(.,'"+ arrivePlace +
                "')]/following-sibling::td[contains(.,'"+ seatType +
                "')]/following-sibling::td[contains(.,'"+ departDate +
                "')]/following-sibling::td[contains(.,'"+ bookDate +
                "')]/following-sibling::td[contains(.,'"+ status +
                "')]/following-sibling::td[contains(.,'"+ amount + "')]/following-sibling::td/input"));
    }

    protected WebElement getErrFilterMsg(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='error message']"));
    }

    protected WebElement getDepartStationCbx(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterDpStation']"));
    }

    protected WebElement getArriveStationCbx(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterArStation']"));
    }

    protected WebElement getDepartDateTxt(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']"));
    }

    protected WebElement getStatusCbx(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterStatus']"));
    }

    protected WebElement getFilterBtn(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@value='Apply Filter']"));
    }

    protected WebElement getFilterResultLbl(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//strong/span"));
    }


    //Methods
    public void cancelTicket(String departPlace, String arrivePlace, String seatType, String departDate, String bookDate, String status, String amount){
        WebElement btn = this.getOperationBtn(departPlace,arrivePlace, seatType, departDate, bookDate,status,amount);

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

    public int countRowsFitInfo(String departPlace, String arrivePlace, String seatType, String departDate, String bookDate, String status, String amount){
        int iCount = Constant.WEBDRIVER.findElements(By.xpath("//table[@class='MyTable']//td[contains(.,'" + departPlace +
                    "')]/following-sibling::td[contains(.,'"+ arrivePlace +
                    "')]/following-sibling::td[contains(.,'"+ seatType +
                    "')]/following-sibling::td[contains(.,'"+ departDate +
                    "')]/following-sibling::td[contains(.,'"+ bookDate +
                    "')]/following-sibling::td[contains(.,'"+ status +
                    "')]/following-sibling::td[contains(.,'"+ amount + "')]/following-sibling::td/input")).size();
        return iCount;
    }

}
