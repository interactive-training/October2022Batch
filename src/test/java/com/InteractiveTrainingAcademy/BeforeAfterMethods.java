package com.InteractiveTrainingAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BeforeAfterMethods {

    WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("Before suite");
//    }
//
//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("After suite");
//    }
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("Before class");
//    }
//
//
//    @AfterClass
//    public void afterClass(){
//        System.out.println("After class");
//    }

//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("Before test");
//    }
//
//    @AfterTest
//    public void afterTest(){
//        System.out.println("After test");
//    }

//    @Test
//    public void mytest(){
//        System.out.println("My test case goes here.");
//    }


    @BeforeClass
    public void beforeSetup(){

        System.out.println("Before test executed in ITA Training Page");

//        System.setProperty("webdriver.chrome.driver",
//                "D:\\Tools\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://interactivetrainingacademy.co.uk/");


    }

    @AfterClass
    public void tearDown(){
        System.out.println("After test executed in ITA About US class");

        driver.quit();
    }


}
