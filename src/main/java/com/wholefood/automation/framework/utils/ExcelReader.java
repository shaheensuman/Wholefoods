package com.wholefood.automation.framework.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;


/**
 * Created by Iftekhar Ivaan on 5/7/2016.
 */
public class ExcelReader {
    private XSSFWorkbook wb  = null;
    private SimpleDateFormat simpleDateFormat;

    public ExcelReader(String fileName) throws Exception{

        File file = new File(fileName);
        if(!file.exists()){
            throw new Exception("file with name " + fileName + " does not exist");
        }
        else
        {
            FileInputStream fileStreem = new FileInputStream(file);
            wb  = new XSSFWorkbook(fileStreem);
        }
    }

    public String[] getExcelRowData(String sheetName, int row) {

        String[] data = null;

        if (wb != null) {
            int sheetIndex = wb.getSheetIndex(sheetName);
            data = getExcelRowData(sheetIndex,row);
        }
        return data;
    }
    public String[] getExcelRowData(int sheetNumbere, int row) {
        String[] data = null;

        if (wb != null) {
            XSSFSheet sheet = wb.getSheetAt(sheetNumbere);
            if (sheet != null) {
                int cols = sheet.getRow(row).getPhysicalNumberOfCells();
                data = new String[cols];
                for (int i = 0; i < cols; i++) {
                    Cell cell = sheet.getRow(row).getCell(i);
                    String cellData = getData(cell).toString();
                    data[i] = cellData;
                }
            }
        }
        return data;
    }

    public String[] getExcelColData(String sheetName, int col) {
        String[] data = null;

        if (wb != null) {
            int sheetIndex = wb.getSheetIndex(sheetName);
            data = getExcelColData(sheetIndex,col);
        }
        return data;
    }
    public String[] getExcelColData(int sheetNumber, int col) {
        String[] data = null;

        if (wb != null) {
            XSSFSheet sheet = wb.getSheetAt(sheetNumber);
            if (sheet != null) {
                int rows = sheet.getLastRowNum() + 1;
                data = new String[rows];
                for (int i = 0; i < rows; i++) {

                    Cell cell = sheet.getRow(i).getCell(col);
                    String cellData = getData(cell).toString();

                    data[i] = cellData;

                }

            }
        }
        return data;
    }

    public String getExcelCellData(String sheetName, int row, int col) {
        String data = null;

        if (wb != null) {
            int sheetIndex = wb.getSheetIndex(sheetName);
            data = getExcelCellData(sheetIndex,row,col);
        }
        return data;
    }
    public String getExcelCellData(int sheetNumber, int row, int col) {
        String data = null;

        if (wb != null) {
            XSSFSheet sheet = wb.getSheetAt(sheetNumber);
            if (sheet != null) {
                Cell cell = sheet.getRow(row).getCell(col);
                String cellData = getData(cell).toString();
                data = cellData;
            }
        }
        return data;
    }

    public String[][] getExcelSheetData(String sheetName) {
        String[][] data = null;

        if (wb != null) {
            int sheetIndex = wb.getSheetIndex(sheetName);
            data = getExcelSheetData(sheetIndex);

        }
        return data;
    }
    public String[][] getExcelSheetData(int sheetIndex){
        String[][] data = null;

        if (wb != null) {
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);
            if (sheet != null) {
                int rows = sheet.getLastRowNum() + 1;
                int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();

                data = new String[rows][cols];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {

                        Cell cell = sheet.getRow(i).getCell(j);
                        String cellData = getData(cell).toString();

                        data[i][j] = cellData;
                    }
                }

            }
        }
        return data;
    }
    public String[][] getExcelSheetData(String sheetName, boolean skipHeaderColumn) {
        String[][] data = null;

        if (wb != null) {
            int sheetIndex = wb.getSheetIndex(sheetName);
            data = getExcelSheetData(sheetIndex,skipHeaderColumn);
        }
        return data;
    }
    public String[][] getExcelSheetData(int sheetIndex, boolean skipHeaderColumn)  {
        String[][] data = null;

        if (wb != null) {
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);
            if (sheet != null) {

                if(skipHeaderColumn){
                    int rows = sheet.getLastRowNum();
                    int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();

                    data = new String[rows][cols];

                    for (int i = 1; i <= rows; i++) {
                        for (int j = 0; j < cols; j++) {

                            Cell cell = sheet.getRow(i).getCell(j);
                            String cellData = getData(cell).toString();

                            data[i - 1][j] = cellData;
                        }
                    }
                }
                else{
                    int rows = sheet.getLastRowNum() + 1;
                    int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();

                    data = new String[rows][cols];

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {

                            Cell cell = sheet.getRow(i).getCell(j);
                            String cellData = getData(cell).toString();

                            data[i][j] = cellData;
                        }
                    }
                }

            }
        }
        return data;
    }


    private  Object getData(Cell cell){

        Object result = null;
        if(cell != null){
            switch (cell.getCellType ())
            {
                case HSSFCell.CELL_TYPE_NUMERIC :
                {
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        result = simpleDateFormat.format(cell.getDateCellValue());
                    }
                    else
                    {
                        result = cell.getNumericCellValue ();
                    }
                    break;
                }
                case HSSFCell.CELL_TYPE_STRING :
                {
                    RichTextString richTextString = cell.getRichStringCellValue ();
                    result = richTextString.getString();
                    break;
                }
                case HSSFCell.CELL_TYPE_BLANK:
                {
                    result = "";
                    break;
                }
                default :
                {
                    System.out.println("******************************************************************");
                    System.out.println("Cell [" + cell.getRowIndex() + "," + cell.getColumnIndex() + "]");
                    System.out.println("Cell Type: " + cell.getCellType ());
                    System.out.println ("Cell Type is not supported");
                    System.out.println("Using default as BLANK");
                    System.out.println("******************************************************************");

                    result = "";
                    break;
                }
            }
        }

        return result;
    }

    public SimpleDateFormat getSimpleDateFormat() {

        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {

        this.simpleDateFormat = simpleDateFormat;
    }


    public static void main(String[] args) throws Exception {

        ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "/src/test/test-data/HeatclinicSearchData.xlsx");

        String[] row1 = excelReader.getExcelRowData("search",1);
        System.out.println(Arrays.toString(row1));

        String[] col1 = excelReader.getExcelColData("search",1);
        System.out.println(Arrays.toString(col1));

        String[][] sheet1 = excelReader.getExcelSheetData("search");
        System.out.println(Arrays.deepToString(sheet1));

    }

}
