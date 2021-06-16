package pageObjects.Railway;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage{
    //Locators
    private final By linkEmail = By.xpath("//b[.=\"Email: \"]//following-sibling::a");

    //Elements
    protected WebElement getLinkEmail(){
        return Constant.WEBDRIVER.findElement(linkEmail);
    }

    //Methods
    public void clickEmailLink(){
        this.getLinkEmail().click();
    }

}
