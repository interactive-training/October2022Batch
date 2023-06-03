package com.ita.pages;

import com.aventstack.extentreports.Status;
import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class JobSeekersLoginPage extends BasePage {
    static WebDriver driver;

    static By emailBy = By.name("email");
    static By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");


    public JobSeekersLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public static JobSeekersPage loginJobSeeker(String email, String password){
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        //use submit() method of form or click();
        driver.findElement(By.xpath("//form[@id='signup-form']")).submit();
        return new JobSeekersPage(driver);
    }


}
