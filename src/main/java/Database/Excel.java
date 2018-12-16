package Database;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

/**
 * Created by mdrahman on 12/6/18.
 * Spring 2018
 */
public class Excel {

    /**

     Excel Vs DataProvider
     Video ref : https://www.youtube.com/watch?v=wJWFXyaZFlo


    Workbook:       XSSFWorkbook and HSSFWorkbook classes implement this interface.
    XSSFWorkbook:   Is a class representation of XLSX file.
    HSSFWorkbook:   Is a class representation of XLS file.

    Sheet:          XSSFSheet and HSSFSheet classes implement this interface.
    XSSFSheet:      Is a class representing a sheet in an XLSX file.
    HSSFSheet:      Is a class representing a sheet in an XLS file.

    Row:            XSSFRow and HSSFRow classes implement this interface.
    XSSFRow:        Is a class representing a row in the sheet of XLSX file.
    HSSFRow:        Is a class representing a row in the sheet of XLS file.


    Cell:           XSSFCell and HSSFCell classes implement this interface.
    XSSFCell:       Is a class representing a cell in a row of XLSX file.
    HSSFCell:       Is a class representing a cell in a row of XLS file.

    To read integer value from a cell we need to put an appostrophe in front of the value

    getSheet(sheet Name)
    getlastCellNum()
    getStringCellValue()
    getRow()
    getRow(int)
    getCell(int)
    getNumericCellValue()
    getDateCellValue()
    getBooleanCellValue()


    **/


    public File file;
    public FileInputStream fileInputStream;
    public XSSFWorkbook wb;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;


    @BeforeClass
    public void initiateTables() throws IOException {

        //Create an object of File & Object to read
        file = new File("/Users/mdrahman/Documents/Excel_FramewaorkPractice/demo.xlsx");
        fileInputStream = new FileInputStream(file);

        // Load workbook & Sheet
        wb = new XSSFWorkbook(fileInputStream);
//        sheet = wb.getSheetAt(0);
        sheet = wb.getSheet("Sheet3");
    }



    @Test
    public void readExcel() throws IOException {

        int lastRowNum = sheet.getLastRowNum();
        // Heading
        System.out.print(sheet.getRow(0).getCell(0).getStringCellValue() + " |  ");
        System.out.print(sheet.getRow(0).getCell(1).getStringCellValue() + "   |  ");
        System.out.print(sheet.getRow(0).getCell(2).getStringCellValue() + "   |  ");
        System.out.println(sheet.getRow(0).getCell(3).getStringCellValue());
        System.out.println("--------- " + "--------- " + "----------- " + "--------- ");

        // Rows Iterations
        for (int i = 1; i <= lastRowNum; i++) {
            if (sheet.getRow(i) == null) break;
            System.out.print(sheet.getRow(i).getCell(0).getStringCellValue() + "    ");
            System.out.print(sheet.getRow(i).getCell(1).getStringCellValue() + "        ");
            System.out.print(sheet.getRow(i).getCell(2).getStringCellValue() + "   ");
            System.out.print(sheet.getRow(i).getCell(3).getStringCellValue());

            System.out.println("\n"+lastRowNum);

        }

        row = sheet.createRow(lastRowNum + 1);


        cell = row.createCell(4);


//        cell.setCellValue("N");
//        System.out.println(cell.getStringCellValue());
//        System.out.println("\n"+lastRowNum);


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        wb.write(fileOutputStream);
        fileOutputStream.close();



    }


//    @Test
//    public void createCellValue() throws IOException {
//
//        int lastRowNum = sheet.getLastRowNum();

//        for(int i = 1; i <= lastRowNum; i++ ){
//            if(sheet.getRow(i) == null) break;
//
//            sheet.getRow(i).createCell(7).setCellValue("text");
//        }

//    }



    // Write & Close File
//    @AfterClass
//    public void closeDatatTable() throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        wb.write(fileOutputStream);
//        fileOutputStream.close();
//    }


}
