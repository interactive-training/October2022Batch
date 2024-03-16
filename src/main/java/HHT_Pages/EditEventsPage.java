package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditEventsPage {
    WebDriver driver;
    public EditEventsPage(WebDriver driver) {
      this.driver = driver;
    }
    // By variables

    //Page Methods
    public void editEventInfo(String EventTitle,String EditField, String EditInfo ){
        // Loading all the titles to click View of the event selected
        List<WebElement> titleElements = driver.findElements(By.xpath("//table//tr/td[2]"));
        System.out.println(titleElements.size());
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
        // Editing the field of the selected event


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
}
