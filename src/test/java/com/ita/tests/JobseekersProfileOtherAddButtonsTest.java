package com.ita.tests;
import com.ita.base.BaseTest;

import com.ita.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JobseekersProfileOtherAddButtonsTest extends BaseTest {
//    @BeforeTest
//    public void beforeTest(){
//        HomePage.clickJobSeekersLinkOnTop();
//        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
//    }

    @Test
    public void workAuthorisationAdd() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));


        JobSeekersProfileEditIconsPage addWorkAuthorisation = new JobSeekersProfileEditIconsPage(driver);
        JobSeekersPage.clickAddWorkAuthorisation();
        addWorkAuthorisation.setWorkAuthorisation("United Kingdom, India,France");
        addWorkAuthorisation.clickSaveButton();
    }

    @Test
    public void certifications(){
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersPage.setClickAddCertifications();

        JobseekersProfileOtherAddButtonsPage editcertifications = new JobseekersProfileOtherAddButtonsPage(driver);
        editcertifications.setAddCertificationName("Java");
        editcertifications.setAddCertificationSummary("Basic Java");
        editcertifications.setAddYearAcquiredCertification("2000");
        editcertifications.setAddMonthAcquiredCertification("06");
        editcertifications.clickSaveButton();

    }

    @Test
    public void awards(){
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersPage.setClickAddAwards();

        JobseekersProfileOtherAddButtonsPage editAwards = new JobseekersProfileOtherAddButtonsPage(driver);

        editAwards.setAddAwardName("PETALS");
        editAwards.setAddAwardDescription("Teaching Course");
        editAwards.clickSaveButton();
    }

    @Test
    public void extracurriculars() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersPage.setClickAddExtracurriculars();

        JobseekersProfileOtherAddButtonsPage editExtracurriculars = new JobseekersProfileOtherAddButtonsPage(driver);
        editExtracurriculars.setAddExtracurriculars("Play badminton regularly.");
        //editExtracurriculars.clickSaveButton();        // defect needs to be fixed
    }


}



