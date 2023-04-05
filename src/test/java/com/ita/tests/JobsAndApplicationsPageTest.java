package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobsAndApplicationsPage;
import com.ita.pages.RecruitersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsAndApplicationsPageTest extends BaseTest {

    @Test
    public void VerifyJObsAndApplicationsPage(){


        RecruitersPage recruitersPage = homepage.clickRecruitersLinkOnTop();
        //enter credentials
        recruitersPage.loginRecruiter("born.testers@gmail.com", "October2022" );

        //after login in, verify user in RecruitersPage' dash board page
        String expected_Title = "Recruiter Dashboard";
        Assert.assertTrue(recruitersPage.getBrowserTitle().contains(expected_Title), "Both titles are not matching");

        //verify email id is displyed as we passed
        String expectedEmail = "born.testers@gmail.com";
        String actualEmail = recruitersPage.getRecruitersEmailAddr();
        Assert.assertEquals(actualEmail, expectedEmail , "Email value is not showing as expected.");

        //after succesfully logged in , click Jobs & applications page
        JobsAndApplicationsPage jobsnapplicationspage =  homepage.clickJobsAndApplicationsMenuOnTop();

//        jobsnapplicationspage.getManageJobsColumnList();

        //verify the added row is listed in the table in the last row

        //verify view the added row and data is displayed as same

        //verify delete functionality

        //verify edit functionality


    }


}
