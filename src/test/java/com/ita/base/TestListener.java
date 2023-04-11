package com.ita.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {

//    WebDriver driver;


    @Override
    public void onTestStart(ITestResult iTestResult) {
        //access test description

//        System.out.println(driver.getTitle());

        String testName = iTestResult.getMethod().getMethodName();
        String testDesc = iTestResult.getMethod().getDescription();

        System.out.printf("Test added with testcase name %s and test description as %s", testName, testDesc);
        extentTest = extentReports.createTest(testName, testDesc);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        ITestContext tc = iTestResult.getTestContext();
        WebDriver driver = (WebDriver)tc.getAttribute("WebDriver");

        String testName = iTestResult.getMethod().getMethodName();

        try {
            extentTest.log(Status.FAIL, iTestResult.getThrowable());
            String screenshotFilePath = getScreenShot(driver,testName);
            File f = new File(screenshotFilePath);

            extentTest.log(Status.FAIL, screenshotFilePath);
            extentTest.addScreenCaptureFromPath(f.getPath());

            extentTest.addScreenCaptureFromBase64String(getScreenShotAsBase64(driver,testName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

//        System.out.println(driver.getTitle());
//        iTestContext.setAttribute("WebDriver", driver);

        extentReports = ExtentReportObject.getExtentReportObject();

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        extentReports.flush();

    }
}
