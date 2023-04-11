package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersPage;
import com.ita.pages.WorkExperiencePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobSeekersWorkExperienceTest extends BaseTest {

    @Test
    public void  addValidExperience(){

        JobSeekersPage jobseekerpage = homepage.clickJobSeekersLinkOnTop();
        jobseekerpage.loginJobSeeker("chamtester23@gmail.com", "Welcome@123");

        WorkExperiencePage wexp = jobseekerpage.clickADDWorkExperience();

        //verify work experience page appeared
        Assert.assertTrue(jobseekerpage.isWorkExperienceHeaderTextDisplayed(), "Work experience page does not loaded property.");

        //enter company name
        wexp.enterCompanyName("company name 1");

        //enter job title
        wexp.enterJobTitle("job title 1");


        wexp.updateHeadline("Check");  // Check/UnCheck -- ENUM

        wexp.selectJobType("Full Time");

        wexp.selectStartMonth("01");

        wexp.selectStartYear("2012");

//        wexp.selectEndMonth("02");
//        wexp.selectEndMonth("2014");

        wexp.enterDescription("some long long long descrption, with multilinne characters..");

        wexp.clickSaveChanges();



    }


}
