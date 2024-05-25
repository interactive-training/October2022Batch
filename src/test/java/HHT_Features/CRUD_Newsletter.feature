Feature: NewsLetter


   # Create NewsLetter
  @createNewsletter
  Scenario Outline:Create Newsletter

    Given browser is open
    When user enters email address "<NewsLetterEmailID>"
    And user clicks on sign up
    Then user navigated to the newsletter page
    Examples:
      | NewsLetterEmailID    |
      | siva.msccs@gmail.com |



@deleteNewsletter

  Scenario Outline: Delete NewsLetter
  Given browser is open
  When user enters email address "<NewsLetterEmailID>"
    And user clicks on sign up
    Then user navigated to the newsletter page

    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    When User clicks on NewsLetter Subscribers menu
    Then user should get News Letter Subscriber Details page
    When admin user clicks on delete action button of "<NewsLetterEmailID>"
    Then newsletter should be deleted successfully
    Examples:
      | NewsLetterEmailID    |
      | a.msccs@gmail.com |


    # View NewsLetter

    #Scenario: View NewsLetter
    #  When admin user navigated to newsletter subscriber page
    #  Then user should view the detail list of newsletter subscribers
















