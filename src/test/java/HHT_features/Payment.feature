Feature: Payment module

#Background: Below steps are common
#  Given user launches url

  Scenario Outline: Verify cart functionality by adding from Donations page
    When user launches the given url
    Then user should be on the Landing Page
    Given user clicks on Donations link
    Then user is on Donations page
    And clicks on donate button of "<DONATIONS>"
    Then user should get DONATION DETAILS page
    When user clicks on Add to cart button of Donation Details Page
    Then user should be on Product Details Page
    And user clicks on Add to cart button of Product Details Page
    Then item should be added to the cart successfully
    When user clicks on Checkout button
    And navigates to My Account login page
    And logins with valid credentials "<UserName>" and "<Password>"
    Then user should get Payment Page
    When user clicks on pay with card button
    And enters valid card details "<CardNumber>", "<ExpiryDetails>" and "<CVC>"
    Then user should get successful message on ORDER CONFIRMATION page
    And user logouts successfully
    Examples:
       |DONATIONS  |UserName   |Password|CardNumber       |ExpiryDetails|CVC|
       |Pound a Day|d@gmail.com|012     |4242424242424242 |09/25        |234|
