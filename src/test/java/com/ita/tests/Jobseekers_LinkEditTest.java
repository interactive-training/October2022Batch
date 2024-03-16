package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekers_LinkEditPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jobseekers_LinkEditTest extends BaseTest {

    @Test
    public void links() {
        //Test Data
        String url = "https://www.abc.co.uk";
        String desciption = "Abc";

        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_LinkEditPage jobSeekers_linkEditPage = jobSeekersLandingPage.clickLink();

        jobSeekers_linkEditPage.setLinkURL(url);
        jobSeekers_linkEditPage.setLinkDescription(desciption);
        jobSeekersLandingPage.clickSaveButton();

        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // Verify Link is Edited
        String actual = jobSeekersLandingPage.verifyLinkUrl();
        Assert.assertEquals(actual, url);
        //Assert.assertEquals(jobSeekersLandingPage.verifyLinkDescription(),desciption,"Description is not the same.");
    }
}

