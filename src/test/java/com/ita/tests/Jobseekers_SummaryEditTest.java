package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekers_SummaryEditPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jobseekers_SummaryEditTest extends BaseTest {
    @Test
    public void summary() {
        // Test Data
        String summaryText = "This is my 3 years summary.";

        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_SummaryEditPage jobSeekers_summaryEditPage = jobSeekersLandingPage.clickSummary();

        jobSeekers_summaryEditPage.setSummary(summaryText);
        jobSeekers_summaryEditPage.clickSaveButton();

        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // verify Summary edited
        String actual = jobSeekersLandingPage.verifySummaryText();
        Assert.assertEquals(actual,summaryText);
    }
}
