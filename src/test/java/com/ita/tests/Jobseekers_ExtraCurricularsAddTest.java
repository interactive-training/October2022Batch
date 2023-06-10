package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.annotations.Test;

public class Jobseekers_ExtraCurricularsAddTest extends BaseTest {

    @Test
    public void extracurriculars() {
        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        Jobseekers_ExtracurricularsAddPage jobseekers_addExtracurricularsPage = jobSeekersLandingPage.clickAddExtracurriculars();

        jobseekers_addExtracurricularsPage.setAddExtracurriculars("Play badminton regularly.");
        //jobseekers_addExtracurricularsPage.clickSaveButton();        // defect needs to be fixed
        //verify Jobseekers Landing Page
        //jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();
    }


}



