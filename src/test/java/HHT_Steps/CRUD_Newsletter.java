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

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRUD_Newsletter {
    TestContext testContext;

    public CRUD_Newsletter(TestContext testContext){
        this.testContext = testContext;
    }


    //    *******--------Create NewsLetter Front-End Panel ---------************

    @Given("browser is open")
    public void browser_is_open() {
////        System.setProperty("web-driver.chrome.driver","P://December_2023_HHT_Project//chromedriver-win64//chromedriver-win64//chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }

    @And("user is on home page")
    public void user_is_on_home_page() throws IOException {
      testContext.getLoginPage().getWebsiteURL();


    }


    @When("user enters email address {string}")
    public void userEntersEmailAddress(String Emailid) {
        //Enter Email Address
       testContext.getNewsLetter_homePage().Newsletteremail(Emailid);


    }

    @When("user clicks on sign up")
    public void user_clicks_on_sign_up()  {
        // Sign up the Page
     testContext.getNewsLetter_homePage().NewsLetterSignup();
    }

    @Then("user navigated to the newsletter page")
    public void user_navigated_to_the_newsletter_page() {
        // NewsLetter Page Open
        testContext.getNewsLetter_confirmationPage().verifyAddNewsLetterHeader();
        System.out.println("Successfully go to NewsLetter Front End Home Page");

    }

    //    *******--------View & Delete NewsLetter Back-End Admin Panel---------************

//    @Given("user is on admin login page")
//    public void user_is_on_admin_login_page()
//    {
//        testContext.getLoginPage().getAdminURL(admin);
//
//    }
//    @When("user enters email address and password")
//    public void  user_enters_email_address_and_password(){
//        // Enter Email Address and Password
//        WebElement EmailAddress = driver.findElement(By.xpath("//input[@id='usr_email']"));
//        EmailAddress.sendKeys("sk_behara@hotmail.com");
//        WebElement Password = driver.findElement(By.xpath("//input[@id='usr_password']"));
//        Password.sendKeys("test@123");
//
//    }
//    @And("user clicks on login button")
//    public void user_clicks_on_login_button() {
//        // User Clicks on Login Button
//        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='login']"));
//        btnLogin.click();
//        System.out.println("Successfully login to Admin Page");
//
//
//    }
//    @Then("user navigated to the admin home page")
//    public void user_navigated_to_the_admin_home_page() {
//        // Admin Panel Home Page Display on the Screen
//        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/home.php";
//        String actualURL = driver.getCurrentUrl();
//        Assert.assertEquals(actualURL,expectedURL,"URLs are not matching");
//        System.out.println("Welcome to Hanuman Hindu Temple Admin Panel");

//    }
    @And ("User clicks on NewsLetter Subscribers menu")
    public void User_clicks_on_NewsLetter_Subscribers_menu(){
        testContext.getAdministrationPanelPage().clickNewsLetter();
    }
    @Then("user should get News Letter Subscriber Details page")
    public void userShouldGetNewsLetterSubscriberDetailsPage() {
        testContext.getNewsLetterSubscriberDetails_Page().verifyNewsLetterSubscriberDetailsHeader();
    }


    //*************--------Deleting NewsLetter----------*********

    @When("admin user clicks on delete action button of {string}")
    public void adminUserClicksOnDeleteActionButtonOf(String EmailField)  {
        testContext.getNewsLetterSubscriberDetails_Page().DeleteNewsLetter(EmailField);
//
           }

    @Then("newsletter should be deleted successfully")
    public void newsletter_should_be_deleted_successfully()
    {
        // Newsletter Deleted Successfully
        System.out.println("Newsletter Subscriber Deleted Successfully");
    }



}

