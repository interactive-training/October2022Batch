package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.HomePage;
import com.ita.pages.JobSeekersLoginPage;
import com.ita.pages.JobSeekersSignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobSeekersSignUpTest extends BaseTest {

    @Test
    public void verifySignUp(){
        // Test data
        String fullName ="John Gregory";
        String email = "john4@gmail.com";
        String password = "john";
        String industry = "Banking";

        homePage.clickJobSeekersLinkOnTop();
        //Verify Login Page
        String actualTitle = homePage.getBrowserTitle();
        Assert.assertTrue(actualTitle.contains("Sign in"));
        JobSeekersLoginPage.clickSignUp();
        //Verify Sign Up Page
        String actualUrl = homePage.getBrowserUrl();
        Assert.assertEquals(actualUrl,"https://www.viewcvs.co.uk/register_form.php");

        JobSeekersSignUpPage jobSeekersSignUpPage=new JobSeekersSignUpPage(driver);
        jobSeekersSignUpPage.getFullName(fullName);
        jobSeekersSignUpPage.getEmail(email);
        jobSeekersSignUpPage.getPassword(password);
        jobSeekersSignUpPage.clickNext();
        // verify Industry Page
        String actualHeader = jobSeekersSignUpPage.headerText();
        Assert.assertTrue(actualHeader.equalsIgnoreCase("Select Industry"));

        jobSeekersSignUpPage.setIndustry(industry);
        jobSeekersSignUpPage.marketingCheckBox();
        jobSeekersSignUpPage.clickNext();

        // verify Account Created Page
        String currentUrl = jobSeekersSignUpPage.getBrowserUrl();
        Assert.assertEquals(currentUrl,"https://www.viewcvs.co.uk/account_created.php");
        String actual = jobSeekersSignUpPage.accountCreatedAlert();
        String expected = "Your account has been created. welcome to Viewcvs.co.uk";
        Assert.assertEquals(actual,expected, "Text does not match.");

        jobSeekersSignUpPage.clickGoToAccount();
        // verify Account Created Page
        String currentTitle = jobSeekersSignUpPage.getBrowserTitle();
        Assert.assertEquals(currentTitle,"Dashboard");
    }
}
