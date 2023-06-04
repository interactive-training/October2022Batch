package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.RecruitersLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitersLoginTest extends BaseTest {

    @Test
    public void VerifyJObsAndApplicationsPage(){

        //        ============================= RecruitersLoginPage =================
        RecruitersLoginPage recruitersPage = homepage.clickRecruitersLinkOnTop();
        //enter credentials
        recruitersPage.loginRecruiter(prop.getProperty("recruiterUsername"), prop.getProperty("recruiterPassword"));

        //after login in, verify user in RecruitersLoginPage' dash board page
        String expected_Title = "Recruiter Dashboard";
        Assert.assertTrue(recruitersPage.getBrowserTitle().contains(expected_Title), "Both titles are not matching");


        //verify email id is displayed as we passed
        String expectedEmail = prop.getProperty("recruiterUsername");
        String actualEmail = recruitersPage.getRecruitersEmailAddr();
        Assert.assertEquals(actualEmail, expectedEmail , "Email value is not showing as expected.");


    }

    @Test
    public void VerifyRecruitersLogin_Invalid_Username_InValid_password(){

        RecruitersLoginPage recruitersPage = homepage.clickRecruitersLinkOnTop();

        //enter credentials
        recruitersPage.loginRecruiter("born.testers@gmsdfsfdfail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = recruitersPage.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for wrong username/password not displayed correctly"); //junit - (expected, actual)

    }

    @Test
    public void VerifyRecruitersLogin_Valid_Username_InValid_password(){

        RecruitersLoginPage recruitersPage = homepage.clickRecruitersLinkOnTop();

        //enter credentials
        recruitersPage.loginRecruiter("born.testers@gmail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = recruitersPage.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for valid username, invalid password");

    }


}
