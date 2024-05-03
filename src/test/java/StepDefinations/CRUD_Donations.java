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

import java.io.InterruptedIOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRUD_Donations {
    WebDriver driver;

    @Given("user is on administration login page")
    public void user_is_on_administration_login_page() throws InterruptedException {
        System.setProperty("web-driver.chrome.driver","P://December_2023_HHT_Project//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Navigate to Admin Login Page
        driver.get("https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/login.php");
        Thread.sleep(2000);
    }

    @When("user enters login details")
    public void user_enters_login_details() throws InterruptedException {

        // Enter Login Details
        WebElement emailAddress = driver.findElement(By.xpath("//input[@id='usr_email']"));
        emailAddress.sendKeys("sk_behara@hotmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='usr_password']"));
        password.sendKeys("test@123");
        Thread.sleep(2000);
    }

    @And("user clicks on admin login button")
    public void user_clicks_on_admin_login_button() throws InterruptedException {

        // Clicks on Login Button
        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='login']"));
        btnLogin.click();
        System.out.println("Successfully login to Admin Panel Page");
        Thread.sleep(2000);
    }

    @Then("user is on the Hanuman Hindu Temple Admin Panel")
    public void user_is_on_the_Hanuman_Hindu_Temple_Admin_Panel() throws InterruptedException {

        // Admin Panel Home Page Display on the Screen
        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/home.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URLs are not matching");
        Thread.sleep(2000);
        System.out.println("Welcome to Hanuman Hindu Temple Admin Panel");
    }
    @And("user is at CMS dropdown and clicks on Donations")
    public void user_is_at_CMS_dropdown_and_clicks_on_Donations() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement CMS_elm = driver.findElement(By.linkText("CMS"));
        action.moveToElement(CMS_elm).perform();
        System.out.println("CMS dropdown");
        driver.findElement(By.linkText("DONATIONS")).click();
        System.out.println("clicked on DONATIONS");
        Thread.sleep(3000);

    }

//    *******--------Viewing Donation Details Page---------************

    @When("user clicks on view action button of {string}")
    public void user_clicks_on_view_action_button_of(String DonationTitle) throws InterruptedException {
        List<WebElement> ViewTitle = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr[2]//td[2]"));
        System.out.println(ViewTitle.size());
        for (int X = 0; X<ViewTitle.size(); X++) {
            String Title = ViewTitle.get(X).getText();
            if (Title.equals(DonationTitle)) {
                int r = X + 1;
                break;
            }
        }
        WebElement btnView=driver.findElement(By.xpath("//div[contains(@id,'purchase_list')]//table//tr[2]//td[4]//a[1]"));
        btnView.click();
        Thread.sleep(3000);

    }
    @Then("user should View Donation Details")
    public void user_should_View_Donation_Details() throws InterruptedException {
        WebElement actualHeader = driver.findElement(By.xpath("(//div[@id='bar']/h1)"));
        String actualHeaderText = actualHeader.getText();
        String expectedHeaderText = "View Donation Details";
        Assert.assertEquals(actualHeaderText, expectedHeaderText);
        System.out.println("User successfully View Donation Details Page");
        //Thread.sleep(3000);
        driver.close();
        driver.quit();

    }
    //**********-------Editing Donations Details Page-------********

    @When("user selects the Edit option for {string} and edits the{string},with{string}")
    public void user_Selects_The_Edit_Option_For_And_Edits_The_With(String DonationTitle, String Editfield, String EditInfo) throws InterruptedException
    {
        List<WebElement> EditElements = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr[2]//td[2]"));
        System.out.println(EditElements.size());

        for (int i1 = 0; i1 <=EditElements.size(); i1++) {
            String Donation_Title = EditElements.get(i1).getText();

            if (Donation_Title.equals(DonationTitle)) {
                int r1 = i1+2;
                break;
            }
        }
        WebElement btnEdit = driver.findElement(By.xpath("//div[contains(@id,'purchase_list')]//table//tr[2]//td[4]//a[2]"));
        btnEdit.click();
        Thread.sleep(4000);
        WebElement actual_Header = driver.findElement(By.xpath("(//div[@id='bar'])"));
        String H = actual_Header.getText();
        String expected_Header = "Edit Donation Details";
        Assert.assertEquals(H, expected_Header);
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("Annadanam 1");
        Thread.sleep(3000);
    }

    @And("clicks Submit button on Edit Page")
    public void clicks_Submit_Button_On_Edit_Page() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user should see the message {string}")
    public void user_Should_See_The_Message(String expectedMsg) throws InterruptedException{
        String actualMsg=driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
        Assert.assertEquals(expectedMsg,actualMsg);
        System.out.println("Donation details updated successfully");
        //Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}

