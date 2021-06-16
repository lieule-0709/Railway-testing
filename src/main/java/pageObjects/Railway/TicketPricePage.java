package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{
    //Locators
    private final By trainTxt = By.xpath("//tr[@class='TableSmallHeader']/th");
    private final By bookHSBtn = By.xpath("//td[.='HS:']/ancestor::tr//a[.='Book ticket']");
    private final By bookSSBtn = By.xpath("//td[.='SS:']/ancestor::tr//a[.='Book ticket']");
    private final By booSSCBtn = By.xpath("//td[.='SSC:']/ancestor::tr//a[.='Book ticket']");
    private final By bookHBBtn = By.xpath("//td[.='HB:']/ancestor::tr//a[.='Book ticket']");
    private final By bookSBBtn = By.xpath("//td[.='SB:']/ancestor::tr//a[.='Book ticket']");
    private final By bookSBCBtn = By.xpath("//td[.='SBC:']/ancestor::tr//a[.='Book ticket']");

    //Elements
    protected WebElement getTrainTxt(){
        return Constant.WEBDRIVER.findElement(trainTxt);
    }

    protected WebElement getBookHSBtn(){
        return Constant.WEBDRIVER.findElement(bookHSBtn);
    }

    protected WebElement getBookSSBtn(){
        return Constant.WEBDRIVER.findElement(bookSSBtn);
    }

    protected WebElement getBookSSCBtn(){
        return Constant.WEBDRIVER.findElement(booSSCBtn);
    }

    protected WebElement getBookHBBtn(){
        return Constant.WEBDRIVER.findElement(bookHBBtn);
    }

    protected WebElement getBookSBBtn(){
        return Constant.WEBDRIVER.findElement(bookSBBtn);
    }

    protected WebElement getBookSBCBtn(){
        return Constant.WEBDRIVER.findElement(bookSBCBtn);
    }

}
