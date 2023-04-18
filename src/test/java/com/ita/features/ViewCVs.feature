Feature: As a user I should be able to add my work experience.
  Scenario: Verify the input box fields are editable and can accept valid values.
    Given the user launched the ViewCV url
    When the user logged into Jobseekers account with valid credentials
    And the user navigates to the Work Experience tab
    And clicks on add button
    Then it should navigate to Experience page


#    When the user enters the valid data in all the essential fields
#    Then it should save the work experience successfully for the profile


#  or edit icon-

#Feature: As a user I should be able to add my work experience.
#  Scenario: Verify the input box fields with invalid values.
#    Given the user launched the ViewCV url.
#    And the user logged into Jobseeker's account with valid credentials.
#    And the user navigates to the Work Experience tab and clicks on add button/edit icon; it should navigate to Experience page.
#    When the user enters the invalid data in one or more of the input(text) fields.
#    Then it show display an error message.
#    And it should not save the work experience successfully for the profile.
#    Examples: |Company Name|JobTitle|Country|Town/City|
#    |ABC.ltd|abc@@12|United|Asia|
#    |ABC.ltd|abc@@12|United Kingdom|Hounslow|
#    |ABC.ltd|Tester|United|Hounslow        |
#    |111@!!|abc@@12|United Kingdom|Hounslow|
#
#Feature: As a user I should be able to add my work experience.
#  Scenario: Verify the Job Type drop-down input field has values and the user can select one of them.
#    Given the user launched the ViewCV url.
#    And the user logged into Jobseeker's account with valid credentials.
#    And the user navigates to the Work Experience tab and clicks on add button/edit icon; it should navigate to Experience page.
#    When the user clicks anywhere on the 'Job Type' input field.
#    Then all the Job Type options should be displayed.
#    And the user should be able to select one option.
#    And the selected option should be saved and displayed successfully.
#
#Feature: As a user I should be able to add my work experience.
#  Scenario: Verify the Start Month/ End Month drop-down fields have values and the user can select one of them.
#    Given the user launched the ViewCV url.
#    And the user logged into Jobseeker's account with valid credentials.
#    And the user navigates to the Work Experience tab and clicks on add button/edit icon; it should navigate to Experience page.
#    When the user clicks anywhere on the 'Start Month/ End Month' input field.
#    Then it should display all the names of the months or numbers from 01 to 12.
#    And the user should be able to select one option.
#    And the selected option should be saved and displayed successfully.