package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testDemoITA {

    WebDriver driver;

    @Before
    public void beforeSetup(){
        System.setProperty("webdriver.chrome.driver",
                "D:\\Tools\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://interactivetrainingacademy.co.uk/");


    }

    @Test
    public void Home(){

        //click homelink
        driver.findElement(By.linkText("Home")).click();
        Assert.assertEquals("Quality Training & Consultation",driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/span[1]")).getText());

    }

}
