package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.Recruiters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitersTest extends BaseTest {

    @Test
    public void VerifyJObsAndApplicationsPage(){

        //        ============================= Recruiters =================


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



    }

    @Test
    public void VerifyRecruitersLogin_Invalid_Username_InValid_password(){

        Recruiters recruiters = new Recruiters(driver);

        //enter credentials
        recruiters.loginRecruiter("born.testers@gmsdfsfdfail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = recruiters.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for wrong username/password not displayed correctly"); //junit - (expected, actual)

    }

    @Test
    public void VerifyRecruitersLogin_Valid_Username_InValid_password(){

        Recruiters recruiters = homepage.clickRecruitersLinkOnTop();

        //enter credentials
        recruiters.loginRecruiter("born.testers@gmail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = recruiters.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for valid username, invalid password");

    }


}
