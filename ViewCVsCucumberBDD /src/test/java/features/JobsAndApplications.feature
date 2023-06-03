Feature: As a Recruiter I should be able to manage the job application

  Scenario: Verify the edit functionality of Manage Jobs
    Given User has logged into Recruiters with "born.testers@gmail.com" and "October2022"
    When User clicks on Jobs and Applications
    And User clicks the option "Manual tester" and "edit" on a record
    And User edits and saves
    Then User should get this alert to accept "Job Details Updated Successfully..."

  Scenario: Verify the view functionality of Manage Jobs
    Given User has logged into Recruiters with "born.testers@gmail.com" and "October2022"
    When User clicks on Jobs and Applications
    And User clicks the option "PA" and "view" on a record
    Then the "PA" record should be in "view"


  Scenario: Verify the delete functionality of Manage Jobs
    Given User has logged into Recruiters with "born.testers@gmail.com" and "October2022"
    When User clicks on Jobs and Applications
    And User clicks the option "Tester" and "delete" on a record
    Then the "Tester" record should be deleted
