Feature:Regular Poojas
#
  Background: Verify Crud Poojas operations

    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    When user is at CMS dropdown and click Poojas
    Then user should navigate to the Pooja Details Page

  @CreatePoojas
  Scenario Outline: Verify  creating poojas
    And user clicks on ADD pooja button
    Then user should go to the ADD Pooja Details page
    When user enters all details for Pooja Type as "<PujaServicesSection>" with "<PoojaTitle>"
      |PoojaType     |PoojaStartDate|PoojaEndDate   |PoojaFrequency|PoojaTimeDuration|PoojaCutOffTime|PoojaAmount|PoojaLocation|PoojaCountry  |PoojaContent|
      |Car Puja      |2/05/2024     |2/05/2024     |Yearly         |9am to 3pm      |3pm            |20         |Hounslow     |United Kingdom|Festival    |
      |Pradhana Sevas|12/05/24      |12/05/2024    |Yearly         |9am to 9pm      |8pm            |25         |Hounslow    |United Kingdom |Festival    |

    And clicks on Submit button for Poojas

    #  $$$$$$$$$$$$$$$$$$ Front end Testing $$$$$$$$$$$$$$$$$$$$$$$$$$$
    When user launches the given url
    Then user should be on the Landing Page
    When user clicks on Poojas Icon
    Then user should navigate to the Poojas page
    And clicks on Pooja Type as "<PujaServicesSection>"
    Then I should navigate to it and "<PoojaTitle>" is visible
    Examples:
    |PoojaTitle|PujaServicesSection|
    |Sankranti| Regular Poojas     |
    | Ugadi   |Special Poojas     |

#      ******* View Poojas *********
  @ViewPoojas
 Scenario Outline: :Verify View Poojas
   When user clicks on View for Pooja with "<Pooja Title>"
   Then it should navigate to the selected poojas page
  Examples:
   | Pooja Title|
   | Ratha Sapthami	    |

#      ******* View Poojas *********
@EditPoojas
  Scenario Outline: Verify Edit Poojas
    When user selects the Edit Pooja option for "<PoojaTitle>"
    Then user should be on the Edit Pooja Page
    When user edits the Pooja for "<EditField>" with "<EditInfo>"
    And clicks on Submit button on Edit Pooja page
    Then Pooja Title should be edited

  Examples:
      | PoojaTitle|EditField|EditInfo|
      | Ugadi  	  | Pooja Title| Special Pooja|
      | Sankranti     | Pooja Start Date 	  |10/04/2024|
      | Sankranti      | Pooja End Date 	  |11/04/2024|

  #      ******* Delete Poojas *********
@DeletePoojas
  Scenario Outline: Verify Delete Poojas
    When user selects the Delete option for Pooja with "<PoojaTitle>"
    Then Pooja should be deleted
    Examples:
      | PoojaTitle |
      | Sankranti  |
