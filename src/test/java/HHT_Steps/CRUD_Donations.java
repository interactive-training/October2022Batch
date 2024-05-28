package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CRUD_Donations {

    TestContext testContext;
    private Logger logger = LogManager.getLogger(this.getClass());

    public CRUD_Donations(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("user is at CMS dropdown and clicks on Donations")
    public void user_is_at_CMS_dropdown_and_clicks_on_Donations() {
        testContext.getAdministrationPanelPage().clickDonations();
    }

//    *******--------Viewing Donation Details Page---------************

    @When("user clicks on view action button of {string}")
    public void user_clicks_on_view_action_button_of(String DonationTitle) throws InterruptedException {

        String msg = "Step executed :  user clicks on view action button of {string} ";

//        Logger logger = LogMe.getMyLogger(this.getClass());

        logger.info(msg);
        logger.debug(msg);
        logger.error(msg);
        logger.debug(msg);

        testContext.getAdmin_donationsDetails_Page().viewDonations(DonationTitle);
    }

    @Then("user should View Donation Details")
    public void user_should_View_Donation_Details() {
        testContext.getDonations_viewDonationDetails_Page().verifyViewDonationDetailsHeader();
    }
    //**********-------Editing Donations Details Page-------********

    @When("user selects the Edit option for {string} of Donations")
    public void user_selects_the_edit_option_for_of_donations(String DonationTitle) {
        testContext.getAdmin_donationsDetails_Page().editDonations(DonationTitle);
    }

    @And("user should be on Edit Donations page")
    public void userShouldBeOnEditDonationsPage() {
        testContext.getDonations_editDonation_Page().verifyEditDonationsDetailsHeader();
    }

    @When("user edits the {string} of Donations with {string}")
    public void user_edits_the_of_donations_with(String Editfield, String EditInfo) {
        testContext.getDonations_editDonation_Page().editDonationFields(Editfield, EditInfo);
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
