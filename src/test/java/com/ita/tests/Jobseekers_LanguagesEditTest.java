package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekers_LanguagesEditPage;
import com.ita.pages.JobSeekers_TravelEditPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jobseekers_LanguagesEditTest extends BaseTest {
    @Test
    public void languages() {
        //Test data
        String language = "Punjabi";
        String relevanceType = "Intermediate";

        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_LanguagesEditPage jobSeekers_languagesEditPage = jobSeekersLandingPage.clickLanguages();
        jobSeekers_languagesEditPage.setLanguage(language);
        jobSeekers_languagesEditPage.setRelevanceType(relevanceType);
        jobSeekers_languagesEditPage.clickSaveChanges();
        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // verify Language is added
        Assert.assertEquals(jobSeekersLandingPage.verifylanguage(),language);
    }
}


//Assert.assertEquals(jobSeekersLandingPage.verifyLanguageRelevanceType(), relevanceType);



