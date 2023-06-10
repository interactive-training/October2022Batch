package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekers_ContactInformationEditPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jobseekers_ContactInformationEditTest extends BaseTest {
    @Test
    public void contactInformation() {
        String name = "Mary Thomas";
        String phone = "76543890";
        String phoneType= "Work";
        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_ContactInformationEditPage jobSeekers_contactInformationEditPage = jobSeekersLandingPage.clickContact();
        jobSeekers_contactInformationEditPage.setName(name);
        jobSeekers_contactInformationEditPage.setPhone(phone);
        jobSeekers_contactInformationEditPage.setPhoneType(phoneType);
        jobSeekers_contactInformationEditPage.clickSaveButton();

        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // Verify Contact Information
        Assert.assertTrue(jobSeekersLandingPage.verifyContactInformationText(name));
    }
}

//      negative test
//        jobSeekers_contactInformationEditPage.setEmail("marythomas@gmail.com");
