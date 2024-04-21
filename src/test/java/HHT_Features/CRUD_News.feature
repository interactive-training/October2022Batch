Feature:News

  Background: Below steps are common for every scenario
    Given the admin user launches the url "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/login.php"
    And logs in with Email address "mailto:sk_behara@hotmail.com" in email field and Password "test@123" in password field
    And User clicks on CMS dropdown and selects News
    Then user should get News Details page

#Creating News
  Scenario Outline:  : Add News without a picture
    When User clicks on Add News button
    Then user should get Add News Details page
    When user enters data in all the mandatory fields "<NewsTitle>","<NewsContent>"
    And clicks Submit button
    Then the News should be added successfully.
#Front end verification for created News
    When user launches the given url "https://www.hanumanhindutemple.org/test_mode/index.php"
    Then user should be on the Home Page
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

#  View the News
  Scenario Outline: Viewing News
    When user clicks on View of "<NewsTitle>"
    Then user should get View details page
    Examples:
      | NewsTitle |
      | Ugadi News |

#    Editing the News
#    Scenario Outline: Editing the fields of News
#      When user selects the Edit option for "<NewsTitle>" and edits the "<Editfield>" with "<EditInfo>"
#        And clicks Submit button on Edit Page
#        Then user should see the message "News details updated successfully"
##      *******-----Front end verification-------*******
##      When user launches the given url "https://www.hanumanhindutemple.org/test_mode/index.php"
##    Then user should be on the Home Page
##    When user clicks on News
##    Then user should be able to see the News "<NewsTitle>"
#
#      Examples:
#      |NewsTitle  | Editfield |EditInfo|
#     # | Lakshmi pooja | News Artile/Content|Pooja details will be updated soon   |
#      |Navami1	|News Title |  Navami|

#      Deleting the News
#  Scenario Outline: Deleting News
#    When user clicks on Delete of "<NewsTitle>"
#    Then user should be able delete the news
#    Examples:
#      | NewsTitle |
#      | Updated News1 |

