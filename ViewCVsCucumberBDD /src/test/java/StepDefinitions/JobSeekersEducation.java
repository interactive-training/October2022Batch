package StepDefinitions;

import Utililities.TestContext;
import Utililities.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class JobSeekersEducation {
    TestContext testContext;

    public JobSeekersEducation(TestContext testContext){
        this.testContext=testContext;
    }

    @Given("User is on the MyProfile Page")
    public void user_is_on_the_my_profile_page() {
        testContext.getHomepage().OpenURL();
        testContext.getHomepage().clickJobSeekersLinkOnTop();
        testContext.getJobSeekersLoginPage().login("mary1@gmail.com","abcd");
        testContext.getJobSeekersLoginPage().isMyProfilePageDisplayed(); // verify page
    }

    @When("User presses the Add button for Education")
    public void user_presses_the_add_button_for_education() {
        testContext.getJobseekersEduPage().setClickAddEducation();
        String expectedTitle = "Add Education";
        Assert.assertEquals(testContext.getJobseekersEduPage().getBrowserTitle(),expectedTitle, "Titles do not match.");
    }

    @When("User enters data for the following")
    public void user_enters_valid_data_for_the_following(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps();

        String degreeType = data.get(0).get("DegreeType");  // we are passing the var from datatable to the method using the header name
        String degreeName = data.get(0).get("DegreeName");
        degreeName = degreeName + Utility.getCurrentDateTime();// we are passing the value by the row and column of the table
        String schoolName = data.get(0).get("SchoolName");
        String country = data.get(0).get("Country");
        String townName = data.get(0).get("Town");
        String startMonth = data.get(0).get("StartMonth");
        String startYear = data.get(0).get("StartYear");
        String completionMonth = data.get(0).get("CompletionMonth");
        String completionYear = data.get(0).get("CompletionYear");
        String concentration = data.get(0).get("Concentration");
        String description = data.get(0).get("Description");

        testContext.getJobseekersEduPage().setDegreeType(degreeType);
        testContext.getJobseekersEduPage().setDegreeName(degreeName);
        testContext.getJobseekersEduPage().setSchoolName(schoolName);
        testContext.getJobseekersEduPage().setCountryName(country);
        testContext.getJobseekersEduPage().setTownName(townName);
        testContext.getJobseekersEduPage().isStudyingHere(dataTable);
        testContext.getJobseekersEduPage().selectStartMonth(startMonth);
        testContext.getJobseekersEduPage().selectStartYear(startYear);
        testContext.getJobseekersEduPage().selectCompletionMonth(completionMonth);
        testContext.getJobseekersEduPage().selectCompletionYear(completionYear);
        testContext.getJobseekersEduPage().setConcentration(concentration);
        testContext.getJobseekersEduPage().setDescription(description);
    }

    //@When("User presses save button")
    public void user_presses_save_button() {
        testContext.getJobseekersEduPage().saveChangesButton();
        testContext.getJobSeekersLoginPage().isMyProfilePageDisplayed(); // verify
    }

    @Then("It should create a new record in the Education")
    public void it_should_create_a_new_record_in_the_education() {
        System.out.println(" Education details have been completed.");
    }

}
