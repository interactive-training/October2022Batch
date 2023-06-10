package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekers_LocationEditPage;
import org.testng.annotations.Test;

public class Jobseekers_LocationEditTest extends BaseTest {
    @Test
    public void location() {
        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();

        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_LocationEditPage jobSeekers_locationEditPage = jobSeekersLandingPage.clickLocation();

        jobSeekers_locationEditPage.setAddress1("26");
        jobSeekers_locationEditPage.setAddress2("Manor Road");
        jobSeekers_locationEditPage.setCountry("USA");
        jobSeekers_locationEditPage.setTown("Boston");
        jobSeekers_locationEditPage.setPostcode(" BO3 6FH");
//        jobSeekers_locationEditPage.clickSaveButton();   //defect
//        //verify Jobseekers Landing Page
//        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();
        //Assert

    }
}


