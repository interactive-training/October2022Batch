package com.ita.tests;
import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.annotations.Test;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobseekersEducationPage;
import com.ita.pages.JobSeekersLandingPage;

public class JobseekersEducationTest extends BaseTest {

    @Test
    public void addEducation() {

        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker("mary1@gmail.com", "abcd");
        JobSeekersLandingPage.clickAddEducation();

        JobseekersEducationPage addDegreeType = new JobseekersEducationPage(driver);

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

        addDegreeType.setDegreeName(degreeName);
        addDegreeType.setSchoolName(schoolName);
        addDegreeType.setCountryName(country);
        addDegreeType.setTownName(town);
        addDegreeType.selectStartMonth(startMonth);
        addDegreeType.selectStartYear(startYear);
        addDegreeType.selectCompletionMonth(completionMonth);
        addDegreeType.selectCompletionYear(completionYear);
        addDegreeType.setConcentration(concentration);
        addDegreeType.setDescription(description);
        addDegreeType.clickSaveChanges();

    }
}
