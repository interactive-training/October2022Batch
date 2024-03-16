package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeleteEventsPage {
    WebDriver driver;

    public DeleteEventsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void deleteEvent(String EventTitle){
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
                        System.out.println(currentTitle + "-" +"serial number is: " + eventToDelete);
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

    public void verifyEventDeletedAtBackend(String EventTitle){
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
        //System.out.println("This event does not exist in the Administration Panel.");

    }
}
