//package com.ita.stepDefinitions;
//
//import com.ita.util.TestContext;
//import io.cucumber.java.*;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//
//import java.io.File;
//import java.io.IOException;
//
//public class Hooks {
//    TestContext testContext;
//
//    WebDriver driver;
//
//    public Hooks(TestContext testContext) {
//        this.testContext = testContext;
//    }
////
////
////    @Before("@chrome")
////    public void setupChrome() throws IOException {
////
////        System.out.println("@Before  annotation in cucumber setup method - hooks class.");
////        this.driver = testContext.getDriver("chrome");
////        System.out.println(driver.getTitle());
////    }
////
////    @Before("@firefox")
////    public void setupFirefox() throws IOException {
////
////        System.out.println("@Before  annotation in cucumber setup method - hooks class.");
////        this.driver = testContext.getDriver("firefox");
////        System.out.println(driver.getTitle());
////    }
////
////    @After
////    public void tearDown() throws IOException {
////
////        System.out.println("@After annotation in Cucumber after method - Closing browser in tearDown");
////        this.driver.quit();
////
////    }
////
////    @BeforeStep
////    public void beforeStep(Scenario scenario) throws IOException {
////
////        System.out.println("@BeforeStep annotation for Cucumber - in beforeStep method");
//////        if (scenario.isFailed()) {
//////            //screenshot
//////            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//////            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
//////            scenario.attach(fileContent, "image/png", "image");
//////
//////        }
////
////    }
////
////    @AfterStep
////    public void AddScreenshot(Scenario scenario) throws IOException {
////
////        System.out.println("@AfterStep annotation for Cucumber - in beforeStep method");
////
////        if (scenario.isFailed()) {
////            //screenshot
////            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
////            scenario.attach(fileContent, "image/png", "image");
////
////        }
////
////    }
//
//}
