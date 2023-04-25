package com.ita.util;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;


public class ExcelReader{


    public  static XSSFWorkbook workbook;

    public static XSSFSheet sheet;

    public static XSSFRow row;

    public static XSSFCell cell;

    public static FileInputStream fis;

//    public static Workbook workbook;

    private String excelFilePath;
    private File excelFile;

//    private static Logger log;

//    ExcelReader(String excelFilePath){
//
//        log.info("Message for logger");
//        //check if the file exists
//
//        File f = FileUtils.getFile(excelFilePath);
//
//
//    }
    static Logger logger;
    public ExcelReader(){
         logger = LogManager.getLogger(ExcelReader.class);
    }

    public static String getCelldata( int rownum,int col) throws IOException
    {

        fis =new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/LoginDetails.xlsx");

        workbook = new XSSFWorkbook(fis);

        System.out.println(workbook);

        sheet= workbook.getSheet("Recruiter");

        row=sheet.getRow(rownum);

        cell=row.getCell(col);

        String cellValue = cell.getStringCellValue();


        workbook.close();
        fis.close();

        return cellValue;

    }


    public static void main(String[] args) throws IOException {

        //should be before suite
//        System.setProperty("log4j.configurationFile","D:\\Training\\Batch2_Oct_2022\\12032003\\October2022Batch\\log4j2.configurationFile.xml");
        logger = LogManager.getLogger(ExcelReader.class);

//        System.out.println(ExcelReader.getCelldata(1,2));
        logger.error("NET :: JournalDev :: LEVEL");
        logger.info("This is information log");
        logger.trace("This is trace ");


    }

}