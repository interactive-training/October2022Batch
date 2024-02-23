Feature: I want to verify view newsletter on the backend admin page

  Scenario: View NewsLetter
    Given user is on admin login page
    When user enters email address and password
    And user clicks on login button
    Then user navigated to the admin home page
    And User clicks on NewsLetter Subscribers menu
    Then user should view the detail list of newsletter subscribers