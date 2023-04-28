Feature:  Recruiters Register functionality

  Background: background method
    Given User in home page
    When User clicks "Recruiters" button
    And User clicks Register link
    Then User is on Registration page

#  //before method hooks
#  Given User is in https://www.viewcvs.co.uk/recruiter_register.php#

  Scenario: Verifying registration process with all fields - happy path
    When User enters below data
      | Firstname | Lastname | Company_name | Phone_number | Email_address | Password     |
      | madhu     | latha    | ITA          | 07423060433  | born.testers  | october@1234 |
    Then User should successfully create an account


  Scenario Outline: Verifying registration process without mandatory fields - unhappy path
    Given User is on Registration page
    When User enters data as <Firstname> <Lastname> <Company_name> <Phone_number> <Email_address> <Password>
    Then User should see an error message as "Please fill in this field"
    Examples:
      | Firstname | Lastname | Company_name | Phone_number | Email_address          | Password     |
      |           | latha    | ITA          | 07423060433  | born.testers@gmail.com | october@1234 |
      | firstname |          | ITA          | 07423060433  | born.testers@gmail.com | october@1234 |
      | firstname | latha    |              | 07423060433  | born.testers@gmail.com | october@1234 |
      | firstname | latha    | ITA          |              | born.testers@gmail.com | october@1234 |


##    //sign in - negative test
#  Scenario: Verify the account without registering - sign in - negative test
#    Given User is on ViewCV login page
#    When User press SignIn button
#    Then User should get an error message as "please register an account"

