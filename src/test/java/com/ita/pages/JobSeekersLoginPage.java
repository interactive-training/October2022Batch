package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekersLoginPage extends BasePage {
     WebDriver driver;

     By emailBy = By.name("email");
     By passwordBy = By.name("password");
     By signUpBy= By.xpath("//a[@href='register_form.php']/span");

    public JobSeekersLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public JobSeekersLandingPage loginJobSeeker(String email, String password){
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        //use submit() method of form or click();
        driver.findElement(By.xpath("//form[@id='signup-form']")).submit();
        return new JobSeekersLandingPage(driver);
    }
    public void clickSignUp(){
        driver.findElement(signUpBy).click();
    }
//    // Verify Login Page
//    public static String pleaseLogInText(){
//        String  pleaseLogInText = driver.findElement(pleaseLogInBy).getText();
//        return pleaseLogInText;
//    }



}
