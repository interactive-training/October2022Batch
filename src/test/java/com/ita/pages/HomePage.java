package com.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

// Page factory , cached
// Extend report (small server) / Allure Report (single page)


public class HomePage extends BasePage {
    WebDriver driver;


    By recruiters_LinkText = By.linkText("Recruiters");


    By recruiters_PartialLinkText = By.partialLinkText("RecruitersPage");

    By jobSeekersBy = By.linkText("Job Seekers");

    By jobsAndApplicationsLink = By.partialLinkText("applications");
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public RecruitersPage clickRecruitersLinkOnTop(){

        driver.findElement(recruiters_LinkText).click();
        return new RecruitersPage(driver);

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
