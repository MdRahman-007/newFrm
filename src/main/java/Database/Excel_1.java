package Database;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;

/**
 * Created by mdrahman on 12/9/18.
 * Spring 2018
 *
 *
 * URL : https://www.callicoder.com/java-read-excel-file-apache-poi/
 *
 */
public class Excel_1 {

    public String filePath = "/Users/mdrahman/Documents/Excel_FramewaorkPractice/excel_1.xlsx";

    public File file;
    public FileInputStream fileInputStream;
    public FileOutputStream fileOutputStream;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public Sheet sheet1 = null;
    public XSSFCell cell;
    public DataFormatter dataFormatter ;



    @BeforeClass
    public void initiateTable() throws IOException {

        file = new File(filePath);
        fileInputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(fileInputStream);
        dataFormatter = new DataFormatter();

    }

    @AfterClass
    public void closeTable() throws IOException {

        fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }



    // Create Sheet || Column Iteration || Row Iteration || RowColumnIteration || Specific Column Iteration
    // DataFormater


    @Test
    public void createSheet(){
        try {
            sheet1 = workbook.createSheet("SheetNew");
            System.out.println("New Sheet Created");

        } catch (Exception e){
            System.out.println(" *** Catch Block *** \n" +e.toString()+"\n");
            System.out.println("Sheet is already created");
        }

        // for-each loop to see the sheet Names
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("= > " + sheet.getSheetName());
        }

    }

    @Test
    public void columnIteration(){

        sheet1 = workbook.getSheet("SheetNew");

        // Iterating over Rows and Columns using Iterator
        System.out.println("\n\nIterating over Rows \n");

        for (int columnIndex = 0; columnIndex < 4; columnIndex++){
            cell = (XSSFCell) sheet1.getRow(0).getCell(columnIndex);
            System.out.println(cell.toString());
            }
    }

    @Test
    public void rowIteration(){

        sheet1 = workbook.getSheet("SheetNew");

        // Iterating over Rows and Columns using Iterator
        System.out.println("\n\n Iterating over Rows \n");

        for (int rowIndex = 1; rowIndex < 5; rowIndex++){
            cell = (XSSFCell) sheet1.getRow(rowIndex).getCell(1);
            System.out.println(cell.toString());
        }
    }

    @Test
    public void cellIteration_AllAtOnce(){

    sheet1 = workbook.getSheet("SheetNew");

    // Iterating over Rows and Columns using Iterator
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

    Iterator <Row> rowIterator = sheet1.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
        }
    }

    @Test
    public void cellIteration_SpecificColumn(){

        sheet1 = workbook.getSheet("SheetNew");

        int cI_RunMode  = 0;
        int cI_TestName = 0;


        // Iterating through column and get specific Column Name
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

        int lastRowNumber = sheet1.getLastRowNum();
        int lastColumnNumber = sheet1.getRow(0).getLastCellNum();
        String stringCellValue = null;

        // Get the column index for RunMode
        for ( int columnIndex = 0; columnIndex < lastColumnNumber; columnIndex++ ){
                stringCellValue = sheet1.getRow(0).getCell(columnIndex).getStringCellValue();
                if (stringCellValue.equalsIgnoreCase( "RunMode")){
                    cI_RunMode = columnIndex;
                }
                else if(stringCellValue.equalsIgnoreCase( "TestName")){
                    cI_TestName = columnIndex;
            }
        }

        // Iterate through all the rows of RunMode and find the TestName
        for (int rowIndex = 1; rowIndex <= lastRowNumber; rowIndex++) {
            stringCellValue = sheet1.getRow(rowIndex).getCell(cI_RunMode).getStringCellValue();
            if (stringCellValue.equalsIgnoreCase("Yes")) {
                stringCellValue = sheet1.getRow(rowIndex).getCell(cI_TestName).getStringCellValue();
                System.out.println(stringCellValue);
                try {
                    Cell  cell = sheet1.getRow(rowIndex).getCell(5);

                    if(cell == null){
                        cell = sheet1.getRow(rowIndex).createCell(5);
                    }

                    cell.setCellValue("TT");

                }catch (Exception e){
                    System.out.println(e.toString());
                }

            }
        }
    }



    // Excel as  hashmap


}
