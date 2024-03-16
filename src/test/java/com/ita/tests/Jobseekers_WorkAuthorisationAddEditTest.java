package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekers_WorkAuthorisationAddEditPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jobseekers_WorkAuthorisationAddEditTest extends BaseTest {

    @Test(description= "Edit Work Authorisation")
    public void workAuthorisationEdit() {
        String workAuthorisation = "United Kingdom, France,Spain";
        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();

        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_WorkAuthorisationAddEditPage jobSeekers_workAuthorisationPage = jobSeekersLandingPage.clickWorkAuthorisationEdit();

        jobSeekers_workAuthorisationPage.setWorkAuthorisation(workAuthorisation);
        jobSeekers_workAuthorisationPage.clickSaveButton();
        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // verify WorkAuthorisation edited
        Assert.assertEquals(jobSeekersLandingPage.verifyWorkAuthorisation(), workAuthorisation);

    }

    @Test(description= "Add Work Authorisation")
    public void workAuthorisationAdd() {
        String workAuthorisation = "United Kingdom";
        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();

        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_WorkAuthorisationAddEditPage jobSeekers_workAuthorisationPage = jobSeekersLandingPage.clickWorkAuthorisationAdd();

        jobSeekers_workAuthorisationPage.setWorkAuthorisation(workAuthorisation);
        jobSeekers_workAuthorisationPage.clickSaveButton();
        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // verify WorkAuthorisation added
        Assert.assertEquals(jobSeekersLandingPage.verifyWorkAuthorisation(), workAuthorisation);
    }
}

