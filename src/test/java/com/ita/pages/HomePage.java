package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {
    static WebDriver driver;


    static By recruiters_LinkText = By.linkText("Recruiters");
    static By jobSeekersBy = By.linkText("Job Seekers");
    By jobsAndApplicationsLink = By.partialLinkText("applications");
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static RecruitersLoginPage clickRecruitersLinkOnTop(){
        driver.findElement(recruiters_LinkText).click();
        return new RecruitersLoginPage(driver);
    }

    public static JobSeekersLoginPage clickJobSeekersLinkOnTop(){
        driver.findElement(jobSeekersBy).click();
        return new JobSeekersLoginPage(driver);
    }

    public ManageJobsPage clickJobsAndApplicationsMenuOnTop(){

        driver.findElement(jobsAndApplicationsLink).click();

        //verify it navigates to correct page // here is the assertion in basetest , not in page object.
        String expected_value = "Manage Jobs";
        String actualValue = driver.getTitle();
        Assert.assertTrue(actualValue.contains(expected_value), "User could not navigate to Jobs and application page.");

        return new ManageJobsPage(driver);

    }



}
