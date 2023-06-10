package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.annotations.Test;

public class Jobseekers_CertificationsAddEditTest extends BaseTest {

    @Test
    public void certifications(){
        String name = "Java";
        String summary = "Basic Java";
        String year ="2000";
        String month = "06";
        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_CertificationsAddEditPage jobSeekers_certificationsAddEditPage = jobSeekersLandingPage.clickCertificationsAdd();

        jobSeekers_certificationsAddEditPage.setAddCertificationName(name);
        jobSeekers_certificationsAddEditPage.setAddCertificationSummary(summary);
        jobSeekers_certificationsAddEditPage.setAddYearAcquiredCertification(year);
        jobSeekers_certificationsAddEditPage.setAddMonthAcquiredCertification(month);
        jobSeekers_certificationsAddEditPage.clickSaveButton();
        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();
        jobSeekersLandingPage.verifyLatestfieldText(name);

    }


}



