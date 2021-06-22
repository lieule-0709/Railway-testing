package common.utilities;

import common.constant.Constant;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class Utilities {
    public static void selectOption(WebElement selectBox, String option){
        Select dropdown = new Select(selectBox);
        dropdown.selectByVisibleText(option);
    }
}
