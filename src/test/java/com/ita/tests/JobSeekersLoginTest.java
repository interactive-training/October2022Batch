package com.ita.tests;

import com.aventstack.extentreports.Status;
import com.ita.base.BaseTest;
import com.ita.pages.HomePage;
import com.ita.pages.JobSeekersLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class JobSeekersLoginTest extends BaseTest {

    @Test(description = "Jobseeker's Test")
    public void verifyJObSeekers() throws IOException {

        homePage.clickJobSeekersLinkOnTop();
        //Verify Login Page
        String actualTitle = homePage.getBrowserTitle();
        Assert.assertTrue(actualTitle.contains("Sign in"));
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        getCurrentExtentTest().log(Status.INFO, "Jobseeker's login was successful");

    }
}

//    @Test(groups = {"smoke", "sanity"})
//    public void Testcase1() {
//
//        //in test explicitly add log and test
//
//        Assert.assertTrue(true);
//
//    }
//    @Test()
//    public void Testcase2() throws Exception {
//
//
////        Assert.assertTrue(false);
//




