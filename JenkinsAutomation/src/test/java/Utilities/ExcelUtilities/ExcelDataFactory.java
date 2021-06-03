package Utilities.ExcelUtilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataFactory {

    public File fil;
    public FileInputStream fileIS;
    XSSFWorkbook wb;

    public ExcelDataFactory() throws IOException {
        fil = new File(System.getProperty("user.dir") + "/src/test/resources/inputData/TestData.xlsx");
        try {
            fileIS = new FileInputStream(fil);
            wb = new XSSFWorkbook(fileIS);
        } catch (FileNotFoundException e) {
            System.out.println("This path" + fil + " does not have the excel file" + e.getMessage());
        }
    }

    public String getStringData(int sheetName, int row, int col) {
        return wb.getSheetAt(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

    public String getStringData(String sheetName, int row, int col) {
        return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

    public double getNumberData(String sheetName, int row, int col) {
        return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
    }
}
