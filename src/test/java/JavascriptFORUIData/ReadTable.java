package JavascriptFORUIData;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ReadTable {

    @Test
    public void ReadData() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://imsports.rediff.com/score/in_asa_1083844.html");
        Thread.sleep(10000);

        // Execute JavaScript code to extract table data
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<Map<String, String>> tableDataList = (List<Map<String, String>>) jsExecutor.executeScript(
                "var tableDataList = [];" +
                        "var table = document.getElementById('bat-board');" +
                        "var rows = table.querySelectorAll('tbody tr');" +
                        "for (var i = 0; i < rows.length; i++) {" +
                        "  var rowData = {};" +
                        "  var cells = rows[i].querySelectorAll('td');" +
                        "  for (var j = 0; j < headerCells.length; j++) {" +
                        "    var header = headerCells[j].innerText.trim();" +
                        "    var data = cells[j].innerText.trim();" +
                        "    rowData[header] = data;" +
                        "  }" +
                        "  tableDataList.push(rowData);" +
                        "}" +
                        "return tableDataList;");

        // Print the table data
        for (Map<String, String> rowData : tableDataList) {
            System.out.println(rowData);
        }

        driver.quit();
    }

}
