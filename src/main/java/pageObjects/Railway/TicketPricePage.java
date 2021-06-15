package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Locators
    private final By trainTxt = By.xpath("//tr[@class='TableSmallHeader']/th");
    private final By bookHSBtn = By.xpath("//td[.='HS:']/ancestor::tr//a[.='Book ticket']");
    private final By bookSSBtn = By.xpath("//td[.='SS:']/ancestor::tr//a[.='Book ticket']");
    private final By booSSCBtn = By.xpath("//td[.='SSC:']/ancestor::tr//a[.='Book ticket']");
    private final By bookHBBtn = By.xpath("//td[.='HB:']/ancestor::tr//a[.='Book ticket']");
    private final By bookSBBtn = By.xpath("//td[.='SB:']/ancestor::tr//a[.='Book ticket']");
    private final By bookSBCBtn = By.xpath("//td[.='SBC:']/ancestor::tr//a[.='Book ticket']");

    //Elements
    public WebElement getTrainTxt(){
        return Constant.WEBDRIVER.findElement(trainTxt);
    }

    public WebElement getBookHSBtn(){
        return Constant.WEBDRIVER.findElement(bookHSBtn);
    }

    public WebElement getBookSSBtn(){
        return Constant.WEBDRIVER.findElement(bookSSBtn);
    }

    public WebElement getBookSSCBtn(){
        return Constant.WEBDRIVER.findElement(booSSCBtn);
    }

    public WebElement getBookHBBtn(){
        return Constant.WEBDRIVER.findElement(bookHBBtn);
    }

    public WebElement getBookSBBtn(){
        return Constant.WEBDRIVER.findElement(bookSBBtn);
    }

    public WebElement getBookSBCBtn(){
        return Constant.WEBDRIVER.findElement(bookSBCBtn);
    }

}
