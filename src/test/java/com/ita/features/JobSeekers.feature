#
#Feature: As a user I should be able to add my work experience
#    feature description goes here
#    multiple line description can be provided here
#
#
##  1 - //if I enter a valid value in email and password, submit - login process
#
#
#   Scenario: 1 - Verify the input box fields are editable and can accept valid values - only work experience
#    Given the user is on the MyProfile Page
#    When user press the Add button for Work Experience
#    And user enters valid data for all fields in Work Experience page
#      |CompanyName|JobTitle|UpdateHeadline|Country|Town|JobType|Is_CurrentlyWorkHere|StartMonth|StartYear|EndMonth|EndYear|Achievements|Description|
#
#
#    And user presses save button
#    Then It should create a new record in the Work Experience
#
#
#  Scenario: 2 - Verify the input box fields are editable and can accept valid values - only Education
#    Given the user is on the MyProfile Page
##    When user press the Add button for Education page
#
#    And user enters valid data for all fields in Education page  // add, //enter details , // save
#    |DEgreetype|
#    |DEgreetype2|
#    |DEgreetype2|
#
#    And user presses save button
#    Then It should create a new record in the Work Experience
#
##
##  Scenario: Verify the input box fields are editable and can accept valid values
##    Given the user is on the MyProfile Page and he selects the Add button for Education
##    When he enters the valid data for all the fields of Education and presses save button
##    Then it should create a new record/file in the Education
#
#
#  Scenario: 3 - Verify user can add data sucessfully on MyProfile page
#    Given the user is on the MyProfile Page  except Work Experience and Education
#
#    And presses save button
#    Then it should create a new record/file for each field
#
