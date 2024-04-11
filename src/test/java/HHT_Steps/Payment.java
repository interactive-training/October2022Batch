package HHT_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Payment {
    WebDriver driver;

    @Given("user launches url")
    public void userLaunchesUrl() {
        driver.get("https://www.hanumanhindutemple.org/test_mode/index.php");
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
    @When("clicks on donate button of one of the Donations")
    public void clicks_on_donate_button_of_one_of_the_donations() {
        driver.findElements();

    }
    @Then("user should get DONATION DETAILS page")
    public void user_should_get_donation_details_page() {

    }
    @When("user clicks on Add to cart button")
    public void user_clicks_on_add_to_cart_button() {

    }
    @Then("item should be added to the cart successfully")
    public void item_should_be_added_to_the_cart_successfully() {

    }
    @When("user clicks on Checkout button")
    public void user_clicks_on_checkout_button() {

    }
    @When("navigates to My Account login page")
    public void navigates_to_my_account_login_page() {

    }
    @When("logins with valid credentials")
    public void logins_with_valid_credentials() {

    }
    @Then("user should get Payment Page")
    public void user_should_get_payment_page() {

    }
    @When("user clicks on pay with card button")
    public void user_clicks_on_pay_with_card_button() {

    }
    @When("enters valid card details")
    public void enters_valid_card_details() {

    }
    @Then("user should get successful message on ORDER CONFIRMATION page")
    public void user_should_get_successful_message_on_order_confirmation_page() {

    }


}
