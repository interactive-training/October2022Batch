Feature: Homepage
  Background: Homepage
 // Scenario: Verify the Homepage functionality
    Given user launch the url
    When user clicks on Home Icon
    Then Home page should refresh
    And clicks on Accept button

  Scenario: Verify About Us links
    When user is on About us dropdown
    And user clicks on Inspirer link
    Then should navigate to the Inspirer page
    When user clicks on Charity Hanuman Temple link
    Then user should navigate to the  Charity Hanuman Temple
    When user clicks on Hanuman Temple link
    Then user should navigate to the Hanuman Temple page
    When user clicks on privacy palicy link
    Then user should navigate to the Privacy palicy page

Scenario: Verify News Module
  When user clicks on news link
  Then user should navigate to the News page

Scenario: Verify Events Module
  When user clicks on Calender link at Events dropdown
  Then user should navigate to Calender  page
  And user clicks on Events link At events dropdown
  Then user navigate to the Events page

#Scenario: Verify Poojas Module
#  When user clicks on Poojas link
#  Then user should navigate to the Poojas
#
#  Scenario: verify Do
