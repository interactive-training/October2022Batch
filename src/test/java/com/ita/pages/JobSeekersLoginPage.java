package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekersLoginPage extends BasePage {
    static WebDriver driver;

    static By emailBy = By.name("email");
    static By passwordBy = By.name("password");
    static By signUpBy= By.xpath("//a[@href='register_form.php']/span");

    By button = By.xpath("//button[text()=' Sign in']");
    static By pleaseLogInBy = By.name("form-title");

    public JobSeekersLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public static JobSeekersLandingPage loginJobSeeker(String email, String password){
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        //use submit() method of form or click();
        driver.findElement(By.xpath("//form[@id='signup-form']")).submit();
        return new JobSeekersLandingPage(driver);
    }
    public static void clickSignUp(){
        driver.findElement(signUpBy).click();
    }
//    // Verify Login Page
//    public static String pleaseLogInText(){
//        String  pleaseLogInText = driver.findElement(pleaseLogInBy).getText();
//        return pleaseLogInText;
//    }



}
