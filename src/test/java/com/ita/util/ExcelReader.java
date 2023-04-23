package com.ita.util;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReader {


    @DataProvider()
    public Iterator<Object[]> getLoginData(){


        //Path of the excel file
        FileInputStream fs = new FileInputStream("D:\\DemoFile.xlsx");
//Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(sheet.getRow(0).getCell(0));
        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.getCell(1);
        System.out.println(sheet.getRow(0).getCell(1));
        Row row2 = sheet.getRow(1);
        Cell cell2 = row2.getCell(1);
        System.out.println(sheet.getRow(1).getCell(0));
        Row row3 = sheet.getRow(1);
        Cell cell3 = row3.getCell(1);
        System.out.println(sheet.getRow(1).getCell(1));
    //String cellval = cell.getStringCellValue();
    //System.out.println(cellval);

        //open apachi poi excel file name first.

        return null;
    }
}
