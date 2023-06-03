package StepDefinitions;

import Utililities.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class JobSeekersContactInformation {
    TestContext testContext;
    
    public JobSeekersContactInformation(TestContext testContext){
        this.testContext = testContext;
    }

    @When("User presses the Edit icon for the Contact Information")
    public void user_presses_the_edit_icon_for_the_contact_information() {
        testContext.getJobSeekersProfileOtherFieldsPage().clickContact();
        String expectedURL= "https://www.viewcvs.co.uk/contact_information.php";
        Assert.assertEquals(testContext.getJobSeekersLoginPage().getBrowserUrl(),expectedURL);

    }
    @When("User enters the Contact Information")
    public void user_enters_the_contact_information() {
        testContext.getJobSeekersProfileOtherFieldsPage().getPhone("7651253766");
        testContext.getJobSeekersProfileOtherFieldsPage().getPhoneType("Mobile");
        
    }

    @Then("The details should be updated")
    public void the_details_should_be_updated() {

        // How to Assert phone
        //h1[text()='Contact Information']/../p/br[2]
        String actualValue = testContext.getJobSeekersProfileOtherFieldsPage().getPhoneNumber();
        String expectedValue = "7651253766";
        Assert.assertEquals(actualValue, expectedValue);
        System.out.println("Contact information is up-to-date");
    }


}
