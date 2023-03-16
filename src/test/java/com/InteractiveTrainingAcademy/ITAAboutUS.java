package com.InteractiveTrainingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ITAAboutUS extends BeforeAfterMethods{

//    WebDriver driver;


//
//    @BeforeTest
//    public void beforeSetup(){
//        System.out.println("Before test executed in ITA About US class");
//
////        System.setProperty("webdriver.chrome.driver",
////                "D:\\Tools\\ChromeDriver\\chromedriver.exe");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        driver = new ChromeDriver(options);
//        driver.get("https://interactivetrainingacademy.co.uk/");
//
//    }

    @Test
    public void verify_ABOUT_US(){
//        this.driver = getDriver();
        //click homelink
        driver.findElement(By.linkText("ABOUT US")).click();

        WebElement elmText = driver.findElement(By.xpath("//h2/*[text()='About Us']"));
        Assert.assertTrue(elmText.isDisplayed());

    }

    @Test
    public void verify_OUR_APPROACH(){

        //click homelink
        driver.findElement(By.linkText("ABOUT US")).click();

        WebElement elmText = driver.findElement(By.xpath("//h2/*[text()='Our Approach']"));
        Assert.assertTrue(elmText.isDisplayed());

    }

//    @AfterTest
//    public void tearDown(){
//        System.out.println("After test executed in ITA About US class");
//
//        driver.quit();
//    }

}
