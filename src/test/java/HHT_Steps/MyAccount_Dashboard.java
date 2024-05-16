package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.io.IOException;

public class MyAccount_Dashboard {

    TestContext testContext;

    public MyAccount_Dashboard(TestContext testContext)
    {
        this.testContext = testContext;
    }
    @When("the user launches the url")
    public void the_user_launches_the_url() throws IOException {
       testContext.getLoginPage().getWebsiteURL();

    }

    @Then("the user should be on the Home Page")
    public void the_user_should_be_on_the_home_page() {
        String expectedTile = "Welcome to Hanuman Hindu Temple...";
        String actualTitle = testContext.getTitle();
        Assert.assertEquals(actualTitle,expectedTile,"Titles did not match.");

    }
    @When("the user clicks on My Account")
    public void the_user_clicks_on_my_account() {
    //testContext.getMyAccountPage().verifyMyAccountHeader();
    testContext.getMyAccountPage().clicksMyAccount();
    System.out.println("clicked on My Account");

    }

    @When("the user logs in with Existing Member Credentials {string} and {string}")
    public void the_user_logs_in_with_existing_member_credentials(String UserName, String Password)  {
      testContext.getMyAccountPage().loginAsRegisteredUser(UserName,Password);

    }

    @Then("the user should go to the {string}")
    public void the_user_should_go_to_the(String expectedTitle) {
        testContext.getMyAccountDashboardPage().verifyDashboard(expectedTitle);
        System.out.println(" HomePage Titles matched.");

    }

    //Family Members / Donors Icon
    @When ("I click on Family Members Donors Icon")
    public void I_click_on_Family_Members_Donors_Icon(){
       testContext.getMyAccountDashboardPage().verifyFamilyMembersDonorsHeader();

    }
    @Then("it should go to Family Members Donors Page with title {string}")
    public void it_Should_Go_To_Family_Members_Donors_Page_With_Title(String expectedTitle){
        testContext.getMyAccountDashboardPage().verifyFamilyMembersDonors(expectedTitle);
        System.out.println("Family Members Donors - Hanuman Hindu Temple Page Titles matched.");

    }

    //Calendar Icon

    @When("I click on Calendar Icon")
    public void i_click_on_calendar_icon() {
        testContext.getMyAccountDashboardPage().verifyCalendarHeader();

    }

    @Then("it should go to Calendar Page with title {string}")
    public void it_should_go_to_calendar_page_with_title(String expectedTitle) {
        testContext.getMyAccountDashboardPage().verifyCalendar(expectedTitle);
        System.out.println("Calendar Page Titles matched.");

    }

    // Events Icon
    @When("I click on Events Icon")
    public void i_click_on_events_icon() {
        testContext.getMyAccountDashboardPage().verifyEventsHeader();
    }
    @Then("it should go to Events Page with title {string}")
    public void it_should_go_to_events_page_with_title(String expectedTitle) {
        testContext.getMyAccountDashboardPage().verifyEvents(expectedTitle);
        System.out.println("Event Page Titles matched.");

    }
    // Poojas Icon
    @When("I click on Poojas Icon")
    public void iClickOnPoojasIcon() {
        testContext.getMyAccountDashboardPage().verifyPoojasHeader();

    }

    @Then("it should go to Poojas Page with title {string}")
    public void itShouldGoToPoojasPageWithTitle(String expectedTitle) {
        testContext.getMyAccountDashboardPage().verifyPoojas(expectedTitle);
        System.out.println("Pooja Page Titles matched.");

    }
    // Donations Icon
    @When("I click on Donations Icon")
    public void iClickOnDonationsIcon() {
       testContext.getMyAccountDashboardPage().verifyDonationsHeader();

    }

    @Then("it should go to Donations Page with title {string}")
    public void itShouldGoToDonationsPageWithTitle(String expectedTitle) {
        testContext.getMyAccountDashboardPage().verifyDonations(expectedTitle);
        System.out.println("Donations Page Titles matched.");

    }
    @And("Close the browser")
    public void close_the_browser ()
    {
       testContext.getMyAccountDashboardPage().verifyLogout();
    }

}
