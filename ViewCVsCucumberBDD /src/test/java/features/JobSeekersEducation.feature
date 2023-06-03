#Feature: As a user I should be able create my profile in JobSeekers
#         Fill all the information for Education
#
#  Scenario: User should be able to fill all the fields in Education
#
#    Given User is on the MyProfile Page
#    When User presses the Add button for Education
#    When User enters data for the following
#      | DegreeType | DegreeName         | SchoolName | Country | Town       | isStudyingHere | StartMonth | StartYear | CompletionMonth | CompletionYear   | Concentration           | Description |
#      | Bachelor    | Science | Abc College | India   | Chandigarh | Yes            |07             | 2000       | 07        | 2023    | Computers | I achieved first class. |
#    And User presses save button
#    Then It should create a new record in the Education