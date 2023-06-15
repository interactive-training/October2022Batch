package com.ita.util;

//import com.sun.media.sound.InvalidFormatException;
import freemarker.template.utility.DateUtil;
import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Utility {

public static String TEST_DATA_SHEET_PATH = "/Users/ravibabuadari/October2022Batch/October2022Batch/src/test/java/testData/ViewCvsData.xlsx";
//static Workbook book;
//static Sheet sheet;
    public static String getScreenShotFilePath(WebDriver driver, String testName) throws IOException {

//        Faker faker = Faker.instance();

        TakesScreenshot sc = (TakesScreenshot) driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        String sourcePath;
        testName = testName.replace(" ","_");
        testName=testName+currentDateTime();

        sourcePath = System.getProperty("user.dir") + "/target/Reports/Screenshots/" + testName + ".png";
        File target = new File(sourcePath);
        FileUtils.copyFile(source,target);
        return sourcePath;

    }

    public static String getScreenShotAsBase64(WebDriver driver, String testName) throws IOException {

//        Faker faker = Faker.instance();

        TakesScreenshot sc = (TakesScreenshot) driver;
        return sc.getScreenshotAs(OutputType.BASE64);

//        String sourcePath;
//        sourcePath = System.getProperty("user.dir") + "/target/Reports/Screenshots/" + testName + ".png";
//        File target = new File(sourcePath);
//        FileUtils.copyFile(source,target);
//        return sourcePath;

    }


    public static String currentDateTime() {

        return LocalDateTime.now().getYear()+"_"+
                LocalDateTime.now().getMonth()+"_"+
                LocalDateTime.now().getDayOfMonth()+"_"+
                LocalDateTime.now().getDayOfWeek()+"_"+
                LocalDateTime.now().getHour()+"_"+
                LocalDateTime.now().getMinute()+"_"+
                LocalDateTime.now().getSecond();



    }

//    public static Object[][] getTestData(String sheetNmae){
//        FileInputStream file=null;
//        try {
//            file = new FileInputStream(TEST_DATA_SHEET_PATH);
//        }catch)FileNotFoundException e)
//        {e.printStackTrace();}
//        try{
//            book = Workbook.create(file);
//        } catch(InvalidFormatException e){
//    }{e.printStackTrace();}
//        catch(IOException e)
//        {e.printStackTrace();}
//        sheet = book}



    public static void showMessageDialog(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }

}
