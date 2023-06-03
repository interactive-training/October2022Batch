package StepDefinitions;

import Utililities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class JobSeekersSignUp {
    TestContext testContext;

    public JobSeekersSignUp (TestContext testContext){
        this.testContext = testContext;
    }

    @Given("User is Sign Up Page")
    public void user_is_sign_up_page() {
        testContext.getHomepage().OpenURL();
        testContext.getHomepage().clickJobSeekersLinkOnTop();
        testContext.getJobSeekersSignUpPage().clickSignUp();

        String expectedURL = "https://www.viewcvs.co.uk/register_form.php";
        String actualURL = testContext.getJobseekersEduPage().getBrowserUrl();
        Assert.assertEquals(actualURL,expectedURL);
        //Assert.assertTrue((testContext.getJobSeekersSignUpPage().createAnAccountIsDisplayed().contains("Account")));
       // testContext.getJobSeekersSignUpPage().verifyJobSeekersSignUp();  // did not assert and did not display the message just false?
    }
    @When("User clicks on full name, Email id, password and clicks the next button")
    public void user_clicks_on_full_name_email_id_password_and_clicks_next_button() {
        testContext.getJobSeekersSignUpPage().getFullName("Mary");
        testContext.getJobSeekersSignUpPage().getEmail("mary11@gmail.com");
        testContext.getJobSeekersSignUpPage().getPassword("abcd");
        testContext.getJobSeekersSignUpPage().clickNext();
        // verify
        String expectedTitle = "Your account";
        String actualTitle = testContext.getJobSeekersSignUpPage().getBrowserTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title did not match.");

    }
    @And("User selects the Industry and clicks the Continue button")
    public void user_selects_the_industry_and_clicks_continue_button() {
        testContext.getJobSeekersSignUpPage().setIndustry("Engineering");
        testContext.getJobSeekersSignUpPage().marketingCheckBox();
        testContext.getJobSeekersSignUpPage().clickContinue();
        //verify page
        String expectedTitle = "Account Created - ViewCVs.co.uk";
        String actualTitle = testContext.getJobSeekersSignUpPage().getBrowserTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title did not match.");
    }

    @Then("Your account has been created welcome to Viewcvs.co.uk message should be displayed")
    public void your_account_has_been_created_welcome_to_viewcvs_co_uk_message_should_be_displayed() {
        //verify page
        String expectedTitle = "Account Created - ViewCVs.co.uk";
        String actualTitle = testContext.getJobSeekersSignUpPage().getBrowserTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title did not match.");
        //verify by calling method
        testContext.getJobSeekersSignUpPage().accountCreatedAlert();
    }
}
