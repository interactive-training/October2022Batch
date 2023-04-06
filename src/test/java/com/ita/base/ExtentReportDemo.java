package com.ita.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExtentReportDemo extends BaseTest {

    //ExtentReport, ExtentSparkReport

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest test;
    @BeforeTest
    public void reportConfig(){
        System.out.println("Exetnt report");

        //get the path of extent repoort to store
        String path = System.getProperty("user.dir") + "\\Reports\\ExtentReport\\index.html";
        extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Report name set as project name or web UI test");
        extentSparkReporter.config().setDocumentTitle("This is document Title shown on top of browser");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "ITA Tester name");
        extentReports.setSystemInfo("AnotherSystemInfoKey", "AnotkerSystekInfo Value");

    }

    @AfterTest
    public void thisIfAfterTest(){
        extentReports.flush();
    }

    @Test
    public void TestExtentReportDemo(){
        test = extentReports.createTest("My test started here");
        //pass

    }

    @Test
    public void TestExtentReportDemo1() throws IOException {
        test = extentReports.createTest(" 2nd test startged here");

        //fail
        test.fail("detaileds passed here for failed test , like why it got failed... etc...");
        test.addScreenCaptureFromPath(getScreenShot());
        extentReports.flush();

    }

}
