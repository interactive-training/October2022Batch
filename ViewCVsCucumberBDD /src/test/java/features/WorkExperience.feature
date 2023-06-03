#Feature: As a user I should be able add create my profile in Jobseekers
#  Verify the input box fields are editable and can accept valid values - only work experience
#
#  Scenario: The user should be able to fill all the fields in Work Experience
#    Given the user is on the MyProfile Page
#    When user presses the Add button for Work Experience
#    And user enters valid data for the following
#      | CompanyName | JobTitle   | UpdateHeadline | Country | Town   | JobType   | Is_CurrentlyWorkHere | StartMonth | StartYear | EndMonth | EndYear | Achievements           | Description                              |
#      | ABC         | Programmer | Yes          | Russia  | Moscow | Permanent | Check                | 03         | 1999      | 05       | 2023    | C Sharp Certificataion | I have 4 years of experience in C Sharp. |
#    And user presses save button
#    Then It should create a new record in the Work Experience