package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class VerifyCreateNewsletter {

    WebDriver driver;
    @Given("browser is open")
    public void browser_is_open() {
        System.setProperty("web-driver.chrome.driver","P://December_2023_HHT_Project//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @And("user is on home page")
    public void user_is_on_home_page() throws InterruptedException {
        //Navigate to Home Page
        driver.get("https://www.hanumanhindutemple.org/test_mode/index.php");
        Thread.sleep(3000);

    }

    @When("user enters email address")
    public void user_enters_email_address() throws InterruptedException {
        //Enter Email Address
        WebElement elmEmailAddress = driver.findElement(By.xpath("//input[@id='emailaddress']"));
        elmEmailAddress.sendKeys("testsharma123@gmail.com");
        Thread.sleep(2000);

    }

    @When("user clicks on sign up")
    public void user_clicks_on_sign_up() throws InterruptedException {
        // Sign up the Page
        WebElement btnSignup = driver.findElement(By.xpath("//input[@name='save']"));
        btnSignup.click();
        Thread.sleep(2000);
    }

    @Then("user navigated to the newsletter page")
    public void user_navigated_to_the_newsletter_page() throws InterruptedException{
        // NewsLetter Page Open
        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/newsletter.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URLs are not matching");
        System.out.println("Successfully go to NewsLetter Front End Home Page");
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

}
