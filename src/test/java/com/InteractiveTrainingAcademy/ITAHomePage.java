package com.InteractiveTrainingAcademy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ITAHomePage extends BeforeAfterMethods {

//    WebDriver driver;

//
//    @BeforeClass
//    public void beforeSetup(){
//
//        System.out.println("Before class executed in ITA Home page");
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
    public void verify_Quality_Training_and_Consultation_Text(){

        //click homelink
        driver.findElement(By.linkText("HOME")).click();
        Assert.assertEquals("Quality Training & Consultation",driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/span[1]")).getText());

    }

    @Test
    public void verify_Contact_us_page(){

        //click homelink
        driver.findElement(By.linkText("Contact Us")).click();

        //verify url for contact us page
        Assert.assertEquals("https://interactivetrainingacademy.co.uk/contactus", driver.getCurrentUrl(), "Contact us page URL does not match as expected.");

    }


//    @AfterClass
//    public void tearDown(){
//        System.out.println("After class executed in ITA Home page");
//
//        driver.quit();
//    }

}
