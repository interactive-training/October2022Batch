Feature: My Account Dashboard


  Background:My Account existing member and  Dashboard Icons
    When launch the url
    And user  clicks on My Account link on Home page
    And entered all the existing account details
    Then user should navigate to the My Account Dashboard

  Scenario: Verify Dashboard
    When clicks on My Account Icon
    Then user navigate to My Account page

  Scenario: Verify Family Member Icon
    When user clicks on Family Members Icon
    Then user naviagate to Family Members page
    And  user Clicks on My Acccount
    Then user should receive Dasboard page

  Scenario: Verify Calender Icon
    When user clicks on Calender Icon
    Then user navigate to Calender page
    And user clicks on My Account link
    Then user comebacks to the Dasboard page

  Scenario: Verify Events
    When user clicks on Events Icon
    Then user naviagate to the Events page
    And clicks on My Account link button
    Then user comes back to the Dshboard page

  Scenario: Verify Poojas
    When user clicks on Poojas Icon
    Then user navigate to the Poojas page
    And clicks on My Account Link txt

  Scenario: Verify Donations
    When user clicks on Donations link
    Then user should navigate to the Donations page
    And clicks on My account link on Dashboard

  Scenario: Verify Logout button
    When user clicks on Logout button
    Then user should naviagte to My Account existing member pag