@events
Feature: As an admin user I should be able to perform CRUD operations an event

    Background: Below steps are common for events
        When user launches the URL as "admin"
        And signs in with admin credentials "sk_behara@hotmail.com" and "test@123"
        Then user should get in to the Administration Panel
        When user clicks on CMS drop down and then choose Events
        Then user should get into Events Page

    @CreateEvent @events-end-end
    Scenario Outline: Add a new event with pictures
        When user clicks on Add Event button
        Then user should get in to Add Events Details Page
        When user enters the details for all the mandatory fields
            |EventTitle|EventType|EventStartDate|EventEndDate|EventTimeDuration|EventLocation|EventContent|
            |Maha Shivratri     |Festival |08/03/2024    |08/03/2024  |6-8PM            |Temple      |Maha Shivaratri is a Hindu festival celebrated annually in honour of the deity Shiva, between February and March. According to the Hindu calendar, the festival is observed on the fourteenth day of the first half of the lunar month of Phalguna.|

        And clicks Submit button
        Then the event should be created with message "Events details Added successfully"
        # -----------------Front-end Verification on Event's tab--------------------------------
        When user launches the given url
        Then user should be on the Landing Page
        When user clicks on Events and chooses the Events option
        Then user should be on the Events Page
        When user clicks on the "<EventTitle>" of Event page for "view"
        Then user should be able to see the event "<EventTitle>" in "events"

       # -----------------Front-end Verification on Calendar's tab-----------------------------------
        When user clicks on Events and chooses the Calendar option
        Then user should be on the Calendar Page
        When user clicks on the "<EventTitle>" of Calendar page for "view"
        Then user should be able to see the event "<EventTitle>" in "calendar"
        Examples:
            |EventTitle|
            |Maha Shivratri     |


    @EditEvent  @events-end-end
    Scenario Outline: Editing the field of an event by Event Title
        When user clicks on Add Event button
        Then user should get in to Add Events Details Page
        When user enters the details for all the mandatory fields
            |EventTitle|EventType|EventStartDate|EventEndDate|EventTimeDuration|EventLocation|EventContent|
            |Maha Shivratri     |Festival |08/03/2024    |08/03/2024  |6-8PM            |Temple      |Maha Shivaratri is a Hindu festival celebrated annually in honour of the deity Shiva, between February and March. According to the Hindu calendar, the festival is observed on the fourteenth day of the first half of the lunar month of Phalguna.|

        And clicks Submit button
        Then the event should be created with message "Events details Added successfully"

        When user selects the Edit option for "<EventTitle>" and edits the "<EditField>" with "<EditInfo>"
        And clicks Submit button on Edit Page of events
        Then user should see the message "Event details updated successfully"

        #-----------------Front-end Verification on Event's tab--------------------------------
        When user launches the given url
        Then user should be on the Landing Page
        When user clicks on Events and chooses the Events option
        Then the user should click on Accept button
        Then user should be on the Events Page
        When user clicks on the "<EventTitle>" of Event page for "view"
        Then user should be able to see the event "<EventTitle>" in "events"

        #-----------------Front-end Verification on Calendar's tab-----------------------------------
        When user clicks on Events and chooses the Calendar option
        Then user should be on the Calendar Page
        When user clicks on the "<EventTitle>" of Calendar page for "view"
        Then user should be able to see the event "<EventTitle>" in "calendar"

        Examples:
            |EventTitle| EditField |EditInfo|
            |Maha Shivratri  |Event Location |Temple Hall|

    @ViewEvent
    Scenario Outline: Viewing the event with Event Title
        When user clicks on Add Event button
        Then user should get in to Add Events Details Page
        When user enters the details for all the mandatory fields
            |EventTitle|EventType|EventStartDate|EventEndDate|EventTimeDuration|EventLocation|EventContent|
            |Navami     |Festival |08/03/2024    |08/03/2024  |6-8PM            |Temple      |Maha Shivaratri is a Hindu festival celebrated annually in honour of the deity Shiva, between February and March. According to the Hindu calendar, the festival is observed on the fourteenth day of the first half of the lunar month of Phalguna.|

        And clicks Submit button
        Then the event should be created with message "Events details Added successfully"

        When user selects the View option for the event "<EventTitle>"
        Then user should be able to view the event

#            Front-end Verification on Event's tab
        When user launches the given url
        Then user should be on the Landing Page
        When user clicks on Events and chooses the Events option
        Then user should be on the Events Page
        When user clicks on the "<EventTitle>" of Event page for "view"
        Then user should be able to see the event "<EventTitle>" in "events"

        #       Front-end Verification on Calendar's tab
        When user launches the given url
        Then user should be on the Landing Page
        When user clicks on Events and chooses the Calendar option
        Then user should be on the Calendar Page
        When user clicks on the "<EventTitle>" of Calendar page for "view"
        Then user should be able to see the event "<EventTitle>" in "calendar"

        Examples:
            | EventTitle |
            |  Navami    |

    @DeleteEvent
    Scenario Outline: Deleting an event as a backend admin user
        When user clicks on Add Event button
        Then user should get in to Add Events Details Page
        When user enters the details for all the mandatory fields
            |EventTitle|EventType|EventStartDate|EventEndDate|EventTimeDuration|EventLocation|EventContent|
            |Maha Shivratri     |Festival |08/03/2024    |08/03/2024  |6-8PM            |Temple      |Maha Shivaratri is a Hindu festival celebrated annually in honour of the deity Shiva, between February and March. According to the Hindu calendar, the festival is observed on the fourteenth day of the first half of the lunar month of Phalguna.|

        And clicks Submit button
        Then the event should be created with message "Events details Added successfully"

        When user selects the Delete option for "<EventTitle>" then it should be deleted
        Then the event should be  deleted for "<EventTitle>"

#    ------------ Front-end verification of deleted event on the Event's Page
        When user launches the given url
        Then user should be on the Landing Page
        When user clicks on Events and chooses the Events option
        Then user should be on the Events Page
        When user clicks on the "<EventTitle>" of Event page for "delete"

#    ----------- Front-end verification of deleted event on the Calendar's Page
        When user clicks on Events and chooses the Calendar option
        Then user should be on the Calendar Page
        When user clicks on the "<EventTitle>" of Calendar page for "delete"


        Examples:
            |EventTitle |
            | Holi    |

#    @create-incorrect-event
#    Scenario : Add a new event with incorrect date
#        When user clicks on Add Event button
#        Then user should get in to Add Events Details Page
#        When user enters the details for all the mandatory fields
#            |EventTitle     |EventType|EventStartDate|EventEndDate|EventTimeDuration|EventLocation|EventContent|
#            |Ram Navami 2   |Festival |09/vbnnmm        |  juikl       |6-8PM            |Temple       |Ugadi or Yugadi, also known as Samvatsarādi, is New Year's Day according to the Hindu calendar and is celebrated in the states of Andhra Pradesh, Telangana, Karnataka and Goa in India. The cycle is actually consists of 60 years, each year individually named. The first day of each year called 'Ugadi'.|
#
#        And clicks Submit button
#        Then it should not create the event

#        Then it should show error message "Error: Please try again"


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