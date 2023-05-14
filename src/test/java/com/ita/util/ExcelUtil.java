package com.ita.util;

//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getObjetArrayFromTable(String excelFilePath, String sheetName) throws Exception {


        XSSFCell Cell;
        XSSFRow Row;


        // Import excel sheet.
        File src = new File(excelFilePath);

        // Load the file.
        FileInputStream finput = new FileInputStream(src);

        XSSFWorkbook w = new XSSFWorkbook(finput);

        // Load the sheet in which data is stored.
//        sheet= workbook.getSheetAt(0);
        XSSFSheet sheet = w.getSheet(sheetName);

        //set maximum rows and cols to store
        int rows = sheet.getLastRowNum(); //if it is 6 (0th row = heading , skipt it., so start from 1)
        int cols = 4; //we are storing 4 columns only (0,1,2,3)

        //initialize variable to store data
        Object[][] data = new Object[rows][cols];

        //Now, loop through rows and cols and load into a table array value
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            //1 - email
            String cellValueEmail = sheet.getRow(i).getCell(0).getStringCellValue();

            String cellValuePassword = sheet.getRow(i).getCell(1).getStringCellValue();

            String cellValueStatus = sheet.getRow(i).getCell(2).getStringCellValue();

            String cellValueErrorMsg = sheet.getRow(i).getCell(3).getStringCellValue();

            data[i - 1][0] = cellValueEmail;
            data[i - 1][1] = cellValuePassword;
            data[i - 1][2] = cellValueStatus + "";
            data[i - 1][3] = cellValueErrorMsg + "";

        }

        return data;

    }//method

} //class