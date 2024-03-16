package HHT_Steps;
import HHT_Pages.LoginPage;
import Utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class CRUD_EventStep {
    WebDriver driver;
    TestContext testContext;

    // this constructor will load the contents of the TestContext class which can be accessed through its object.
    public CRUD_EventStep(TestContext testContext){
        this.testContext = testContext;
    }

    // ------------------------------------------Background Steps--------------------------------------------------
    @When("user launches the URL as {string}")
    public void the_admin_user_launches_the_URL(String admin) throws IOException {
        //testContext.intializeDriver();
        testContext.getLoginPage().getAdminURL(admin);
    }

    @And("signs in with admin credentials {string} and {string}")
    public void signsInWithAdminCredentials(String emailId, String password) {
        testContext.getLoginPage().loginAsAdmin(emailId, password);
    }

    @Then("user should get in to the Administration Panel")
    public void userShouldGetInToTheAdministrationPanel() {
        String expectedTitle = ":: Welcome to Hanuman Hindu Temple - Home page ::";
        String actualTitle = testContext.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Url did not match");
        System.out.println("Administration Panel page");
    }

    @When("user clicks on CMS drop down and then choose Events")
    public void clicksOnCMSDropDownAndThenChooseEvents() {
        testContext.getAdministrationPanelPage().clickCMSthenEvents();
    }
    
    @Then("user should get into Events Page")
    public void userShouldGetInToEventsPage() {
        String expectedTitle = ":: Welcome to Hanuman Hindu Temple Events Details ::";
        String actualTitle = testContext.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles match");
        System.out.println("Events page");

    }

    // ------------------------------------------Create Events--------------------------------------------------
    @When("user clicks on Add Event button")
    public void userClicksOnMyAddEventButton() {
       // testContext.getEventsPage();
        testContext.getAdminEventsPage().clickAddEvents();
    }

    @Then("user should get in to Add Events Details Page")
    public void userShouldGetInToAddEventsDetailsPage() {
        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/add_event.php";
        String actualURL = testContext.getURL();
        Assert.assertEquals(actualURL, expectedURL, "Url did not match");
        System.out.println("Add Events Details Page");
    }

    @When("user enters the details for all the mandatory fields")
    public void user_enters_the_details_for_all_the_mandatory_fields(DataTable dataTable)  {
        testContext.getCreateEventsPage().createEvent(dataTable);
    }

    @When("clicks Submit button")
    public void clicks_submit_button() {
        testContext.getCreateEventsPage().clickSubmitButton();
    }

    @Then("the event should be created with message {string}")
    public void theEventShouldBeCreatedWithMessage(String expectedMessage) {
        String actualMessage = testContext.getMessage();
        Assert.assertEquals(actualMessage, expectedMessage, " Create message is verified.");
        System.out.println("Event added with pictures.");
    }

    @Then("it should not create the event")
    public void it_should_not_create_the_event() {
        String date = testContext.getCreateEventsPage().verifyIncorrectDate();
        Assert.assertEquals(date, "", "Date is present");
        System.out.println("Date is absent.");
    }

//    @Then("it should show error message {string}")
//    public void itShouldShowErrorMessage(String ErrorMessage) {
//        String actualMessage = driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
//        Assert.assertEquals(actualMessage, ErrorMessage, " Message is not verified.");
//        System.out.println("Error message is verified and event is not created.");
//        driver.close();
//    }

    // --------------------------------Create Event's Front-end Event's Verification-------------------------------------------------------------
    @When("user launches the given url")
    public void userLaunchesTheGivenUrl() throws IOException {
        testContext.getLoginPage().getWebsiteURL();
    }
    @Then("user should be on the Landing Page")
    public void userShouldBeOnTheLandingPage() {
        String expectedTitle = "Welcome to Hanuman Hindu Temple...";
        String actualTitle = testContext.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles did not match.");
    }

    @When("user clicks on Events and chooses the Events option")
    public void UserClicksOnEventsAndChoosesTheEventsOption()  {
        testContext.getLandingPage().userChoosesEventsInEventsDropDown();

    }

    @Then("the user should click on Accept button")
    public void the_user_should_click_on_accept_button() throws InterruptedException {
        testContext.clickAcceptButton();
    }

    @Then("user should be on the Events Page")
    public void UserShouldBeOnTheEventsPage() {
        String expectedHeading = "EVENTS";
        String actualHeading = testContext.getEventsPage().eventsPageHeading();
        Assert.assertEquals(actualHeading, expectedHeading, "Events heading is absent");
    }

    @When("user clicks on the More Info of {string}")
        public void moreInfo(String EventTitle){
        testContext.getEventsPage().userClicksMoreInfo(EventTitle );
    }
    @Then("user should be able to see the event {string} in {string}")
    public void user_should_be_able_to_see_the_event(String EventTitle, String Page) throws InterruptedException {
        String actualTitle = testContext.getEventsPage().verifyEventTitleOnPage();
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle, EventTitle, " Titles did not match.");
        if(Page.equalsIgnoreCase("calendar")) {
            System.out.println("Event is verified on Calendar Page.");
        } else if (Page.equalsIgnoreCase("events")){
            System.out.println("Event is verified on Event Page.");
        }
    }

    // --------------------------------Create Event's Front-end Calendar's Verification-------------------------------------------------------------

    @When("user clicks on Events and chooses the Calendar option")
    public void UserClicksOnEventsAndChoosesTheCalendarOption() {
        testContext.getCalendarPage().clickEventsThenCalendar();
    }

    @Then("user should be on the Calendar Page")
    public void UserShouldBeOnTheCalendarPage() {
        Assert.assertTrue(testContext.getCalendarPage().verifyCalendarPage());
    }

    @When("user clicks on the {string}")
    public void userClicksOnThe(String EventTitle) {
        testContext.getCalendarPage().userClicksOnDetails(EventTitle);
    }


    // ------------------------------------------View Event---------------------------------------------------------

    @When("user selects the View option of {string}")
    public void userSelectsTheViewOption(String EventTitle) {

    }

    @Then("user should be able to view the event")
    public void userShouldBeAbleToViewTheEvent() {
        // Verifying the Event Selected Page
        String expectedHeading = "View Events Details";
        String actualHeading = driver.findElement(By.xpath("//div[@id='bar']/h1")).getText();
        Assert.assertEquals(actualHeading, expectedHeading, "Headings did not match");
        System.out.println("Event Viewed");
        driver.quit();
    }

    // ------------------------------------------Edit Event-----------------------------------------
    @When("user selects the Edit option for {string} and edits the {string} with {string}")
    public void userSelectsTheEditOption(String EventTitle, String EditField, String EditInfo) {

        testContext.getEditEventsPage().editEventInfo(EventTitle,EditField,EditInfo);


    }

    @And("clicks Submit button on Edit Page")
    public void clicksSubmitButtonOnEditPage() {
        testContext.getAdminEventsPage().clickSubmitButton();

    }

    @Then("user should see the message {string}")
    public void user_should_see_the_message(String expectedMessage) {
        String actualMessage = testContext.getMessage();
                //driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Messages are not matching,");
        System.out.println("Event Message Verified");
    }

    //---------------------------------------Delete Event---------------------------------------------------------
    @When("user selects the Delete option for {string} then it should be deleted")
    public void user_selects_the_delete_option_for_then_it_should_be_deleted(String EventTitle) {
          // Below is the code for just deleting the event( it will delete the first one if there are duplicates)
//        List<WebElement> titleElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
//        System.out.println(titleElements.size());

//        for (int n = 0; n <= titleElements.size(); n++) {
//            // Looping each Event Title
//            String title = titleElements.get(n).getText();
//            int r = n + 2; // to pass the matching row for the given event to delete
//            if (title.equalsIgnoreCase(EventTitle)) {
//                // Deleting the event
//                driver.findElement(By.xpath("//tbody/tr[ " + r + " ]/td[4]/a[3]")).click();
//                break;
//            }
//        }

        // Below is the code to delete the last event if there are duplicate events with the same title
        int r, s;
        String eventToDelete = "";
        //Storing all the titles in the web-element 'titleElements'
        List<WebElement> titleElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        System.out.println(titleElements.size());
            // Looping each Event Title
            for (int n = 0; n < titleElements.size(); n++) {
                // Retrieving each Event Title from the titleElements
                String title = titleElements.get(n).getText();
                r = n + 2; // to pass the matching row for the given event to delete
                if (title.equalsIgnoreCase(EventTitle)) {
                    // Collecting the matched event's Serial Number into a List of WebElements(checkForDuplicateEvent) and then checking for any other duplicate events
                    List<WebElement> duplicateEventSerialNumbers = driver.findElements(By.xpath("//table/tbody/tr[" + r + "]/td[1]"));
                    // Checking for any duplicate events from the nth row
                    for (int d = n + 1; d < titleElements.size(); d++) {
                        // Looping each Event Title for any duplicates
                        String titleDuplicate = titleElements.get(d).getText();
                        s = d + 2; // to pass the matching row for the given event to delete
                        if (titleDuplicate.equalsIgnoreCase(title)) {
                            // title of current event
                            String currentTitle = driver.findElement(By.xpath("//table/tbody/tr[" + s + "]/td[2]")).getText();
                            WebElement duplicate = driver.findElement(By.xpath("//table/tbody/tr[" + s + "]/td[1]"));
                            eventToDelete = duplicate.getText();
                            System.out.println(currentTitle + "serial number is: " + eventToDelete);
                            //String number = StringValueof(duplicate.getText()); // serial number of current event
                            duplicateEventSerialNumbers.add(1, duplicate);
                        }
                    }
                    System.out.println(" Number of duplicate Events=" + duplicateEventSerialNumbers.size());
                    if (duplicateEventSerialNumbers.size() > 1) {
                        // Deleting the last created duplicate event
//                        String eventToDelete = String.valueOf(duplicateEventSerialNumbers.lastIndexOf(duplicateEventSerialNumbers));
//                        System.out.println(" Event being deleted Serial number: " + eventToDelete);
                        int m = Integer.parseInt(eventToDelete) + 1;
                        driver.findElement(By.xpath("//tbody/tr[ " + m + " ]/td[4]/a[3]")).click();
                        break;
                    } else
                        // Deleting the unique event( not duplicated)
                        driver.findElement(By.xpath("//tbody/tr[ " + r + " ]/td[4]/a[3]")).click();
                    break;
                }
            }

    }

        @Then("the event should be  deleted for {string}")
        public void theEventShouldBeDeleted(String EventTitle ) {
            // Back-end verification of deleted event
            List<WebElement> newTitleElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
            System.out.println(newTitleElements.size());
            int title_Elements = newTitleElements.size() -1;
            for (int n = 0; n <= title_Elements; n++) {
                // Looping each Event Title
                String title = newTitleElements.get(n).getText();
                if (title.equalsIgnoreCase(EventTitle)) {
                    System.out.println("There is a duplicate event.");
                    break;
                }
            }
            System.out.println("This event does not exist in the Administration Panel.");
            driver.quit();
        }


    @And("the user should not find the deleted Event {string} in Events")
    public void theUserShouldNotFindTheDeletedEvent(String EventTitle) {
        // Front-end verification of deleted event on the Event's Page
        List<WebElement> titleElements = driver.findElements(By.xpath("//p[@class='quote-author']"));
        System.out.println(titleElements.size());
        //int title_Elements = titleElements.size() -1;

        for (int n = 0; n < titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();

            if (title.equalsIgnoreCase(EventTitle)) {
                System.out.println("There is a duplicate event.");
                break;
            }
        }
        System.out.println("This event does not exist on the Event's Page.");
    }

    // Front-end verification of deleted event on the Calendar's Page
    @And("the user should not find the deleted Event {string} in Calendar")
    public void theUserShouldNotFindTheDeletedEventInCalendar(String EventTitle) {
        List<WebElement> titleElements = driver.findElements(By.xpath("//tbody/tr/td[3]/div/p/a"));
        System.out.println(titleElements.size());

        for (int n = 0; n < titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();
            if (title.equalsIgnoreCase(EventTitle)) {
                System.out.println("There is a duplicate event.");
                break;
            }
        }
        System.out.println("This event does not exist in the Calendar.");
        driver.quit();
    }


}

//    //-----------------------------Edit Event Front-End Verification------------------------------------------------------------------------
//    @When("user clicks on the More Info of {int} the user should be able to see event")
//    public void userClicksOnTheMoreInfoOfSerialNumber(int SerialNumber) {
//        SerialNumber--;
//        Actions action = new Actions(driver);// Initiating the Actions class for mouse hover(drop-down)
//        action.moveToElement(driver.findElement(By.xpath("(//div[@class='events_main'])[" + SerialNumber + "]/p[5]/a"))).click().build().perform();
//        System.out.println("More Info clicked");
//    }


//    String chromePath = "C:\\Automation\\chrome\\chrome-win64\\chrome.exe";
//        System.setProperty("web-driver.chrome.driver", chromePath);

//@When("user selects the View option of {int}")
//    public void userSelectsTheViewOptionOfSerialNumber(int SerialNumber) throws InterruptedException {
//        List<WebElement> rowElements = driver.findElements(By.xpath("//table/tbody/tr"));
//        System.out.println(rowElements.size());
//        if (SerialNumber > 1 && SerialNumber <= rowElements.size()) {
//            String festivalTitle = String.valueOf(driver.findElement(By.xpath("//tbody/tr[" + SerialNumber + "]/td[2]")).getText());
//            System.out.println(festivalTitle);
//            //Thread.sleep(3000);
//            driver.findElement(By.xpath("//tbody/tr[" + SerialNumber + "]/td[4]/a[1]")).click();
//            Thread.sleep(8000);
//            System.out.println("Event Selected");
//
//            // Verifying the festival Title
//            String actualFestivalTitle = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
//            Assert.assertEquals(actualFestivalTitle, festivalTitle, "Event Titles did not match");
//        } else {
//            System.out.println("Please give a valid number");
//        }
//    }

//    List<WebElement> titleElements = driver.findElements(By.xpath("//p[@class='quote-author']"));
//        System.out.println(rowElements.size());
//        if (SerialNumber > 1 && SerialNumber <= rowElements.size()) {
//            String festivalTitle = String.valueOf(driver.findElement(By.xpath("//tbody/tr[" + SerialNumber + "]/td[2]")).getText());
//            System.out.println(festivalTitle);
//            //Thread.sleep(3000);
//            driver.findElement(By.xpath("//tbody/tr[" + SerialNumber + "]/td[4]/a[1]")).click();
//            Thread.sleep(8000);
//            System.out.println("Event Selected");
//
//            // Verifying the festival Title
//            String actualFestivalTitle = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
//            Assert.assertEquals(actualFestivalTitle, festivalTitle, "Event Titles did not match");
//        } else {
//            System.out.println("Please give a valid number");
//        }
//    }