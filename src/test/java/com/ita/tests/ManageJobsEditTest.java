package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageJobsEditTest extends BaseTest {
    @Test
    public void editManageJobsRecord() throws InterruptedException {
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

        HomePage.clickRecruitersLinkOnTop();
        RecruitersLoginPage.loginRecruiter(prop.getProperty("recruiterUsername"), prop.getProperty("recruiterPassword"));

        ManageJobsPage manageJobsPage = new ManageJobsPage(driver);
        manageJobsPage.clickJobsAndApplications();
        // verify Manage Jobs Page
        manageJobsPage.manageJobsHeader();
        manageJobsPage.getRecord(record, "Edit");
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
