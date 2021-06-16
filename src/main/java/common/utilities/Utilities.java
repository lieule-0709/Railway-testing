package common.utilities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.Reader;

public class Utilities {
    public static void selectOption(WebElement selectBox, String option){
        Select dropdown = new Select(selectBox);
        dropdown.selectByVisibleText(option);
    }


    /**
     * Reading test data from a CSV file
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "dataLogin-csv")
    public static Object[][] readCSVData(String pathFile) throws Exception {

        String[][] testData;

        //Get the workbook
        Reader fileInputStream = new FileReader(pathFile);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(fileInputStream);

        int numberOfRecords = 0;
        int numberOfColumns = 0;


        for (CSVRecord record : records
        ) {
            System.out.println("Reading record line #" + ++numberOfRecords);
            numberOfColumns = record.size();
        }

        testData = new String[numberOfRecords - 1][numberOfColumns];

        int currentRecord = 0;

        fileInputStream = new FileReader(pathFile);
        records = CSVFormat.EXCEL.parse(fileInputStream);

        for (CSVRecord record : records
        ) {

            System.out.println("Reading test data ");
            if (record.getRecordNumber() == 1) {
                System.out.println("record = " + record);
                continue;
            }

            for (int i = 0; i < record.size(); i++) {
                testData[currentRecord][i] = record.get(i);

            }
            currentRecord++;
        }

        return testData;
    }
}
