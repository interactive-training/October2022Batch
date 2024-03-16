package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.annotations.Test;

//public class JobseekersProfileEditIconsTest extends BaseTest {
//    @Test
//    public void languages(){
//        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
//
//        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
//        jobSeekersLandingPage.clickLanguages();
//
//        JobSeekers_LanguagesEditPage jobSeekers_languagesEditPage = new JobSeekers_LanguagesEditPage(driver);
//        jobSeekers_languagesEditPage.setEditLanguage("German");
//        jobSeekers_languagesEditPage.setRelevanceType("Intermediate");
//        jobSeekers_languagesEditPage.clickSaveChanges();
//    }
//
//    @Test
//    public void additionalInformationRelocate(){
//        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
//
//        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
//        jobSeekersLandingPage.setClickRelocate();
//
//        JobSeekers_TravelEditPage addRelocate = new JobSeekers_TravelEditPage(driver);
//        addRelocate.setRelocate();
//        addRelocate.clickSaveButton(); // defect taking to Add Award Page
//    }
//    @Test
//    public void additionalInformationTravel() throws InterruptedException {
//        String inputTravel = "2";
//        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
//
//        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
//        jobSeekersLandingPage.setClickTravel();
//        //addTravel.setTravel(inputTravel);
//        Thread.sleep(3000);
//       // addTravel.clickSaveButton(); // defect taking to Add Award Page
//    }
//}
