package com.ita.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekersPage extends BasePage {
    public static final Logger log = LogManager.getLogger(JobSeekersPage.class.getName());

    WebDriver driver;
    By emailBy = By.name("email");

    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");


    By jobsAndApplicationsLink = By.linkText("Jobs & applications");
    By manageJobsTextBy = By.xpath("//div[text()='Manage Jobs ']");

    By workExperienceHeaderBy = By.xpath("//div[text()='Add Experience']");

    By workButton = By.xpath("//h1[text()='Work Experience ']/..//a/button");


    public JobSeekersPage(WebDriver driver){
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


    public WorkExperiencePage clickADDWorkExperience(){

        //click on work experience
        driver.findElement(workButton).click();

//        verify you are in 'add experience' page

        return new WorkExperiencePage(driver);


    }

    public boolean isWorkExperienceHeaderTextDisplayed(){
        return driver.findElement(workExperienceHeaderBy).isDisplayed();

    }

}
