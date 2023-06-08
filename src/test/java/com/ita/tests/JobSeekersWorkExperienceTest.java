package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.HomePage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobseekersWorkExperiencePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobSeekersWorkExperienceTest extends BaseTest {
    @Test
    public void  addValidExperience() throws InterruptedException {

        homePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickAddWorkExperience();
        //verify work experience page appeared
        Assert.assertTrue(JobSeekersLandingPage.isWorkExperienceHeaderTextDisplayed(), "Work experience page does not loaded property.");

        JobseekersWorkExperiencePage jobseekers = new JobseekersWorkExperiencePage(driver);
        // declaring Work Experience data
        String name = "IT";
        String title = "Automation Tester678";
        String checkAndUncheck = "check";
        String country = "China1";
        String jobType = "Other";
        String startMonth= "03";
        String startYear= "2021";
        String endMonth= "03";
        String endYear= "2022";
        String achievement = " Automation Certification1";
        String description = "I have 1 year of experience in Selenium.";

         //calling the methods
        jobseekers.setCompanyName(name);
        jobseekers.setJobTitle(title);
        jobseekers.updateHeadline(checkAndUncheck);
        jobseekers.modifyCountry(country);
        jobseekers.setJobType(jobType);
        jobseekers.setStartMonth(startMonth);
        jobseekers.setStartYear(startYear);
        jobseekers.setEndMonth(endMonth);
        jobseekers.setEndYear(endYear);
        jobseekers.addachievement(achievement);
        jobseekers.setDescription(description);
        jobseekers.clickSaveChanges();

        // verifying the title field
        JobSeekersLandingPage.verifyJobTitleText(title);


    }
}
