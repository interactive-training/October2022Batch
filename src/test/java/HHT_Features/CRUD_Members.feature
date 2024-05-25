Feature:I want to verify members on the backend admin page

  Background: Below steps are common for every scenario
    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    When user clicks on Members
    Then user should get into Members Page

  @viewMembers
  Scenario Outline: Verify View Members
    When user clicks on view of "<MemberName>"
    Then user should get View Details Page
    Examples:
      |MemberName  |
      |Pramod  Mallick   |

 # Deleting the Members
@deleteMembers
  Scenario Outline: Verify Delete Members
    When user clicks on Delete action button of "<MemberName>"
    Then user should be able delete the members
    Examples:
      |MemberName  |
      |Pramod  Mallick    |