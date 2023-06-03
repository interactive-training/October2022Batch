package StepDefinitions;

import Utililities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class RecruitersManageJob {
    TestContext testContext;

    public RecruitersManageJob(TestContext testContext){
        this.testContext = testContext;
    }

    @Given("User has logged into Recruiters with {string} and {string}")
    public void userHasLoggedIntoRecruitersWithAnd(String userEmail, String password){
        testContext.getHomepage().OpenURL();
        testContext.getRecruitersPostAJobPage().clickRecruitersLinkOnTop();
        testContext.getJobSeekersLoginPage().login(userEmail,password);
    }

    @Given("User clicks on Post a Job")
    public void user_clicks_on_post_a_job() {
        testContext.getRecruitersPostAJobPage().clickPostAJob();
    }

    @When("User has entered the following and clicked submit")
    public void user_has_entered_the_following_and_clicked_submit(DataTable dataTable) {

        List<Map<String,String>> data = dataTable.asMaps();  // Map<K,V>: 1st String is for Table headers(key) and the second String is for values of the table

        String jobTitle = data.get(0).get("JobTitle");
        String salary = data.get(0).get("Salary");
        String jobType = data.get(0).get("JobType");
        String location = data.get(0).get("Location");
        String sector = data.get(0).get("Sector");
        String description = data.get(0).get("Description");

        testContext.getRecruitersPostAJobPage().setJobTitle(jobTitle);
        testContext.getRecruitersPostAJobPage().setSalary(salary);
        testContext.getRecruitersPostAJobPage().setJobType(jobType);
        testContext.getRecruitersPostAJobPage().setLocation(location);
        testContext.getRecruitersPostAJobPage().setSector(sector);
        testContext.getRecruitersPostAJobPage().setDescription(description);

        testContext.getHomepage().setSaveNextButton();
    }

    @Then("User should get this alert to accept {string}")
    public void user_should_get_this_alert_to_accept(String string) {
        String alert = testContext.getRecruitersPostAJobPage().getAlert();
        Assert.assertEquals(string,alert);
        System.out.println("Alert text validated.");
        testContext.getRecruitersPostAJobPage().clickAlert();
        System.out.println("Clicked ok on the alert.");
    }
}
