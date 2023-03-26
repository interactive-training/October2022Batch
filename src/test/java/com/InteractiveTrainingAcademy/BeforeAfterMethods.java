package com.InteractiveTrainingAcademy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BeforeAfterMethods {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    public WebDriver getDriver(){
        return driver;
    }


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

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }

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

    @BeforeSuite
    public void beforeSuite(){

        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent.attachReporter(htmlReporter);

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");

    }
    @BeforeMethod
    public void beforeTestMethod(){

        test = extent.createTest("My Test", "Test description");
        test.log(Status.INFO, "Test started");
//        // Run the test code
//        test.log(Status.PASS, "Test passed");

    }
    @AfterMethod
    public void afterTestMethod(ITestResult result){

//        test = extent.createTest("My Test", "Test description");
//        test.log(Status.INFO, "Test started");
        // Run the test code
//        test.log(Status.PASS, "Test passed");

        test = extent.createTest(result.getName());
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getThrowable());
        } else {
            test.pass("Test passed");
        }

        extent.flush();
    }

}
