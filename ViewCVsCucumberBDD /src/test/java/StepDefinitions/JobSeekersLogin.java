package StepDefinitions;

import Utililities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JobSeekersLogin {
    public static final Logger log = LogManager.getLogger(JobSeekersLogin.class.getName());

    WebDriver driver;
    Hooks hooks;
    TestContext testContext;  // static var of TestContext class

    public JobSeekersLogin(TestContext testContext) {
        this.testContext = testContext;
        // this constructor will load the contents of the TestContext class which can be accessed through its object.
        // Instead of writing ViewCvs  var = new ViewCvs(driver), this sentence is written internally by pico container.
    }

    @Given("the user launched the ViewCV url")
    public void the_user_launched_the_view_cv_url() {
        testContext.getHomepage().OpenURL(); //access homepage through testContext and call its method
        System.out.println("The user launched the Viewcv url");
        System.out.println(testContext.getHomepage().getBrowserTitle());
    }

    @When("the user logged into Jobseekers account with valid credentials")
    public void theUserLoggedIntoJobseekersAccountWithValidCredentials() {  // gets the userEmail and password from the feature file to this step
        testContext.getHomepage().clickJobSeekersLinkOnTop();
        testContext.getJobSeekersLoginPage().login("swatada2233@gmail.com", "Welcome@123");// takes the userEmail and password from the method of this step
    }

    @Then("it should navigate to My Profile page")
    public void it_should_navigate_to_my_profile_page() {
        testContext.getJobSeekersLoginPage().isMyProfilePageDisplayed(); // to verify the My Profile Page is displayed
        System.out.println("My Profile Page is displayed.");

 //       or assert title
//        String expectedURL = "https://www.viewcvs.co.uk/experience.php";
//        String actualURL = testContext.getHomepage().getBrowserUrl();
//        Assert.assertEquals(actualURL,expectedURL);
    }

}
