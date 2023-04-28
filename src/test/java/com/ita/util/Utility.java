package com.ita.util;

import freemarker.template.utility.DateUtil;
import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Utility {

    WebDriver driver;

    public Utility(WebDriver driver){
        this.driver = driver;
    }

    public String getScreenShotFilePath(WebDriver driver, String testName) throws IOException {

//        Faker faker = Faker.instance();
    //create unique file names
//        verify the link.png //
//        System.getProperty("user.dir") + "\" + " testName + ".png";

//        String sourcePath =  "D:\Training\Batch2_Oct_2022\12032003\October2022Batch\verify_the_link.png_2023_04_12_13.png"



        TakesScreenshot sc = (TakesScreenshot) driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        String sourcePath;
        testName = testName.replace(" ","_");
        testName=testName+getCurrentDateTime();

        sourcePath = System.getProperty("user.dir") + testName + ".png";
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


    public static String getCurrentDateTime() {

        return LocalDateTime.now().getYear()+"_"+
                LocalDateTime.now().getMonth()+"_"+
                LocalDateTime.now().getDayOfMonth()+"_"+
                LocalDateTime.now().getDayOfWeek()+"_"+
                LocalDateTime.now().getHour()+"_"+
                LocalDateTime.now().getMinute()+"_"+
                LocalDateTime.now().getSecond();



    }


    public void SwitchWindowToChild() {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

    public void handleAlert(){
        //impliment

    }

}
