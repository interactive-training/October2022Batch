package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.HomePage;
import com.ita.pages.ManageJobsPage;
import com.ita.pages.RecruitersLandingPage;
import com.ita.pages.RecruitersLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManageJobsTest extends BaseTest {
    @DataProvider(name="Record")
    public Object[][] record(){
        return new Object[][]{{"Estate Agent"}};
    }

    @Test(dataProvider = "Record")
        public void verifyManageJobsPageView (String dpRecord) throws InterruptedException {
        RecruitersLoginPage recruitersLoginPage = homePage.clickRecruitersLinkOnTop();
        RecruitersLandingPage recruitersLandingPage = recruitersLoginPage.loginRecruiter(prop.getProperty("recruiterUsername"), prop.getProperty("recruiterPassword"));
        recruitersLandingPage.clickJobsAndApplications();

        ManageJobsPage manageJobsPage = new ManageJobsPage(driver);

        //manageJobsPage.clickJobsAndApplications();
        // verify Manage Jobs Page Header
        manageJobsPage.manageJobsHeader();
        // Clicking the Record to View
        manageJobsPage.getRecord(dpRecord,"View");
        // Verify Edit Page Title
        String expectedTitle = "Edit a Job";
        Assert.assertEquals(manageJobsPage.getBrowserTitle(), expectedTitle);
        // Verify record is viewed in the above page
        String actualResult = String.valueOf((manageJobsPage.getRecord(dpRecord, "View")));
        Assert.assertTrue(actualResult.contains("3")); //to use contains the getRecord cannot be void. Int didn't have 'contains' so converted to String.
        System.out.println("Verified the record is viewed.");
    }
    @Test(dataProvider = "Record")
    public void verifyManageJobsPageEdit (String dpRecord) throws InterruptedException {
        RecruitersLoginPage recruitersLoginPage = homePage.clickRecruitersLinkOnTop();
        RecruitersLandingPage recruitersLandingPage = recruitersLoginPage.loginRecruiter(prop.getProperty("recruiterUsername"), prop.getProperty("recruiterPassword"));
        recruitersLandingPage.clickJobsAndApplications();

        ManageJobsPage manageJobsPage = new ManageJobsPage(driver);
        //manageJobsPage.clickJobsAndApplications();
        // verify Page Header
        manageJobsPage.manageJobsHeader();
        // Edit Record
        manageJobsPage.getRecord(dpRecord,"Edit");
        // Verify Page Title
        String expectedTitle = "Edit a Job";
        Assert.assertEquals(manageJobsPage.getBrowserTitle(), expectedTitle);

        // verify record is viewed in the above page
        String actualResult = String.valueOf((manageJobsPage.getRecord(dpRecord, "Edit")));
        Assert.assertTrue(actualResult.contains("2"));
        //to use contains the getRecord cannot be void. Int didn't have 'contains' so converted to String.
        System.out.println("Verified the record is edited.");
    }
    @Test(dataProvider = "Record")
    public void verifyManageJobsPageDelete (String dpRecord) throws InterruptedException {
        homePage.clickRecruitersLinkOnTop();
        //RecruitersLoginPage.loginRecruiter(prop.getProperty("recruiterUsername"), prop.getProperty("recruiterPassword"));

        ManageJobsPage manageJobsPage = new ManageJobsPage(driver);
        //manageJobsPage.clickJobsAndApplications();
        // verify Page Header
        manageJobsPage.manageJobsHeader();
        // Delete Record
        manageJobsPage.getRecord(dpRecord,"Delete");
        // verify record is viewed in the above page
        String actualResult = String.valueOf((manageJobsPage.getRecord(dpRecord, "Delete")));
        Assert.assertTrue(actualResult.contains("1"));
        //to use contains the getRecord cannot be void. Int didn't have 'contains' so converted to String.
        System.out.println("Verified the record is deleted.");
    }

}
