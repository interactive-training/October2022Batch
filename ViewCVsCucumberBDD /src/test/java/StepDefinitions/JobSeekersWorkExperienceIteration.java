package StepDefinitions;

import Utililities.TestContext;
import Utililities.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class JobSeekersWorkExperienceIteration{
    TestContext testContext;

    public JobSeekersWorkExperienceIteration(TestContext testContext) {
        this.testContext = testContext;}

    @When("User presses the Add button for Work Experience, enters the following data and presses the save button")
    public void user_presses_the_add_button_for_work_experience_enters_the_following_data_and_presses_the_save_button(DataTable dataTable) throws InterruptedException {

            List<Map<String, String>> data = dataTable.asMaps();// declaring the way to read the table
            // Map<K,V>: 1st String is for Table headers(key) and the second String is for values of the table
            // to add multiple records
            for (int x = 0; x <= data.size() - 1; x++) {

                // Clicking Add Button of Work Experience
                testContext.getJobSeekersLoginPage().addWorkExperience();
                // Verify through Header Text
                testContext.getJobseekersWorkExperiencePage().isWorkExperienceHeaderTextDisplayed();

                //Reading data from the DataTable
                String companyName = data.get(x).get("CompanyName");// we are passing the var from datatable to the method using the header name
                String jobTitle = data.get(x).get("JobTitle");
                jobTitle = jobTitle + Utility.getCurrentDateTime();
                String countryName = data.get(x).get("Country");
                //String updateHeadline = data.get(0).get("UpdateHeadline");
                String townName = data.get(x).get("Town");
                String jobType = data.get(x).get("JobType");
                String startMonth = data.get(x).get("StartMonth");
                String startYear = data.get(x).get("StartYear");
                String endMonth = data.get(x).get("EndMonth");
                String endYear = data.get(x).get("EndYear");
                String achievements = data.get(x).get("Achievements");
                String description = data.get(x).get("Description");

                //Enter the values by calling the methods of the page
                testContext.getJobseekersWorkExperiencePage().setCompanyName(companyName);  // passing the value from String companyName above
                testContext.getJobseekersWorkExperiencePage().setJobTitle(jobTitle);

                //testContext.getJobseekersWorkExperiencePage().checkUpdateHeadline();            // Check Headline is updated;
                //testContext.getJobseekersWorkExperiencePage().setUpdateHeadline(updateHeadline);  // Check/uncheck based on Data Table
                testContext.getJobseekersWorkExperiencePage().setCountry(countryName);
                testContext.getJobseekersWorkExperiencePage().setTown(townName);
                testContext.getJobseekersWorkExperiencePage().setJobType(jobType);
                testContext.setJobTitle(jobTitle);
                testContext.getJobseekersWorkExperiencePage().setStartMonth(startMonth);
                testContext.getJobseekersWorkExperiencePage().setStartYear(startYear);
                testContext.getJobseekersWorkExperiencePage().setEndMonth(endMonth);
                testContext.getJobseekersWorkExperiencePage().setEndYear(endYear);
                testContext.getJobseekersWorkExperiencePage().setAchievement(achievements);
                testContext.getJobseekersWorkExperiencePage().setDescription(description);

                //Clicking Save Button
                testContext.getJobseekersWorkExperiencePage().setSaveChangesButton();
                testContext.getJobSeekersLoginPage().isMyProfilePageDisplayed();      // verify
            }
        }

    @Then("It should create a new records for Work Experience")
    public void it_should_create_a_new_records_for_work_experience() {

      String expectedTitle = testContext.getJobTitle();
      Assert.assertTrue(expectedTitle.contains("Programmer"));
      System.out.println(" All the Work Experience is added.");
        }

}
