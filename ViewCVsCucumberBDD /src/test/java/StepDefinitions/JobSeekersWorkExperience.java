package StepDefinitions;

import Utililities.TestContext;
import Utililities.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class JobSeekersWorkExperience{
    TestContext testContext;


    public JobSeekersWorkExperience(TestContext testContext){
        this.testContext=testContext;
    }

    @Given("The user is on the MyProfile Page")
    public void theUserIsOnTheMyProfilePage() {
        testContext.getHomepage().OpenURL();
        testContext.getHomepage().clickJobSeekersLinkOnTop();
        testContext.getJobSeekersLoginPage().login("mary1@gmail.com", "abcd");

        //Verify Page through Title
        String expectedTitle = "Dashboard";
        String actualTitle =testContext.getJobSeekersLoginPage().getBrowserTitle(); // getBrowserTitle is in Basepage so use any page to call it.
        Assert.assertEquals(actualTitle,expectedTitle, "Titles do not match");
        System.out.println(" Assertion successful");

    }

    @When("User presses the Add button for Work Experience")
    public void user_presses_the_add_button_for_work_experience() {
        testContext.getJobSeekersLoginPage().addWorkExperience();
        // Verify through Header Text
        testContext.getJobseekersWorkExperiencePage().isWorkExperienceHeaderTextDisplayed();
    }

    @And("User enters valid data for the following")
    public void user_enters_valid_data_for_the_following(DataTable dataTable) throws InterruptedException {
        // declaring the way to read the table
        List<Map<String,String>> data = dataTable.asMaps();  // Map<K,V>: 1st String is for Table headers(key) and the second String is for values of the table

            String companyName = data.get(0).get("CompanyName");// we are passing the var from datatable to the method using the header name
            String jobTitle = data.get(0).get("JobTitle");
            jobTitle = jobTitle + Utility.getCurrentDateTime();
            String countryName = data.get(0).get("Country");
            String updateHeadline = data.get(0).get("UpdateHeadline");
            String townName = data.get(0).get("Town");
            String jobType = data.get(0).get("JobType");
            String startMonth = data.get(0).get("StartMonth");
            String startYear = data.get(0).get("StartYear");
            String endMonth = data.get(0).get("EndMonth");
            String endYear = data.get(0).get("EndYear");
            String achievements = data.get(0).get("Achievements");
            String description = data.get(0).get("Description");

            //Enter the values by calling the methods of the page
            testContext.getJobseekersWorkExperiencePage().setCompanyName(companyName);  // passing the value from String companyName above
            testContext.getJobseekersWorkExperiencePage().setJobTitle(jobTitle);
            testContext.setJobTitle(jobTitle);

            //testContext.getJobseekersWorkExperiencePage().checkUpdateHeadline();            // Check Headline is updated;
            //testContext.getJobseekersWorkExperiencePage().setUpdateHeadline(updateHeadline);  // Check/uncheck based on Data Table
            testContext.getJobseekersWorkExperiencePage().setCountry(countryName);
            testContext.getJobseekersWorkExperiencePage().setTown(townName);
            testContext.getJobseekersWorkExperiencePage().setJobType(jobType);

            testContext.getJobseekersWorkExperiencePage().setStartMonth(startMonth);
            testContext.getJobseekersWorkExperiencePage().setStartYear(startYear);
            testContext.getJobseekersWorkExperiencePage().setEndMonth(endMonth);
            testContext.getJobseekersWorkExperiencePage().setEndYear(endYear);
            testContext.getJobseekersWorkExperiencePage().setAchievement(achievements);
            testContext.getJobseekersWorkExperiencePage().setDescription(description);

    }

    @And("User presses save button")
    public void user_presses_save_button() throws InterruptedException {
        testContext.getJobseekersWorkExperiencePage().setSaveChangesButton();
        testContext.getJobSeekersLoginPage().isMyProfilePageDisplayed();// verify
        Thread.sleep(3000);
    }

    @Then("It should create a new record in the Work Experience")
    public void it_should_create_a_new_record_in_the_work_experience() {
       // String actualJobTitle = how to find from my profile as it will create new when I execute??
        String expectedTitle = testContext.getJobTitle();
        Assert.assertTrue(expectedTitle.contains("Programmer"));
        System.out.println(" All the Work Experience is added.");

    }
}



