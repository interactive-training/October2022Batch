package HHT_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CreateNews {

    private WebDriver driver;
    private TestContext testContext;

    public void CreateNews(TestContext testContext){
        this.testContext = testContext;
        this.driver = testContext.getDriver();
    }
    @And("clicks on CMS drop down and then choose News")
    public void clicksOnCMSDropDownAndThenChooseNews() {
    }

    @When("user clicks on my Add News button")
    public void userClicksOnMyAddNewsButton() {
    }

    @Then("user should go to Add News Details Page")
    public void userShouldGoToAddNewsDetailsPage() {
    }

    @When("the user fills all the mandatory fields")
    public void theUserFillsAllTheMandatoryFields() {
    }



}
