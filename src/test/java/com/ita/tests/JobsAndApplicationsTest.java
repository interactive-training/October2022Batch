package com.ita.tests;

import com.aventstack.extentreports.Status;
import com.ita.base.BaseTest;
import com.ita.pages.JobsAndApplicationsPage;
import com.ita.pages.RecruitersLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsAndApplicationsTest extends BaseTest {

    @Test()
    public void VerifyJObsAndApplicationsPage(){


        getCurrentExtentTest().log(Status.INFO, "Test started, it is in test method if some extra information to be added.");

        RecruitersLoginPage recruitersPage = homepage.clickRecruitersLinkOnTop();

        //enter credentials
        recruitersPage.loginRecruiter("born.testers@gmail.com", "October2022" );

        //after login in, verify user in RecruitersLoginPage' dash board page
        String expected_Title = "Recruiter Dashboard";
        Assert.assertTrue(recruitersPage.getBrowserTitle().contains(expected_Title), "Both titles are not matching");

        //verify email id is displyed as we passed
        String expectedEmail = "born.testers@gmail.com";
        String actualEmail = recruitersPage.getRecruitersEmailAddr();
        Assert.assertEquals(actualEmail, expectedEmail , "Email value is not showing as expected.");

        //after succesfully logged in , click Jobs & applications page
        JobsAndApplicationsPage jobsnapplicationspage =  homepage.clickJobsAndApplicationsMenuOnTop();


    }


}
