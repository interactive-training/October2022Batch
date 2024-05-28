
Feature:Donations

  Background: Below steps are common for every scenarios
    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    When user is at CMS dropdown and clicks on Donations

  @adminViewDonations @wip
  Scenario Outline: Verify View Donations
    When user clicks on view action button of "<DonationTitle>"
    Then user should View Donation Details
    Examples:
      | DonationTitle |
      | Annadanam     |

  @adminEditDonations
  Scenario Outline: Verify Edit Donations
    When user selects the Edit option for "<DonationTitle>" of Donations
    And user should be on Edit Donations page
    When user edits the "<Editfield>" of Donations with "<EditInfo>"
    And clicks Submit button on Edit Page
    Then user should see the message Donation details updated successfully
    Examples:
      | DonationTitle | Editfield            | EditInfo |
      | Annadanam     | Donation Amount in £ | 20       |

# Deleting Donations

 # Scenario Outline: Verify Delete Donations
 #   When user clicks on Delete of "<DonationTitle>"
 #   Then user should be able delete the donations
 #	Examples:
 #     |DonationTitle  |
 #     |Annadanam    |
