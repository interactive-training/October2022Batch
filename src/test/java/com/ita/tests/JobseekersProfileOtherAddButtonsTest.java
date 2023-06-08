package com.ita.tests;
import com.ita.base.BaseTest;

import com.ita.pages.*;
import org.testng.annotations.Test;

public class JobseekersProfileOtherAddButtonsTest extends BaseTest {
//    @BeforeTest
//    public void beforeTest(){
//        HomePage.clickJobSeekersLinkOnTop();
//        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
//    }

    @Test
    public void workAuthorisationAdd() {
        homePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));


        JobSeekersProfileEditIconsPage addWorkAuthorisation = new JobSeekersProfileEditIconsPage(driver);
        JobSeekersLandingPage.clickAddWorkAuthorisation();
        addWorkAuthorisation.setWorkAuthorisation("France, United Kingdom, Spain");
        addWorkAuthorisation.clickSaveButton();
    }

    @Test
    public void certifications(){
        homePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.setClickAddCertifications();

        JobseekersProfileOtherAddButtonsPage editcertifications = new JobseekersProfileOtherAddButtonsPage(driver);
        editcertifications.setAddCertificationName("Java");
        editcertifications.setAddCertificationSummary("Basic Java");
        editcertifications.setAddYearAcquiredCertification("2000");
        editcertifications.setAddMonthAcquiredCertification("06");
        editcertifications.clickSaveButton();

    }

    @Test
    public void awards(){
        homePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.setClickAddAwards();

        JobseekersProfileOtherAddButtonsPage editAwards = new JobseekersProfileOtherAddButtonsPage(driver);

        editAwards.setAddAwardName("ISTBQ");
        editAwards.setAddAwardDescription("Manual Testing Certification");
        editAwards.clickSaveButton();
    }

    @Test
    public void extracurriculars() {
        homePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.setClickAddExtracurriculars();

        JobseekersProfileOtherAddButtonsPage editExtracurriculars = new JobseekersProfileOtherAddButtonsPage(driver);
        editExtracurriculars.setAddExtracurriculars("Play badminton regularly.");
        editExtracurriculars.clickSaveButton();        // defect needs to be fixed
    }


}



