package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobsAndApplications;
import com.ita.pages.Recruiters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsAndApplicationsTest extends BaseTest {

    @Test
    public void VerifyJObsAndApplicationsPage(){


        Recruiters recruiters = homepage.clickRecruitersLinkOnTop();
        //enter credentials
        recruiters.loginRecruiter("born.testers@gmail.com", "October2022" );

        //after login in, verify user in Recruiters' dash board page
        String expected_Title = "Recruiter Dashboard";
        Assert.assertTrue(recruiters.getBrowserTitle().contains(expected_Title), "Both titles are not matching");

        //verify email id is displyed as we passed
        String expectedEmail = "born.testers@gmail.com";
        String actualEmail = recruiters.getRecruitersEmailAddr();
        Assert.assertEquals(actualEmail, expectedEmail , "Email value is not showing as expected.");

        //after succesfully logged in , click Jobs & applications page
        JobsAndApplications jobsnapplicationspage =  homepage.clickJobsAndApplicationsMenuOnTop();

//        jobsnapplicationspage.getManageJobsColumnList();

        //verify the added row is listed in the table in the last row

        //verify view the added row and data is displayed as same

        //verify delete functionality

        //verify edit functionality


    }


}
