Feature: As a user I should be able to post a job

  Scenario: Verify the Post a Job Functionality
    Given User has logged into Recruiters with "born.testers@gmail.com" and "October2022"
    And User clicks on Post a Job
    When User has entered the following and clicked submit
    |JobTitle|Salary|JobType|Location|Sector|Description|
    |Tester  |30000 |Permanent|Hounslow|IT & Telecoms|We need 3 years of experience.|
    Then User should get this alert to accept "Job Posted and Uploaded Successfully..."