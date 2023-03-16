package com.InteractiveTrainingAcademy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ITAConsultingPage extends BeforeAfterMethods {

//    WebDriver driver;
//
//    @BeforeTest
//    public void beforeSetup(){
//
//        System.out.println("Before test executed in ITA Consulting Page");
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
//
//    }

    @Test
    public void verify_Consulting_page() throws InterruptedException {


        WebElement elmToClick_Manual_and_Automation = driver.findElement(By.linkText("CONSULTING & DEVELOPMENT"));
        elmToClick_Manual_and_Automation.click();

        //verify manual and automation page appears.
        WebElement elmTextManualAndAutomation =
                driver.findElement(By.xpath("//*[text()='Software Consultancy']"));
        Assert.assertTrue(elmTextManualAndAutomation.isDisplayed());

//        Thread.sleep(5000);

    }

//    @AfterClass
//    public void tearDown(){
//        System.out.println("After test executed in ITA Consulting Page");
//
//        driver.quit();
//    }

}
