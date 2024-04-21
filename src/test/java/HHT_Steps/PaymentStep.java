//package HHT_Steps;
//
//import Utilities.TestContext;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import java.time.Duration;
//import java.util.List;
//
//public class PaymentStep {
//    TestContext testContext;
//
//    // this constructor will load the contents of the TestContext class which can be accessed through its object.
//    public PaymentStep(TestContext testContext){
//        this.testContext = testContext;
//    }
//
////    @Given("user launches url")
////    public void userLaunchesUrl() {
////        driver = new ChromeDriver();
//////        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////     driver.get("https://www.hanumanhindutemple.org/test_mode/index.php");
////     driver.manage().window().maximize();
////    }
//    @Given("user clicks on Donations link")
//    public void user_clicks_on_donations_link() {
//        testContext.getLandingPage().clickDonations();
//    }
//    @Then("user is on Donations page")
//    public void user_is_on_donations_page() {
//        Assert.assertTrue(testContext.getDonationsPage().verifyDonationsHeader());
////        String Expectedurl="https://www.hanumanhindutemple.org/test_mode/donations.php";
////        String Actualurl = testContext.getURL();
////        Assert.assertEquals(Expectedurl,Actualurl);
//        System.out.println("User is on Donations page");
//
//    }
//    @When("clicks on donate button of {string}")
//    public void clicksOnDonateButtonOf(String Donations) {
//        testContext.getDonationsPage().clicksOnDonateForTitle(Donations);
//    }
//    @Then("user should get DONATION DETAILS page")
//    public void user_should_get_donation_details_page() {
////    String ExpHeader = "DONATION DETAILS";
////    String ActHeader = testContext.getDonationsDetailsPage().verifyDonationDetailsHeader();
////    Assert.assertEquals(ExpHeader,ActHeader);
//        Assert.assertTrue(testContext.getDonationsDetailsPage().verifyDonationDetailsHeader());
//        System.out.println("Donations detail page verified ");
//    }
//    @When("user clicks on Add to cart button of Donation Details Page")
//    public void user_clicks_on_add_to_cart_button_of_Donation() {
//        testContext.getDonationsDetailsPage().clickAddToCartButton();
//    }
//    @Then("user should be on Product Details Page")
//    public void userShouldBeOnProductDetailsPage() {
//        Assert.assertTrue(testContext.getDonationsProductDetailsPage().verifyProductDetailsHeader());
//        System.out.println("Product Details page verified ");
//
//    }
//    @And("user clicks on Add to cart button of Product Details Page")
//    public void userClicksOnAddToCartButtonOfProductDetailsPage() {
//        testContext.getDonationsProductDetailsPage().clickAddToCartButton();
//
//    }
//    @Then("item should be added to the cart successfully")
//    public void item_should_be_added_to_the_cart_successfully() {
////        String Exp = "https://www.hanumanhindutemple.org/test_mode/view_cart.php";
////        String Act = testContext.getURL();
////        Assert.assertEquals(Exp,Act);
//        Assert.assertTrue(testContext.getShoppingCartPage().verifyCartItemsHeader());
//        System.out.println("Cart page matched ");
//    }
//    @When("user clicks on Checkout button")
//    public void user_clicks_on_checkout_button() {
//       testContext.getShoppingCartPage().clickCheckOut();
//    }
//    @Then("navigates to My Account login page")
//    public void navigates_to_my_account_login_page() {
//        Assert.assertTrue(testContext.getMyAccountPage().verifyMyAccountHeader());
////      String Ex_url = "https://www.hanumanhindutemple.org/test_mode/account_login.php";
////      String Act_url = testContext.getURL();
////      Assert.assertEquals(Ex_url,Act_url);
//      System.out.println("At MyAccount login page");
//    }
//    @And("logins with valid credentials {string} and {string}")
//    public void loginsWithValidCredentialsAnd(String UserName, String Password) {
//        testContext.getMyAccountPage().loginAsRegisteredUser(UserName, Password);
//        System.out.println("Entered the valid login details");
//    }
//    @Then("user should get Payment Page")
//    public void user_should_get_payment_page() {
////     String EXPECTED_Header= "Payment Page";
////     String ACTUAL_Header = testContext.getPaymentPage().verifyPaymentPageHeader();
////     Assert.assertEquals(EXPECTED_Header,ACTUAL_Header);
//        Assert.assertTrue(testContext.getPaymentPage().verifyPaymentPageHeader());
//     System.out.println("On payment page");
//    }
//    @When("user clicks on pay with card button")
//    public void user_clicks_on_pay_with_card_button() {
//    testContext.getPaymentPage().clickPayWithCard();
//    }
//    @And("enters valid card details {string}, {string} and {string}")
//    public void entersValidCardDetails(String CardNumber, String ExpiryDetails,String CVC) {
//        testContext.getPaymentPage().enterCardDetails(CardNumber,ExpiryDetails,CVC);
//    }
//    @When("enters valid card details")
//    public void enters_valid_card_details() throws InterruptedException {
//    }
//    @Then("user should get successful message on ORDER CONFIRMATION page")
//    public void user_should_get_successful_message_on_order_confirmation_page() {
//
//    String Expected_H = "ORDER CONFIRMATION";
//    String Actual_H = testContext.getOrderConfirmationPage().verifyOrderConfirmationHeader();
//    Assert.assertEquals(Expected_H,Actual_H);
//    System.out.println("Payment is Successful");
//    }
//
//    @And("user logouts successfully")
//    public void userLogoutsSuccessfully() {
//        testContext.getLandingPage().clickLogOut();
//    }
//
//
//
//}
