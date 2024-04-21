#Feature: As a user I should be able to create my profile in JobSeekers
#  Fill all the information for Work Experience
#
#  Scenario: The user should be able to fill all the fields for multiple records in Work Experience
#
#    Given The user is on the MyProfile Page
#    When User presses the Add button for Work Experience, enters the following data and presses the save button
#
#      | CompanyName | JobTitle| UpdateHeadline | Country | Town   | JobType  | Is_CurrentlyWorkHere | StartMonth | StartYear | EndMonth | EndYear | Achievements          | Description|
#      | ABC         | Programmer    | Yes            | Russia  | Moscow | Per Diem | Check                | 03         | 1999      | 05       | 2023    | C Sharp Certification | I have 4 years of experience in C Sharp. |
#      | GHI         | IT Programmer | Yes            | China   | Yin    | Per Diem | Check                | 05         | 1998      | 03       | 2021    | C++  Certification    | I have 2 years of experience in C ++.    |
#      | VGY         | Tester | Yes            | China   | India    | Per Diem | Check                | 05         | 1998      | 03       | 2022    | Java  Certification    | I have 2 years of experience in Java.    |
#
#    Then It should create a new records for Work Experience