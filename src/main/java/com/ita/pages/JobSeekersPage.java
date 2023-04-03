package com.ita.pages;

import com.ita.utility.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobSeekersPage extends BasePage {

    WebDriver driver;
    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");


    By jobsAndApplicationsLink = By.linkText("Jobs & applications");
    By manageJobsTextBy = By.xpath("//div[text()='Manage Jobs ']");

    By workExperienceHeaderBy = By.xpath("//div[text()='Add Experience']");


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


    public void addWorkExperience(){

        //click on work experience
        By workButton = By.xpath("//h1[text()='Work Experience ']/..//a/button");
        driver.findElement(workButton).click();

//        Assert.assertTrue(driver.findElement(workExperienceHeaderBy).isDisplayed(), "Work experience page does not loaded property.");

        //verify you are in 'add experience' page

    }

    public boolean isWorkExperienceHeaderTextDisplayed(){
        return driver.findElement(workExperienceHeaderBy).isDisplayed();

    }

}
