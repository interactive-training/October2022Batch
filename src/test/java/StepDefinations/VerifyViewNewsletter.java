package StepDefinations;

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

import java.util.concurrent.TimeUnit;

public class VerifyViewNewsletter {

    WebDriver driver;
    @Given("user is on admin login page")
    public void user_is_on_admin_login_page()throws InterruptedException
    {
        System.setProperty("web-driver.chrome.driver","P://December_2023_HHT_Project//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Navigate to Admin Login Page
        driver.get("https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/login.php");
        Thread.sleep(2000);
    }
    @When("user enters email address and password")
    public void  user_enters_email_address_and_password()throws InterruptedException{
        // Enter Email Address and Password
        WebElement EmailAddress = driver.findElement(By.xpath("//input[@id='usr_email']"));
        EmailAddress.sendKeys("sk_behara@hotmail.com");
        WebElement Password = driver.findElement(By.xpath("//input[@id='usr_password']"));
        Password.sendKeys("test@123");
        Thread.sleep(2000);
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button()throws InterruptedException {
        // User Clicks on Login Button
        WebElement btnlogin = driver.findElement(By.xpath("//input[@name='login']"));
        btnlogin.click();
        System.out.println("Successfully login to Admin Page");
        Thread.sleep(2000);

    }
    @Then("user navigated to the admin home page")
    public void user_navigated_to_the_admin_home_page() throws InterruptedException{
        // Admin Panel Home Page Display on the Screen
        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/home.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URLs are not matching");
        Thread.sleep(2000);
        System.out.println("Welcome to Hanuman Hindu Temple Admin Panel");

    }
    @And ("User clicks on NewsLetter Subscribers menu")
    public void User_clicks_on_NewsLetter_Subscribers_menu()throws InterruptedException{
        // Click on NewsLetter Subscribers Menu
        Actions a = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.xpath("//div[@id='wrapper']/nav/ul/li[5]/a"));
        a.moveToElement(mainMenu).perform();
        Thread.sleep(3000);
    }
    @Then ("user should view the detail list of newsletter subscribers")
    public void user_should_view_the_detail_list_of_newsletter_subscribers() throws InterruptedException
    {
        // Navigate to NewsLetter Subscribers Page
        driver.get("https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/newsletter_sub.php");
        System.out.println("Page Successfully go to Newsletter Subscribers Details Page");

        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
