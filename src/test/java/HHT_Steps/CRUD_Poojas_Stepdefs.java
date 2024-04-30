package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CRUD_Poojas_Stepdefs {
    WebDriver driver;
    TestContext testContext;

    // this constructor will load the contents of the TestContext class which can be accessed through its object.
    public CRUD_Poojas_Stepdefs(TestContext testContext){
        this.testContext = testContext;
    }

    // ------------------------------------------Background Steps--------------------------------------------------
    @When("user is at CMS dropdown and click Poojas")
    public void userIsAtCMSDropdownAndClickPoojas() {
        testContext.getAdministrationPanelPage().clickCMSthenPoojas();
    }

    @Then("user should navigate to the Pooja Details Page")
    public void userShouldNavigateToTheAddPoojasPage() {
        Assert.assertTrue(testContext.getPoojaDetailsPage().verifyAddPoojaDetailsHeader());
        System.out.println("Pooja Details Page verified.");
    }

    @And("user clicks on ADD pooja button")
    public void userClicksOnADDPoojaButton() {
        testContext.getPoojaDetailsPage().clickAddPoojaButton();
        System.out.println("Clicks on Add poojas");
    }

    //commented by Pramod to fix - duplicate steps issue
    @Then("user should go to the ADD Pooja Details page")
    public void navigateToTheADDPoojaPage() {
        testContext.getPoojas_addPoojasDetailsPage().verifyAddPoojaDetailsHeader();
        System.out.println("on Add Pooja Details page ");
    }

    @When("user enters all details for Pooja Type as {string} with {string}")
    public void userEntersAllDetailsFor(String PoojaServicesSection,String PoojaTitle, DataTable dataTable) {
        testContext.getPoojas_addPoojasDetailsPage().addPoojaDetails(PoojaServicesSection,PoojaTitle,dataTable);
    }

    @And("clicks on Submit button for Poojas")
    public void clicksOnSubmitButtonForPoojas() {
        testContext.getCommonMethods().clickSubmitButton();
    }

    //     *************** Front end ************

    @When("user clicks on Poojas Icon")
    public void userClicksOnPoojasIcon() {
        testContext.getLandingPage().clickPoojas();
    }

    @Then("user should navigate to the Poojas page")
    public void userNavigateToThePoojasPage() {
        testContext.getPoojaServicesPage().verifyPoojaServicesHeader();
//        String ExpUrl = "https://www.hanumanhindutemple.org/test_mode/pooja_services.php";
//        String ActUrl = driver.getCurrentUrl();
//        Assert.assertEquals(ActUrl, ExpUrl);
        System.out.println(" User is on Pooja Services Page.");
    }
    @And("clicks on Pooja Type as {string}")
    public void clicksOnPoojaTypeAs(String PoojaServicesSection) {
        testContext.getPoojaServicesPage().clickPoojaServicesButton(PoojaServicesSection);
    }
    @Then("I should navigate to it and {string} is visible")
    public void i_should_navigate_to_it_and_is_visible(String PoojaTitle) {
        //Verify Page
        Assert.assertTrue(testContext.getPoojaServicesPage().verifySponsorLinkOnPoojaPage());
        //Verify Title
        String actualTitle = testContext.getPoojaServicesPage().verifyPoojaTitle();
        Assert.assertEquals(actualTitle,PoojaTitle,"Titles did not match.");
        System.out.println("Verified that the Pooja is created by the title.");
    }

    //    *********** View Poojas **********
    @When("user clicks on View for Pooja with {string}")
    public void userClicksOnViewForPoojaWith(String PoojaTitle) {
        testContext.getPoojaDetailsPage().clickViewOption(PoojaTitle);
    }
    @Then("it should navigate to the selected poojas page")
    public void itShouldNavigateToTheSelectedPoojasPage() {
        // Header should be View Poojas Details
        String expectedHeader = "View Events Details";
        String actualHeader = testContext.getPoojas_viewPoojasDetails().verifyViewPoojaDetailsHeader();
        Assert.assertEquals(actualHeader,expectedHeader,"Headers did not match.");
        System.out.println("View Events Details Page displayed.");
    }
    //************ Edit Poojas ************

    @When("user selects the Edit Pooja option for {string}")
    public void userSelectsTheEditPoojaOptionFor(String Poojatitle) {
        testContext.getPoojaDetailsPage().clickEditPoojaOption(Poojatitle);
    }

    @Then("user should be on the Edit Pooja Page")
    public void userShouldBeOnTheEditPoojaPage() {
        String actualHeader = testContext.getPoojas_editPoojaDetailsPage().verifyEditPoojaDetailsHeader();
        String expectedHeader = "Edit Pooja Details";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println("User is on Edit Pooja page");
    }
    @When("user edits the Pooja for {string} with {string}")
    public void userEditsThePoojaForWith(String EditField, String EditInfo) {
        testContext.getPoojas_editPoojaDetailsPage().editPoojaDetails(EditField,EditInfo);
    }

    @And("clicks on Submit button on Edit Pooja page")
    public void clicksOnSubmitButtonOnEditPoojaPage() {
        testContext.getCommonMethods().clickSubmitButton();
    }

    @Then("Pooja Title should be edited")
    public void poojaTitleShouldBeEdited() {
        String exp ="Pooja details updated successfully";
        String act = testContext.getPoojaDetailsPage().verifyPoojaDetailsUpdatedMessage();
        Assert.assertEquals(exp,act);
        System.out.println("Pooja edited successfully");
    }

//--------------------------Delete Poojas-----------------------------------------------

    @When("user selects the Delete option for Pooja with {string}")
    public void userSelectsTheDeleteOptionForPoojaWith(String PoojaTitle) {
        testContext.getPoojaDetailsPage().clickDeletePoojaOption(PoojaTitle);
    }

    @Then("Pooja should be deleted")
    public void poojaShouldBeDeleted() {
        System.out.println("Pooja deleted.");
    }
}
