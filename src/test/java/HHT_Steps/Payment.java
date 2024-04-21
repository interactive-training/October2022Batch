package HHT_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Payment {
    WebDriver driver;


    @Given("user launches url")
    public void userLaunchesUrl() {
        driver = new ChromeDriver();
//        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     driver.get("https://www.hanumanhindutemple.org/test_mode/index.php");
     driver.manage().window().maximize();
    }
    @Given("user clicks on Donations link")
    public void user_clicks_on_donations_link() {
        driver.findElement(By.linkText("DONATIONS")).click();

    }
    @Then("user is on Donations page")
    public void user_is_on_donations_page() {
        String Expectedurl="https://www.hanumanhindutemple.org/test_mode/donations.php";
        String Actualurl = driver.getCurrentUrl();
        Assert.assertEquals(Expectedurl,Actualurl);
        System.out.println("User is on Donations page");

    }
    @When("clicks on donate button of {string}")
    public void clicksOnDonateButtonOf(String Donations) {
        List<WebElement> DonationType = driver.findElements(By.xpath("//tr//td[2]//p"));
        System.out.println(DonationType.size());
        for (int n = 0; n<DonationType.size(); n++) {
            String Title = DonationType.get(n).getText();
            if (Title.equalsIgnoreCase(Donations)) {
                int r = n + 1;
                driver.findElement(By.xpath("(//tr[" + r + "]//td[3]//a)")).click();
           break;
            }
        }
    }
    @Then("user should get DONATION DETAILS page")
    public void user_should_get_donation_details_page() {
    String ExpHeader = "DONATION DETAILS";
    WebElement H = driver.findElement(By.xpath("(//div[@class='container'])[4]"));
    String ActHeader = H.getText();
        Assert.assertEquals(ExpHeader,ActHeader);
        System.out.println("Donations detail page matched ");
    }
    @When("user clicks on Add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        // here there are two add to cart buttons so giving two times to clicks on it
        driver.findElement(By.linkText("ADD TO CART")).click();
        driver.findElement(By.name("submit")).click();
        System.out.println("Clicked on ADD to Cart link");
    }
    @Then("item should be added to the cart successfully")
    public void item_should_be_added_to_the_cart_successfully() {
        String Exp = "https://www.hanumanhindutemple.org/test_mode/view_cart.php";
        String Act = driver.getCurrentUrl();
        Assert.assertEquals(Exp,Act);
    System.out.println("Cart page matched ");
    }
    @When("user clicks on Checkout button")
    public void user_clicks_on_checkout_button() {
        driver.findElement(By.partialLinkText("Checkout")).click();
      System.out.println("Clicked on Checkout");
    }
    @Then("navigates to My Account login page")
    public void navigates_to_my_account_login_page() {
      String Ex_url = "https://www.hanumanhindutemple.org/test_mode/account_login.php";
      String Act_url = driver.getCurrentUrl();
      Assert.assertEquals(Ex_url,Act_url);
      System.out.println("At MyAccount login page");
    }
    @When("logins with valid credentials")
    public void logins_with_valid_credentials() {
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("d@gmail.com");
        driver.findElement(By.id("pwd")).sendKeys("012");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        System.out.println("Entered the valid login details");
    }
    @Then("user should get Payment Page")
    public void user_should_get_payment_page() {
     String EXPECTED_Header= "Payment Page";
     WebElement A = driver.findElement(By.xpath("(//div[@class='col-md-12'])//h2"));
     String ACTUAL_Header = A.getText();
     Assert.assertEquals(EXPECTED_Header,ACTUAL_Header);
     System.out.println("On payment page");
    }
    @When("user clicks on pay with card button")
    public void user_clicks_on_pay_with_card_button() {
    driver.findElement(By.xpath("//button[@class='stripe-button-el']")).click();
    System.out.println("Clicked on pay with card");

    }
    @When("enters valid card details")
    public void enters_valid_card_details() throws InterruptedException {
//        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

//       driver.switchTo().alert().getText();
//     WebElement C = driver.findElement(By.id("card_number"));
//        Actions action = new Actions(driver);
//        action.moveToElement(C).sendKeys("4242424242424242");
        WebElement iFrame1 = driver.findElement(By.name("stripe_checkout_app"));
        driver.switchTo().frame(iFrame1);
        String cardNum= "4242424242424242";
        WebElement inputField= driver.findElement((By.xpath("(//div[@class='cardNumberInput input top'])//input")));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[1].value = arguments[0]; ", cardNum, inputField);
//driver.findElement(By.xpath("(//div[@class='cardNumberInput input top'])//input")).sendKeys("4242424242424242");
//Thread.sleep(6000);
//mywait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//div[@class='cardNumberInput input top'])//input")))).sendKeys("4242 4242 4242 4242");
//     driver.findElement(By.id("cc-exp")).sendKeys("09/25");
        String cExp= "09/25 ";
        WebElement inputField1= driver.findElement(By.id("cc-exp"));
        JavascriptExecutor js1= (JavascriptExecutor) driver;
        js1.executeScript("arguments[1].value = arguments[0]; ", cExp, inputField1);
        driver.findElement(By.id("cc-csc")).sendKeys("234");
     driver.findElement(By.xpath("(//div[@class='inner'])[2]")).click();
        driver.switchTo().defaultContent();
     System.out.println("entered the card details and submit ");
    }
    @Then("user should get successful message on ORDER CONFIRMATION page")
    public void user_should_get_successful_message_on_order_confirmation_page() {

    String Expected_H = "ORDER CONFIRMATION";
    WebElement O = driver.findElement(By.xpath("(((//div[@class='body-inner'])//div)[17])//h2"));
    String Actual_H = O.getText();
    Assert.assertEquals(Expected_H,Actual_H);
    System.out.println("Payment is Successful");

    }


    @And("user logouts successfully")
    public void userLogoutsSuccessfully() {
        driver.findElement(By.partialLinkText("Logout")).click();
        driver.quit();
    }
}