package com.wholefood.automation.framework.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Iftekhar Ivaan on 3/25/2017.
 */
public class TableUtils {

    private WebDriver driver = null;

    public TableUtils(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getTableCellBySearch(By tableLocator, String searchTerm, String columnToReturn){

        String[] searchPart = searchTerm.split("=");
        String searchColumnText = searchPart[0];
        String searchColumnValue = searchPart[1];

        WebElement table = driver.findElement(tableLocator);
        List<WebElement> columnHeaders = table.findElements(By.tagName("th"));

        HashMap<String, Integer> columnIndex = new HashMap<String, Integer>();
        for(int i = 0; i < columnHeaders.size(); i++){
            String headerText = columnHeaders.get(i).getText().toUpperCase();
            columnIndex.put(headerText,i);
        }

        int searchColumnIndex = columnIndex.get(searchColumnText.toUpperCase());
        int returnColumnIndex = columnIndex.get(columnToReturn.toUpperCase());

        WebElement tableReturnCell = null;

        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        for(WebElement row : rows){

            List<WebElement> cells = row.findElements(By.tagName("td"));
            if(cells != null && cells.size()> 0) {
                WebElement searchCell = cells.get(searchColumnIndex);
                if (searchCell.getText().contentEquals(searchColumnValue)) {
                    tableReturnCell = cells.get(returnColumnIndex);
                    break;
                }
            }
        }
        return tableReturnCell;
    }

    public WebElement getTableCellByIndex(By tableLocator, int rowIndex, int columnIndex){


        WebElement table = driver.findElement(tableLocator);

        WebElement tableReturnCell = null;

        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        WebElement row = rows.get(rowIndex);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if(cells != null && cells.size()> 0) {
            tableReturnCell = cells.get(columnIndex);
        }
        return tableReturnCell;
    }
}