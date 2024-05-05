

Feature: NewsLetter

   # Create NewsLetter

  Scenario Outline: Create Newsletter
    Given browser is open
    And user is on home page
    When user enters email address "<NewsLetterEmailID>"
    And user clicks on sign up
    Then user navigated to the newsletter page
    Examples:
      |NewsLetterEmailID|
      |testsharma123@gmail.com|

    # View & Delete NewsLetter

#  Scenario: Delete NewsLetter
  Background: Below steps are common for every scenario
    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    And User clicks on NewsLetter Subscribers menu
    Then user should get News Letter Subscriber Details page
    When admin user clicks on delete action button
    Then newsletter should be deleted successfully


    # View NewsLetter

    #Scenario: View NewsLetter
    #  When admin user navigated to newsletter subscriber page
    #  Then user should view the detail list of newsletter subscribers
















