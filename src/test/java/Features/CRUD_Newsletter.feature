

Feature: NewsLetter

   # Create NewsLetter

  Scenario: Create Newsletter
    Given browser is open
    And user is on home page
    When user enters email address
    And user clicks on sign up
    Then user navigated to the newsletter page


    # View & Delete NewsLetter

  Scenario: Delete NewsLetter
    Given user is on admin login page
    When user enters email address and password
    And user clicks on login button
    Then user navigated to the admin home page
    And User clicks on NewsLetter Subscribers menu
    When admin user clicks on delete action button
    Then newsletter should be deleted successfully


    # View NewsLetter

    #Scenario: View NewsLetter
    #  When admin user navigated to newsletter subscriber page
    #  Then user should view the detail list of newsletter subscribers
















