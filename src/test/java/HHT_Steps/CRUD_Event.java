package HHT_Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CRUD_Event {
    WebDriver driver;

    // ------------------------------------------Background Steps--------------------------------------------------
    @When("the admin user launches the URL {string}")
    public void the_admin_user_launches_the_URL(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("signs in with admin credentials {string} and {string}")
    public void signsInWithAdminCredentials(String emailId, String password) {
        By emailIDBy = By.id("usr_email");
        By pwdBy = By.id("usr_password");

        driver.findElement(emailIDBy).sendKeys(emailId); // email Id
        driver.findElement(pwdBy).sendKeys(password);    // password
        //driver.findElement(By.xpath("input[@class='btn-lg btn-success btn-block']")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;// Login Button
        jse.executeScript("document.querySelector(\"input[value='Login']\").click();");
        System.out.println("Login successful");
    }

    @Then("user should get in to the Administration Panel")
    public void userShouldGetInToTheAdministrationPanel() {
        String expectedTitle = ":: Welcome to Hanuman Hindu Temple - Home page ::";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Url did not match");
        System.out.println("Administration Panel page");
    }

    @When("user clicks on CMS drop down and then choose Events")
    public void clicksOnCMSDropDownAndThenChooseEvents() {
        Actions action = new Actions(driver);                             // Initiating the Actions class for mouse hover(drop-down)
        WebElement CMS_Menu = driver.findElement(By.linkText("CMS"));    //Finding the element with drop-down
        action.moveToElement(CMS_Menu).perform();                        // Hovering over the Training drop-down
        WebElement events = driver.findElement(By.linkText("EVENTS"));  // Finding the Events
        events.click();
    }
    
    @Then("user should get into Events Page")
    public void userShouldGetInToEventsPage() {
        String expectedTitle = ":: Welcome to Hanuman Hindu Temple Events Details ::";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles match");
        System.out.println("Events page");

    }

    // ------------------------------------------Create Events--------------------------------------------------
    @When("user clicks on Add Event button")
    public void userClicksOnMyAddEventButton() {
        driver.findElement(By.xpath("//a[@href='add_event.php']")).click();
    }

    @Then("user should get in to Add Events Details Page")
    public void userShouldGetInToAddEventsDetailsPage() {
        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/add_event.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Url did not match");
        System.out.println("Add Events Details Page");
    }

    @When("user enters the details for all the mandatory fields {string},{string},{string},{string},{string},{string},{string}")
    public void user_enters_the_details_for_all_the_mandatory_fields(String EventTitle, String EventType, String EventStartDate, String EventEndDate, String EventTimeDuration, String EventLocation, String EventContent)  {
        // Passing information to the text fields through feature
        driver.findElement(By.xpath("//tr/td[2]/input")).sendKeys(EventTitle);
        driver.findElement(By.xpath("//tr[2]/td[2]/input")).sendKeys(EventType);
        driver.findElement(By.xpath("//tr[3]/td[2]/input")).sendKeys(EventStartDate);
        driver.findElement(By.xpath("//tr[4]/td[2]/input")).sendKeys(EventEndDate);
        driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys(EventTimeDuration);
        driver.findElement(By.xpath("//tr[6]/td[2]/input")).sendKeys(EventLocation);
        // Passing information to the iframe
        WebElement outerIframe = driver.findElement(By.id("article___Frame"));
        driver.switchTo().frame(outerIframe);
        WebElement innerIframe = driver.findElement(By.xpath("//td[@id='xEditingArea']/iframe"));
        driver.switchTo().frame(innerIframe);
        driver.findElement(By.xpath("/html/body")).sendKeys(EventContent);
        driver.switchTo().defaultContent();
        // Passing the path of the pictures
        String Picture1Path = "//Users//ravibabuadari//Desktop//testing//bogi Small.jpeg";
        driver.findElement(By.xpath("//tr[9]/td[2]/input")).sendKeys(Picture1Path);
        driver.findElement(By.xpath("//tr[10]/td[2]/input")).sendKeys(Picture1Path);
    }

    @When("clicks Submit button")
    public void clicks_submit_button() {
        driver.findElement(By.xpath("//tr[12]/td/input")).click();
        System.out.println("Clicked on submit");
    }

    @Then("the event should be created with message {string}")
    public void theEventShouldBeCreatedWithMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, " Create message is verified.");
        System.out.println("Event added with pictures.");
        driver.quit();
    }

    @Then("it should not create the event")
    public void it_should_not_create_the_event() {
//        The below code is working but earlier gave the uncommented code, it failed so I want to just understand the error
//        String date = driver.findElement(By.xpath("//tr[4]/td[2]/input")).getText();
//        Assert.assertEquals(date, "", "Date is present");
//        System.out.println("Date is absent.");
        WebElement date = driver.findElement(By.xpath("//tr[4]/td[2]/input"));
        String EndDate =date.getText();
        Assert.assertNull(EndDate, "Date is present.");
//        why the below error
//        java.lang.AssertionError: Date is present. expected [null] but found []  :[[ChromeDriver: chrome on mac (3710e27aeb6240ce85ceadbe6ec9784b)] -> xpath: //tr[4]/td[2]/input]
    }

    @Then("it should show error message {string}")
    public void itShouldShowErrorMessage(String ErrorMessage) {
        String actualMessage = driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
        Assert.assertEquals(actualMessage, ErrorMessage, " Message is not verified.");
        System.out.println("Error message is verified and event is not created.");
        driver.close();
    }

    // --------------------------------Create Event's Front-end Event's Verification-------------------------------------------------------------
    @When("user launches the given url {string}")
    public void userLaunchesTheGivenUrl(String validURL) {
        driver = new ChromeDriver();
        driver.get(validURL);
        driver.manage().window().maximize();
    }
    @Then("user should be on the Home Page")
    public void userShouldBeOnTheHomePage() {
        String expectedTile = "Welcome to Hanuman Hindu Temple...";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTile, "Titles did not match.");
    }

    @When("user clicks on Events and chooses the Events option")
    public void UserClicksOnEventsAndChoosesTheEventsOption()  {
        Actions action = new Actions(driver);// Initiating the Actions class for mouse hover(drop-down)
        WebElement Home_Menu = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][normalize-space()='Events']"));    //Finding the element with drop-down
        action.moveToElement(Home_Menu).perform(); // Hovering over the Training drop-down
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement events = driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]/li[2]/a"));
        action.moveToElement(events).click().perform();
    }

    @Then("the user should click on Accept button")
    public void the_user_should_click_on_accept_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ms-3']")).click();
        Thread.sleep(3000);
    }

    @Then("user should be on the Events Page")
    public void UserShouldBeOnTheEventsPage() {
        String expectedHeading = "EVENTS";
        String actualHeading = driver.findElement(By.xpath("(//div[@class='container'])[4]/h2")).getText();
        Assert.assertEquals(actualHeading, expectedHeading, "Events heading is absent");
    }

    @When("user clicks on the More Info of {string}")
    public void userClicksOnTheMoreInfo(String EventTitle) {
        List<WebElement> titleElements = driver.findElements(By.xpath("(//div[@class='events_main'])/p[3]"));
        System.out.println(titleElements.size());

        for (int n = 0; n <= titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();
            int r = n + 1; // to pass the matching row for the given event
            if (title.equalsIgnoreCase(EventTitle)) {
                // Clicking on the Event Title
                driver.findElement(By.xpath("(//div[@class='events_main'])["+ r +"]/p[5]/a")).click();
                break;
            }
        }
    }

    @Then("user should be able to see the event {string}")
    public void user_should_be_able_to_see_the_event(String EventTitle) throws InterruptedException {
        String actualTitle = driver.findElement(By.xpath("//div[@class='gurumid']/div[2]/h4")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle, EventTitle, " Titles did not match.");
        System.out.println("Event is verified.");
    }

    // --------------------------------Create Event's Front-end Calendar's Verification-------------------------------------------------------------

    @When("user clicks on Events and chooses the Calendar option")
    public void UserClicksOnEventsAndChoosesTheCalendarOption() {
        Actions action = new Actions(driver);// Initiating the Actions class for mouse hover(drop-down)
        WebElement Home_Menu = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][normalize-space()='Events']"));    //Finding the element with drop-down
        action.moveToElement(Home_Menu).perform(); // Hovering over the Training drop-down
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement events = driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]/li[1]/a"));  // By.xpath("(//a[@href='events_web.php'])[1]")      Finding the Events
        action.moveToElement(events).click().perform();
    }

    @Then("user should be on the Calendar Page")
    public void UserShouldBeOnTheCalendarPage() {
        String expectedHeading = "CALENDAR";
        String actualHeading = driver.findElement(By.xpath("(//div[@class='container'])[4]/h2")).getText();
        Assert.assertEquals(actualHeading, expectedHeading, "Calendar heading is absent");
    }

    @When("user clicks on the {string}")
    public void userClicksOnThe(String EventTitle) {
        List<WebElement> titleElements = driver.findElements(By.xpath("//tbody/tr/td[3]/div/p/a"));
        System.out.println(titleElements.size());

        for (int n = 0; n <= titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();
            int r = n + 1; // to pass the matching row for the given event
            if (title.equalsIgnoreCase(EventTitle)) {
                // Clicking on the Event Title
                driver.findElement(By.xpath("//tbody/tr[ " + r + " ]/td[3]/div/p/a")).click();
                break;
            }
        }
    }

    // ------------------------------------------View Event---------------------------------------------------------

    @When("user selects the View option of {string}")
    public void userSelectsTheViewOption(String EventTitle) {
        List<WebElement> titleElements = driver.findElements(By.xpath("//tr/td[2]"));
        System.out.println(titleElements.size());

        for (int n = 0; n <= titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();
            int r = n + 1; // to pass the matching row for the given event
            if (title.equalsIgnoreCase(EventTitle)) {
                // Clicking on the Event Title
                driver.findElement(By.xpath("//tr[" + r + " ]/td[4]/a[1]")).click();
                break;
            }
        }
    }


    @Then("user should be able to view the event")
    public void userShouldBeAbleToViewTheEvent() {
        // Verifying the Event Selected Page
        String expectedTitle = "::Welcome to Hanuman Hindu Temple View Events Details ::";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Url did not match");
        System.out.println("Event Viewed");
        driver.quit();
    }

    // ------------------------------------------Edit Event-----------------------------------------
    @When("user selects the Edit option for {string} and edits the {string} with {string}")
    public void userSelectsTheEditOption(String EventTitle, String EditField, String EditInfo) {

        List<WebElement> titleElements = driver.findElements(By.xpath("//tr/td[2]"));
        System.out.println(titleElements);
//        if (SerialNumber > 1 && SerialNumber <= rowElements.size()) {
//            driver.findElement(By.xpath("//tbody/tr[" + SerialNumber + "]/td[4]/a[2]")).click();
//            // Verifying the Edit Events Details Heading
//            String actualHeading = driver.findElement(By.xpath("//div[@id='bar']/h1")).getText();
//            String expectedHeading = "Edit Events Details";
//            Assert.assertEquals(actualHeading, expectedHeading, "Url did not match");
        for (int n = 0; n <= titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();
            if (title.equalsIgnoreCase(EventTitle)) {
                // Clicking on the selected Event Title
                int r = n + 2; // to pass the matching row for the given event
                driver.findElement(By.xpath("//tr[" + r + " ]/td[4]/a[2]")).click();
                break;
            }
        }


        if (EditField.equalsIgnoreCase("Event title")) {
            driver.findElement(By.xpath("//tr[1]/td[2]/input")).clear();
            driver.findElement(By.xpath("//tr[1]/td[2]/input")).sendKeys(EditInfo);
        } else if (EditField.equalsIgnoreCase("Event type")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/input")).clear();
            driver.findElement(By.xpath("//tr[3]/td[2]/input")).sendKeys(EditInfo);
        } else if (EditField.equalsIgnoreCase("Event Start Date")) {
            driver.findElement(By.xpath("//tr[4]/td[2]/input")).clear();
            driver.findElement(By.xpath("//tr[4]/td[2]/input")).sendKeys(EditInfo);
        } else if (EditField.equalsIgnoreCase("Event End Date")) {
            driver.findElement(By.xpath("//tr[5]/td[2]/input")).clear();
            driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys(EditInfo);
        } else if (EditField.equalsIgnoreCase("Event Time Duration")) {
            driver.findElement(By.xpath("//tr[6]/td[2]/input")).clear();
            driver.findElement(By.xpath("//tr[6]/td[2]/input")).sendKeys(EditInfo);
        } else if (EditField.equalsIgnoreCase("Event Location")) {
            driver.findElement(By.xpath("//tr[7]/td[2]/input")).clear();
            driver.findElement(By.xpath("//tr[7]/td[2]/input")).sendKeys(EditInfo);

//            else if (field.equalsIgnoreCase("Event Status")) {
//                //driver.findElement(By.xpath("//tr[8]/td[2]/select[@id='country']")).sendKeys(editField);
//            } else if (field.equalsIgnoreCase("Event Country")) {
//                //driver.findElement(By.xpath("//tr[8]/td[2]/select[@id='country']")).sendKeys(editField);
//            }

        } else {
            System.out.println("Please give a valid Event Title");
        }
    }


    @And("clicks Submit button on Edit Page")
    public void clicksSubmitButtonOnEditPage() {
        driver.findElement(By.xpath("//tr[13]/td/input")).click();
        System.out.println("Event Edited");
    }

    @Then("user should see the message {string}")
    public void user_should_see_the_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Messages are not matching,");
        System.out.println("Event Message Verified");
    }

    //---------------------------------------Delete Event---------------------------------------------------------
    @When("user selects the Delete option for {string} then it should be deleted")
    public void user_selects_the_delete_option_for_then_it_should_be_deleted(String EventTitle) {

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
        //Storing all the titles in the web-element 'titleElements'
        int r,s;
        String eventToDelete ="" ;
        List<WebElement> titleElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        System.out.println(titleElements.size());
        // Looping each Event Title
        for (int n = 0; n < titleElements.size(); n++) {
            // Retrieving each Event Title from the titleElements
            String title = titleElements.get(n).getText();
             r = n + 2; // to pass the matching row for the given event to delete
            if (title.equalsIgnoreCase(EventTitle)) {
                // Collecting the Serial Number into a List of WebElements(checkForDuplicateEvent) and then checking for any duplicate events
                List<WebElement> duplicateEventSerialNumbers = driver.findElements(By.xpath("//table/tbody/tr[" + r +"]/td[1]"));
                // Checking for any duplicate events from the nth row
                for ( int d=n+1; d < titleElements.size(); d++) {
                    // Looping each Event Title for any duplicates
                    String titleDuplicate = titleElements.get(d).getText();
                     s = d + 2; // to pass the matching row for the given event to delete
                    if (titleDuplicate.equalsIgnoreCase(title)) {
                        // title of current event
                        String currentTitle = driver.findElement(By.xpath("//table/tbody/tr[" + s + "]/td[2]")).getText() ;
                        WebElement duplicate = driver.findElement(By.xpath("//table/tbody/tr[" + s + "]/td[1]"));
                        eventToDelete = duplicate.getText();
                        System.out.println(currentTitle  + "serial number is: " + eventToDelete);
                        //String number = StringValueof(duplicate.getText()); // serial number of current event
                        duplicateEventSerialNumbers.add(1,duplicate);
                    }
                }
                System.out.println(" Number of duplicate Events="+ duplicateEventSerialNumbers.size());
                if (duplicateEventSerialNumbers.size()>1){
                    // Deleting the last created duplicate event
//                        String eventToDelete = String.valueOf(duplicateEventSerialNumbers.lastIndexOf(duplicateEventSerialNumbers));
//                        System.out.println(" Event being deleted Serial number: " + eventToDelete);
                    int m = Integer.parseInt(eventToDelete) + 1;
                    driver.findElement(By.xpath("//tbody/tr[ " + m + " ]/td[4]/a[3]")).click();
                    break;
                }else
                    // Deleting the unique event( not duplicated)
                    driver.findElement(By.xpath("//tbody/tr[ " + r + " ]/td[4]/a[3]")).click();
                    break;
                }
            }


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
        System.out.println("Event is deleted at the back-end");
        driver.quit();
    }



    // Front-end verification of deleted event on the Event's Page
    @And("the user should not find the deleted Event {string} in Events")
    public void theUserShouldNotFindTheDeletedEvent(String EventTitle) {
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
        System.out.println("Event is deleted in the Events.");
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
        System.out.println("Event is deleted in the Calendar.");
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