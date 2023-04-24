
Feature: As a user I should be able to add my work experience.
  Description for the above feature

  @sanity
    Scenario: test scenario to show demo for datatable
      Given I have multiple rows of data in a single column
        |email@email.com |
        |email 2         |
        |email3          |
        |email4         |
      When I have multiple rows of data with multiple columns
        |email@email.com | pass1 |
        |email 2         | pass2 |
        |email3          | pass3 |
      And I have multiple rows of data with multiple columns and column header
        |Email| Password|
        |email@email.com | pass1 |
        |email 2         | pass2 |
        |email3          | pass3 |
    And I have multiple rows of data with multiple columns and column header with more than two columns
      |Email| Password| address |
      |email@email.com | pass1 | addre1 |
      |email 2         | pass2 | addr2  |
      |email3          | pass3 | addr3  |
      Then my test case is passed

#  @regression
#  Scenario: test scenario to show demo for datatable
#    Given I have multiple rows of data
#      | email@email.com | password123 |
#    Then my test case is passed
