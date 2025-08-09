package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
    private FileInputStream file;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

 
    public ExcelUtility(String excelPath, int sheetNumber) {
        try {
            file = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(sheetNumber);
        } catch (IOException e) {
            System.err.println("Error initializing Excel Utility for path: " + excelPath);
            e.printStackTrace();
        }
    }


    public int getTotalRows() {
        
        return sheet.getLastRowNum();
    }


    public int getTotalColumns() {

        if (sheet.getRow(0) == null) {
            return 0; 
        }
        return sheet.getRow(0).getLastCellNum();
    }


    public String getCellValue(int rowNum, int colNum) {
       
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            return ""; 
        }

        XSSFCell cell = row.getCell(colNum);
        if (cell == null) {
            return ""; 
        }
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
    
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
            if (file != null) {
                file.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing the Excel file resources.");
            e.printStackTrace();
        }
    }
}