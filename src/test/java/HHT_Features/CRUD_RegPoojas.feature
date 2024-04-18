Feature:Regular Poojas
#
  Background: Verify Crud Poojas operations
#  Scenario: verify Pooja
    Given user launch the backend url
    When user enters Login details
    And clicks on Login button
    Then user should navigate to the Admin portal
    When user is at CMS dropdown
    Then user should navigate to the Add poojas page
#
#
#  Scenario Outline: Verify  creating poojas
#    And user clicks on ADD pooja button
#    Then navigate to the ADD pooja page
#    When user enters all details in all the following fields "<Pooja Title>"," <Pooja Services Section>"," <Pooja Type>"," <Pooja Start Date>", "<Pooja End Date>" ,"<Pooja Frequency>"," <Pooja Time Duration>"," <Pooja Cut Off Time>","<Pooja Amount>","<Pooja Location>","<Pooja Country>"
#    And Admin enters the description about festival in Pooja Artile field
#    And clicks on Submit button
#    Examples:
#      |Pooja Title|Pooja Services Section|Pooja Type|Pooja Start Date|Pooja End Date|Pooja Frequency|Pooja Time Duration|Pooja Cut Off Time|Pooja Amount|Pooja Location|Pooja Country|
#      | Navami   |Regular poojas        |thoram    |2/05/2024       |2/05/2024     |Yearly         |9am to 3pm|3pm               |20            |Hounslow    |United Kingdom      |
#      |Ugadi     |Regular poojas        |thoram    |12/05/24        |12/05/2024    |Yearly         |9am to 9pm|8pm               |25            |Hounslow    |United Kingdom      |
#

  #      ******* View Poojas *********

#  $$$$$$$$$$$$$$$$$$ Front end Testing $$$$$$$$$$$$$$$$$$$$$$$$$$$
#  Scenario: verify frontend
#    Given Launch the frontend url
#    When user clicks on Poojas Icon
#    Then user navigate to the Poojas page
#    And clicks on Regular Poojas
#    Then I should navigate to Regular poojas page and created pooja is visible
#
 Scenario Outline: :Verify View Poojas
  When user clicks on View of "<Pooja Title>" of "<Pooja Services Section>"
   Then it should navigate to the selected poojas page
  Examples:
   | Pooja Title|Pooja Services Section|
   | Special Pooja	    | Regular Poojas|
#

#  Scenario Outline: Verify Edit Poojas
#    When user select the edit option for"<PoojaTitle>",and edits the"<edit field>",with"<edit info>"
#    And clicks on Submit button on edit page
#    Then Pooja Title should be edited
#    Examples:
#      | PoojaTitle|edit field|edit info|
#      | Ugadi  	  | Pooja Title| Special Pooja|
##     | Navami1     | Pooja Start Date 	  |10/04/2024|
##     | Navami1      | Pooja End Date 	  |11/04/2024|
##
##