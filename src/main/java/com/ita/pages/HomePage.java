package com.ita.pages;

import com.ita.utility.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {
    WebDriver driver;

    By recruiters_LinkText = By.linkText("Recruiters");
    By recruiters_PartialLinkText = By.partialLinkText("Recruiters");

    By jobSeekersBy = By.linkText("Job Seekers");

    By jobsAndApplicationsLink = By.partialLinkText("applications");
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Recruiters clickRecruitersLinkOnTop(){
        driver.findElement(recruiters_PartialLinkText).click();
        return new Recruiters(driver);

    }

    public JobSeekersPage clickJobSeekersLinkOnTop(){
        driver.findElement(jobSeekersBy).click();
        return new JobSeekersPage(driver);
    }

    public JobsAndApplicationsPage clickJobsAndApplicationsMenuOnTop(){
        //jobs and verification link

        driver.findElement(jobsAndApplicationsLink).click();

        //verify it navigates to correct page // here is the assertion in basetest , not in page object.
        String expected_value = "Manage Jobs";
        String actualValue = driver.getTitle();
        Assert.assertTrue(actualValue.contains(expected_value), "User could not navigate to Jobs and application page.");

        return new JobsAndApplicationsPage(driver);


    }



}
