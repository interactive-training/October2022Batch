package Swathi.features.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MyAccountExisting {
    WebDriver driver;
    @When("the user launches the url {string}")
    public void the_user_launches_the_url(String validURL) {
        driver = new ChromeDriver();
        driver.get(validURL);
        driver.manage().window().maximize();
    }

    @Then("the user should be on the Home Page")
    public void the_user_should_be_on_the_home_page() {
        String expectedTile = "Welcome to Hanuman Hindu Temple...";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTile,"Titles did not match.");
    }
    @When("the user clicks on My Account")
    public void the_user_clicks_on_my_account() {
        WebElement myAcct = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        myAcct.click();
        System.out.println("clicked");
    }

    @When("the user logs in with Existing Member Credentials")
    public void the_user_logs_in_with_existing_member_credentials() {
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("swatybuddha@gmail.com");
        driver.findElement(By.id("pwd")).sendKeys("HASharswa13");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementsByClassName('btn btn-primary')[1].click();");
//        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click(); //not visible
    }

    @Then("the user should go to the {string}")
    public void the_user_should_go_to_the(String expectedTitle) {
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"Titles have matched.");
        System.out.println(" HomePage Titles matched.");
    }


//------------------------------------ Calendar Icon-----------------------------------------------
    @When("I click on Calendar Icon")
    public void i_click_on_calendar_icon() {
        driver.findElement(By.xpath("(//a[@href='m_calendar.php'])[3]")).click(); //*[@id="page-inner"]/div/div/div[3]/a
    }

    @Then("it should go to Calendar Page with title {string}")
    public void it_should_go_to_calendar_page_with_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
        System.out.println("Calendar Page Titles matched.");
    }

    // Events Icon
    @When("I click on Events Icon")
    public void i_click_on_events_icon() {
        driver.findElement(By.xpath("(//a[@href='m_events.php'])[3]")).click(); //*[@id="page-inner"]/div/div/div[3]/a
    }
    @Then("it should go to Events Page with title {string}")
    public void it_should_go_to_events_page_with_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
        System.out.println("Event Page Titles matched.");
    }
    // Poojas Icon
    @When("I click on Poojas Icon")
    public void iClickOnPoojasIcon() {
        driver.findElement(By.xpath("(//a[@href='m_pooja_services.php'])[3]")).click();
    }

    @Then("it should go to Poojas Page with title {string}")
    public void itShouldGoToPoojasPageWithTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
        System.out.println("Pooja Page Titles matched.");
    }
    // Donations Icon
    @When("I click on Donations Icon")
    public void iClickOnDonationsIcon() {
        driver.findElement(By.xpath("(//a[@href='m_donations.php'])[3]")).click();
    }

    @Then("it should go to Donations Page with title {string}")
    public void itShouldGoToDonationsPageWithTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
        System.out.println("Donations Page Titles matched.");
    }
    @And("Close the browser")
    public void close_the_browser ()
    {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

}

   // @When("user enters New email address and clicks Proceed")
//    public void user_enters_new_member_credentials() {
//       driver.findElement(By.id("email")).sendKeys("swatybuddha@gmail.com");
//        driver.findElement(By.xpath("//button[@class='btn btn-primary1']")).click();
//    }


