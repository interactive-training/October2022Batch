Feature:Donations

  Background: Below steps are common for every scenarios
    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    When user is at CMS dropdown and clicks on Donations

  @adminViewDonations
  Scenario Outline: Verify View Donations
    When user clicks on view action button of "<DonationTitle>"
    Then user should View Donation Details
    Examples:
      | DonationTitle |
      | Annadanam     |

  @adminEditDonations
  Scenario Outline: Verify Edit Donations
    When user selects the Edit option for "<DonationTitle>" and edits the"<Editfield>",with"<EditInfo>"
    And user should be on Edit Donations page
    And clicks Submit button on Edit Page
    Then user should see the message Donation details updated successfully
    Examples:
      | DonationTitle | Editfield            | EditInfo |
      | Annadanam     | Donation Amount in £ | 15       |

# Deleting Donations

 # Scenario Outline: Verify Delete Donations
 #   When user clicks on Delete of "<DonationTitle>"
 #   Then user should be able delete the donations
 #	Examples:
 #     |DonationTitle  |
 #     |Annadanam    |
