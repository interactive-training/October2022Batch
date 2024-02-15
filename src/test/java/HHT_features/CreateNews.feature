Feature: Create Events
  Background: Below steps are common for every scenario
    When the admin user launches the URL
    And signs with the admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to Administarion Panel
    And clicks on CMS drop down and then choose News


  Scenario: Verify the mandatory Create Event fields
    When user clicks on my Add News button
    Then user should go to Add News Details Page
    When the user fills all the mandatory fields
    Then the 