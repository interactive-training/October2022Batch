package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CRUD_News_Stepdefs {
    TestContext testContext;

    // this constructor will load the contents of the TestContext class which can be accessed through its object.
    public CRUD_News_Stepdefs(TestContext testContext){
        this.testContext = testContext;
    }

    // ------------------------------------------Background Steps--------------------------------------------------

    @When("user clicks on CMS dropdown and selects News")
    public void userClicksOnCMSDropdownAndSelectsNews() {
        testContext.getAdministrationPanelPage().clickCMSthenNews();
    }
    @Then("user should get News Details page")
    public void userShouldGetNewsDetailsPage() {
        Assert.assertTrue(testContext.getNewsDetailsPage().verifyNewsDetailsHeader());
        System.out.println("User is on News details page");
    }
//******************Creating News**********************
    @When("User clicks on Add News button")
    public void userClicksOnAddNewsButton() {
        testContext.getNewsDetailsPage().clickAddNews();
    }

    @Then("user should get Add News Details page")
    public void userShouldGetAddNewsDetailsPage() {
        testContext.getNews_addNewsDetailsPage().verifyAddNewsDetailsHeader();
        System.out.println("You are on Add News Details Page");
    }

    @When("user enters data in all the mandatory fields {string},{string}")
    public void userEntersDataInAllTheMandatoryFields(String NewsTitle, String NewsContent) {
        testContext.getNews_addNewsDetailsPage().addNews(NewsTitle, NewsContent);
    }
    @And("clicks the Submit button")
    public void clicksTheSubmitButton() {
        testContext.getNews_addNewsDetailsPage().clickSubmitButton();
    }

    @Then("the News should be added successfully.")
    public void theNewsShouldBeAddedSuccessfully() {
        Assert.assertTrue(testContext.getNewsDetailsPage().verifyNewsAlert());
    }

    // -----------------------Front-End Verification------------------------------------------------

//    @When("user launches the given url {string}")
//    public void userLaunchesTheGivenUrl(String validURL) {
//        driver = new ChromeDriver();
//        driver.get(validURL);
//        driver.manage().window().maximize();
//    }

//    @Then("user should be on the Home Page")
//    public void userShouldBeOnTheHomePage() {
////        driver.manage().window().maximize();
//        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/index.php";
//        String actualURL = driver.getCurrentUrl();
//        Assert.assertEquals(actualURL, expectedURL, "User is on expected URL");
//        System.out.println("homepage url verified");
//    }


    @When("user clicks on News")
    public void userClicksOnNews() {
        testContext.getLandingPage().clickNews();
        System.out.println("clicked on news");
    }
    @Then("user should be able to see the News {string}")
    public void userShouldBeAbleToSeeTheNews(String NewsTitle) {
        String actualTitle= testContext.getNewsPage().verifyNewsTitle();
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
        Assert.assertTrue(testContext.getNews_viewNewsDetailsPage().verifyViewNewsDetailsHeader());
    }

//**********-------Editing the details of News-------********
    @When("user selects the Edit option for {string}")
    public void userSelectsTheEditOptionFor(String NewsTitle) {
        testContext.getNewsDetailsPage().clickEditNews(NewsTitle);
    }
    @Then("the user should be on Edit News Details Page")
    public void theUserShouldBeOnEditNewsDetailsPage() {
        String actualHeader =testContext.getNews_editNewsDetailsPage().verifyEditNewsDetailsHeader();
        String expectedHeader = "Edit News Details";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println("User is on Edit News page");
    }
    @When("the user edits the {string} with {string}")
    public void theUserEditsTheWith(String Editfield, String EditInfo) {
        testContext.getNews_editNewsDetailsPage().editNews(Editfield, EditInfo);
    }

    @When("clicks Submit button of Edit News Page")
    public void clicks_submit_button_of_edit_news_page() {
        testContext.getCommonMethods().clickSubmitButton();
    }

    @Then("user should see message {string}")
    public void userShouldSeeMessage(String expectedmsg) {
        String actualmsg= testContext.getCommonMethods().verifyMessage();
        Assert.assertEquals(expectedmsg,actualmsg);
        System.out.println("Edited News is verified successfully");
    }
//*************--------Deleting News----------*********
    @When("user clicks on Delete of {string}")
    public void userClicksOnDeleteOf(String NewsTitle) {
        testContext.getNewsDetailsPage().clickDeleteNews(NewsTitle);
}

    @Then("user should be able delete the news")
    public void userShouldBeAbleDeleteTheNews() {
        //loop and check news title is deleted, add it to News Details Page and call that method

//        String E="https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/news.php";
//        String A = driver.getCurrentUrl();
//        Assert.assertEquals(A,E);
        System.out.println("News Deleted");
    }
}








