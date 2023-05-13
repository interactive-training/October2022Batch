package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import java.io.IOException;

public class AutoITDemoTest extends BaseTest {

    @Test
    public void uploadFile() throws IOException, InterruptedException {

        //login to app
        JobSeekersPage jobseekers = homepage.clickJobSeekersLinkOnTop();
        jobseekers.loginJobSeeker("chamtester23@gmail.com", "Welcome@123");


        //click 'upload video cv' on menu bar on top
        driver.findElement(By.linkText("Upload Video CV")).click();

        //click 'choose file' button
        WebElement elmChooseFile = driver.findElement(By.xpath("//input[@id='file1']"));
//        elmChooseFile.click(); // error on click ??

        //use action to click
        Actions actions = new Actions(driver);
        actions.moveToElement(elmChooseFile).click().perform();


        Thread.sleep(2000);

        //how to exeute EXE file
        String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\AutoITSampleFileToUpload.txt";
        //double quote for the paramter
        String autoITEXEPathWithParameter = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\AutoITUploadScriptFile.exe " + "\"" + filepath + "\"";
//
//        LOGGER.info("file path : " + filepath);
//        LOGGER.info("Auto IT exe path  with parameter :" + autoITEXEPathWithParameter);
//

        Runtime.getRuntime().exec(autoITEXEPathWithParameter);


        Thread.sleep(2000);

        //click upload file
        driver.findElement(By.xpath("//input[@value='Upload File']")).click();

        Thread.sleep(2000);

        //verify that 'success' msg appearfs
        WebElement elmSuccessMsg = driver.findElement(By.xpath("//h3[@id='status']"));
        String expectedMsg = elmSuccessMsg.getText();

        Assert.assertTrue(expectedMsg.contains("SUCCESS"), "File upload is failed.");


    }
}
