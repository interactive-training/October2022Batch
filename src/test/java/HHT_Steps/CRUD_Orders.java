package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;



public class CRUD_Orders {

    TestContext testContext;

    public CRUD_Orders(TestContext testContext)
    {
        this.testContext = testContext;

    }
    @When("admin user launches the URL as {string}")
    public void admin_user_launches_the_URL_as(String admin) throws IOException {
        testContext.getLoginPage().getAdminURL(admin);
    }
    @And("signs in with admin login credentials {string} and {string}")
    public void signs_in_with_admin_login_credentials(String emailId, String password)  {

        testContext.getLoginPage().loginAsAdmin(emailId, password);
    }

    @Then("user should get in to the Admin Panel Page")
    public void user_should_get_in_to_the_Admin_Panel_Page()  {
        // Admin Panel Home Page Display on the Screen
        testContext.getAdministrationPanelPage().welcomeLogin();
        System.out.println("Administration Panel Page");
    }

    @When("user clicks on Orders")
    public void user_clicks_on_Orders() {
            // Clicks on Orders Menu
            testContext.getAdministrationPanelPage().clickOrders();
            System.out.println("Orders Details Page");
    }
    @Then("user should get into Orders Page")
    public void user_should_get_into_Orders_Page()  {
        // Navigate to Orders Page
        testContext.getAdmin_orderDetailsPage().verifyOrdersDetailsHeader();
    }

    //    *******--------Viewing the Orders Details Page---------************

    @When("user clicks on View Order of {string}")
    public void user_clicks_on_View_Order_of(String OrderDate)  {
        testContext.getOrders_viewOrderDetailsPage().viewOrders(OrderDate);
    }

    @Then("user should View Order Details Page")
    public void user_should_view_order_details_page() {
        //View Order Details Page
        testContext.getOrders_viewOrderDetailsPage().verifyViewOrdersDetailsHeader();
        System.out.println("User successfully View Order Details");

    }

}
