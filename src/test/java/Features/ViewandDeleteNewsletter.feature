Feature: I want to verify newsletter on the backend admin page

  Background: Below steps are common for every scenario
    Given user is on admin login page
    When user enters email address and password
    And user clicks on login button
    Then user navigated to the admin home page
    And User clicks on NewsLetter Subscribers menu

  Scenario: View NewsLetter
    When admin user navigated to newsletter subscriber page
    Then user should view the detail list of newsletter subscribers


   # Deleting NewsLetter
  Scenario: Verify Delete NewsLetter
    When admin user clicks on delete action button
    Then newsletter should be deleted successfully