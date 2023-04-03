package com.ita.pages;

import com.ita.utility.CommonComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekers extends CommonComponents {

    WebDriver driver;
    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");


    By jobsAndApplicationsLink = By.linkText("Jobs & applications");
    By manageJobsTextBy = By.xpath("//div[text()='Manage Jobs ']");


    public JobSeekers(WebDriver driver){
        super(driver);
        this.driver = driver;

    }

    public void loginJobSeeker(String email, String password){
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);

        //use submit() method of form
        driver.findElement(By.xpath("//form[@id='signup-form']")).submit();


//        driver.findElement(button).click();
    }

    By errorMsgLocator = By.xpath("//div[@id='errorval']/b");

    public String getErrorMsg(){
        return driver.findElement(errorMsgLocator).getText();
    }

    public void addWorkExperience(){

        //click on work experience
        driver.findElement(By.xpath("//div[@class='summary'][4]//a")).click();


    }
//
//    public String getManageJobsText(){
//        return  driver.findElement(manageJobsTextBy).getText().trim();
//    }


}
