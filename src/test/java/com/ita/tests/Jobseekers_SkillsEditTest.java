package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersLandingPage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekers_SkillsEditPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jobseekers_SkillsEditTest extends BaseTest {


    @Test
    public void skills() {
        //Test Data
        String skill ="Java";
        String skillLevel ="Intermediate";
        JobSeekersLoginPage jobSeekersLoginPage = homePage.clickJobSeekersLinkOnTop();
        JobSeekersLandingPage jobSeekersLandingPage = jobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekers_SkillsEditPage jobSeekers_skillsEditPage = jobSeekersLandingPage.clickSkills();

        jobSeekers_skillsEditPage.setSkill(skill);
        jobSeekers_skillsEditPage.setSkillType(skillLevel);
        jobSeekers_skillsEditPage.clickSaveChanges();

        //verify Jobseekers Landing Page
        jobSeekersLandingPage.isMyProfileHeaderTextDisplayed();

        //Assert
        Assert.assertEquals(jobSeekersLandingPage.verifySkill(),skill);
        Assert.assertEquals(jobSeekersLandingPage.verifySkillLevel(),skillLevel);

    }
}


