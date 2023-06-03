package StepDefinitions;

import Utililities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class JobsAndApplicationsManageJobs {

    TestContext testContext;
    String option;

    public JobsAndApplicationsManageJobs(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("User clicks on Jobs and Applications")
    public void user_clicks_on_jobs_and_applications() {
        testContext.getJobsAndApplicationsPage().setClickJobsAndApplication();
        String expectedURL = "https://www.viewcvs.co.uk/manage_jobs.php";
        Assert.assertEquals(testContext.getHomepage().getBrowserUrl(), expectedURL);
    }

    @When("User clicks the option {string} and {string} on a record")
    public void user_clicks_the_option_and_on_a_record(String record, String option) throws InterruptedException {
        testContext.getJobsAndApplicationsPage().getRecord(record, option);
        System.out.println("Record is managed.");
    }

    @And("User edits and saves")
    public void userEditsAndSaves() {
        testContext.getRecruitersPostAJobPage().setLocation("Birmingham");
        testContext.getRecruitersPostAJobPage().setSector("Apprenticeships");
        testContext.getHomepage().setSaveNextButton();
    }

    @Then("User should be able to edit that record {string}")
    public void user_should_be_able_to_edit_that_record(String stringAlert) {
        //verify alert
        testContext.getRecruitersPostAJobPage().getAlert();
        String alert = testContext.getRecruitersPostAJobPage().getAlert();  // reusing the methods
        Assert.assertEquals(stringAlert, alert);
        System.out.println("Alert text validated.");
        testContext.getRecruitersPostAJobPage().clickAlert();  // reusing the methods
        System.out.println("Alert accepted.");
    }

    @Then("the {string} record should be in {string}")
    public void theRecordShouldBe(String record, String option) throws InterruptedException {
        // verify page Title
        String expectedTitle = "Edit a Job";
        Assert.assertEquals(testContext.getHomepage().getBrowserTitle(), expectedTitle);
        // verify record is viewed in the above page
        String actualResult = String.valueOf((testContext.getJobsAndApplicationsPage().getRecord(record, option)));
        Assert.assertTrue(actualResult.contains("3"));
        //to use contains the getRecord cannot be void. Int didn't have 'contains' so converted to String.
        System.out.println("Verified the record is viewed.");
    }



    @Then("the {string} record should be deleted")
    public void theRecordShouldBeDeleted(String record) throws InterruptedException {
        //verify page
        String expectedTitle = "Recruiter section - Manage Jobs";
        Assert.assertEquals(testContext.getHomepage().getBrowserTitle(), expectedTitle);
        // verify record is deleted in the table:as it is deleted the record should not be in the table
        String actualResult = String.valueOf((testContext.getJobsAndApplicationsPage().getRecord(record, "delete")));
        Assert.assertTrue(actualResult.contains("1"));
        //to use contains the getRecord cannot be void. Int didn't have 'contains' so converted to String.
        System.out.println("Verified the record is deleted.");
    }
}
