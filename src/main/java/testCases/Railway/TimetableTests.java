package testCases.Railway;

import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.TimeTablePage;

public class TimetableTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private TimeTablePage timeTablePage;

    @Test
    public void TC005() {
        homePage.open();
        timeTablePage = homePage.navigateToTimeTablePage();
        timeTablePage.goToBookTicketpage("Sài Gòn", "Huế");
    }
}
