Feature:I want to verify members on the backend admin page

  Background: Below steps are common for every scenario
    Given admin user launches the URL
    When admin user signs in with login credentials
    And admin user clicks on login button
    Then user should get in to the Administration Panel
    When user clicks on Members
    Then user should get into Members Page

  Scenario Outline: Verify View Members
    When user clicks on view of "<MemberName>"
    Then user should get View Details Page
    Examples:
      |MemberName  |
      |Test  321    |

 # Deleting the Members

  Scenario Outline: Verify Delete Members
    When user clicks on Delete of "<MemberName>"
    Then user should be able delete the members
    Examples:
      |MemberName  |
      |Test  321    |