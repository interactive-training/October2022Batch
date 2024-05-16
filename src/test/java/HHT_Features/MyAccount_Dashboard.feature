Feature: My Account Dashboard Page

  Background: Below steps are common for existing user
    When the user launches the url
    Then the user should be on the Home Page
    When the user clicks on My Account
    When the user logs in with Existing Member Credentials "test321@gmail.com" and "Test@321"
    Then the user should go to the "Dashboard"

@familyMembers
  Scenario: Verify Family Members/Donors Icon
    When I click on Family Members Donors Icon
    Then it should go to Family Members Donors Page with title "Family Members Donors - Hanuman Hindu Temple"
    And Close the browser

@Calendar
  Scenario: Verify Calendar Icon
    When I click on Calendar Icon
    Then it should go to Calendar Page with title "Calendar"
    And Close the browser

@Events
  Scenario: Verify Events Icon
    When I click on Events Icon
    Then it should go to Events Page with title "Events"
    And Close the browser

@Poojas
  Scenario: Verify Poojas Icon
    When I click on Poojas Icon
    Then it should go to Poojas Page with title "Pooja Services"
    And Close the browser

@Donations
  Scenario: Verify Donations Icon
    When I click on Donations Icon
    Then it should go to Donations Page with title "Donations"
    And Close the browser

