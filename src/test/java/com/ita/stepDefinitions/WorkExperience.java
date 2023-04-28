package com.ita.stepDefinitions;

import com.github.javafaker.Bool;
import com.ita.pages.WorkExperiencePage;
import com.ita.util.TestContext;
import com.ita.util.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class WorkExperience {

    TestContext testContext;

    public WorkExperience(TestContext testContext){
        super();
        this.testContext = testContext;
    }

    @Given("User is on MyProfile page")
    public void user_is_on_my_profile_page() {

        String expectedValue = "Dashboard";
        String actualValue = testContext.getJobSeekersPage().getBrowserTitle();
        assertEquals(actualValue, expectedValue, "Title is not matching.");

    }
    @When("User presses the Add button for Work Experience")
    public void user_presses_the_add_button_for_work_experience() {
        // Write code here that turns the phrase above into concrete actions
        testContext.getJobSeekersPage().clickADDWorkExperience();



    }
    @When("User enters below data in Add Work Experience page")
    public void user_enters_below_data_in_add_work_experience_page(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();


        WorkExperiencePage workExpPage = testContext.getWorkExperiencePage();
        List<Map<String,String>> data = dataTable.asMaps();

        //company
        String companyName = data.get(0).get("CompanyName");
        workExpPage.addCompanyName(companyName);

        //job title
        String jobTitle = data.get(0).get("JobTitle");
        jobTitle = jobTitle + Utility.getCurrentDateTime();
        workExpPage.addJobTitle(jobTitle);

        testContext.setJobTitle(jobTitle);

        //update my headline
        String updateMyHeadline = data.get(0).get("UpdateHeadline");
        if (updateMyHeadline.equalsIgnoreCase("yes")){

            //how to verify if it is checked or not
            if (workExpPage.ifChecked()) //true / false
                //do not do anything
                System.out.println("Already checked.");
            else
                workExpPage.checkBoxUpdateHeadline();  // checking

        }

        //country
        workExpPage.modifyCountry(data.get(0).get("UpdateHeadline"));

        //job type //select object
        workExpPage.selectJobType(data.get(0).get("JobType"));

        //start  month / year

        workExpPage.selectStartMonth(data.get(0).get("StartMonth"));
        workExpPage.selectStartYear(data.get(0).get("StartYear"));

        workExpPage.selectEndMonth(data.get(0).get("EndMonth"));
        workExpPage.selectEndYear(data.get(0).get("EndYear"));

    }
    @When("user presses save button")
    public void user_presses_save_button() {

        //click save
         testContext.getWorkExperiencePage().saveChangesButton();

    }
    @Then("It should create a new record in the Work Experience")
    public void it_should_create_a_new_record_in_the_work_experience() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        String expectedjobTitle = testContext.getJobTitle();

//        By jobTitleBy = By.xpath("//strong[text()='" + expectedjobTitle + "']");

        Boolean isJobTitleExist = testContext.getWorkExperiencePage().isJobTitleExistByName(expectedjobTitle);

        assertTrue(isJobTitleExist,"Job Title not found.");

//        assertEquals(testContext.getWorkExperiencePage().getBrowserTitle(), testContext.getJobTitle());
//        System.out.println("write assetions");

    }
}
