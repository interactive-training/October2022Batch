Feature:News

  Background: Below steps are common for every scenario
    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    And user clicks on CMS dropdown and selects News
    Then user should get News Details page

#Creating News
  Scenario Outline:  : Add News without a picture
    When User clicks on Add News button
    Then user should get Add News Details page
    When user enters data in all the mandatory fields "<NewsTitle>","<NewsContent>"
    And clicks Submit button for News
    Then the News should be added successfully.
#Front end verification for created News
    When user launches the given url
    Then user should be on the Landing Page
    When user clicks on News
    Then user should be able to see the News "<NewsTitle>"
    Examples:
      | NewsTitle | NewsContent |
      |Special News|Special pooja on auspicious day|
     # |SriRama Navami News|Abhishekam in the evening      |
      #|Ugadi News |Annadaanam in the evening      |

#  Scenario: Add new News with a picture.
#    When user enters the details for all the mandatory fields
#    And adds a picture
#    And clicks Submit button
#    Then News should be created successfully.


  Scenario Outline: Viewing News
    When user clicks on View of "<NewsTitle>"
    Then user should get View details page
    Examples:
      | NewsTitle |
      | Ugadi News |

@editNews
    Scenario Outline: Editing the fields of News
      When user selects the Edit option in news for "<NewsTitle>"
      Then the user should be on Edit News Details Page
      When the user edits the "<Editfield>" with "<EditInfo>" in news
      And clicks Submit button of Edit News Page
      Then user should see the edited message for news as "News details updated successfully"

      Examples:
      |NewsTitle  | Editfield |EditInfo|
     # | Lakshmi pooja | News Artile/Content|Pooja details will be updated soon   |
      |Special News	|News Title |  Navami|


  Scenario Outline: Deleting News
    When user clicks on Delete of "<NewsTitle>"
    Then user should be able delete the news
    Examples:
      | NewsTitle |
      | Ugadi     |
