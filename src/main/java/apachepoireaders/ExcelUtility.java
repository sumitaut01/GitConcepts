package apachepoireaders;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelUtility {
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            // You can add more cases for other data types if needed
            default:
                return "";
        }
    }

    public static List<Hashtable<String, String>> extractDataForTestCase(String filePath, String sheetName, String testCaseName) throws Exception {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Iterator<Row> rowIterator = sheet.iterator();
        List<Hashtable<String, String>> data = new ArrayList<>();

        boolean isTestCaseFound = false;
        Row headerRow = null;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (!isTestCaseFound) {
                String testCaseCell = getCellValue(row.getCell(1));
                if (testCaseName.equals(testCaseCell)) {
                    isTestCaseFound = true;
                    headerRow = row;
                    continue;
                }
            } else {
                String runValue = getCellValue(row.getCell(2));
                System.out.println("runvalues is ==>"+runValue);
                if ("Y".equals(runValue)) {
                    Hashtable<String, String> record = new Hashtable<>();
                    for (int i = 3; i < row.getLastCellNum() && i < headerRow.getLastCellNum(); i++) {
                        String key = getCellValue(headerRow.getCell(i));
                        String value = getCellValue(row.getCell(i));
                        record.put(key, value);
                    }
                    data.add(record);
                } else if (runValue.equalsIgnoreCase("Run")){//|| !String.valueOf(runValue).equalsIgnoreCase("n") ||!String.valueOf(runValue).trim().equalsIgnoreCase("")) {
                    // Exit if we reach an empty row
                    break;
                }
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
    @DataProvider(name = "excelData")
    public Object[][] provideTestData() throws Exception {
        List<Hashtable<String, String>> testCaseDataList = ExcelUtility.extractDataForTestCase("D:\\SeleniumFrameWorks\\SampleFormat.xlsx", "Sheet1", "Case01");

        Object[][] dataArray = new Object[testCaseDataList.size()][1]; // One column for the map itself
        for (int i = 0; i < testCaseDataList.size(); i++) {
            dataArray[i][0] = testCaseDataList.get(i);
        }
        return dataArray;
    }

    public static void main(String[] args) {
        try {
            List<Hashtable<String, String>> testCaseDataList = extractDataForTestCase("D:\\SeleniumFrameWorks\\SampleFormat.xlsx", "Sheet1", "Case02");

            for (Map<String, String> testCaseData : testCaseDataList) {
                System.out.println("Test Case Data:");
                for (Map.Entry<String, String> entry : testCaseData.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                System.out.println("------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "excelData")
    public void data(Hashtable<String,String> data){
        System.out.println(data);
    }



}
