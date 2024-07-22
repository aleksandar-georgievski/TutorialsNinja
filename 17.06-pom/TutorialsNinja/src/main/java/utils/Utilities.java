package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Utilities {

    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_WAIT_TIME = 8;
    public static String generateEmailWithTimeStamp() {
        Date date = new Date();
        String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
        return "ace"+timeStamp+"@gmail.com";
    }

    public static Object[][] getTestDataFromExcel(String sheetName) {
        File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\Book1.xlsx");

        FileInputStream fisExcel;
        try {
            fisExcel = new FileInputStream(excelFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fisExcel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i=0;i<rows;i++) {
            XSSFRow row = sheet.getRow(i+1);
            for (int j=0;j<cols;j++) {
                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;
                }
            }
        }
        return data;
    }

    public static String captureScreenshot(WebDriver driver, String testName) {
        File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
        try {
            FileHandler.copy(srcScreenShot, new File(destinationScreenShotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destinationScreenShotPath;
    }
}










