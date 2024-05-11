package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CRUD_Members {

    TestContext testContext;

    public CRUD_Members(TestContext testContext)
    {
        this.testContext = testContext;

    }

    @When("user clicks on Members")
    public void user_clicks_on_members() {

     testContext.getAdministrationPanelPage().clickMembers();

    }
    @Then("user should get into Members Page")
    public void user_should_get_into_members_page()  {
      testContext.getMembersDetails_Page().verifyMembersDetailsHeader();
    }

    //    *******--------Viewing the Member Details Page---------************


    @When("user clicks on view of {string}")
    public void user_clicks_on_view_of(String MemberName)  {

        testContext.getMembers_ViewMembersDetailsPage().viewMembers(MemberName);

    }

    @Then("user should get View Details Page")
    public void user_should_get_view_details_page()  {
        testContext.getMembers_ViewMembersDetailsPage().verifyViewMembersDetailsHeader();
        System.out.println("User successfully View Member Details");

    }

    //*************--------Deleting Members----------*********

    @When("user clicks on Delete action button of {string}")
    public void user_Clicks_On_Delete_action_button_Of(String MemberName)  {

       testContext.getMembers_deleteMembersDetailsPage().deleteMembers(MemberName);

    }
    @Then("user should be able delete the members")
    public void userShouldBeAbleDeleteTheMembers()  {
        System.out.println("Members Deleted Successfully");

    }
}
