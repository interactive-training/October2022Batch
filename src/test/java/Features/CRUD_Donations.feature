Feature:Donations

  Background: Below steps are common for every scenarios
    Given user is on administration login page
    When user enters login details
    And user clicks on admin login button
    Then user is on the Hanuman Hindu Temple Admin Panel
    And user is at CMS dropdown and clicks on Donations

  Scenario Outline: Verify View Donations
    When user clicks on view action button of "<DonationTitle>"
    Then user should View Donation Details
    Examples:
      |DonationTitle  |
      |Annadanam    |

  Scenario Outline: Verify Edit Donations
    When user selects the Edit option for "<DonationTitle>" and edits the"<edit field>",with"<edit info>"
    And clicks Submit button on Edit Page
    Then user should see the message "Donation details updated successfully"
    Examples:
      |DonationTitle  | Editfield |EditInfo|
      |Annadanam  	|DonationTitle |Annadanam 1|

# Deleting Donations

 # Scenario Outline: Verify Delete Donations
 #   When user clicks on Delete of "<DonationTitle>"
 #   Then user should be able delete the donations
 #	Examples:
 #     |DonationTitle  |
 #     |Annadanam    |
