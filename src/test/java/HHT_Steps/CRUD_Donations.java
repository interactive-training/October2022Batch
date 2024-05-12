package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.InterruptedIOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRUD_Donations {

    public static final Logger LOGGER = LogManager.getLogger(CRUD_Donations.class);
    TestContext testContext;

    public CRUD_Donations(TestContext testContext) {
        this.testContext = testContext;
    }


    @And("user is at CMS dropdown and clicks on Donations")
    public void user_is_at_CMS_dropdown_and_clicks_on_Donations() {
        LOGGER.info("getAdminstrationPanelPage started");
        testContext.getAdministrationPanelPage().clickDonations();
    }

//    *******--------Viewing Donation Details Page---------************

    @When("user clicks on view action button of {string}")
    public void user_clicks_on_view_action_button_of(String DonationTitle) throws InterruptedException {
        testContext.getAdmin_donationsDetails_Page().viewDonations(DonationTitle);
    }

    @Then("user should View Donation Details")
    public void user_should_View_Donation_Details() {
        testContext.getDonations_viewDonationDetails_Page().verifyViewDonationDetailsHeader();
    }
    //**********-------Editing Donations Details Page-------********

    @When("user selects the Edit option for {string} and edits the{string},with{string}")
    public void user_Selects_The_Edit_Option_For_And_Edits_The_With(String DonationTitle, String Editfield, String EditInfo) {
        testContext.getAdmin_donationsDetails_Page().editDonations(DonationTitle);
    }

    @And("user should be on Edit Donations page")
    public void userShouldBeOnEditDonationsPage() {
        testContext.getDonations_editDonation_Page().verifyEditDonationsDetailsHeader();
    }

    @When("user edits the {string},with{string}")
    public void userEditsTheWith(String Editfield, String EditInfo) {
        testContext.getDonations_editDonation_Page().editDonationFields(Editfield, EditInfo);
//
    }

    @And("clicks Submit button on Edit Page")
    public void clicks_Submit_Button_On_Edit_Page() {
        testContext.getDonations_editDonation_Page().DonationSubmitButton();
    }

    @Then("user should see the message Donation details updated successfully")
    public void userShouldSeeTheMessageDonationDetailsUpdatedSuccessfully() {
        testContext.getDonations_editDonation_Page().verifySuccessfullMsg();
        System.out.println("Donation details updated successfully");
    }
}
