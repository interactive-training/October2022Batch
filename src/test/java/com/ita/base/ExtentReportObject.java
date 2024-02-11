package com.ita.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExtentReportObject{

    //ExtentReport, ExtentSparkReport-- html report name
    //Listeners

    public static ExtentReports getExtentReportObject(){
        System.out.println("Extern report");

        ExtentSparkReporter extentSparkReporter;
        ExtentReports extentReports;
//        ExtentTest test;

        //get the path of extent repoort to store
        String path = System.getProperty("user.dir") + "/target/Reports/ExtentReport/index.html";
        extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Report  name set as project name or web UI test");
        extentSparkReporter.config().setDocumentTitle("This is document Title shown on top of browser");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "ITA Tester name");
        extentReports.setSystemInfo("AnotherSystemInfoKey", "AnotkerSystekInfo Value");

        return extentReports;
    }


}
