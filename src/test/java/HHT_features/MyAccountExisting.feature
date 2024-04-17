Feature: I want to verify the presence of web elements on the home page

  Background: I want to verify login for existing user
    When the user launches the url "https://www.hanumanhindutemple.org/test_mode/index.php"
    Then the user should be on the Home Page
    When the user clicks on My Account
    When the user logs in with Existing Member Credentials
    Then the user should go to the "Dashboard"

  Scenario: I want to verify Calendar Icon
    When I click on Calendar Icon
    Then it should go to Calendar Page with title "Calendar"
    And Close the browser

  Scenario: I want to verify Events Icon
    When I click on Events Icon
    Then it should go to Events Page with title "Events"
    And Close the browser

  Scenario: I want to verify Poojas Icon
    When I click on Poojas Icon
    Then it should go to Poojas Page with title "Pooja Services"
    And Close the browser

  Scenario: I want to verify Donations Icon
    When I click on Donations Icon
    Then it should go to Donations Page with title "Donations"
    And Close the browser