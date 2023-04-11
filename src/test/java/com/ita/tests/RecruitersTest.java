package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.RecruitersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitersTest extends BaseTest {

    @Test
    public void VerifyJObsAndApplicationsPage(){

        //        ============================= RecruitersPage =================


        RecruitersPage recruitersPage = homepage.clickRecruitersLinkOnTop();
        //enter credentials
        recruitersPage.loginRecruiter("born.testers@gmail.com", "October2022" );

        //after login in, verify user in RecruitersPage' dash board page
        String expected_Title = "Recruiter Dashboard";
        Assert.assertTrue(recruitersPage.getBrowserTitle().contains(expected_Title), "Both titles are not matching");


        //verify email id is displyed as we passed
        String expectedEmail = "born.testers@gmail.com";
        String actualEmail = recruitersPage.getRecruitersEmailAddr();
        Assert.assertNotEquals(actualEmail, expectedEmail , "Email value is not showing as expected.");


    }

    @Test
    public void VerifyRecruitersLogin_Invalid_Username_InValid_password(){

        RecruitersPage recruitersPage = homepage.clickRecruitersLinkOnTop();

        //enter credentials
        recruitersPage.loginRecruiter("born.testers@gmsdfsfdfail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = recruitersPage.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for wrong username/password not displayed correctly"); //junit - (expected, actual)

    }

    @Test
    public void VerifyRecruitersLogin_Valid_Username_InValid_password(){

        RecruitersPage recruitersPage = homepage.clickRecruitersLinkOnTop();

        //enter credentials
        recruitersPage.loginRecruiter("born.testers@gmail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = recruitersPage.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for valid username, invalid password");

    }


}
