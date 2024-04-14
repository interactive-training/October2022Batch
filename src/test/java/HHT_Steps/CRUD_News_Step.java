package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class CRUD_News_Step {
    WebDriver driver;
    TestContext testContext;

    // this constructor will load the contents of the TestContext class which can be accessed through its object.
    public CRUD_News_Step(TestContext testContext){
        this.testContext = testContext;
    }

//    @Given("the admin user launches the url {string}")
//    public void theAdminUserLaunchesTheUrlHttpsWwwHanumanhindutempleOrgTest_modeAdm_hhtMASLoginPhp(String url) {
//        driver = new ChromeDriver();
//        driver.get(url);
//    }
//
//
//    @And("logs in with Email address {string} in email field and Password {string} in password field")
//    public void logsInWithEmailAddressInEmailFieldAndPasswordInPasswordField(String emailID, String password) {
//        driver.findElement(By.id("usr_email")).sendKeys(emailID);
//        driver.findElement(By.id("usr_password")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@class='btn-lg btn-success btn-block']")).click();
//    }
//@When("user launches the URL as {string}")
//public void the_admin_user_launches_the_URL(String admin) throws IOException {
//    //testContext.intializeDriver();
//    testContext.getLoginPage().getAdminURL(admin);
//}
//
//    @And("signs in with admin credentials {string} and {string}")
//    public void signsInWithAdminCredentials(String emailId, String password) {
//        testContext.getLoginPage().loginAsAdmin(emailId, password);
//    }
//
//    @Then("user should get in to the Administration Panel")
//    public void userShouldGetInToTheAdministrationPanel() {
//        testContext.getAdministrationPanelPage().welcomeLogin();
////        String expectedTitle = "Hanuman Hindu Temple";
////        String actualTitle = testContext.getTitle();
////        Assert.assertEquals(actualTitle, expectedTitle, "Url did not match");
//        System.out.println("Administration Panel page");
//    }
    @When("user clicks on CMS dropdown and selects News")
    public void user_clicks_on_cms_dropdown_and_selects_news() {
        testContext.getAdministrationPanelPage().clickCMSthenNews();
    }
    @Then("user should get News Details page")
    public void userShouldGetNewsDetailsPage() {
        String expURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/news.php";
        String actURL = testContext.getURL();
        Assert.assertEquals(expURL,actURL);
        System.out.println("User is on News details page");
    }
//******************Creating News**********************
    @When("User clicks on Add News button")
    public void userClicksOnAddNewsButton() {
        testContext.getNewsDetailsPage().clickAddNews();
    }

    @Then("user should get Add News Details page")
    public void userShouldGetAddNewsDetailsPage() {
        String expectedURl = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/add_news.php";
        String actualURL = testContext.getURL();
        Assert.assertEquals(actualURL, expectedURl, "Urls are same");
        System.out.println("You are on Add News Page");
    }

    @When("user enters data in all the mandatory fields {string},{string}")
    public void userEntersDataInAllTheMandatoryFields(String NewsTitle, String NewsContent) {
        testContext.getNews_addNewsDetailsPage().addNews(NewsTitle,NewsContent);
    }


    @And("clicks the Submit button")
    public void clicksSubmitButton() {
        testContext.getNews_addNewsDetailsPage().clickSubmitButton();
    }

    @Then("the News should be added successfully.")
    public void theNewsShouldBeAddedSuccessfully() {
        String expectedURl = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/news.php";
        String actualURL = testContext.getURL();
        Assert.assertEquals(actualURL, expectedURl, "Urls matched");
        System.out.println("News details Inserted successfully message should appear");
    }

//    @When("user launches the given url {string}")
//    public void userLaunchesTheGivenUrl(String validURL) {
//        driver = new ChromeDriver();
//        driver.get(validURL);
//        driver.manage().window().maximize();
//
//    }
//
//    @Then("user should be on the Home Page")
//    public void userShouldBeOnTheHomePage() {
////        driver.manage().window().maximize();
//        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/index.php";
//        String actualURL = driver.getCurrentUrl();
//        Assert.assertEquals(actualURL, expectedURL, "User is on expected URL");
//        System.out.println("homepage url verified");
//    }

    // Front-End News Verification
    @When("user clicks on News")
    public void userClicksOnNews() {
        testContext.getLandingPage().clickNews();
    }
    @Then("user should be able to see the News {string}")
    public void userShouldBeAbleToSeeTheNews(String NewsTitle) {

        String actualTitle= testContext.getNewsPage().verifyNews();
        Assert.assertEquals(actualTitle, NewsTitle);
        System.out.println("Added News is verified.");
    }
//    *******--------View the News---------************
  @When("user clicks on View of {string}")
  public void userClicksOnViewOf(String NewsTitle) {
      testContext.getNewsDetailsPage().clickViewNews(NewsTitle);
    }

    @Then("user should get View details page")
    public void userShouldGetViewDetailsPage () {
        String actualHeader = testContext.getNews_viewNewsDetailsPage().verifyViewNewsDetailsHeader();
        String expectedHeader = "View News Details";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println("User successfully viewed News");
      }
//**********-------Editing the details of News-------********
    @When("user selects the Edit option for {string}")
    public void userSelectsTheEditOptionFor(String  NewsTitle) {
        testContext.getNewsDetailsPage().clickEditNews(NewsTitle);
    }
    @Then("user should be in the Edit News Details Page")
    public void userShouldBeInTheEditNewsDetailsPage() {
        String actualHeader = testContext.getNews_editNewsDetailsPage().verifyEditNewsDetailsHeader();
        String expectedHeader = "Edit News Details";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println("User is on Edit News page");
    }

    @When("user edits the {string} with {string}")
    public void userEdits(String Editfield, String EditInfo){
        testContext.getNews_editNewsDetailsPage().editNews(Editfield,EditInfo);
    }

//    @And("clicks Submit button on Edit Page")
//    public void clicksSubmitButtonOnEditPage() {
//        testContext.getNews_editNewsDetailsPage().clickSubmitButton();
//    }

    @Then("user should see the News message {string}")
    public void userShouldSeeTheNewsMessage(String expectedmsg) {
        String actualmsg= testContext.getNewsDetailsPage().verifyNewsAlert();
        Assert.assertEquals(expectedmsg,actualmsg);
        System.out.println("Edited News is verified successfully");
        driver.close();
    }
//*************--------Deleting News----------*********
    @When("user clicks on Delete of {string}")
    public void userClicksOnDeleteOf(String NewsTitle) {
        testContext.getNewsDetailsPage().clickDeleteNews(NewsTitle);
}

    @Then("user should be able delete the news")
    public void userShouldBeAbleDeleteTheNews() {
        String expectedURL="https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/news.php";
        String actualURL = testContext.getURL();
        Assert.assertEquals(actualURL,expectedURL);
        System.out.println("News Deleted");
    }
}








