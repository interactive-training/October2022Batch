package com.ita.tests;
import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobseekersEducationPage;
import com.ita.pages.JobSeekersLandingPage;

public class JobseekersEducationTest extends BaseTest {

    @Test
    public void addEducation() {

        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobseekersEducationPage jobseekersEducationPage = jobSeekersLandingPage.clickAddEducation();

        // declaring Education data
        String degreeType = "Master";
        String degreeName = "Masters of Science";
        String schoolName = "David Primary school";
        String country = "Portugal";
        String town = "Albufeira";
        String startMonth= "06";
        String startYear= "1987";
        String completionMonth= "06";
        String completionYear= "1999";
        String concentration = "n/a";
        String description = "n/a";

        //Calling the methods of the Page

        jobseekersEducationPage.setDegreeName(degreeName);
        jobseekersEducationPage.setSchoolName(schoolName);
        jobseekersEducationPage.setCountryName(country);
        jobseekersEducationPage.setTownName(town);
        jobseekersEducationPage.selectStartMonth(startMonth);
        jobseekersEducationPage.selectStartYear(startYear);
        jobseekersEducationPage.selectCompletionMonth(completionMonth);
        jobseekersEducationPage.selectCompletionYear(completionYear);
        jobseekersEducationPage.setConcentration(concentration);
        jobseekersEducationPage.setDescription(description);
        jobseekersEducationPage.clickSaveChanges();

        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        // Verify School name
        Assert.assertTrue(jobSeekersLandingPage.verifyLatestfieldText(schoolName));

    }
}
