Feature: As an admin user I should be able to create an event
    Background: Below steps are common for events

        When the admin user launches the URL "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/login.php"
        And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
        Then user should get in to the Administration Panel
        When user clicks on CMS drop down and then choose Events
        Then user should get into Events Page

    Scenario Outline: Add a new event with pictures
        When user clicks on Add Event button
        Then user should get in to Add Events Details Page
        When user enters the details for all the mandatory fields "<EventTitle>","<EventType>","<EventStartDate>","<EventEndDate>","<EventTimeDuration>","<EventLocation>","<EventContent>"
        And clicks Submit button
        Then the event should be created with message "Events details Added successfully"
        #       Front-end Verification on Event's tab
        When user launches the given url "https://www.hanumanhindutemple.org/test_mode/index.php"
        Then user should be on the Home Page
        When user clicks on Events and chooses the Events option
        Then the user should click on Accept button
        Then user should be on the Events Page
        When user clicks on the More Info of "<EventTitle>"
        Then user should be able to see the event "<EventTitle>"
        #       Front-end Verification on Calendar's tab
        When user clicks on Events and chooses the Calendar option
        Then user should be on the Calendar Page
        When user clicks on the "<EventTitle>"
        Then user should be able to see the event "<EventTitle>"
        Examples:
            |EventTitle|EventType|EventStartDate|EventEndDate|EventTimeDuration|EventLocation|EventContent|
            |Maha Shivratri     |Festival |08/03/2024    |08/03/2024  |6-8PM            |Temple      |Maha Shivaratri is a Hindu festival celebrated annually in honour of the deity Shiva, between February and March. According to the Hindu calendar, the festival is observed on the fourteenth day of the first half of the lunar month of Phalguna.|

    Scenario Outline: Editing the field of an event by Event Title
        When user selects the Edit option for "<EventTitle>" and edits the "<EditField>" with "<EditInfo>"
        And clicks Submit button on Edit Page
        Then user should see the message "Event details updated successfully"

#               Front-end Verification on Event's tab
        When user launches the given url "https://www.hanumanhindutemple.org/test_mode/index.php"
        Then user should be on the Home Page
        When user clicks on Events and chooses the Events option
        Then the user should click on Accept button
        Then user should be on the Events Page
        When user clicks on the More Info of "<EventTitle>"
        Then user should be able to see the event "<EventTitle>"
        #       Front-end Verification on Calendar's tab
        When user clicks on Events and chooses the Calendar option
        Then user should be on the Calendar Page
        When user clicks on the "<EventTitle>"
        Then user should be able to see the event "<EventTitle>"

        Examples:
            |EventTitle| EditField |EditInfo|
            |Maha Shivratri  |Event Location |Temple Hall|

@view
    Scenario Outline: Viewing the event with Event Title
        When user selects the View option of "<EventTitle>"
        Then user should be able to view the event
        ##       Front-end Verification
        When user launches the given url "https://www.hanumanhindutemple.org/test_mode/index.php"
        Then user should be on the Home Page
        When user clicks on Events and chooses the Events option
        And the user should click on Accept button
        Then user should be on the Events Page
        When user clicks on the More Info of "<EventTitle>"

        Examples:
            | EventTitle |
            |   Maha Shivratri    |

    @delete
    Scenario Outline: Deleting an event as a backend admin user
        When user selects the Delete option for "<EventTitle>" then it should be deleted
        Then the event should be  deleted for "<EventTitle>"
#    // Front-end verification of deleted event on the Event's Page
        When user launches the given url "https://www.hanumanhindutemple.org/test_mode/index.php"
        Then user should be on the Home Page
        When user clicks on Events and chooses the Events option
        And the user should click on Accept button
        Then user should be on the Events Page
        And the user should not find the deleted Event "<EventTitle>" in Events

#    // Front-end verification of deleted event on the Calendar's Page
        When user clicks on Events and chooses the Calendar option
        Then user should be on the Calendar Page
        And the user should not find the deleted Event "<EventTitle>" in Calendar
        Examples:
            |EventTitle |
            | Maha Shivratri    |

#    Scenario Outline: Add a new event with incorrect date
#        When user clicks on Add Event button
#        Then user should get in to Add Events Details Page
#        When user enters the details for all the mandatory fields "<EventTitle>","<EventType>","<EventStartDate>","<EventEndDate>","<EventTimeDuration>","<EventLocation>","<EventContent>"
#        And clicks Submit button
#        Then it should not create the event
##        Then it should show error message "Error: Please try again"
#        Examples:
#            |EventTitle     |EventType|EventStartDate|EventEndDate|EventTimeDuration|EventLocation|EventContent|
#            |Ram Navami 2   |Festival |09/vbnnmm        |  juikl       |6-8PM            |Temple       |Ugadi or Yugadi, also known as Samvatsarādi, is New Year's Day according to the Hindu calendar and is celebrated in the states of Andhra Pradesh, Telangana, Karnataka and Goa in India. The cycle is actually consists of 60 years, each year individually named. The first day of each year called 'Ugadi'.|


#    Scenario Outline: Editing the field of an event by Serial Number
#        When user selects the Edit option for serial number <SerialNumber> for "<EditField>" with "<EditInfo>"
#        And clicks Submit button on Edit Page
#        Then user should see the message "Event details updated successfully"
#        #       Front-end Verification
#        When user launches the given url "https://www.hanumanhindutemple.org/test_mode/index.php"
#        Then user should be on the Home Page
#        When user clicks on Events and chooses the Events option
#        And the user should click on Accept button
#        Then user should be on the Events Page
#        When user clicks on the More Info of <SerialNumber> the user should be able to see event
#        Examples:
#            |SerialNumber  |EditField |EditInfo|
#            |4  |Event Location |Temple Hall|