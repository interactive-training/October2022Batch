package com.ita.tests;

import com.aventstack.extentreports.Status;
import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class JobSeekersTest extends BaseTest{

    @Test(description = "Test description goes here to display in the report left side of the IDE.")
    public void verifyJObSeekers() throws IOException {

        JobSeekersPage jobseekers = homepage.clickJobSeekersLinkOnTop();
        jobseekers.loginJobSeeker("chamtester23@gmail.com", "Welcome@123");

    }

    @Test
    public void Testcase1() {

        //in test explicitly add log and test

        Assert.assertTrue(true);

    }
    @Test
    public void Testcase2()  {


        Assert.assertTrue(false);

    }

}
