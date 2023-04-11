package com.ita.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utility {

    public String getScreenShot(WebDriver driver, String testName) throws IOException {

//        Faker faker = Faker.instance();

        TakesScreenshot sc = (TakesScreenshot) driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        String sourcePath;
        sourcePath = System.getProperty("user.dir") + "/target/Reports/Screenshots/" + testName + ".png";
        File target = new File(sourcePath);
        FileUtils.copyFile(source,target);
        return sourcePath;

    }

    public String getScreenShotAsBase64(WebDriver driver, String testName) throws IOException {

//        Faker faker = Faker.instance();

        TakesScreenshot sc = (TakesScreenshot) driver;
        return sc.getScreenshotAs(OutputType.BASE64);

//        String sourcePath;
//        sourcePath = System.getProperty("user.dir") + "/target/Reports/Screenshots/" + testName + ".png";
//        File target = new File(sourcePath);
//        FileUtils.copyFile(source,target);
//        return sourcePath;

    }

}
