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

    @Then("user should navigate to the Add poojas page")
    public void userShouldNavigateToTheAddPoojasPage() {
        Assert.assertTrue(testContext.getPoojaDetailsPage().verifyPoojaDetailsHeader());
        System.out.println("Pooja Details Page verified.");
    }

    @And("user clicks on ADD pooja button")
    public void userClicksOnADDPoojaButton() {
        testContext.getPoojaDetailsPage().clickAddPoojaButton();
        System.out.println("Clicks on Add poojas");
    }

    //commented by Pramod to fix - duplicate steps issue
//    @Then("navigate to the ADD pooja page")
//    public void navigateToTheADDPoojaPage() {
//        testContext.getPoojas_addPoojasDetailsPage().verifyAddPoojaDetailsHeader();
//        System.out.println("on Add Poojas Details page ");
//    }

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
    @When("user select the edit option for{string},and edits the{string},with{string}")
    public void editTheFollowingFields (String Poojatitle, String Editfield, String editinfo) {
        List<WebElement> EditPoojaTitle = driver.findElements(By.xpath("//tr//td[2]"));
        System.out.println(EditPoojaTitle.size());
        for (int E = 0; E < EditPoojaTitle.size(); E++) {
            String Title = EditPoojaTitle.get(E).getText();
            if (Title.equals(Poojatitle)) {
                int r1 = E + 2;
                driver.findElement(By.xpath("//tr[" + r1 + "]/td[6]/a[2]")).click();
                break;
            }
        }
        WebElement actualHeader = driver.findElement(By.xpath("//div[@id='bar']"));
        String H = actualHeader.getText();
        String expectedHeader = "Edit Pooja Details";
        Assert.assertEquals(H, expectedHeader);
        System.out.println("User is on Edit Pooja page");
        if(Editfield.equals("Pooja Title")) {
            driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).clear();
            driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).sendKeys(editinfo);
//          driver.findElement(By.xpath("//tr[5]/td[2]/input")).clear();
//          driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys(editinfo);
//          driver.findElement(By.xpath("//tr[6]/td[2]/input")).clear();
//          driver.findElement(By.xpath("//tr[6]/td[2]/input")).sendKeys(editinfo);
            System.out.println("Title edited");
        }
    }
    @And("clicks on Submit button on edit page")
    public void clicksOnSubmitButtonOnEditPage() {
        driver.findElement(By.name("save")).click();
        System.out.println("Edit and submitted");
    }

    @Then("Pooja Title should be edited")
    public void poojaTitleShouldBeEdited() {
        String exp ="https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/poojas.php";
        String act = driver.getCurrentUrl();
        Assert.assertEquals(exp,act);
        System.out.println("Edited successfully");
    }


}
