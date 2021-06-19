package testCases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static common.utilities.extentReports.ExtentTestManger.startTest;

public class TC12_Errors_display_when_password_reset_token_is_blank extends BaseTest{
    @Test(description = "Errors display when password reset token is blank")
    public void TC12(Method method){
        startTest(method.getName(), "Errors display when password reset token is blank");
    }
}
