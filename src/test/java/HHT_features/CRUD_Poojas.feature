Feature:Regular Poojas
#
  Background: Verify Crud Poojas operations

    When user launches the URL as "admin"
    And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Administration Panel
    When user is at CMS dropdown and click Poojas
    Then user should navigate to the Add poojas page

  @createPoojas
  Scenario Outline: Verify  creating poojas
    And user clicks on ADD pooja button
    Then navigate to the ADD pooja page
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
  @viewPoojas
 Scenario Outline: :Verify View Poojas
  When user clicks on View for Pooja with "<Pooja Title>"
   Then it should navigate to the selected poojas page
  Examples:
   | Pooja Title|
   | Ratha Sapthami	    |
#
@editPoojas
  Scenario Outline: Verify Edit Poojas
    When user select the edit option for"<PoojaTitle>",and edits the"<edit field>",with"<edit info>"
    And clicks on Submit button on edit page
    Then Pooja Title should be edited
    Examples:
      | PoojaTitle|edit field|edit info|
      | Ugadi  	  | Pooja Title| Special Pooja|
#     | Navami1     | Pooja Start Date 	  |10/04/2024|
#     | Navami1      | Pooja End Date 	  |11/04/2024|
##
##