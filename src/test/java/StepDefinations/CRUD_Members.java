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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRUD_Members {

    WebDriver driver;
    @Given("admin user launches the URL")
    public void admin_user_launches_the_url() throws InterruptedException {
        System.setProperty("web-driver.chrome.driver","P://December_2023_HHT_Project//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Navigate to Admin Login Page
        driver.get("https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/login.php");
        Thread.sleep(2000);
    }

    @When("admin user signs in with login credentials")
    public void admin_user_signs_in_with_login_credentials() throws InterruptedException {
        // Enter Admin Credentials
        WebElement emailAddress = driver.findElement(By.xpath("//input[@id='usr_email']"));
        emailAddress.sendKeys("sk_behara@hotmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='usr_password']"));
        password.sendKeys("test@123");
        Thread.sleep(2000);
    }

    @And("admin user clicks on login button")
    public void admin_user_clicks_on_login_button() throws InterruptedException {
        // Admin User Clicks on Login Button
        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='login']"));
        btnLogin.click();
        System.out.println("Successfully login to Admin Panel Page");
        Thread.sleep(2000);
    }

    @Then("user should get in to the Administration Panel")
    public void user_should_get_in_to_the_administration_panel() throws InterruptedException {
        // Admin Panel Home Page Display on the Screen
        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/home.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URLs are not matching");
        Thread.sleep(2000);
        System.out.println("Welcome to Hanuman Hindu Temple Admin Panel");
    }

    @When("user clicks on Members")
    public void user_clicks_on_members() throws InterruptedException{
        // Click on Member Menu
        Actions a = new Actions(driver);
        WebElement menuList = driver.findElement(By.xpath("//div[@id='wrapper']/nav/ul/li[3]/a"));
        a.moveToElement(menuList).perform();
        Thread.sleep(2000);

    }
    @Then("user should get into Members Page")
    public void user_should_get_into_members_page() throws InterruptedException {
        // Navigate to Members Page
        driver.get("https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/members.php");
        System.out.println("Page Successfully go to Members Details Page");
        Thread.sleep(2000);
    }

    //    *******--------Viewing the Member Details Page---------************


    @When("user clicks on view of {string}")
    public void user_clicks_on_view_of(String MemberName) throws InterruptedException {
        List<WebElement> ViewMemberElements = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr[2]//td[2]"));
        boolean snoStatus = false;
        for(WebElement viewelm:ViewMemberElements)
        {
            String viewValue = viewelm.getText();
            System.out.println(viewValue);
            if (viewValue.equals(MemberName))
            {
                snoStatus = true;
                break;
            }
        }
        Assert.assertTrue(snoStatus,"Data don't Match");
        WebElement btn_view =driver.findElement(By.xpath("//td[text()='1']//following-sibling::td/a[text()='View']"));
        btn_view.click();
        Thread.sleep(3000);

    }

    @Then("user should get View Details Page")
    public void user_should_get_view_details_page() throws InterruptedException {
        WebElement actualHeader = driver.findElement(By.xpath("(//div[@id='bar']/h1)"));
        String Headers = actualHeader.getText();
        String expectedHeader = "View Member Details";
        Assert.assertEquals(Headers, expectedHeader);
        System.out.println("User successfully View Member Details");
        //Thread.sleep(3000);
        driver.close();
        driver.quit();

    }

    //*************--------Deleting Members----------*********

    @When("user clicks on Delete of {string}")
    public void userClicksOnDeleteOf(String MemberName) throws InterruptedException {
        List<WebElement> DeleteElements = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr[2]//td[2]"));
        boolean sno = false;
        for(WebElement deleteelm:DeleteElements)
        {
            String deleteValue = deleteelm.getText();
            System.out.println(deleteValue);
            if (deleteValue.equals(MemberName))
            {
                sno = true;
                break;
            }
        }
        Assert.assertTrue(sno,"Data don't Match");
        WebElement btn_delete = driver.findElement(By.xpath("//td[text()='1']//following-sibling::td/a[text()='Delete']"));
        btn_delete.click();
        Thread.sleep(3000);

    }
    @Then("user should be able delete the members")
    public void userShouldBeAbleDeleteTheMembers()  {
        System.out.println("Members Deleted Successfully");

        driver.close();
        driver.quit();
    }
}
