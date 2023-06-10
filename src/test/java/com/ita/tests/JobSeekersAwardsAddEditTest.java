package com.ita.tests;
import com.ita.base.BaseTest;

import com.ita.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobSeekersAwardsAddEditTest extends BaseTest {

    @Test
    public void awards(){
        //Test Data
        String name ="ISTBQ";
        String description = "Manual Testing Certification";

        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_AwardsAddEditPage jobSeekers_awardsAddEditPage = jobSeekersLandingPage.clickAddAwards();

        jobSeekers_awardsAddEditPage.setAwardName(name);
        jobSeekers_awardsAddEditPage.setAwardDescription(description);
        jobSeekers_awardsAddEditPage.clickSaveButton();
        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // verify Awards edited
        Assert.assertTrue(jobSeekersLandingPage.verifyLatestfieldText(name));
    }
}



