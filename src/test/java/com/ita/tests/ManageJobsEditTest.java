package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManageJobsEditTest extends BaseTest {
    @DataProvider(name="Record")
    public Object[][] record(){
        return new Object[][]{{"Estate Agent"}};
    }

    @Test(dataProvider = "Record")
    public void editManageJobsRecord(String dpRecord) throws InterruptedException {
        // declaring test data
        String record = "Manual Tester";
        String jobTitle = "Automation Tester";
        String jobLocation= "India";
        String jobSpecificLocation = "Chandigarh";
        String day = "26";
        String month = "02";
        String year = "2024";
        String sector = "IT & Telecoms";
        String jobDescription ="We need minimum 4 years of experience.";

        RecruitersLoginPage recruitersLoginPage = homePage.clickRecruitersLinkOnTop();
        RecruitersLandingPage recruitersLandingPage = recruitersLoginPage.loginRecruiter(prop.getProperty("recruiterUsername"), prop.getProperty("recruiterPassword"));
        recruitersLandingPage.clickJobsAndApplications();

        ManageJobsPage manageJobsPage = new ManageJobsPage(driver);
        manageJobsPage.manageJobsHeader();
        manageJobsPage.getRecord(dpRecord, "Edit");
        // Verify Page Title
        String expectedTitle = "Edit a Job";
        Assert.assertEquals(manageJobsPage.getBrowserTitle(), expectedTitle);

        ManageJobsEditPage editJob = new ManageJobsEditPage(driver);
        // calling methods to edit
        editJob.editJobTitle(jobTitle);
        editJob.editLocation(jobLocation);
        editJob.editSpecificLocation(jobSpecificLocation);
        editJob.editDay(day);
        editJob.editMonth(month);
        editJob.editYear(year);
        editJob.editSector(sector);
        editJob.editJobDescription(jobDescription);
        editJob.clickSubmit();
    }
}
